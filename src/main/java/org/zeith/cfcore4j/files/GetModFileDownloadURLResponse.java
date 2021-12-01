package org.zeith.cfcore4j.files;

import org.json.JSONObject;

public class GetModFileDownloadURLResponse
{
	public final String data;

	public GetModFileDownloadURLResponse(JSONObject $)
	{
		this.data = $.getString("data");
	}

	@Override
	public String toString()
	{
		return "GetModFileDownloadURLResponse{" +
				"data='" + data + '\'' +
				'}';
	}
}