package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.util.List;

public class GameVersionsByType
{
	public final long type;
	public final List<String> versions;

	public GameVersionsByType(JSONObject $)
	{
		this.type = $.getLong("type");
		this.versions = Util.parseListStr($.getJSONArray("versions"));
	}

	@Override
	public String toString()
	{
		return "GameVersionsByType{" +
				"type=" + type +
				", versions=" + versions +
				'}';
	}
}