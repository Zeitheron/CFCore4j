package org.zeith.cfcore4j;

import org.zeith.cfcore4j.mods.*;
import org.zeith.cfcore4j.schemas.Mod;
import org.zeith.cfcore4j.schemas.StringResponse;

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
	 * @param req
	 * 		SearchModsRequest
	 *
	 * @return SearchModsResponse
	 *
	 * @see SearchModsRequest
	 * @see SearchModsResponse
	 */
	public SearchModsResponse searchMods(SearchModsRequest req)
	{
		return new SearchModsResponse(this, req,
				core.request(1, "mods/search", req, "Search Mods")
						.get()
		);
	}
	
	/**
	 * Get a single mod.
	 *
	 * @param req
	 * 		GetModRequest
	 *
	 * @return GetModResponse
	 *
	 * @see GetModRequest
	 * @see GetModResponse
	 */
	public GetModResponse getMod(GetModRequest req)
	{
		return new GetModResponse(
				core.request(1, "mods/" + req.modId(), null, "Mod " + req.modId())
						.get()
		);
	}
	
	/**
	 * Get a single mod.
	 *
	 * @param modId
	 * 		The mod id to get
	 *
	 * @return An instance of a {@link Mod}
	 *
	 * @see Mod
	 */
	public Mod getMod(long modId)
	{
		return getMod(GetModRequest.create(modId)).data;
	}
	
	/**
	 * Get a list of mods.
	 *
	 * @param req
	 * 		GetModsRequest
	 *
	 * @return GetModsResponse
	 *
	 * @see GetModsRequest
	 * @see GetModsResponse
	 */
	public GetModsResponse getMods(GetModsRequest req)
	{
		return new GetModsResponse(
				core.request(1, "mods", null, "Mods " + req.modIds(), req.toString())
						.post()
		);
	}
	
	/**
	 * Get a list of mods.
	 *
	 * @param modIds
	 * 		List of mods to get
	 *
	 * @return A list of {@link Mod}
	 *
	 * @see Mod
	 */
	public List<Mod> getMods(long... modIds)
	{
		return getMods(GetModsRequest.create().addMod(modIds)).data;
	}
	
	/**
	 * Get a list of mods.
	 *
	 * @param modIds
	 * 		List of mods to get
	 *
	 * @return A list of {@link Mod}
	 *
	 * @see Mod
	 */
	public List<Mod> getMods(Iterable<Long> modIds)
	{
		return getMods(GetModsRequest.create().addMod(modIds)).data;
	}
	
	/**
	 * Get a list of mods.
	 *
	 * @param modIds
	 * 		List of mods to get
	 *
	 * @return A list of {@link Mod}
	 *
	 * @see Mod
	 */
	public List<Mod> getMods(Collection<Long> modIds)
	{
		return getMods(GetModsRequest.create().addMod(modIds)).data;
	}
	
	/**
	 * Get a list of featured, popular and recently updated mods.
	 *
	 * @param req
	 * 		GetFeaturedModsRequest
	 *
	 * @return GetFeaturedModsResponse
	 *
	 * @see GetFeaturedModsRequest
	 * @see GetFeaturedModsResponse
	 */
	public GetFeaturedModsResponse getFeaturedMods(GetFeaturedModsRequest req)
	{
		return new GetFeaturedModsResponse(
				core.request(1, "mods/featured", null, "Featured Mods", req.toString())
						.post()
		);
	}
	
	/**
	 * Get the full description of a mod in HTML format.
	 *
	 * @param req
	 * 		GetModDescriptionRequest
	 *
	 * @return GetModDescriptionResponse
	 *
	 * @see GetModDescriptionRequest
	 * @see StringResponse
	 */
	public StringResponse getModDescription(GetModDescriptionRequest req)
	{
		return new StringResponse(
				core.request(1, "mods/" + req.modId() + "/description", null, "Mod " + req.modId() + " Description")
						.get()
		);
	}
	
	/**
	 * Get the full description of a mod in HTML format.
	 *
	 * @param modId
	 * 		The mod to get the description of.
	 *
	 * @return The full description of a mod in HTML format.
	 */
	public String getModDescription(long modId)
	{
		return getModDescription(GetModDescriptionRequest.create(modId)).data;
	}
}