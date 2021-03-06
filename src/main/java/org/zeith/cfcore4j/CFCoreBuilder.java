package org.zeith.cfcore4j;

import org.zeith.cfcore4j.base.HTTPCache;
import org.zeith.cfcore4j.guava.RateLimiter;
import org.zeith.httplib.JSONHttpRequest;

import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * This builder creates an authorized instance of {@link CFCore4j}.
 *
 * @see CFCore4j
 */
public class CFCoreBuilder
{
	private Function<JSONHttpRequest, JSONHttpRequest> requestTransformator = UnaryOperator.identity();
	private String apiKey;
	private HTTPCache cache;
	private RateLimiter rateLimiter;
	
	public CFCoreBuilder authorize(String apiKey)
	{
		this.apiKey = apiKey;
		return this;
	}
	
	public CFCoreBuilder cache(HTTPCache cache)
	{
		this.cache = cache;
		return this;
	}
	
	public CFCoreBuilder rateLimit(RateLimiter rateLimiter)
	{
		this.rateLimiter = rateLimiter;
		return this;
	}
	
	public CFCoreBuilder transformHttp(UnaryOperator<JSONHttpRequest> op)
	{
		if(op != null) requestTransformator = op;
		else requestTransformator = UnaryOperator.identity();
		return this;
	}
	
	public CFCoreBuilder addUserAgent(String userAgent)
	{
		if(userAgent != null && !userAgent.isEmpty())
			requestTransformator = requestTransformator.andThen(e -> e.userAgent(userAgent));
		return this;
	}
	
	public CFCoreBuilder addHeaders(Map<String, String> headers)
	{
		if(headers != null && !headers.isEmpty())
			requestTransformator = requestTransformator.andThen(e -> e.headers(headers));
		return this;
	}
	
	public CFCore4j build()
	{
		return new CFCore4j(apiKey, cache, rateLimiter, e -> requestTransformator.apply(e));
	}
}