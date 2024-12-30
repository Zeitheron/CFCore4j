package org.zeith.cfcore4j.base;

import org.json.JSONArray;
import org.json.JSONObject;
import org.zeith.cfcore4j.schemas.Pagination;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class PaginatedResponse<V, R extends PaginatedResponse<V, R>>
{
	public final List<V> data;
	public final Pagination pagination;

	public PaginatedResponse(JSONObject $)
	{
		this.data = decodeData($.getJSONArray("data"));
		this.pagination = new Pagination($.getJSONObject("pagination"));
	}

	protected abstract List<V> decodeData(JSONArray data);

	public abstract R fromIndex(long index);

	public R nextPage()
	{
		return pagination.resultCount > 0 ? fromIndex(pagination.index + pagination.resultCount) : (R) this;
	}

	public R prevPage()
	{
		return pagination.index > 0 ? fromIndex(Math.max(0, pagination.index - pagination.resultCount)) : (R) this;
	}

	public boolean contains(long idx)
	{
		return idx >= pagination.index && idx < pagination.index + pagination.resultCount;
	}

	public V get(long idx)
	{
		if(contains(idx)) return data.get((int) (idx - pagination.index));
		return null;
	}

	public Stream<V> streamTillEnd()
	{
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterateTillEnd(), 0), false);
	}

	public Iterator<V> iterateTillEnd()
	{
		long totalCount = pagination.totalCount;

		return new Iterator<V>()
		{
			private long i = pagination.index;
			private PaginatedResponse<V, R> currentPage = PaginatedResponse.this;

			@Override
			public boolean hasNext()
			{
				return currentPage != null && i < totalCount;
			}

			@Override
			public V next()
			{
				if(currentPage != null && currentPage.contains(i))
				{
					V mod = currentPage.get(i);
					i++;
					if(!currentPage.contains(i) && i < totalCount)
						currentPage = currentPage.nextPage();
					return mod;
				}
				return null;
			}
		};
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + "{" +
				"data=" + data +
				", pagination=" + pagination +
				'}';
	}
}