package org.zeith.cfcore4j.mods;

import org.json.JSONObject;
import org.zeith.cfcore4j.schemas.Mod;

public class GetModResponse
{
	public final Mod data;

	public GetModResponse(JSONObject $)
	{
		this.data = new Mod($.getJSONObject("data"));
	}

	@Override
	public String toString()
	{
		return "GetModResponse{" +
				"data=" + data +
				'}';
	}
}