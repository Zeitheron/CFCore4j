package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class FileDependency
{
	public final long modId;
	public final FileRelationType relationType;

	public FileDependency(JSONObject $)
	{
		this.modId = $.getLong("modId");
		this.relationType = FileRelationType.fromJson($.getInt("relationType"));
	}

	@Override
	public String toString()
	{
		return "FileDependency{" +
				"modId=" + modId +
				", relationType=" + relationType +
				'}';
	}
}