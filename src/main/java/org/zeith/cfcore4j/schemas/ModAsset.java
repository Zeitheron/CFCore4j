package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class ModAsset
{
	public final long id;
	public final long modId;
	public final String title;
	public final String description;
	public final String thumbnailUrl;
	public final String url;

	public ModAsset(JSONObject $)
	{
		this.id = $.getLong("id");
		this.modId = $.getLong("modId");
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