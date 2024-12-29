package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class FileDependency
{
	public final long modId;
	public final long fileId;
	public final FileRelationType relationType;

	public FileDependency(JSONObject $)
	{
		this.modId = $.getLong("modId");
		this.fileId = $.optLong("fileId");
		this.relationType = FileRelationType.fromJson($.getInt("relationType"));
	}

	@Override
	public String toString()
	{
		return "FileDependency{" +
				"modId=" + modId +
				", fileId=" + fileId +
				", relationType=" + relationType +
				'}';
	}
}