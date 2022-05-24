package org.zeith.cfcore4j.base;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface HTTPCache
{
	boolean shouldRefresh(String url);
	
	String getCached(String url);
	
	default JSONObject getCachedJSONObject(String url)
	{
		String v = getCached(url);
		if(v == null || v.isEmpty()) return null;
		return (JSONObject) new JSONTokener(v).nextValue();
	}
	
	void putCached(String url, String value);
	
	static HTTPCache cacheInRAMFor(TimeUnit unit, long duration)
	{
		return new HTTPCacheInRAM(unit.toMillis(duration));
	}
	
	class HTTPCacheInRAM implements HTTPCache
	{
		private final long cacheLifespanMS;
		private final Map<String, Long> cacheTime = new HashMap<>();
		private final Map<String, String> cacheContent = new HashMap<>();
		
		public HTTPCacheInRAM(long cacheLifespanMS)
		{
			this.cacheLifespanMS = cacheLifespanMS;
		}
		
		@Override
		public boolean shouldRefresh(String url)
		{
			return !cacheTime.containsKey(url) || System.currentTimeMillis() - cacheTime.get(url) >= cacheLifespanMS;
		}
		
		@Override
		public String getCached(String url)
		{
			return cacheContent.get(url);
		}
		
		@Override
		public void putCached(String url, String value)
		{
			cacheTime.put(url, System.currentTimeMillis());
			cacheContent.put(url, value);
		}
	}
}