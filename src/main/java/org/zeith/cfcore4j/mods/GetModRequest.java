package org.zeith.cfcore4j.mods;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModRequest
		implements IQueryContainer
{
	private int modId;

	public GetModRequest(int modId)
	{
		this.modId = modId;
	}

	public static GetModRequest create(int modId)
	{
		return new GetModRequest(modId);
	}

	public GetModRequest modId(int modId)
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