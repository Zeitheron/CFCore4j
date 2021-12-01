package org.zeith.cfcore4j.query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder
{
	public static QueryBuilder start()
	{
		return new QueryBuilder();
	}

	final List<String> params = new ArrayList<>();

	private QueryBuilder()
	{
	}

	public QueryBuilder put(String key, Object v)
	{
		String p = nonNullParam(key, v);
		if(!p.isEmpty()) params.add(p);
		return this;
	}

	public QueryBuilder putOrdinal(String key, Enum<?> v)
	{
		String p = nonNullParamOrdinal(key, v);
		if(!p.isEmpty()) params.add(p);
		return this;
	}

	public String build()
	{
		if(params.isEmpty()) return "";
		return "?" + String.join("&", params);
	}

	@Override
	public String toString()
	{
		return build();
	}

	static String urlEncode(String v)
	{
		try
		{
			return URLEncoder.encode(v, "UTF-8");
		} catch(UnsupportedEncodingException e)
		{
			return URLEncoder.encode(v);
		}
	}

	static String nonNullParam(String key, Object value)
	{
		if(value != null && key != null && !key.isEmpty())
		{
			String v;

			if(value instanceof IStringable) v = ((IStringable) value).asString();
			else v = value.toString();

			if(v != null && !v.isEmpty())
				return key + "=" + urlEncode(v);
		}
		return "";
	}

	static String nonNullParamOrdinal(String key, Enum<?> value)
	{
		if(value != null && key != null && !key.isEmpty())
		{
			String v = Integer.toString(value.ordinal());
			return key + "=" + urlEncode(v);
		}
		return "";
	}
}