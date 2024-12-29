package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;

public class MinecraftModLoaderVersion
{
	public final long id;
	public final long gameVersionId;
	public final long minecraftGameVersionId;
	public final String forgeVersion;
	public final String name;
	public final String downloadUrl;
	public final String filename;
	public final ModLoaderInstallMethod installMethod;
	public final boolean latest;
	public final boolean recommended;
	public final boolean approved;
	public final Instant dateModified;
	public final String mavenVersionString;
	public final String versionJson;
	public final String librariesInstallLocation;
	public final String minecraftVersion;
	public final String additionalFilesJson;
	public final long modLoaderGameVersionId;
	public final long modLoaderGameVersionTypeId;
	public final GameVersionStatus modLoaderGameVersionStatus;
	public final GameVersionTypeStatus modLoaderGameVersionTypeStatus;
	public final long mcGameVersionId;
	public final long mcGameVersionTypeId;
	public final GameVersionStatus mcGameVersionStatus;
	public final GameVersionTypeStatus mcGameVersionTypeStatus;
	public final String installProfileJson;
	
	public MinecraftModLoaderVersion(JSONObject $)
	{
		this.id = $.getLong("id");
		this.gameVersionId = $.getLong("gameVersionId");
		this.minecraftGameVersionId = $.getLong("minecraftGameVersionId");
		this.forgeVersion = $.getString("forgeVersion");
		this.name = $.getString("name");
		this.downloadUrl = $.getString("downloadUrl");
		this.filename = $.getString("filename");
		this.installMethod = ModLoaderInstallMethod.fromJson($.getInt("installMethod"));
		this.latest = $.getBoolean("latest");
		this.recommended = $.getBoolean("recommended");
		this.approved = $.getBoolean("approved");
		this.dateModified = Util.parseDateTime($.getString("dateModified"));
		this.mavenVersionString = $.getString("mavenVersionString");
		this.versionJson = $.getString("versionJson");
		this.librariesInstallLocation = $.getString("librariesInstallLocation");
		this.minecraftVersion = $.getString("minecraftVersion");
		this.additionalFilesJson = $.optString("additionalFilesJson");
		this.modLoaderGameVersionId = $.getLong("modLoaderGameVersionId");
		this.modLoaderGameVersionTypeId = $.getLong("modLoaderGameVersionTypeId");
		this.modLoaderGameVersionStatus = GameVersionStatus.fromJson($.getInt("modLoaderGameVersionStatus"));
		this.modLoaderGameVersionTypeStatus = GameVersionTypeStatus.fromJson($.getInt("modLoaderGameVersionTypeStatus"));
		this.mcGameVersionId = $.getLong("mcGameVersionId");
		this.mcGameVersionTypeId = $.getLong("mcGameVersionTypeId");
		this.mcGameVersionStatus = GameVersionStatus.fromJson($.getInt("mcGameVersionStatus"));
		this.mcGameVersionTypeStatus = GameVersionTypeStatus.fromJson($.getInt("mcGameVersionTypeStatus"));
		this.installProfileJson = $.optString("installProfileJson");
	}
	
	@Override
	public String toString()
	{
		return "MinecraftModLoaderVersion{" +
			   "id=" + id +
			   ", gameVersionId=" + gameVersionId +
			   ", minecraftGameVersionId=" + minecraftGameVersionId +
			   ", forgeVersion='" + forgeVersion + '\'' +
			   ", name='" + name + '\'' +
			   ", downloadUrl='" + downloadUrl + '\'' +
			   ", filename='" + filename + '\'' +
			   ", installMethod=" + installMethod +
			   ", latest=" + latest +
			   ", recommended=" + recommended +
			   ", approved=" + approved +
			   ", dateModified=" + dateModified +
			   ", mavenVersionString='" + mavenVersionString + '\'' +
			   ", versionJson=" + JSONObject.quote(versionJson) +
			   ", librariesInstallLocation='" + librariesInstallLocation + '\'' +
			   ", minecraftVersion='" + minecraftVersion + '\'' +
			   ", additionalFilesJson=" + JSONObject.quote(additionalFilesJson) +
			   ", modLoaderGameVersionId=" + modLoaderGameVersionId +
			   ", modLoaderGameVersionTypeId=" + modLoaderGameVersionTypeId +
			   ", modLoaderGameVersionStatus=" + modLoaderGameVersionStatus +
			   ", modLoaderGameVersionTypeStatus=" + modLoaderGameVersionTypeStatus +
			   ", mcGameVersionId=" + mcGameVersionId +
			   ", mcGameVersionTypeId=" + mcGameVersionTypeId +
			   ", mcGameVersionStatus=" + mcGameVersionStatus +
			   ", mcGameVersionTypeStatus=" + mcGameVersionTypeStatus +
			   ", installProfileJson=" + JSONObject.quote(installProfileJson) +
			   '}';
	}
}