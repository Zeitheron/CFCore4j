package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFileDownloadURLRequest
		implements IQueryContainer
{
	private long modId;
	private long fileId;

	public GetModFileDownloadURLRequest(long modId, long fileId)
	{
		this.modId = modId;
		this.fileId = fileId;
	}

	public static GetModFileDownloadURLRequest create(long modId, long fileId)
	{
		return new GetModFileDownloadURLRequest(modId, fileId);
	}

	public GetModFileDownloadURLRequest modId(long modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFileDownloadURLRequest fileId(long fileId)
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