package org.zeith.cfcore4j.files;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetFilesRequest
{
	private final List<Long> fileIds = new ArrayList<>();

	public static GetFilesRequest create()
	{
		return new GetFilesRequest();
	}

	public GetFilesRequest addFile(long... fileId)
	{
		for(long i : fileId)
			this.fileIds.add(i);
		return this;
	}

	public GetFilesRequest addFile(Collection<Long> fileId)
	{
		this.fileIds.addAll(fileId);
		return this;
	}

	public GetFilesRequest addFile(Iterable<Long> fileId)
	{
		for(long i : fileId)
			this.fileIds.add(i);
		return this;
	}

	public List<Long> fileIds()
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