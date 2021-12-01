package org.zeith.cfcore4j.categories;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.Category;

import java.util.List;

public class GetCategoriesResponse
{
	public final List<Category> data;

	public GetCategoriesResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), Category::new);
	}

	@Override
	public String toString()
	{
		return "GetCategoriesResponse{" +
				"data=" + data +
				'}';
	}
}