package org.zeith.cfcore4j.schemas;

public enum HashAlgo
{
	SHA1, // 1
	MD5, // 2
	UNKNOWN;

	private static final HashAlgo[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static HashAlgo fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}