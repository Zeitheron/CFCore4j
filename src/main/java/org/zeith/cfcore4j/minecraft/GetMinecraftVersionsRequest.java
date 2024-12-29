package org.zeith.cfcore4j.minecraft;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;
import org.zeith.cfcore4j.schemas.SortOrder;

public class GetMinecraftVersionsRequest
		implements IQueryContainer
{
	private SortOrder sort;
	
	public static GetMinecraftVersionsRequest create()
	{
		return new GetMinecraftVersionsRequest();
	}
	
	public GetMinecraftVersionsRequest sort(SortOrder order)
	{
		this.sort = order;
		return this;
	}
	
	@Override
	public QueryBuilder toBuilder()
	{
		QueryBuilder qb = QueryBuilder.start();
		if(sort != null) qb.put("sortDescending", sort == SortOrder.DESCENDING);
		return qb;
	}
}