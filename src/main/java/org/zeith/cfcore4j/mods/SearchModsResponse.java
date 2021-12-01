package org.zeith.cfcore4j.mods;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.Mod;
import org.zeith.cfcore4j.schemas.Pagination;

import java.util.List;

public class SearchModsResponse
{
	public final List<Mod> data;
	public final Pagination pagination;

	public SearchModsResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), Mod::new);
		this.pagination = new Pagination($.getJSONObject("pagination"));
	}

	@Override
	public String toString()
	{
		return "SearchModsResponse{" +
				"data=" + data +
				", pagination=" + pagination +
				'}';
	}
}