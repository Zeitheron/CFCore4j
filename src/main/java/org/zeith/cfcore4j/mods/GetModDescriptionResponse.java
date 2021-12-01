package org.zeith.cfcore4j.mods;

import org.json.JSONObject;

public class GetModDescriptionResponse
{
	public final String data;

	public GetModDescriptionResponse(JSONObject $)
	{
		this.data = $.getString("data");
	}

	@Override
	public String toString()
	{
		return "GetModDescriptionResponse{" +
				"data='" + data + '\'' +
				'}';
	}
}