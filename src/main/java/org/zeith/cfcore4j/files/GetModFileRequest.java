package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFileRequest
		implements IQueryContainer
{
	private int modId;
	private int fileId;

	public GetModFileRequest(int modId, int fileId)
	{
		this.modId = modId;
		this.fileId = fileId;
	}

	public static GetModFileRequest create(int modId, int fileId)
	{
		return new GetModFileRequest(modId, fileId);
	}

	public GetModFileRequest modId(int modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFileRequest fileId(int fileId)
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