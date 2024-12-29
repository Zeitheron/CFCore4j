package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFileRequest
		implements IQueryContainer
{
	private long modId;
	private long fileId;

	public GetModFileRequest(long modId, long fileId)
	{
		this.modId = modId;
		this.fileId = fileId;
	}

	public static GetModFileRequest create(long modId, long fileId)
	{
		return new GetModFileRequest(modId, fileId);
	}

	public GetModFileRequest modId(long modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFileRequest fileId(long fileId)
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