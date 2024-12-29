package org.zeith.cfcore4j.schemas;

public enum GameVersionTypeStatus
{
	NORMAL, // 1
	DELETED, // 2
	UNKNOWN;

	private static final GameVersionTypeStatus[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static GameVersionTypeStatus fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}