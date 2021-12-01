package org.zeith.cfcore4j;

import org.zeith.cfcore4j.categories.GetCategoriesRequest;
import org.zeith.cfcore4j.categories.GetCategoriesResponse;
import org.zeith.cfcore4j.schemas.Category;

import java.util.List;

public class Categories
{
	final CFCore4j core;

	Categories(CFCore4j core)
	{
		this.core = core;
	}

	/**
	 * Get all available classes and categories of the specified game. Specify a game id for a list of all game categories, or a class id for a list of categories under that class.
	 *
	 * @param req GetCategoriesRequest
	 * @return GetCategoriesResponse
	 * @see GetCategoriesRequest
	 * @see GetCategoriesResponse
	 */
	public GetCategoriesResponse getCategories(GetCategoriesRequest req)
	{
		return new GetCategoriesResponse(
				core.checkValid("Categories",
						core.getAuth("categories", req)
				).jsonObjectBody()
		);
	}

	/**
	 * Get all available classes and categories of the specified game. Specify a game id for a list of all game categories, or a class id for a list of categories under that class.
	 *
	 * @param gameId The game to get categories for.
	 * @return A list of categories
	 * @see Category
	 */
	public List<Category> getCategories(int gameId)
	{
		return getCategories(GetCategoriesRequest.create().gameId(gameId)).data;
	}

	/**
	 * Get all available classes and categories of the specified game. Specify a game id for a list of all game categories, or a class id for a list of categories under that class.
	 *
	 * @param gameId The game to get categories for.
	 * @param classId The class to get categories for.
	 * @return A list of categories
	 * @see Category
	 */
	public List<Category> getCategories(int gameId, int classId)
	{
		return getCategories(GetCategoriesRequest.create().gameId(gameId).classId(classId)).data;
	}
}