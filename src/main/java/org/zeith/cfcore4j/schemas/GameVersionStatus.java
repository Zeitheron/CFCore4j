package org.zeith.cfcore4j.schemas;

public enum GameVersionStatus
{
	APPROVED, // 1
	DELETED, // 2
	NEW, // 3
	UNKNOWN;

	private static final GameVersionStatus[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static GameVersionStatus fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}