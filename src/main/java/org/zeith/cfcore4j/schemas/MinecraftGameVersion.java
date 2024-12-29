package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;

public class MinecraftGameVersion
{
	public final long id;
	public final long gameVersionId;
	public final String versionString;
	public final String jarDownloadUrl;
	public final String jsonDownloadUrl;
	public final boolean approved;
	public final Instant dateModified;
	public final long gameVersionTypeId;
	public final GameVersionStatus gameVersionStatus;
	public final GameVersionTypeStatus gameVersionTypeStatus;
	
	public MinecraftGameVersion(JSONObject $)
	{
		this.id = $.getLong("id");
		this.gameVersionId = $.getLong("gameVersionId");
		this.versionString = $.getString("versionString");
		this.jarDownloadUrl = $.getString("jarDownloadUrl");
		this.jsonDownloadUrl = $.getString("jsonDownloadUrl");
		this.approved = $.getBoolean("approved");
		this.dateModified = Util.parseDateTime($.getString("dateModified"));
		this.gameVersionTypeId = $.getLong("gameVersionTypeId");
		this.gameVersionStatus = GameVersionStatus.fromJson($.getInt("gameVersionStatus"));
		this.gameVersionTypeStatus = GameVersionTypeStatus.fromJson($.getInt("gameVersionTypeStatus"));
	}
	
	@Override
	public String toString()
	{
		return "MinecraftGameVersion{" + "id=" + id +
			   ", gameVersionId=" + gameVersionId +
			   ", versionString='" + versionString + '\'' +
			   ", jarDownloadUrl='" + jarDownloadUrl + '\'' +
			   ", jsonDownloadUrl='" + jsonDownloadUrl + '\'' +
			   ", approved=" + approved +
			   ", dateModified=" + dateModified +
			   ", gameVersionTypeId=" + gameVersionTypeId +
			   ", gameVersionStatus=" + gameVersionStatus +
			   ", gameVersionTypeStatus=" + gameVersionTypeStatus +
			   '}';
	}
}