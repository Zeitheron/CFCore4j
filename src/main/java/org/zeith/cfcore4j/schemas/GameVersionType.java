package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class GameVersionType
{
	public final int id;
	public final int gameId;
	public final String name;
	public final String slug;

	public GameVersionType(JSONObject $)
	{
		this.id = $.getInt("id");
		this.gameId = $.getInt("gameId");
		this.name = $.getString("name");
		this.slug = $.getString("slug");
	}

	@Override
	public String toString()
	{
		return "GameVersionType{" +
				"id=" + id +
				", gameId=" + gameId +
				", name='" + name + '\'' +
				", slug='" + slug + '\'' +
				'}';
	}
}