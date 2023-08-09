package org.zeith.cfcore4j.schemas;

public enum ModLoaderType
{
	ANY, // 0
	FORGE, // 1
	CAULDRON, // 2
	LITE_LOADER, // 3
	FABRIC, // 4
	QUILT, // 5
	NEOFORGED, // 6
	UNKNOWN; // 7

	private static final ModLoaderType[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 0;
		return ordinal();
	}

	public static ModLoaderType fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i];
	}
}