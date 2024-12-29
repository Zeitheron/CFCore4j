package org.zeith.cfcore4j.minecraft;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;
import org.zeith.cfcore4j.schemas.SortOrder;

public class GetMinecraftModLoadersRequest
		implements IQueryContainer
{
	private String version;
	private Boolean includeAll;
	
	public static GetMinecraftModLoadersRequest create()
	{
		return new GetMinecraftModLoadersRequest();
	}
	
	public GetMinecraftModLoadersRequest version(String version)
	{
		this.version = version;
		return this;
	}
	
	public GetMinecraftModLoadersRequest includeAll(boolean includeAll)
	{
		this.includeAll = includeAll;
		return this;
	}
	
	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("version", version)
				.put("includeAll", includeAll);
	}
}