package org.zeith.cfcore4j.schemas;

public enum SortOrder
{
	ASCENDING("asc"),
	DESCENDING("desc");

	final String kind;

	SortOrder(String kind)
	{
		this.kind = kind;
	}

	@Override
	public String toString()
	{
		return kind;
	}
}