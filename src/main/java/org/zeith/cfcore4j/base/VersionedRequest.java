package org.zeith.cfcore4j.base;

import org.json.JSONObject;
import org.zeith.cfcore4j.errors.*;
import org.zeith.cfcore4j.guava.RateLimiter;
import org.zeith.httplib.HttpRequest;
import org.zeith.httplib.JSONHttpRequest;

import java.util.Optional;
import java.util.function.UnaryOperator;

public class VersionedRequest
{
	private final String apiKey;
	private final HTTPCache cache;
	private final RateLimiter rateLimiter;
	private final UnaryOperator<JSONHttpRequest> requestTransformator;
	
	private final String url;
	private final String cacheKey;
	private final String sendBody;
	private final String requestName;
	
	private boolean authorize = true;
	
	public VersionedRequest(
			String apiKey, HTTPCache cache, RateLimiter rateLimiter, UnaryOperator<JSONHttpRequest> requestTransformator,
			String requestName,
			int version, String path,
			String sendBody
	)
	{
		this.apiKey = apiKey;
		this.cache = cache;
		this.rateLimiter = rateLimiter;
		this.requestTransformator = requestTransformator;
		
		this.requestName = requestName;
		this.url = String.format("https://api.curseforge.com/v%s/%s", version, path);
		this.cacheKey = cache != null ? String.format("%s\n%s", url, sendBody) : null;
		this.sendBody = sendBody;
	}
	
	public VersionedRequest unauthorized()
	{
		this.authorize = false;
		return this;
	}
	
	public JSONHttpRequest request(String url, String method)
	{
		rateLimiter.acquire();
		
		JSONHttpRequest req = requestTransformator.apply(new JSONHttpRequest(url, method));
		if(authorize)
		{
			checkAuthentication();
			return req.header("x-api-key", apiKey);
		}
		return req;
	}
	
	private JSONObject cachedValue()
	{
		return cache != null ? cache.getCachedJSONObject(cacheKey) : null;
	}
	
	public JSONObject get()
	{
		return Optional.ofNullable(cachedValue()).orElseGet(() ->
		{
			JSONObject obj = getRaw().jsonObjectBody();
			if(cache != null) cache.putCached(cacheKey, obj.toString());
			return obj;
		});
	}
	
	public JSONObject post()
	{
		return Optional.ofNullable(cachedValue()).orElseGet(() ->
		{
			JSONObject obj = postRaw().jsonObjectBody();
			if(cache != null) cache.putCached(cacheKey, obj.toString());
			return obj;
		});
	}
	
	private JSONHttpRequest getRaw()
	{
		return checkValid(requestName, request(url, HttpRequest.METHOD_GET));
	}
	
	private JSONHttpRequest postRaw()
	{
		return checkValid(requestName, request(url, HttpRequest.METHOD_POST).contentType(HttpRequest.CONTENT_TYPE_JSON).send(sendBody));
	}
	
	private JSONHttpRequest checkValid(String query, JSONHttpRequest req)
	{
		if(!req.ok())
		{
			if(req.code() == 403)
			{
				checkAuthentication();
				throw new CFAuthenticationException("Invalid API key! " + req.body());
			} else if(req.notFound())
			{
				throw new CFNotFoundException(query + " not found.");
			} else
			{
				throw new CFCoreException("Got a non-ok code (" + req.code() + ") while getting " + query + "!");
			}
		}
		
		return req;
	}
	
	private void checkAuthentication()
	{
		if(apiKey == null || apiKey.isEmpty())
			throw new CFAuthenticationException("Missing API key!");
	}
}