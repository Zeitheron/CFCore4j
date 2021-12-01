package org.zeith.cfcore4j.errors;

public class CFCoreException extends RuntimeException
{
	public CFCoreException()
	{
	}

	public CFCoreException(String message)
	{
		super(message);
	}

	public CFCoreException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public CFCoreException(Throwable cause)
	{
		super(cause);
	}

	public CFCoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}