package org.zeith.cfcore4j;

import org.zeith.cfcore4j.mods.*;
import org.zeith.httplib.HttpRequest;

public class Mods
{
	final CFCore4j core;

	public Mods(CFCore4j core)
	{
		this.core = core;
	}

	public SearchModsResponse searchMods(SearchModsRequest req)
	{
		return new SearchModsResponse(
				core.checkValid("Search Mods",
						core.getAuth("mods/search", req)
				).jsonObjectBody()
		);
	}

	public GetModResponse getMod(GetModRequest req)
	{
		return new GetModResponse(
				core.checkValid("Mod " + req.modId(),
						core.getAuth("mods/" + req.modId())
				).jsonObjectBody()
		);
	}

	public GetModsResponse getMods(GetModsRequest req)
	{
		return new GetModsResponse(
				core.checkValid("Mods " + req.modIds(),
						core.postAuth("mods")
								.contentType(HttpRequest.CONTENT_TYPE_JSON)
								.send(req.toString())
				).jsonObjectBody()
		);
	}

	public GetFeaturedModsResponse getFeaturedMods(GetFeaturedModsRequest req)
	{
		return new GetFeaturedModsResponse(
				core.checkValid("Featured Mods",
						core.postAuth("mods/featured")
								.contentType(HttpRequest.CONTENT_TYPE_JSON)
								.send(req.toString())
				).jsonObjectBody()
		);
	}

	public GetModDescriptionResponse getModDescription(GetModDescriptionRequest req)
	{
		return new GetModDescriptionResponse(
				core.checkValid("Mod " + req.modId() + " Description",
						core.getAuth("mods/" + req.modId() + "/description")
				).jsonObjectBody()
		);
	}
}