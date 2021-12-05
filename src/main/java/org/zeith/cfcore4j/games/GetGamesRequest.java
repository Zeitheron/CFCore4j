package org.zeith.cfcore4j.games;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetGamesRequest
		implements IQueryContainer
{
	private Integer index;
	private Integer pageSize;

	public static GetGamesRequest create()
	{
		return new GetGamesRequest();
	}

	public GetGamesRequest index(int index)
	{
		this.index = index;
		return this;
	}

	public GetGamesRequest pageSize(int pageSize)
	{
		this.pageSize = pageSize;
		return this;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("index", index)
				.put("pageSize", pageSize);
	}

	@Override
	public GetGamesRequest clone()
	{
		GetGamesRequest r = new GetGamesRequest();
		r.index = index;
		r.pageSize = pageSize;
		return r;
	}
}