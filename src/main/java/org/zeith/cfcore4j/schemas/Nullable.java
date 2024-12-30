package org.zeith.cfcore4j.schemas;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Nullable<T>
{
	public T value;
	
	public Nullable(T value)
	{
		this.value = value;
	}
	
	public Optional<T> optional()
	{
		return Optional.ofNullable(value);
	}
	
	public Stream<T> stream()
	{
		return value != null ? Stream.of(value) : Stream.empty();
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