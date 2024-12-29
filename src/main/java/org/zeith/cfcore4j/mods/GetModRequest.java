package org.zeith.cfcore4j.mods;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModRequest
		implements IQueryContainer
{
	private long modId;

	public GetModRequest(long modId)
	{
		this.modId = modId;
	}

	public static GetModRequest create(long modId)
	{
		return new GetModRequest(modId);
	}

	public GetModRequest modId(long modId)
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