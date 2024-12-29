package org.zeith.cfcore4j.mods;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModDescriptionRequest
		implements IQueryContainer
{
	private long modId;

	public GetModDescriptionRequest(long modId)
	{
		this.modId = modId;
	}

	public static GetModDescriptionRequest create(long modId)
	{
		return new GetModDescriptionRequest(modId);
	}

	public GetModDescriptionRequest modId(long modId)
	{
		this.modId = modId;
		return this;
	}

	public long modId()
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