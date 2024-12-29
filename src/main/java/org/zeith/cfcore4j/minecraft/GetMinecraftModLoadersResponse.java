package org.zeith.cfcore4j.minecraft;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.MinecraftModLoaderIndex;

import java.util.List;

public class GetMinecraftModLoadersResponse
{
	public final List<MinecraftModLoaderIndex> data;
	
	public GetMinecraftModLoadersResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), MinecraftModLoaderIndex::new);
	}
	
	@Override
	public String toString()
	{
		return "GetMinecraftModLoadersResponse{" +
			   "data=" + data +
			   '}';
	}
}