package org.zeith.cfcore4j;

import org.zeith.cfcore4j.categories.GetCategoriesRequest;
import org.zeith.cfcore4j.categories.GetCategoriesResponse;

public class Categories
{
	final CFCore4j core;

	Categories(CFCore4j core)
	{
		this.core = core;
	}

	public GetCategoriesResponse getCategories(GetCategoriesRequest req)
	{
		return new GetCategoriesResponse(
				core.checkValid("Categories",
						core.getAuth("categories", req)
				).jsonObjectBody()
		);
	}
}