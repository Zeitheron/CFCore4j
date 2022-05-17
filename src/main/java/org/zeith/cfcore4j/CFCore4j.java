package org.zeith.cfcore4j;

import org.zeith.cfcore4j.errors.CFAuthenticationException;
import org.zeith.cfcore4j.errors.CFCoreException;
import org.zeith.cfcore4j.errors.CFNotFoundException;
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
	static final String BASE_URL = "https://api.curseforge.com/v1/";

	private final String apiKey;

	private final Games games = new Games(this);
	private final Categories categories = new Categories(this);
	private final Mods mods = new Mods(this);
	private final Files files = new Files(this);
	private final Fingerprints fingerprints = new Fingerprints(this);
	
	private final UnaryOperator<JSONHttpRequest> requestTransformator;

	CFCore4j(String apiKey, UnaryOperator<JSONHttpRequest> requestTransformator)
	{
		this.apiKey = apiKey;
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

	// INTERNAL USE ONLY //

	void checkAuthentication()
	{
		if(apiKey == null || apiKey.isEmpty())
			throw new CFAuthenticationException("Missing API key!");
	}

	JSONHttpRequest checkValid(String query, JSONHttpRequest req)
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

	JSONHttpRequest get(String url)
	{
		return requestTransformator.apply(JSONHttpRequest.get(BASE_URL + url));
	}

	JSONHttpRequest post(String url)
	{
		return requestTransformator.apply(JSONHttpRequest.post(BASE_URL + url));
	}

	JSONHttpRequest getAuth(String url)
	{
		return get(url)
				.header("x-api-key", apiKey);
	}

	JSONHttpRequest postAuth(String url)
	{
		return post(url)
				.header("x-api-key", apiKey);
	}

	JSONHttpRequest get(String url, IQueryContainer params)
	{
		return JSONHttpRequest.get(BASE_URL + url + params.toBuilder());
	}

	JSONHttpRequest getAuth(String url, IQueryContainer params)
	{
		return get(url, params)
				.header("x-api-key", apiKey);
	}
}