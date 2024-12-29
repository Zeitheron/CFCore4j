package org.zeith.cfcore4j.minecraft;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.MinecraftGameVersion;

import java.util.List;

public class GetMinecraftVersionsResponse
{
	public final List<MinecraftGameVersion> data;
	
	public GetMinecraftVersionsResponse(JSONObject $)
	{
		this.data = Util.parseList($.getJSONArray("data"), MinecraftGameVersion::new);
	}
	
	@Override
	public String toString()
	{
		return "GetMinecraftVersionsResponse{" +
			   "data=" + data +
			   '}';
	}
}