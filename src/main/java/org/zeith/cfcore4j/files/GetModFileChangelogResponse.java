package org.zeith.cfcore4j.files;

import org.json.JSONObject;

public class GetModFileChangelogResponse
{
	public final String data;

	public GetModFileChangelogResponse(JSONObject $)
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