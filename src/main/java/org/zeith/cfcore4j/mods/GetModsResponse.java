package org.zeith.cfcore4j.mods;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.Mod;

import java.util.List;

public class GetModsResponse
{
	public final List<Mod> data;

	public GetModsResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), Mod::new);
	}

	@Override
	public String toString()
	{
		return "GetModsResponse{" +
				"data=" + data +
				'}';
	}
}