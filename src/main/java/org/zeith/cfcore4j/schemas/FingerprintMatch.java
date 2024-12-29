package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.util.List;

public class FingerprintMatch
{
	public final long id;
	public final File file;
	public final List<File> latestFiles;

	public FingerprintMatch(JSONObject $)
	{
		this.id = $.getLong("id");
		this.file = new File($.getJSONObject("file"));
		this.latestFiles = Util.parseList($.getJSONArray("latestFiles"), File::new);
	}

	@Override
	public String toString()
	{
		return "FingerprintMatch{" +
				"id=" + id +
				", file=" + file +
				", latestFiles=" + latestFiles +
				'}';
	}
}