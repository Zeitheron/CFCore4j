package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class StringResponse
{
	public final String data;

	public StringResponse(JSONObject $)
	{
		this.data = $.getString("data");
	}

	@Override
	public String toString()
	{
		return "StringResponse{" +
				"data='" + data + '\'' +
				'}';
	}
}