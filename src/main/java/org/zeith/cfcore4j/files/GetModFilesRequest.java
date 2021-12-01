package org.zeith.cfcore4j.files;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModFilesRequest
		implements IQueryContainer
{
	private int modId;
	private Integer gameVersionTypeId;
	private Integer index;
	private Integer pageSize;

	public GetModFilesRequest(int modId)
	{
		this.modId = modId;
	}

	public static GetModFilesRequest create(int modId)
	{
		return new GetModFilesRequest(modId);
	}

	public GetModFilesRequest modId(int modId)
	{
		this.modId = modId;
		return this;
	}

	public GetModFilesRequest gameVersionTypeId(Integer gameVersionTypeId)
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

	public int modId()
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
}