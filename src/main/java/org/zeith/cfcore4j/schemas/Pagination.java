package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class Pagination
{
	public final int resultCount;
	public final long index;
	public final int pageSize;
	public final long totalCount;

	public Pagination(JSONObject $)
	{
		this.resultCount = $.getInt("resultCount");
		this.index = $.getLong("index");
		this.pageSize = $.getInt("pageSize");
		this.totalCount = $.getLong("totalCount");
	}

	@Override
	public String toString()
	{
		return "Pagination{" +
				"resultCount=" + resultCount +
				", index=" + index +
				", pageSize=" + pageSize +
				", totalCount=" + totalCount +
				'}';
	}
}