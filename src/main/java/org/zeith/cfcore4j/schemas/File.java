package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;
import java.util.List;

public class File
{
	public final int id;
	public final int gameId;
	public final int modId;
	public final boolean isAvailable;
	public final String displayName;
	public final String fileName;
	public final FileReleaseType releaseType;
	public final FileStatus fileStatus;
	public final List<FileHash> hashes;
	public final Instant fileDate;
	public final long fileLength;
	public final long downloadCount;
	public final String downloadUrl;
	public final List<String> gameVersions;
	public final List<SortableGameVersion> sortableGameVersions;
	public final List<FileDependency> dependencies;
	public final Nullable<Boolean> exposeAsAlternative;
	public final Nullable<Integer> parentProjectFileId;
	public final Nullable<Integer> alternateFileId;
	public final Nullable<Boolean> isServerPack;
	public final Nullable<Integer> serverPackFileId;
	public final long fileFingerprint;
	public final List<FileModule> modules;

	public File(JSONObject $)
	{
		this.id = $.getInt("id");
		this.gameId = $.getInt("gameId");
		this.modId = $.getInt("modId");
		this.isAvailable = $.getBoolean("isAvailable");
		this.displayName = $.getString("displayName");
		this.fileName = $.getString("fileName");
		this.releaseType = FileReleaseType.fromJson($.getInt("releaseType"));
		this.fileStatus = FileStatus.fromJson($.getInt("fileStatus"));
		this.hashes = Util.parseList($.getJSONArray("hashes"), FileHash::new);
		this.fileDate = Util.parseDateTime($.getString("fileDate"));
		this.fileLength = $.getLong("fileLength");
		this.downloadCount = $.getLong("downloadCount");
		this.downloadUrl = $.optString("downloadUrl");
		this.gameVersions = Util.parseListStr($.getJSONArray("gameVersions"));
		this.sortableGameVersions = Util.parseList($.getJSONArray("sortableGameVersions"), SortableGameVersion::new);
		this.dependencies = Util.parseList($.getJSONArray("dependencies"), FileDependency::new);
		this.exposeAsAlternative = new Nullable<>($.isNull("exposeAsAlternative") ? null : $.getBoolean("exposeAsAlternative"));
		this.parentProjectFileId = new Nullable<>($.isNull("parentProjectFileId") ? null : $.getInt("parentProjectFileId"));
		this.alternateFileId = new Nullable<>($.isNull("alternateFileId") ? null : $.getInt("alternateFileId"));
		this.isServerPack = new Nullable<>($.isNull("isServerPack") ? null : $.getBoolean("isServerPack"));
		this.serverPackFileId = new Nullable<>($.isNull("serverPackFileId") ? null : $.getInt("serverPackFileId"));
		this.fileFingerprint = $.getLong("fileFingerprint");
		this.modules = Util.parseList($.getJSONArray("modules"), FileModule::new);
	}

	@Override
	public String toString()
	{
		return "File{" +
				"id=" + id +
				", gameId=" + gameId +
				", modId=" + modId +
				", isAvailable=" + isAvailable +
				", displayName='" + displayName + '\'' +
				", fileName='" + fileName + '\'' +
				", releaseType=" + releaseType +
				", fileStatus=" + fileStatus +
				", hashes=" + hashes +
				", fileDate=" + fileDate +
				", fileLength=" + fileLength +
				", downloadCount=" + downloadCount +
				", downloadUrl='" + downloadUrl + '\'' +
				", gameVersions=" + gameVersions +
				", sortableGameVersions=" + sortableGameVersions +
				", dependencies=" + dependencies +
				", exposeAsAlternative=" + exposeAsAlternative +
				", parentProjectFileId=" + parentProjectFileId +
				", alternateFileId=" + alternateFileId +
				", isServerPack=" + isServerPack +
				", serverPackFileId=" + serverPackFileId +
				", fileFingerprint=" + fileFingerprint +
				", modules=" + modules +
				'}';
	}
}