package org.zeith.cfcore4j.games;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetVersionsRequest
		implements IQueryContainer
{
	private int gameId;

	public GetVersionsRequest(int gameId)
	{
		this.gameId = gameId;
	}

	public static GetVersionsRequest create(int gameId)
	{
		return new GetVersionsRequest(gameId);
	}

	public GetVersionsRequest gameId(int gameId)
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