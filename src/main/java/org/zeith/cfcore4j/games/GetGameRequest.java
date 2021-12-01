package org.zeith.cfcore4j.games;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetGameRequest
		implements IQueryContainer
{
	private int gameId;

	public GetGameRequest(int gameId)
	{
		this.gameId = gameId;
	}

	public static GetGameRequest create(int gameId)
	{
		return new GetGameRequest(gameId);
	}

	public GetGameRequest gameId(int gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public int gameId()
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