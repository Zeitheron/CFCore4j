package org.zeith.cfcore4j;

import org.zeith.cfcore4j.errors.CFAuthenticationException;
import org.zeith.cfcore4j.errors.CFCoreException;
import org.zeith.cfcore4j.errors.CFNotFoundException;
import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.httplib.JSONHttpRequest;

public class CFCore4j
{
	static final String BASE_URL = "https://api.curseforge.com/v1/";

	private final String apiToken;

	private final Games games = new Games(this);
	private final Categories categories = new Categories(this);
	private final Mods mods = new Mods(this);
	private final Files files = new Files(this);
	private final Fingerprints fingerprints = new Fingerprints(this);

	CFCore4j(String apiToken)
	{
		this.apiToken = apiToken;
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

	// INTERNAL USE ONLY

	void checkAuthentication()
	{
		if(apiToken == null || apiToken.isEmpty())
			throw new CFAuthenticationException("Missing API key!");
	}

	JSONHttpRequest checkValid(String query, JSONHttpRequest req)
	{
		if(!req.ok())
		{
			if(req.code() == 403)
			{
				checkAuthentication();
				throw new CFAuthenticationException("Invalid API key!");
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
		return JSONHttpRequest.get(BASE_URL + url);
	}

	JSONHttpRequest post(String url)
	{
		return JSONHttpRequest.post(BASE_URL + url);
	}

	JSONHttpRequest getAuth(String url)
	{
		return get(url)
				.header("x-api-key", apiToken);
	}

	JSONHttpRequest postAuth(String url)
	{
		return post(url)
				.header("x-api-key", apiToken);
	}

	JSONHttpRequest get(String url, IQueryContainer params)
	{
		return JSONHttpRequest.get(BASE_URL + url + params.toBuilder());
	}

	JSONHttpRequest getAuth(String url, IQueryContainer params)
	{
		return get(url, params)
				.header("x-api-key", apiToken);
	}
}