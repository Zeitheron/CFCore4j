package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class FileIndex
{
	public final String gameVersion;
	public final int fileId;
	public final String filename;
	public final FileReleaseType releaseType;
	public final Nullable<Integer> gameVersionTypeId;
	public final Nullable<ModLoaderType> modLoader;

	public FileIndex(JSONObject $)
	{
		this.gameVersion = $.getString("gameVersion");
		this.fileId = $.getInt("fileId");
		this.filename = $.getString("filename");
		this.releaseType = FileReleaseType.fromJson($.getInt("releaseType"));
		this.gameVersionTypeId = new Nullable<>($.isNull("gameVersionTypeId") ? null : $.getInt("gameVersionTypeId"));
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