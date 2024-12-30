package org.zeith.cfcore4j.mods;

import org.json.JSONArray;
import org.json.JSONObject;
import org.zeith.cfcore4j.Mods;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.base.PaginatedResponse;
import org.zeith.cfcore4j.schemas.Mod;

import java.util.List;

public class SearchModsResponse
		extends PaginatedResponse<Mod, SearchModsResponse>
{
	private final Mods mods;
	private final SearchModsRequest req;

	public SearchModsResponse(Mods mods, SearchModsRequest req, JSONObject $)
	{
		super($);
		this.mods = mods;
		this.req = req.clone();
	}

	@Override
	protected List<Mod> decodeData(JSONArray data)
	{
		return Util.parseList(data, Mod::new);
	}

	@Override
	public SearchModsResponse fromIndex(long index)
	{
		return mods.searchMods(req.clone().index(index));
	}
}