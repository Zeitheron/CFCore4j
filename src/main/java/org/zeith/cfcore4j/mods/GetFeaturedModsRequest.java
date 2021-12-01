package org.zeith.cfcore4j.mods;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetFeaturedModsRequest
{
	private Integer gameId;
	private final List<Integer> excludedModIds = new ArrayList<>();
	private Integer gameVersionTypeId;

	public static GetFeaturedModsRequest create()
	{
		return new GetFeaturedModsRequest();
	}

	public GetFeaturedModsRequest gameId(Integer gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public GetFeaturedModsRequest gameVersionTypeId(Integer gameVersionTypeId)
	{
		this.gameVersionTypeId = gameVersionTypeId;
		return this;
	}

	public GetFeaturedModsRequest addExcludedMod(int... modId)
	{
		for(int i : modId)
			excludedModIds.add(i);
		return this;
	}

	public GetFeaturedModsRequest addExcludedMod(Collection<Integer> modId)
	{
		excludedModIds.addAll(modId);
		return this;
	}

	public GetFeaturedModsRequest addExcludedMod(Iterable<Integer> modId)
	{
		for(int i : modId)
			excludedModIds.add(i);
		return this;
	}

	public List<Integer> excludedModIds()
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