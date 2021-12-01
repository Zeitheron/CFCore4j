package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFileDownloadURLRequest
		implements IQueryContainer
{
	private int modId;
	private int fileId;

	public GetModFileDownloadURLRequest(int modId, int fileId)
	{
		this.modId = modId;
		this.fileId = fileId;
	}

	public static GetModFileDownloadURLRequest create(int modId, int fileId)
	{
		return new GetModFileDownloadURLRequest(modId, fileId);
	}

	public GetModFileDownloadURLRequest modId(int modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFileDownloadURLRequest fileId(int fileId)
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