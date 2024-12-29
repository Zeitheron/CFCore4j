package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFileChangelogRequest
		implements IQueryContainer
{
	private long modId;
	private long fileId;

	public GetModFileChangelogRequest(long modId, long fileId)
	{
		this.modId = modId;
		this.fileId = fileId;
	}

	public static GetModFileChangelogRequest create(long modId, long fileId)
	{
		return new GetModFileChangelogRequest(modId, fileId);
	}

	public GetModFileChangelogRequest modId(long modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFileChangelogRequest fileId(long fileId)
	{
		this.fileId = fileId;
		return this;
	}

	public long modId()
	{
		return modId;
	}

	public long fileId()
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