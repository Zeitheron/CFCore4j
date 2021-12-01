package org.zeith.cfcore4j.errors;

public class CFAuthenticationException
		extends CFCoreException
{
	public CFAuthenticationException()
	{
	}

	public CFAuthenticationException(String message)
	{
		super(message);
	}

	public CFAuthenticationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public CFAuthenticationException(Throwable cause)
	{
		super(cause);
	}

	public CFAuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}