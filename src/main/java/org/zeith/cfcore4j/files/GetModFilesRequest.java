package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFilesRequest
		implements IQueryContainer
{
	private long modId;
	private Long gameVersionTypeId;
	private Integer index;
	private Integer pageSize;

	public GetModFilesRequest(long modId)
	{
		this.modId = modId;
	}

	public static GetModFilesRequest create(long modId)
	{
		return new GetModFilesRequest(modId);
	}

	public GetModFilesRequest modId(long modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFilesRequest gameVersionTypeId(Long gameVersionTypeId)
	{
		this.gameVersionTypeId = gameVersionTypeId;
		return this;
	}

	public GetModFilesRequest index(Integer index)
	{
		this.index = index;
		return this;
	}

	public GetModFilesRequest pageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
		return this;
	}

	public long modId()
	{
		return this.modId;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("gameVersionTypeId", gameVersionTypeId)
				.put("index", index)
				.put("pageSize", pageSize);
	}

	@Override
	public GetModFilesRequest clone()
	{
		GetModFilesRequest r = new GetModFilesRequest(modId);
		r.gameVersionTypeId = gameVersionTypeId;
		r.index = index;
		r.pageSize = pageSize;
		return r;
	}
}