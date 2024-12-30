package org.zeith.cfcore4j.errors;

import java.util.Collection;

public class ListSizeLimitExceededException
		extends CFCoreException
{
	public final String fieldId;
	public final Collection<?> values;
	
	public ListSizeLimitExceededException(String fieldId, Collection<?> values, int max)
	{
		super("List size exceeded for field " + fieldId + ": " + values.size() + "/" + max);
		this.fieldId = fieldId;
		this.values = values;
	}
}