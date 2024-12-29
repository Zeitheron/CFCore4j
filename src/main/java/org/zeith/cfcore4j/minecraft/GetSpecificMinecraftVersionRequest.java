package org.zeith.cfcore4j.minecraft;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetSpecificMinecraftVersionRequest
		implements IQueryContainer
{
	private String gameVersionString;
	
	public static GetSpecificMinecraftVersionRequest create()
	{
		return new GetSpecificMinecraftVersionRequest();
	}
	
	public GetSpecificMinecraftVersionRequest gameVersion(String gameVersionString)
	{
		this.gameVersionString = gameVersionString;
		return this;
	}
	
	public String getGameVersionString()
	{
		return gameVersionString;
	}
	
	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start();
	}
}