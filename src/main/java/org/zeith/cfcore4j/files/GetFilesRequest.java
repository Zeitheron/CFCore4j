package org.zeith.cfcore4j.files;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetFilesRequest
{
	private final List<Integer> fileIds = new ArrayList<>();

	public static GetFilesRequest create()
	{
		return new GetFilesRequest();
	}

	public GetFilesRequest addFile(int... fileId)
	{
		for(int i : fileId)
			this.fileIds.add(i);
		return this;
	}

	public GetFilesRequest addFile(Collection<Integer> fileId)
	{
		this.fileIds.addAll(fileId);
		return this;
	}

	public GetFilesRequest addFile(Iterable<Integer> fileId)
	{
		for(int i : fileId)
			this.fileIds.add(i);
		return this;
	}

	public List<Integer> fileIds()
	{
		return Collections.unmodifiableList(fileIds);
	}

	@Override
	public String toString()
	{
		JSONObject $ = new JSONObject();
		$.put("fileIds", fileIds);
		return $.toString();
	}
}