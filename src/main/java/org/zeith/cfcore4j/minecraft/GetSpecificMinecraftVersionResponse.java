package org.zeith.cfcore4j.minecraft;

import org.json.JSONObject;
import org.zeith.cfcore4j.schemas.MinecraftGameVersion;

public class GetSpecificMinecraftVersionResponse
{
	public final MinecraftGameVersion data;
	
	public GetSpecificMinecraftVersionResponse(JSONObject $)
	{
		this.data = new MinecraftGameVersion($.getJSONObject("data"));
	}
	
	@Override
	public String toString()
	{
		return "GetSpecificMinecraftVersionResponse{" +
			   "data=" + data +
			   '}';
	}
}