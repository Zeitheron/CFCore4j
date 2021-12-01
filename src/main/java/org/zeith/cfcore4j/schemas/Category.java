package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;

public class Category
{
	public final int id;
	public final int gameId;
	public final String name;
	public final String slug;
	public final String url;
	public final String iconUrl;
	public final Instant dateModified;
	public final Nullable<Boolean> isClass;
	public final Nullable<Integer> classId;
	public final Nullable<Integer> parentCategoryId;

	public Category(JSONObject $)
	{
		this.id = $.getInt("id");
		this.gameId = $.getInt("gameId");
		this.name = $.getString("name");
		this.slug = $.getString("slug");
		this.url = $.optString("url");
		this.iconUrl = $.getString("iconUrl");
		this.dateModified = Util.parseDateTime($.getString("dateModified"));
		this.isClass = new Nullable<>($.isNull("isClass") ? null : $.optBoolean("isClass"));
		this.classId = new Nullable<>($.isNull("classId") ? null : $.optInt("classId"));
		this.parentCategoryId = new Nullable<>($.isNull("parentCategoryId") ? null : $.optInt("parentCategoryId"));
	}

	@Override
	public String toString()
	{
		return "Category{" +
				"id=" + id +
				", gameId=" + gameId +
				", name='" + name + '\'' +
				", slug='" + slug + '\'' +
				", url='" + url + '\'' +
				", iconUrl='" + iconUrl + '\'' +
				", dateModified=" + dateModified +
				", isClass=" + isClass +
				", classId=" + classId +
				", parentCategoryId=" + parentCategoryId +
				'}';
	}
}