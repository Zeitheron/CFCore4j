package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class FileModule
{
	public final String name;
	public final long fingerprint;

	public FileModule(JSONObject $)
	{
		this.name = $.getString("name");
		this.fingerprint = $.getLong("fingerprint");
	}

	@Override
	public String toString()
	{
		return "FileModule{" +
				"name='" + name + '\'' +
				", fingerprint=" + fingerprint +
				'}';
	}
}