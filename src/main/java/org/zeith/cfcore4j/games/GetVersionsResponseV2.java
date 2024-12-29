package org.zeith.cfcore4j.games;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.GameVersionsByType2;

import java.util.List;

public class GetVersionsResponseV2
{
	public final List<GameVersionsByType2> data;

	public GetVersionsResponseV2(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), GameVersionsByType2::new);
	}

	@Override
	public String toString()
	{
		return "GetVersionsResponseV2{" +
				"data=" + data +
				'}';
	}
}