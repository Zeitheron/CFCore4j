package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;

public class Category
{
	public final long id;
	public final long gameId;
	public final String name;
	public final String slug;
	public final String url;
	public final String iconUrl;
	public final Instant dateModified;
	public final Nullable<Boolean> isClass;
	public final Nullable<Long> classId;
	public final Nullable<Long> parentCategoryId;

	public Category(JSONObject $)
	{
		this.id = $.getLong("id");
		this.gameId = $.getLong("gameId");
		this.name = $.getString("name");
		this.slug = $.optString("slug");
		this.url = $.optString("url");
		this.iconUrl = $.getString("iconUrl");
		this.dateModified = Util.parseDateTime($.optString("dateModified"));
		this.isClass = new Nullable<>($.isNull("isClass") ? null : $.optBoolean("isClass"));
		this.classId = new Nullable<>($.isNull("classId") ? null : $.optLong("classId"));
		this.parentCategoryId = new Nullable<>($.isNull("parentCategoryId") ? null : $.optLong("parentCategoryId"));
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