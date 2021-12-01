package org.zeith.cfcore4j.schemas;

public enum ModLoaderType
{
	ANY, // 0
	FORGE, // 1
	CAULDRON, // 2
	LITE_LOADER, // 3
	FABRIC, // 4
	UNKNOWN;

	private static final ModLoaderType[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 0;
		return ordinal();
	}

	public static ModLoaderType fromJson(int i)
	{
		if(i < 0 || i > VALUES.length) return UNKNOWN;
		return VALUES[i];
	}
}