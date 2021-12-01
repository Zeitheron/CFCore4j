package org.zeith.cfcore4j.categories;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetCategoriesRequest
		implements IQueryContainer
{
	private Integer gameId;
	private Integer classId;

	public static GetCategoriesRequest create()
	{
		return new GetCategoriesRequest();
	}

	public GetCategoriesRequest gameId(int gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public GetCategoriesRequest classId(int classId)
	{
		this.classId = classId;
		return this;
	}

	public Integer gameId()
	{
		return gameId;
	}

	public Integer classId()
	{
		return classId;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("gameId", gameId)
				.put("classId", classId);
	}
}