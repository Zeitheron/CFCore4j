package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class FileDependency
{
	public final int modId;
	public final int fileId;
	public final FileRelationType relationType;

	public FileDependency(JSONObject $)
	{
		this.modId = $.getInt("modId");
		this.fileId = $.optInt("fileId");
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