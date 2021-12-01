package org.zeith.cfcore4j.files;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.File;
import org.zeith.cfcore4j.schemas.Pagination;

import java.util.List;

public class GetModFilesResponse
{
	public final Pagination pagination;
	public final List<File> files;

	public GetModFilesResponse(JSONObject $)
	{
		this.pagination = new Pagination($.getJSONObject("pagination"));
		this.files = Util.parseList($.getJSONArray("data"), File::new);
	}

	@Override
	public String toString()
	{
		return "GetModFilesResponse{" +
				"pagination=" + pagination +
				", games=" + files +
				'}';
	}
}