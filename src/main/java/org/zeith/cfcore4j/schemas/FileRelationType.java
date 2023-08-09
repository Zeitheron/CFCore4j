package org.zeith.cfcore4j.schemas;

public enum FileRelationType
{
	EMBEDDED_LIBRARY, // 1
	OPTIONAL_DEPENDENCY, // 2
	REQUIRED_DEPENDENCY, // 3
	TOOL, // 4
	INCOMPATIBLE, // 5
	INCLUDE, // 6
	UNKNOWN;

	private static final FileRelationType[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static FileRelationType fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}