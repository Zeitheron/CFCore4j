package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class GameVersion
{
	public final long id;
	public final String slug;
	public final String name;
	
	public GameVersion(JSONObject $)
	{
		this.id = $.getLong("id");
		this.slug = $.getString("slug");
		this.name = $.getString("name");
	}
	
	@Override
	public String toString()
	{
		return "GameVersion{" +
			   "id=" + id +
			   ", slug='" + slug + '\'' +
			   ", name='" + name + '\'' +
			   '}';
	}
}
