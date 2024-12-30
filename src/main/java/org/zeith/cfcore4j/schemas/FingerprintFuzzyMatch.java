package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.util.List;

public class FingerprintFuzzyMatch
{
	public final long id;
	public final File file;
	public final List<File> latestFiles;
	public final List<Long> fingerprints;

	public FingerprintFuzzyMatch(JSONObject $)
	{
		this.id = $.getLong("id");
		this.file = new File($.getJSONObject("file"));
		this.latestFiles = Util.parseList($.optJSONArray("latestFiles"), File::new);
		this.fingerprints = Util.parseListLong($.optJSONArray("fingerprints"));
	}

	@Override
	public String toString()
	{
		return "FingerprintFuzzyMatch{" +
				"id=" + id +
				", file=" + file +
				", latestFiles=" + latestFiles +
				", fingerprints=" + fingerprints +
				'}';
	}
}