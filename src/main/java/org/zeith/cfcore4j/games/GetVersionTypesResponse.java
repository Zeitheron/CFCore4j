package org.zeith.cfcore4j.games;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.GameVersionType;

import java.util.List;

public class GetVersionTypesResponse
{
	public final List<GameVersionType> data;

	public GetVersionTypesResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), GameVersionType::new);
	}

	@Override
	public String toString()
	{
		return "GetVersionTypesResponse{" +
				"data=" + data +
				'}';
	}
}