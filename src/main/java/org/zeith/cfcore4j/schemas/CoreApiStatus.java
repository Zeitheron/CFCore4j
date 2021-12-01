package org.zeith.cfcore4j.schemas;

public enum CoreApiStatus
{
	PUBLIC, // 1
	PRIVATE, // 2
	UNKNOWN;

	private static final CoreApiStatus[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static CoreApiStatus fromJson(int i)
	{
		if(i < 1 || i > VALUES.length) return UNKNOWN;
		return VALUES[i - 1];
	}
}