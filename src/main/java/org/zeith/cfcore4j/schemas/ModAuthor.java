package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class ModAuthor
{
	public final int id;
	public final String name;
	public final String url;

	public ModAuthor(JSONObject $)
	{
		this.id = $.getInt("id");
		this.name = $.getString("name");
		this.url = $.getString("url");
	}
}