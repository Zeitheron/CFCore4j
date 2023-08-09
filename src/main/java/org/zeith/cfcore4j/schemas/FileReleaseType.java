package org.zeith.cfcore4j.schemas;

public enum FileReleaseType
{
	RELEASE, // 1
	BETA, // 2
	ALPHA, // 3
	UNKNOWN;

	private static final FileReleaseType[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static FileReleaseType fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}