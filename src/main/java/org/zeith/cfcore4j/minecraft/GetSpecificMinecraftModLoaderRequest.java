package org.zeith.cfcore4j.minecraft;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetSpecificMinecraftModLoaderRequest
		implements IQueryContainer
{
	private String modLoaderName;
	
	public static GetSpecificMinecraftModLoaderRequest create()
	{
		return new GetSpecificMinecraftModLoaderRequest();
	}
	
	public GetSpecificMinecraftModLoaderRequest modLoaderName(String modLoaderName)
	{
		this.modLoaderName = modLoaderName;
		return this;
	}
	
	public String modLoaderName()
	{
		return modLoaderName;
	}
	
	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start();
	}
}