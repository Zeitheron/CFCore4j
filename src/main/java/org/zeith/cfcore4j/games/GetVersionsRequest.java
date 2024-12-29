package org.zeith.cfcore4j.games;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetVersionsRequest
		implements IQueryContainer
{
	private long gameId;

	public GetVersionsRequest(long gameId)
	{
		this.gameId = gameId;
	}

	public static GetVersionsRequest create(long gameId)
	{
		return new GetVersionsRequest(gameId);
	}

	public GetVersionsRequest gameId(long gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public long gameId()
	{
		return gameId;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("gameId", gameId);
	}
}