package org.zeith.cfcore4j.games;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetGameRequest
		implements IQueryContainer
{
	private long gameId;

	public GetGameRequest(long gameId)
	{
		this.gameId = gameId;
	}

	public static GetGameRequest create(long gameId)
	{
		return new GetGameRequest(gameId);
	}

	public GetGameRequest gameId(long gameId)
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