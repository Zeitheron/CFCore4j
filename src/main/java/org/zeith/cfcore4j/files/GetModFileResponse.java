package org.zeith.cfcore4j.files;

import org.json.JSONObject;
import org.zeith.cfcore4j.schemas.File;

public class GetModFileResponse
{
	public final File data;

	public GetModFileResponse(JSONObject $)
	{
		this.data = new File($.getJSONObject("data"));
	}

	@Override
	public String toString()
	{
		return "GetModFileResponse{" +
				"data=" + data +
				'}';
	}
}