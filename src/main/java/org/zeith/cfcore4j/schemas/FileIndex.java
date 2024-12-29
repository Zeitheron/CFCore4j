package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class FileIndex
{
	public final String gameVersion;
	public final long fileId;
	public final String filename;
	public final FileReleaseType releaseType;
	public final Nullable<Long> gameVersionTypeId;
	public final Nullable<ModLoaderType> modLoader;

	public FileIndex(JSONObject $)
	{
		this.gameVersion = $.getString("gameVersion");
		this.fileId = $.getLong("fileId");
		this.filename = $.getString("filename");
		this.releaseType = FileReleaseType.fromJson($.getInt("releaseType"));
		this.gameVersionTypeId = new Nullable<>($.isNull("gameVersionTypeId") ? null : $.getLong("gameVersionTypeId"));
		this.modLoader = new Nullable<>($.isNull("modLoader") ? null : ModLoaderType.fromJson($.getInt("modLoader")));
	}

	@Override
	public String toString()
	{
		return "FileIndex{" +
				"gameVersion='" + gameVersion + '\'' +
				", fileId=" + fileId +
				", filename='" + filename + '\'' +
				", releaseType=" + releaseType +
				", gameVersionTypeId=" + gameVersionTypeId +
				", modLoader=" + modLoader +
				'}';
	}
}