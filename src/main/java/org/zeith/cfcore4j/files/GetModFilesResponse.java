package org.zeith.cfcore4j.files;

import org.json.JSONArray;
import org.json.JSONObject;
import org.zeith.cfcore4j.Files;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.base.PaginatedResponse;
import org.zeith.cfcore4j.schemas.File;

import java.util.List;

public class GetModFilesResponse
		extends PaginatedResponse<File, GetModFilesResponse>
{
	final Files files;
	final GetModFilesRequest req;

	public GetModFilesResponse(Files files, GetModFilesRequest req, JSONObject $)
	{
		super($);
		this.files = files;
		this.req = req.clone();
	}

	@Override
	protected List<File> decodeData(JSONArray data)
	{
		return Util.parseList(data, File::new);
	}

	@Override
	public GetModFilesResponse fromIndex(long index)
	{
		return files.getModFiles(req.clone().index(index));
	}
}