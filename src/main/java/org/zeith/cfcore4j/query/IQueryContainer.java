package org.zeith.cfcore4j.query;

import org.zeith.cfcore4j.errors.CFCoreException;
import org.zeith.cfcore4j.errors.ListSizeLimitExceededException;

import java.util.Collection;

public interface IQueryContainer
{
	default void validate()
			throws CFCoreException
	{
	}
	
	QueryBuilder toBuilder();
	
	static void limitListSize(String fieldId, Collection<?> list, int limit)
			throws ListSizeLimitExceededException
	{
		if(list != null && list.size() > limit)
			throw new ListSizeLimitExceededException(fieldId, list, limit);
	}
}