package org.zeith.cfcore4j.mods;

import org.json.JSONObject;

import java.util.*;

public class GetFeaturedModsRequest
{
	private Long gameId;
	private final List<Long> excludedModIds = new ArrayList<>();
	private Long gameVersionTypeId;

	public static GetFeaturedModsRequest create()
	{
		return new GetFeaturedModsRequest();
	}

	public GetFeaturedModsRequest gameId(Long gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public GetFeaturedModsRequest gameVersionTypeId(Long gameVersionTypeId)
	{
		this.gameVersionTypeId = gameVersionTypeId;
		return this;
	}

	public GetFeaturedModsRequest addExcludedMod(long... modId)
	{
		for(long i : modId)
			excludedModIds.add(i);
		return this;
	}

	public GetFeaturedModsRequest addExcludedMod(Collection<Long> modId)
	{
		excludedModIds.addAll(modId);
		return this;
	}

	public GetFeaturedModsRequest addExcludedMod(Iterable<Long> modId)
	{
		for(long i : modId)
			excludedModIds.add(i);
		return this;
	}

	public List<Long> excludedModIds()
	{
		return Collections.unmodifiableList(excludedModIds);
	}

	@Override
	public String toString()
	{
		JSONObject $ = new JSONObject();
		$.put("gameId", gameId);
		$.put("excludedModIds", excludedModIds);
		$.putOpt("gameVersionTypeId", gameVersionTypeId);
		return $.toString();
	}
}