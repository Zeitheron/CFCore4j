package org.zeith.cfcore4j.schemas;

public enum ModLoaderInstallMethod
{
	FORGE_INSTALLER, // 1
	FORGE_JAR_INSTALL, // 2
	FORGE_INSTALLER_V2, // 3
	FABRIC_INSTALLER, // 4 (undocumented...)
	QUILT_INSTALLER, // 5 (undocumented...)
	NEOFORGE_INSTALLER, // 6 (undocumented...)
	UNKNOWN;

	private static final ModLoaderInstallMethod[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static ModLoaderInstallMethod fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}