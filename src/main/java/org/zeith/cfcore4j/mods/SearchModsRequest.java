package org.zeith.cfcore4j.mods;

import org.json.JSONArray;
import org.json.JSONObject;
import org.zeith.cfcore4j.errors.CFCoreException;
import org.zeith.cfcore4j.query.IQueryContainer;
import org.zeith.cfcore4j.query.QueryBuilder;
import org.zeith.cfcore4j.schemas.ModLoaderType;
import org.zeith.cfcore4j.schemas.ModsSearchSortField;
import org.zeith.cfcore4j.schemas.SortOrder;

import java.util.*;
import java.util.stream.*;

public class SearchModsRequest
		implements IQueryContainer
{
	private Long gameId;
	private Long classId;
	private Long categoryId;
	private final List<Long> categoryIds = new ArrayList<>();
	private String gameVersion;
	private final List<String> gameVersions = new ArrayList<>();
	private String searchFilter;
	private ModsSearchSortField sortField;
	private SortOrder sortOrder;
	private ModLoaderType modLoaderType;
	private final EnumSet<ModLoaderType> modLoaderTypes = EnumSet.noneOf(ModLoaderType.class);
	private Long gameVersionTypeId;
	private Long authorId;
	private Long primaryAuthorId;
	private String slug;
	
	private Long index;
	private Integer pageSize;
	
	public static SearchModsRequest create()
	{
		return new SearchModsRequest();
	}
	
	public SearchModsRequest gameId(Long gameId)
	{
		this.gameId = gameId;
		return this;
	}
	
	public SearchModsRequest classId(Long classId)
	{
		this.classId = classId;
		return this;
	}
	
	public SearchModsRequest categoryId(Long categoryId)
	{
		this.classId = categoryId;
		return this;
	}
	
	public SearchModsRequest categoryIds(Iterable<Long> categoryIds)
	{
		List<Long> l = Stream.concat(this.categoryIds.stream(), StreamSupport.stream(categoryIds.spliterator(), false)).distinct().collect(Collectors.toList());
		this.categoryIds.clear();
		this.categoryIds.addAll(l);
		return this;
	}
	
	public SearchModsRequest categoryIds(long... categoryIds)
	{
		List<Long> l = Stream.concat(this.categoryIds.stream(), LongStream.of(categoryIds).boxed()).distinct().collect(Collectors.toList());
		this.categoryIds.clear();
		this.categoryIds.addAll(l);
		return this;
	}
	
	public SearchModsRequest gameVersion(String gameVersion)
	{
		this.gameVersion = gameVersion;
		return this;
	}
	
	public SearchModsRequest gameVersions(Iterable<String> gameVersions)
	{
		List<String> l = Stream.concat(this.gameVersions.stream(), StreamSupport.stream(gameVersions.spliterator(), false)).distinct().collect(Collectors.toList());
		this.gameVersions.clear();
		this.gameVersions.addAll(l);
		return this;
	}
	
	public SearchModsRequest gameVersions(String... gameVersions)
	{
		List<String> l = Stream.concat(this.gameVersions.stream(), Stream.of(gameVersions)).distinct().collect(Collectors.toList());
		this.gameVersions.clear();
		this.gameVersions.addAll(l);
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
	
	public SearchModsRequest sortOrder(SortOrder sortOrder)
	{
		this.sortOrder = sortOrder;
		return this;
	}
	
	public SearchModsRequest modLoaderType(ModLoaderType modLoaderType)
	{
		this.modLoaderType = modLoaderType;
		return this;
	}
	
	public SearchModsRequest modLoaderTypes(Iterable<ModLoaderType> modLoaderTypes)
	{
		modLoaderTypes.forEach(this.modLoaderTypes::add);
		return this;
	}
	
	public SearchModsRequest modLoaderTypes(ModLoaderType... modLoaderTypes)
	{
		this.modLoaderTypes.addAll(Arrays.asList(modLoaderTypes));
		return this;
	}
	
	public SearchModsRequest gameVersionTypeId(Long gameVersionTypeId)
	{
		this.gameVersionTypeId = gameVersionTypeId;
		return this;
	}
	
	public SearchModsRequest authorId(Long authorId)
	{
		this.authorId = authorId;
		return this;
	}
	
	public SearchModsRequest primaryAuthorId(Long primaryAuthorId)
	{
		this.primaryAuthorId = primaryAuthorId;
		return this;
	}
	
	public SearchModsRequest slug(String slug)
	{
		this.slug = slug;
		return this;
	}
	
	public SearchModsRequest index(Long index)
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
	public void validate()
			throws CFCoreException
	{
		IQueryContainer.limitListSize("categoryIds", categoryIds, 10);
		IQueryContainer.limitListSize("gameVersions", gameVersions, 4);
		IQueryContainer.limitListSize("modLoaderTypes", modLoaderTypes, 5);
	}
	
	@Override
	public QueryBuilder toBuilder()
	{
		return QueryBuilder.start()
				.put("gameId", gameId)
				.put("classId", classId)
				.put("categoryId", categoryIds.isEmpty() ? categoryId : null)
				.put("categoryIds", categoryIds.isEmpty() ? null : new JSONArray(categoryIds).toString())
				.put("gameVersion", gameVersions.isEmpty() ? gameVersion : null)
				.put("gameVersions", gameVersions.isEmpty() ? null : new JSONArray(gameVersions).toString())
				.put("searchFilter", searchFilter)
				.put("sortField", sortField)
				.put("sortOrder", sortOrder)
				.putOrdinal("modLoaderType", modLoaderTypes.isEmpty() ? modLoaderType : null)
				.put("modLoaderTypes", modLoaderTypes.isEmpty() ? null : modLoaderTypes.stream().map(m -> JSONObject.quote(m.jsonName)).collect(Collectors.joining(",", "[", "]")))
				.put("gameVersionTypeId", gameVersionTypeId)
				.put("authorId", authorId)
				.put("primaryAuthorId", primaryAuthorId)
				.put("slug", slug)
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
		r.categoryIds.addAll(categoryIds);
		r.gameVersion = gameVersion;
		r.gameVersions.addAll(gameVersions);
		r.searchFilter = searchFilter;
		r.sortField = sortField;
		r.sortOrder = sortOrder;
		r.modLoaderType = modLoaderType;
		r.modLoaderTypes.addAll(modLoaderTypes);
		r.gameVersionTypeId = gameVersionTypeId;
		r.authorId = authorId;
		r.primaryAuthorId = primaryAuthorId;
		r.slug = slug;
		r.index = index;
		r.pageSize = pageSize;
		return r;
	}
}