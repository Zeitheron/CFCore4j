package org.zeith.cfcore4j.minecraft;

import org.json.JSONObject;
import org.zeith.cfcore4j.schemas.MinecraftModLoaderVersion;

public class GetSpecificMinecraftModLoaderResponse
{
	public final MinecraftModLoaderVersion data;
	
	public GetSpecificMinecraftModLoaderResponse(JSONObject $)
	{
		this.data = new MinecraftModLoaderVersion($.getJSONObject("data"));
	}
	
	@Override
	public String toString()
	{
		return "GetSpecificMinecraftModLoaderResponse{" +
			   "data=" + data +
			   '}';
	}
}