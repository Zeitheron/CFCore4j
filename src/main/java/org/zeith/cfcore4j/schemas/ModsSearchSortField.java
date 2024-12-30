package org.zeith.cfcore4j.schemas;

import org.zeith.cfcore4j.query.IStringable;

public enum ModsSearchSortField implements IStringable
{
	FEATURED, // 1
	POPULARITY, // 2
	LAST_UPDATED, // 3
	NAME, // 4
	AUTHOR, // 5
	TOTAL_DOWNLOADS, // 6
	CATEGORY, // 7
	GAME_VERSION, // 8
	EARLY_ACCESS, // 9
	FEATURED_RELEASED, // 10
	RELEASED_DATE, // 11
	RATING, // 12
	UNKNOWN;

	private static final ModsSearchSortField[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static ModsSearchSortField fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}

	@Override
	public String asString()
	{
		return Integer.toString(toJson());
	}
}