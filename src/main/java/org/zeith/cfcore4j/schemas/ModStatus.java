package org.zeith.cfcore4j.schemas;

public enum ModStatus
{
	NEW, // 1
	CHANGES_REQUIRED, // 2
	UNDER_SOFT_REVIEW, // 3
	APPROVED, // 4
	REJECTED, // 5
	CHANGES_MADE, // 6
	INACTIVE, // 7
	ABANDONED, // 8
	DELETED, // 9
	UNDER_REVIEW, // 10
	UNKNOWN;

	private static final ModStatus[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static ModStatus fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}