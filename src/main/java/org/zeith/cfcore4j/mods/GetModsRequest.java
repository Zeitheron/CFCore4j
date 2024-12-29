package org.zeith.cfcore4j.mods;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetModsRequest
{
	private final List<Long> modIds = new ArrayList<>();

	public static GetModsRequest create()
	{
		return new GetModsRequest();
	}

	public GetModsRequest addMod(long... modId)
	{
		for(long i : modId)
			modIds.add(i);
		return this;
	}

	public GetModsRequest addMod(Collection<Long> modId)
	{
		modIds.addAll(modId);
		return this;
	}

	public GetModsRequest addMod(Iterable<Long> modId)
	{
		for(long i : modId)
			modIds.add(i);
		return this;
	}

	public List<Long> modIds()
	{
		return Collections.unmodifiableList(modIds);
	}

	@Override
	public String toString()
	{
		JSONObject $ = new JSONObject();
		$.put("modIds", modIds);
		return $.toString();
	}
}