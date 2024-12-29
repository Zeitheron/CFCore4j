package org.zeith.cfcore4j;

import org.zeith.cfcore4j.base.HTTPCache;
import org.zeith.cfcore4j.base.VersionedRequest;
import org.zeith.cfcore4j.errors.CFAuthenticationException;
import org.zeith.cfcore4j.guava.RateLimiter;
import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.httplib.JSONHttpRequest;

import java.util.function.UnaryOperator;

/**
 * The heart of all calls to CFCore.
 * An instance contains an API Key and a list of categories that can be accessed:
 *
 * @see Games
 * @see Categories
 * @see Mods
 * @see Files
 * @see Fingerprints
 */
public class CFCore4j
{
	private final String apiKey;
	
	private final Games games = new Games(this);
	private final Categories categories = new Categories(this);
	private final Mods mods = new Mods(this);
	private final Files files = new Files(this);
	private final Fingerprints fingerprints = new Fingerprints(this);
	private final Minecraft minecraft = new Minecraft(this);
	
	private final RateLimiter rateLimiter;
	
	final UnaryOperator<JSONHttpRequest> requestTransformator;
	final HTTPCache cache;
	
	CFCore4j(String apiKey, HTTPCache cache, RateLimiter rateLimiter, UnaryOperator<JSONHttpRequest> requestTransformator)
	{
		this.apiKey = apiKey;
		this.cache = cache;
		this.rateLimiter = rateLimiter;
		this.requestTransformator = requestTransformator;
		checkAuthentication();
	}
	
	public Games games()
	{
		return games;
	}
	
	public Categories categories()
	{
		return categories;
	}
	
	public Mods mods()
	{
		return mods;
	}
	
	public Files files()
	{
		return files;
	}
	
	public Fingerprints fingerprints()
	{
		return fingerprints;
	}
	
	public Minecraft minecraft()
	{
		return minecraft;
	}
	
	// INTERNAL USE ONLY //
	
	VersionedRequest request(int version, String url, IQueryContainer query, String requestName)
	{
		return request(version, url, query, requestName, null);
	}
	
	VersionedRequest request(int version, String url, IQueryContainer query, String requestName, String body)
	{
		return new VersionedRequest(
				apiKey, cache, rateLimiter, requestTransformator,
				requestName, version, url + (query != null ? query.toBuilder() : ""), body
		);
	}
	
	void checkAuthentication()
	{
		if(apiKey == null || apiKey.isEmpty())
			throw new CFAuthenticationException("Missing API key!");
	}
}