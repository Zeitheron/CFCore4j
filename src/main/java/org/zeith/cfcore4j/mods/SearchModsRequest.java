package org.zeith.cfcore4j.mods;

import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;
import org.zeith.cfcore4j.schemas.ModLoaderType;
import org.zeith.cfcore4j.schemas.ModsSearchSortField;
import org.zeith.cfcore4j.schemas.ModsSearchSortOrder;

public class SearchModsRequest
		implements IQueryContainer
{
	private Integer gameId;
	private Integer classId;
	private Integer categoryId;
	private String gameVersion;
	private String searchFilter;
	private ModsSearchSortField sortField;
	private ModsSearchSortOrder sortOrder;
	private ModLoaderType modLoaderType;
	private Integer gameVersionTypeId;
	private Integer index;
	private Integer pageSize;

	public static SearchModsRequest create()
	{
		return new SearchModsRequest();
	}

	public SearchModsRequest gameId(Integer gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public SearchModsRequest classId(Integer classId)
	{
		this.classId = classId;
		return this;
	}

	public SearchModsRequest categoryId(Integer categoryId)
	{
		this.classId = categoryId;
		return this;
	}

	public SearchModsRequest gameVersion(String gameVersion)
	{
		this.gameVersion = gameVersion;
		return this;
	}

	public SearchModsRequest searchFilter(String searchFilter)
	{
		this.searchFilter = searchFilter;
		return this;
	}

	public SearchModsRequest sortField(ModsSearchSortField sortField)
	{
		this.sortField = sortField;
		return this;
	}

	public SearchModsRequest sortOrder(ModsSearchSortOrder sortOrder)
	{
		this.sortOrder = sortOrder;
		return this;
	}

	public SearchModsRequest modLoaderType(ModLoaderType modLoaderType)
	{
		this.modLoaderType = modLoaderType;
		return this;
	}

	public SearchModsRequest gameVersionTypeId(Integer gameVersionTypeId)
	{
		this.gameVersionTypeId = gameVersionTypeId;
		return this;
	}

	public SearchModsRequest index(Integer index)
	{
		this.index = index;
		return this;
	}

	public SearchModsRequest pageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
		return this;
	}

	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("gameId", gameId)
				.put("classId", classId)
				.put("categoryId", categoryId)
				.put("gameVersion", gameVersion)
				.put("searchFilter", searchFilter)
				.put("sortField", sortField)
				.put("sortOrder", sortOrder)
				.putOrdinal("modLoaderType", modLoaderType)
				.put("gameVersionTypeId", gameVersionTypeId)
				.put("index", index)
				.put("pageSize", pageSize);
	}

	@Override
	public SearchModsRequest clone()
	{
		SearchModsRequest r = new SearchModsRequest();
		r.gameId = gameId;
		r.classId = classId;
		r.categoryId = categoryId;
		r.gameVersion = gameVersion;
		r.searchFilter = searchFilter;
		r.sortField = sortField;
		r.sortOrder = sortOrder;
		r.modLoaderType = modLoaderType;
		r.gameVersionTypeId = gameVersionTypeId;
		r.index = index;
		r.pageSize = pageSize;
		return r;
	}
}