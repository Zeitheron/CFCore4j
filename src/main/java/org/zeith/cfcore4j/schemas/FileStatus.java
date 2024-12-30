package org.zeith.cfcore4j.schemas;

public enum FileStatus
{
	PROCESSING, // 1
	CHANGES_REQUIRED, // 2
	UNDER_REVIEW, // 3
	APPROVED, // 4
	REJECTED, // 5
	MALWARE_DETECTED, // 6
	DELETED, // 7
	ARCHIVED, // 8
	TESTING, // 9
	RELEASED, //10
	READY_FOR_REVIEW, // 11
	DEPRECATED, // 12
	BAKING, // 13
	AWAITING_PUBLISHING, // 14
	FAILED_PUBLISHING, // 15
	UNDOCUMENTED_16, // 16
	UNDOCUMENTED_17, // 17
	UNDOCUMENTED_18, // 18
	UNDOCUMENTED_19, // 19
	UNKNOWN;

	private static final FileStatus[] VALUES = values();

	public int toJson()
	{
		if(this == UNKNOWN) return 1;
		return ordinal() + 1;
	}

	public static FileStatus fromJson(int i)
	{
		if(i < 1 || i >= VALUES.length)
		{
			System.err.println("Found unknown " + UNKNOWN.getClass().getSimpleName() + " ordinal: " + i);
			return UNKNOWN;
		}
		return VALUES[i - 1];
	}
}