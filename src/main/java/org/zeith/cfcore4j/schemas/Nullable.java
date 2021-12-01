package org.zeith.cfcore4j.schemas;

import java.util.Objects;

public class Nullable<T>
{
	public T value;

	public Nullable(T value)
	{
		this.value = value;
	}

	public boolean isNull()
	{
		return value == null;
	}

	public boolean notNull()
	{
		return value == null;
	}

	@Override
	public String toString()
	{
		return Objects.toString(value);
	}
}