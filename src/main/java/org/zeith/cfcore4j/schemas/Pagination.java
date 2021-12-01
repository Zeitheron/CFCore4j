package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class Pagination
{
	public final int resultCount;
	public final int index;
	public final int pageSize;
	public final int totalCount;

	public Pagination(JSONObject $)
	{
		this.resultCount = $.getInt("resultCount");
		this.index = $.getInt("index");
		this.pageSize = $.getInt("pageSize");
		this.totalCount = $.getInt("totalCount");
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