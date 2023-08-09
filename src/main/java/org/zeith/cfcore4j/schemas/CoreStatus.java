package org.zeith.cfcore4j.schemas;

public enum CoreStatus
{
	DRAFT, // 1
	TEST, // 2
	PENDING_REVIEW, // 3
	REJECTED, // 4
	APPROVED, // 5
	LIVE, // 6
	UNKNOWN;

	private static final CoreStatus[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static CoreStatus fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}