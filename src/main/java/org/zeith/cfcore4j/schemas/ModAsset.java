package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class ModAsset
{
	public final int id;
	public final int modId;
	public final String title;
	public final String description;
	public final String thumbnailUrl;
	public final String url;

	public ModAsset(JSONObject $)
	{
		this.id = $.getInt("id");
		this.modId = $.getInt("modId");
		this.title = $.optString("title");
		this.description = $.optString("description");
		this.thumbnailUrl = $.optString("thumbnailUrl");
		this.url = $.getString("url");
	}

	@Override
	public String toString()
	{
		return "ModAsset{" +
				"id=" + id +
				", modId=" + modId +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", thumbnailUrl='" + thumbnailUrl + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}