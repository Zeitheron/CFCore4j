package org.zeith.cfcore4j.base;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
	
	static HTTPCacheInRAM cacheInRAMFor(TimeUnit unit, long duration)
	{
		return new HTTPCacheInRAM(unit.toMillis(duration));
	}
	
	class HTTPCacheInRAM
			implements HTTPCache
	{
		private final long cacheLifespanMS;
		private final Map<String, CacheEntry> cacheContent = new ConcurrentHashMap<>();
		private int cacheSizeLimit;
		
		public HTTPCacheInRAM(long cacheLifespanMS)
		{
			this.cacheLifespanMS = cacheLifespanMS;
		}
		
		public HTTPCacheInRAM cacheSizeLimit(int cacheSizeLimit)
		{
			this.cacheSizeLimit = cacheSizeLimit;
			return this;
		}
		
		@Override
		public boolean shouldRefresh(String url)
		{
			return !cacheContent.containsKey(url) || System.currentTimeMillis() - cacheContent.get(url).time >= cacheLifespanMS;
		}
		
		@Override
		public String getCached(String url)
		{
			CacheEntry e = cacheContent.get(url);
			return e != null ? e.value : null;
		}
		
		@Override
		public void putCached(String url, String value)
		{
			cacheContent.put(url, new CacheEntry(
							System.currentTimeMillis(),
							value
					)
			);
			
			if(cacheSizeLimit > 0 && cacheContent.size() > cacheSizeLimit)
			{
				cacheContent.entrySet()
						.stream()
						.min(Comparator.comparingLong(e -> e.getValue().time))
						.map(Map.Entry::getKey)
						.ifPresent(cacheContent::remove);
			}
		}
		
		private static class CacheEntry
		{
			long time;
			String value;
			
			public CacheEntry(long time, String value)
			{
				this.time = time;
				this.value = value;
			}
		}
	}
}