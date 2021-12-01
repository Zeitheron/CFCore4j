package org.zeith.cfcore4j.games;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetVersionTypesRequest
		implements IQueryContainer
{
	private int gameId;

	public GetVersionTypesRequest(int gameId)
	{
		this.gameId = gameId;
	}

	public static GetVersionTypesRequest create(int gameId)
	{
		return new GetVersionTypesRequest(gameId);
	}

	public GetVersionTypesRequest gameId(int gameId)
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