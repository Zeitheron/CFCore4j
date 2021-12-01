package org.zeith.cfcore4j;

import org.zeith.cfcore4j.mods.*;
import org.zeith.cfcore4j.schemas.Mod;
import org.zeith.httplib.HttpRequest;

import java.util.Collection;
import java.util.List;

public class Mods
{
	final CFCore4j core;

	public Mods(CFCore4j core)
	{
		this.core = core;
	}

	/**
	 * Get all mods that match the search criteria.
	 *
	 * @param req SearchModsRequest
	 * @return SearchModsResponse
	 * @see SearchModsRequest
	 * @see SearchModsResponse
	 */
	public SearchModsResponse searchMods(SearchModsRequest req)
	{
		return new SearchModsResponse(
				core.checkValid("Search Mods",
						core.getAuth("mods/search", req)
				).jsonObjectBody()
		);
	}

	/**
	 * Get a single mod.
	 *
	 * @param req GetModRequest
	 * @return GetModResponse
	 * @see GetModRequest
	 * @see GetModResponse
	 */
	public GetModResponse getMod(GetModRequest req)
	{
		return new GetModResponse(
				core.checkValid("Mod " + req.modId(),
						core.getAuth("mods/" + req.modId())
				).jsonObjectBody()
		);
	}

	/**
	 * Get a single mod.
	 *
	 * @param modId The mod id to get
	 * @return An instance of a {@link Mod}
	 * @see Mod
	 */
	public Mod getMod(int modId)
	{
		return getMod(GetModRequest.create(modId)).data;
	}

	/**
	 * Get a list of mods.
	 *
	 * @param req GetModsRequest
	 * @return GetModsResponse
	 * @see GetModsRequest
	 * @see GetModsResponse
	 */
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

	/**
	 * Get a list of mods.
	 *
	 * @param modIds List of mods to get
	 * @return A list of {@link Mod}
	 * @see Mod
	 */
	public List<Mod> getMods(int... modIds)
	{
		return getMods(GetModsRequest.create().addMod(modIds)).data;
	}

	/**
	 * Get a list of mods.
	 *
	 * @param modIds List of mods to get
	 * @return A list of {@link Mod}
	 * @see Mod
	 */
	public List<Mod> getMods(Iterable<Integer> modIds)
	{
		return getMods(GetModsRequest.create().addMod(modIds)).data;
	}

	/**
	 * Get a list of mods.
	 *
	 * @param modIds List of mods to get
	 * @return A list of {@link Mod}
	 * @see Mod
	 */
	public List<Mod> getMods(Collection<Integer> modIds)
	{
		return getMods(GetModsRequest.create().addMod(modIds)).data;
	}

	/**
	 * Get a list of featured, popular and recently updated mods.
	 *
	 * @param req GetFeaturedModsRequest
	 * @return GetFeaturedModsResponse
	 * @see GetFeaturedModsRequest
	 * @see GetFeaturedModsResponse
	 */
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

	/**
	 * Get the full description of a mod in HTML format.
	 *
	 * @param req GetModDescriptionRequest
	 * @return GetModDescriptionResponse
	 * @see GetModDescriptionRequest
	 * @see GetModDescriptionResponse
	 */
	public GetModDescriptionResponse getModDescription(GetModDescriptionRequest req)
	{
		return new GetModDescriptionResponse(
				core.checkValid("Mod " + req.modId() + " Description",
						core.getAuth("mods/" + req.modId() + "/description")
				).jsonObjectBody()
		);
	}

	/**
	 * Get the full description of a mod in HTML format.
	 *
	 * @param modId The mod to get the description of.
	 * @return The full description of a mod in HTML format.
	 */
	public String getModDescription(int modId)
	{
		return getModDescription(GetModDescriptionRequest.create(modId)).data;
	}
}