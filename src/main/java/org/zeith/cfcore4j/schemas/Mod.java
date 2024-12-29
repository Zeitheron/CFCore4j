package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;
import java.util.List;

public class Mod
{
	public final long id;
	public final long gameId;
	public final String name;
	public final String slug;
	public final ModLinks links;
	public final String summary;
	public final ModStatus status;
	public final long downloadCount;
	public final boolean isFeatured;
	public final long primaryCategoryId;
	public final List<Category> categories;
	public final List<ModAuthor> authors;
	public final Nullable<ModAsset> logo;
	public final List<ModAsset> screenshots;
	public final long mainFileId;
	public final List<File> latestFiles;
	public final List<FileIndex> latestFilesIndexes;
	public final Instant dateCreated;
	public final Instant dateModified;
	public final Instant dateReleased;

	public Mod(JSONObject $)
	{
		this.id = $.getLong("id");
		this.gameId = $.getLong("gameId");
		this.name = $.getString("name");
		this.slug = $.getString("slug");
		this.links = new ModLinks($.getJSONObject("links"));
		this.summary = $.getString("summary");
		this.status = ModStatus.fromJson($.getInt("status"));
		this.downloadCount = $.getLong("downloadCount");
		this.isFeatured = $.getBoolean("isFeatured");
		this.primaryCategoryId = $.getLong("primaryCategoryId");
		this.categories = Util.parseList($.getJSONArray("categories"), Category::new);
		this.authors = Util.parseList($.getJSONArray("authors"), ModAuthor::new);
		this.logo = new Nullable<>(!$.isNull("logo") ? new ModAsset($.getJSONObject("logo")) : null);
		this.screenshots = Util.parseList($.getJSONArray("screenshots"), ModAsset::new);
		this.mainFileId = $.getLong("mainFileId");
		this.latestFiles = Util.parseList($.getJSONArray("latestFiles"), File::new);
		this.latestFilesIndexes = Util.parseList($.getJSONArray("latestFilesIndexes"), FileIndex::new);
		this.dateCreated = Util.parseDateTime($.getString("dateCreated"));
		this.dateModified = Util.parseDateTime($.getString("dateModified"));
		this.dateReleased = Util.parseDateTime($.getString("dateReleased"));
	}

	@Override
	public String toString()
	{
		return "Mod{" +
				"id=" + id +
				", gameId=" + gameId +
				", name='" + name + '\'' +
				", slug='" + slug + '\'' +
				", links=" + links +
				", summary='" + summary + '\'' +
				", status=" + status +
				", downloadCount=" + downloadCount +
				", isFeatured=" + isFeatured +
				", primaryCategoryId=" + primaryCategoryId +
				", categories=" + categories +
				", authors=" + authors +
				", logo=" + logo +
				", screenshots=" + screenshots +
				", mainFileId=" + mainFileId +
				", latestFiles=" + latestFiles +
				", latestFilesIndexes=" + latestFilesIndexes +
				", dateCreated=" + dateCreated +
				", dateModified=" + dateModified +
				", dateReleased=" + dateReleased +
				'}';
	}
}