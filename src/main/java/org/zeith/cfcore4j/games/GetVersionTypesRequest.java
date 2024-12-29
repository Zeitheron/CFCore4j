package org.zeith.cfcore4j.games;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetVersionTypesRequest
		implements IQueryContainer
{
	private long gameId;

	public GetVersionTypesRequest(long gameId)
	{
		this.gameId = gameId;
	}

	public static GetVersionTypesRequest create(long gameId)
	{
		return new GetVersionTypesRequest(gameId);
	}

	public GetVersionTypesRequest gameId(long gameId)
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