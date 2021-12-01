package org.zeith.cfcore4j.errors;

public class CFNotFoundException
		extends CFCoreException
{
	public CFNotFoundException()
	{
	}

	public CFNotFoundException(String message)
	{
		super(message);
	}

	public CFNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public CFNotFoundException(Throwable cause)
	{
		super(cause);
	}

	public CFNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}