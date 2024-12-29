package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;

import java.time.Instant;

public class MinecraftModLoaderIndex
{
	public final String name;
	public final String gameVersion;
	public final boolean latest;
	public final boolean recommended;
	public final Instant dateModified;
	public final ModLoaderType type;
	
	public MinecraftModLoaderIndex(JSONObject $)
	{
		this.name = $.getString("name");
		this.gameVersion = $.getString("gameVersion");
		this.latest = $.getBoolean("latest");
		this.recommended = $.getBoolean("recommended");
		this.dateModified = Util.parseDateTime($.getString("dateModified"));
		this.type = $.has("type") ? ModLoaderType.fromJson($.getInt("type")) : ModLoaderType.FORGE;
	}
	
	@Override
	public String toString()
	{
		return "MinecraftModLoaderIndex{" +
			   "name='" + name + '\'' +
			   ", gameVersion='" + gameVersion + '\'' +
			   ", latest=" + latest +
			   ", recommended=" + recommended +
			   ", dateModified=" + dateModified +
			   ", type=" + type +
			   '}';
	}
}