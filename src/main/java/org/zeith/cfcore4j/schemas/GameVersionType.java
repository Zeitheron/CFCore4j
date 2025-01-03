package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class GameVersionType
{
	public final long id;
	public final long gameId;
	public final String name;
	public final String slug;
	public final GameVersionTypeStatus status;
	
	public GameVersionType(JSONObject $)
	{
		this.id = $.getLong("id");
		this.gameId = $.getLong("gameId");
		this.name = $.getString("name");
		this.slug = $.getString("slug");
		this.status = GameVersionTypeStatus.fromJson($.getInt("status"));
	}
	
	@Override
	public String toString()
	{
		return "GameVersionType{" +
			   "id=" + id +
			   ", gameId=" + gameId +
			   ", name='" + name + '\'' +
			   ", slug='" + slug + '\'' +
			   ", status=" + status +
			   '}';
	}
}