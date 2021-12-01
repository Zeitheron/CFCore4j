package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FolderFingerprint
{
	public final String foldername;
	public final List<Long> fingerprints;

	public FolderFingerprint(String foldername, long... fingerprints)
	{
		this.foldername = foldername;
		this.fingerprints = Util.make(() ->
		{
			List<Long> lst = new ArrayList<>();
			for(long fingerprint : fingerprints)
				lst.add(fingerprint);
			return Collections.unmodifiableList(lst);
		});
	}

	public JSONObject serialize()
	{
		return new JSONObject()
				.put("foldername", foldername)
				.put("fingerprints", fingerprints);
	}

	@Override
	public String toString()
	{
		return "FolderFingerprint{" +
				"foldername='" + foldername + '\'' +
				", fingerprints=" + fingerprints +
				'}';
	}
}