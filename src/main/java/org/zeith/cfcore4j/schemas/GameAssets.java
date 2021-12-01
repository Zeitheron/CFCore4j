package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class GameAssets
{
	public final String iconUrl;
	public final String tileUrl;
	public final String coverUrl;

	public GameAssets(JSONObject $)
	{
		this.iconUrl = $.optString("iconUrl");
		this.tileUrl = $.optString("tileUrl");
		this.coverUrl = $.optString("coverUrl");
	}

	@Override
	public String toString()
	{
		return "GameAssets{" +
				"iconUrl='" + iconUrl + '\'' +
				", tileUrl='" + tileUrl + '\'' +
				", coverUrl='" + coverUrl + '\'' +
				'}';
	}
}