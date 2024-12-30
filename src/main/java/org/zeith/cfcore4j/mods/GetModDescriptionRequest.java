package org.zeith.cfcore4j.mods;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;

public class GetModDescriptionRequest
		implements IQueryContainer
{
	private long modId;
	private Boolean raw;
	private Boolean stripped;
	private Boolean markup;
	
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
	
	public GetModDescriptionRequest raw(boolean raw)
	{
		this.raw = raw;
		return this;
	}
	
	public GetModDescriptionRequest stripped(boolean stripped)
	{
		this.stripped = stripped;
		return this;
	}
	
	public GetModDescriptionRequest markup(boolean markup)
	{
		this.markup = markup;
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
				.put("modId", modId)
				.put("raw", raw)
				.put("stripped", stripped)
				.put("raw", raw)
				.put("markup", markup)
				;
	}
}