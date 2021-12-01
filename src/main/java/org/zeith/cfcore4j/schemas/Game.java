package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;

public class Game
{
	public final int id;
	public final String name;
	public final String slug;
	public final Instant dateModified;
	public final GameAssets assets;
	public final CoreStatus status;
	public final CoreApiStatus apiStatus;

	public Game(JSONObject $)
	{
		this.id = $.getInt("id");
		this.name = $.getString("name");
		this.slug = $.getString("slug");
		this.dateModified = Util.parseDateTime($.getString("dateModified"));
		this.assets = new GameAssets($.getJSONObject("assets"));
		this.status = CoreStatus.fromJson($.getInt("status"));
		this.apiStatus = CoreApiStatus.fromJson($.getInt("apiStatus"));
	}

	@Override
	public String toString()
	{
		return "Game{" +
				"id=" + id +
				", name='" + name + '\'' +
				", slug='" + slug + '\'' +
				", dateModified=" + dateModified +
				", assets=" + assets +
				", status=" + status +
				", apiStatus=" + apiStatus +
				'}';
	}
}
