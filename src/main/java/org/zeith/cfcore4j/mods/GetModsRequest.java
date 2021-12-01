package org.zeith.cfcore4j.mods;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetModsRequest
{
	private final List<Integer> modIds = new ArrayList<>();

	public static GetModsRequest create()
	{
		return new GetModsRequest();
	}

	public GetModsRequest addMod(int... modId)
	{
		for(int i : modId)
			modIds.add(i);
		return this;
	}

	public GetModsRequest addMod(Collection<Integer> modId)
	{
		modIds.addAll(modId);
		return this;
	}

	public GetModsRequest addMod(Iterable<Integer> modId)
	{
		for(int i : modId)
			modIds.add(i);
		return this;
	}

	public List<Integer> modIds()
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