package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFileChangelogRequest
		implements IQueryContainer
{
	private int modId;
	private int fileId;

	public GetModFileChangelogRequest(int modId, int fileId)
	{
		this.modId = modId;
		this.fileId = fileId;
	}

	public static GetModFileChangelogRequest create(int modId, int fileId)
	{
		return new GetModFileChangelogRequest(modId, fileId);
	}

	public GetModFileChangelogRequest modId(int modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFileChangelogRequest fileId(int fileId)
	{
		this.fileId = fileId;
		return this;
	}

	public int modId()
	{
		return modId;
	}

	public int fileId()
	{
		return fileId;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("modId", modId)
				.put("fileId", fileId);
	}
}