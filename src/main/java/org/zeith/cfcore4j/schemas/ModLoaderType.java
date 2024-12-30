package org.zeith.cfcore4j.schemas;

public enum ModLoaderType
{
	ANY("Any"), // 0
	FORGE("Forge"), // 1
	CAULDRON("Cauldron"), // 2
	LITE_LOADER("LiteLoader"), // 3
	FABRIC("Fabric"), // 4
	QUILT("Quilt"), // 5
	NEOFORGE("NeoForge"), // 6
	UNKNOWN(null); // 7

	private static final ModLoaderType[] VALUES = values();
	
	public final String jsonName;
	
	ModLoaderType(String jsonName)
	{
		this.jsonName = jsonName;
	}
	
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