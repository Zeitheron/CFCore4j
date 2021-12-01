package org.zeith.cfcore4j.mods;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModDescriptionRequest
		implements IQueryContainer
{
	private int modId;

	public GetModDescriptionRequest(int modId)
	{
		this.modId = modId;
	}

	public static GetModDescriptionRequest create(int modId)
	{
		return new GetModDescriptionRequest(modId);
	}

	public GetModDescriptionRequest modId(int modId)
	{
		this.modId = modId;
		return this;
	}

	public int modId()
	{
		return modId;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("modId", modId);
	}
}