package org.zeith.cfcore4j;

import org.zeith.cfcore4j.minecraft.*;
import org.zeith.cfcore4j.schemas.MinecraftModLoaderIndex;
import org.zeith.cfcore4j.schemas.SortOrder;

public class Minecraft
{
	final CFCore4j core;
	
	public Minecraft(CFCore4j core)
	{
		this.core = core;
	}
	
	/**
	 * Get all minecraft versions.
	 *
	 * @param req
	 * 		GetMinecraftVersionsRequest
	 *
	 * @return GetMinecraftVersionsResponse
	 *
	 * @see GetMinecraftVersionsRequest
	 * @see GetMinecraftVersionsResponse
	 */
	public GetMinecraftVersionsResponse getVersions(GetMinecraftVersionsRequest req)
	{
		return new GetMinecraftVersionsResponse(
				core.request(1, "minecraft/version", req, "Get Minecraft Versions")
						.get()
		);
	}
	
	/**
	 * Get all minecraft versions, pre-sorted by CurseForge.
	 *
	 * @return GetMinecraftVersionsResponse
	 *
	 * @see GetMinecraftVersionsRequest
	 * @see GetMinecraftVersionsResponse
	 */
	public GetMinecraftVersionsResponse getVersions(SortOrder sort)
	{
		return getVersions(GetMinecraftVersionsRequest.create().sort(sort));
	}
	
	/**
	 * Get all minecraft versions, pre-sorted in descending order by CurseForge.
	 *
	 * @return GetMinecraftVersionsResponse
	 *
	 * @see GetMinecraftVersionsRequest
	 * @see GetMinecraftVersionsResponse
	 */
	public GetMinecraftVersionsResponse getVersions()
	{
		return getVersions(GetMinecraftVersionsRequest.create());
	}
	
	/**
	 * Get a specific minecraft version.
	 *
	 * @param req
	 * 		GetSpecificMinecraftVersionRequest
	 *
	 * @return GetSpecificMinecraftVersionResponse
	 *
	 * @see GetSpecificMinecraftVersionRequest
	 * @see GetSpecificMinecraftVersionResponse
	 */
	public GetSpecificMinecraftVersionResponse getSpecificVersion(GetSpecificMinecraftVersionRequest req)
	{
		return new GetSpecificMinecraftVersionResponse(
				core.request(1, "minecraft/version/" + req.getGameVersionString(), req, "Get Specific Minecraft Version: " + req.getGameVersionString())
						.get()
		);
	}
	
	/**
	 * Get a specific minecraft version.
	 *
	 * @param version
	 * 		Minecraft version ("1.21.4" for example)
	 *
	 * @return GetSpecificMinecraftVersionResponse
	 *
	 * @see GetSpecificMinecraftVersionRequest
	 * @see GetSpecificMinecraftVersionResponse
	 */
	public GetSpecificMinecraftVersionResponse getSpecificVersion(String version)
	{
		return getSpecificVersion(GetSpecificMinecraftVersionRequest.create().gameVersion(version));
	}
	
	/**
	 * Get all mod loaders.
	 *
	 * @param req
	 * 		GetMinecraftModLoadersRequest
	 *
	 * @return GetMinecraftModLoadersResponse
	 *
	 * @see GetMinecraftModLoadersRequest
	 * @see GetMinecraftModLoadersResponse
	 */
	public GetMinecraftModLoadersResponse getModLoaders(GetMinecraftModLoadersRequest req)
	{
		return new GetMinecraftModLoadersResponse(
				core.request(1, "minecraft/modloader", req, "Get Minecraft ModLoaders")
						.get()
		);
	}
	
	/**
	 * Get all mod loaders.
	 *
	 * @param version
	 * 		The minecraft version to get mod loaders for
	 * @param includeAll
	 * 		Should all mod loaders be included into the response?
	 *
	 * @return GetMinecraftModLoadersResponse
	 *
	 * @see GetMinecraftModLoadersRequest
	 * @see GetMinecraftModLoadersResponse
	 */
	public GetMinecraftModLoadersResponse getModLoaders(String version, boolean includeAll)
	{
		return getModLoaders(GetMinecraftModLoadersRequest.create()
				.version(version)
				.includeAll(includeAll)
		);
	}
	
	/**
	 * Get all known mod loaders.
	 *
	 * @return GetMinecraftModLoadersResponse
	 *
	 * @see GetMinecraftModLoadersRequest
	 * @see GetMinecraftModLoadersResponse
	 */
	public GetMinecraftModLoadersResponse getModLoaders()
	{
		return getModLoaders(GetMinecraftModLoadersRequest.create());
	}
	
	/**
	 * Get specific mod loader.
	 *
	 * @param req
	 * 		GetSpecificMinecraftModLoaderRequest
	 *
	 * @return GetSpecificMinecraftModLoaderResponse
	 *
	 * @see GetSpecificMinecraftModLoaderRequest
	 * @see GetSpecificMinecraftModLoaderResponse
	 */
	public GetSpecificMinecraftModLoaderResponse getSpecificModLoader(GetSpecificMinecraftModLoaderRequest req)
	{
		return new GetSpecificMinecraftModLoaderResponse(
				core.request(1, "minecraft/modloader/" + req.modLoaderName(), req, "Get Specific Minecraft ModLoader: " + req.modLoaderName())
						.get()
		);
	}
	
	/**
	 * Get specific mod loader.
	 *
	 * @param modLoaderName
	 * 		The name of the mod loader.
	 *
	 * @return GetSpecificMinecraftModLoaderResponse
	 *
	 * @see GetSpecificMinecraftModLoaderRequest
	 * @see GetSpecificMinecraftModLoaderResponse
	 */
	public GetSpecificMinecraftModLoaderResponse getSpecificModLoader(String modLoaderName)
	{
		return getSpecificModLoader(GetSpecificMinecraftModLoaderRequest.create().modLoaderName(modLoaderName));
	}
	
	/**
	 * Get specific mod loader.
	 *
	 * @param modLoader
	 * 		The index of the modloader, obtained from {@link #getModLoaders()} / {@link #getModLoaders(GetMinecraftModLoadersRequest)} / {@link #getModLoaders(String, boolean)}.
	 *
	 * @return GetSpecificMinecraftModLoaderResponse
	 *
	 * @see GetSpecificMinecraftModLoaderRequest
	 * @see GetSpecificMinecraftModLoaderResponse
	 */
	public GetSpecificMinecraftModLoaderResponse getSpecificModLoader(MinecraftModLoaderIndex modLoader)
	{
		return getSpecificModLoader(GetSpecificMinecraftModLoaderRequest.create().modLoaderName(modLoader.name));
	}
}