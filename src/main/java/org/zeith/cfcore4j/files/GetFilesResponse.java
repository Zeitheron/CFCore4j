package org.zeith.cfcore4j.files;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.File;

import java.util.List;

public class GetFilesResponse
{
	public final List<File> data;

	public GetFilesResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), File::new);
	}

	@Override
	public String toString()
	{
		return "GetFilesResponse{" +
				"data=" + data +
				'}';
	}
}