package org.zeith.cfcore4j.categories;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetCategoriesRequest
		implements IQueryContainer
{
	private Long gameId;
	private Long classId;
	private Boolean classesOnly;

	public static GetCategoriesRequest create()
	{
		return new GetCategoriesRequest();
	}

	public GetCategoriesRequest gameId(long gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public GetCategoriesRequest classId(long classId)
	{
		this.classId = classId;
		return this;
	}

	public GetCategoriesRequest classesOnly(boolean classesOnly)
	{
		this.classesOnly = classesOnly;
		return this;
	}

	public Long gameId()
	{
		return gameId;
	}

	public Long classId()
	{
		return classId;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("gameId", gameId)
				.put("classId", classId)
				.put("classesOnly", classesOnly);
	}
}