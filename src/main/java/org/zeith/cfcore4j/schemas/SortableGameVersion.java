package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;

public class SortableGameVersion implements Comparable<SortableGameVersion>
{
	public final String gameVersionName;
	public final String gameVersionPadded;
	public final String gameVersion;
	public final Instant gameVersionReleaseDate;
	public final Nullable<Long> gameVersionTypeId;

	public SortableGameVersion(JSONObject $)
	{
		this.gameVersionName = $.getString("gameVersionName");
		this.gameVersionPadded = $.getString("gameVersionPadded");
		this.gameVersion = $.getString("gameVersion");
		this.gameVersionReleaseDate = Util.parseDateTime($.getString("gameVersionReleaseDate"));
		this.gameVersionTypeId = new Nullable<>($.isNull("gameVersionTypeId") ? null : $.getLong("gameVersionTypeId"));
	}

	@Override
	public String toString()
	{
		return "SortableGameVersion{" +
				"gameVersionName='" + gameVersionName + '\'' +
				", gameVersionPadded='" + gameVersionPadded + '\'' +
				", gameVersion='" + gameVersion + '\'' +
				", gameVersionReleaseDate=" + gameVersionReleaseDate +
				", gameVersionTypeId=" + gameVersionTypeId +
				'}';
	}
	
	@Override
	public int compareTo(SortableGameVersion o)
	{
		return gameVersionPadded.compareTo(o.gameVersionPadded);
	}
}