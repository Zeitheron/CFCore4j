package org.zeith.cfcore4j.games;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.GameVersionsByType;

import java.util.List;

public class GetVersionsResponse
{
	public final List<GameVersionsByType> data;

	public GetVersionsResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), GameVersionsByType::new);
	}

	@Override
	public String toString()
	{
		return "GetVersionsResponse{" +
				"data=" + data +
				'}';
	}
}