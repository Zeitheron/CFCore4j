package org.zeith.cfcore4j.guava;

import java.io.IOException;
import java.io.OutputStream;

public class RatelimitOutputStream
		extends OutputStream
{
	private final RateLimiter limiter;
	private final OutputStream out;

	public RatelimitOutputStream(RateLimiter limiter, OutputStream out)
	{
		this.limiter = limiter;
		this.out = out;
	}

	@Override
	public void write(byte[] b) throws IOException
	{
		if(limiter != null)
			limiter.acquire(b.length);
		out.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException
	{
		if(limiter != null)
			limiter.acquire(len);
		out.write(b, off, len);
	}

	@Override
	public void flush() throws IOException
	{
		out.flush();
	}

	@Override
	public void close() throws IOException
	{
		out.close();
	}

	@Override
	public void write(int b) throws IOException
	{
		if(limiter != null)
			limiter.acquire();
		out.write(b);
	}
}

