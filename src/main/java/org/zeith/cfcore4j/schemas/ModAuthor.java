package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class ModAuthor
{
	public final long id;
	public final String name;
	public final String url;

	public ModAuthor(JSONObject $)
	{
		this.id = $.getLong("id");
		this.name = $.getString("name");
		this.url = $.getString("url");
	}
	
	@Override
	public String toString()
	{
		return "ModAuthor{" +
			   "id=" + id +
			   ", name='" + name + '\'' +
			   ", url='" + url + '\'' +
			   '}';
	}
}