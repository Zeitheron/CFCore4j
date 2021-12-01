package org.zeith.cfcore4j.mods;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.Mod;

import java.util.List;

public class GetFeaturedModsResponse
{
	public final List<Mod> featured;
	public final List<Mod> popular;
	public final List<Mod> recentlyUpdated;

	public GetFeaturedModsResponse(JSONObject $)
	{
		$ = $.getJSONObject("data");
		this.featured = Util.parseList($.getJSONArray("featured"), Mod::new);
		this.popular = Util.parseList($.getJSONArray("popular"), Mod::new);
		this.recentlyUpdated = Util.parseList($.getJSONArray("recentlyUpdated"), Mod::new);
	}

	@Override
	public String toString()
	{
		return "GetFeaturedModsResponse{" +
				"featured=" + featured +
				", popular=" + popular +
				", recentlyUpdated=" + recentlyUpdated +
				'}';
	}
}