package org.zeith.cfcore4j;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Util
{
	public static Instant parseDateTime(String dateTime)
	{
		if(dateTime == null || dateTime.isEmpty()) return null;
		try
		{
			return Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(dateTime));
		} catch(DateTimeException e)
		{
			return null;
		}
	}

	public static <T> List<T> parseList(JSONArray array, Function<JSONObject, T> factory)
	{
		if(array == null || array.isEmpty()) return Collections.emptyList();
		List<T> lst = new ArrayList<>();
		for(int i = 0; i < array.length(); i++) lst.add(factory.apply(array.getJSONObject(i)));
		return Collections.unmodifiableList(lst);
	}

	public static List<String> parseListStr(JSONArray array)
	{
		if(array == null || array.isEmpty()) return Collections.emptyList();
		List<String> lst = new ArrayList<>();
		for(int i = 0; i < array.length(); i++) lst.add(array.getString(i));
		return Collections.unmodifiableList(lst);
	}

	public static List<Long> parseListLong(JSONArray array)
	{
		if(array == null || array.isEmpty()) return Collections.emptyList();
		List<Long> lst = new ArrayList<>();
		for(int i = 0; i < array.length(); i++) lst.add(array.getLong(i));
		return Collections.unmodifiableList(lst);
	}

	public static <I, V> Map<String, V> parseMap(JSONObject object, BiFunction<JSONObject, String, I> intermediate, Function<I, V> bake)
	{
		Map<String, V> map = new HashMap<>();
		for(String key : object.keySet())
			map.put(key, bake.apply(intermediate.apply(object, key)));
		return Collections.unmodifiableMap(map);
	}

	public static <T> T make(Supplier<T> maker)
	{
		return maker.get();
	}
}