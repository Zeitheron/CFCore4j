package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.util.List;

public class GameVersionsByType2
{
	public final long type;
	public final List<GameVersion> versions;

	public GameVersionsByType2(JSONObject $)
	{
		this.type = $.getLong("type");
		this.versions = Util.parseList($.getJSONArray("versions"), GameVersion::new);
	}

	@Override
	public String toString()
	{
		return "GameVersionsByType2{" +
				"type=" + type +
				", versions=" + versions +
				'}';
	}
}