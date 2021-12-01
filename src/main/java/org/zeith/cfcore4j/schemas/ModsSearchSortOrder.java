package org.zeith.cfcore4j.schemas;

public enum ModsSearchSortOrder
{
	ASCENDING("asc"),
	DESCENDING("desc");

	final String kind;

	ModsSearchSortOrder(String kind)
	{
		this.kind = kind;
	}

	@Override
	public String toString()
	{
		return kind;
	}
}