package org.zeith.cfcore4j;

import org.zeith.cfcore4j.games.*;
import org.zeith.cfcore4j.schemas.Game;
import org.zeith.cfcore4j.schemas.GameVersionType;
import org.zeith.cfcore4j.schemas.GameVersionsByType;

import java.util.List;

public class Games
{
	final CFCore4j core;

	public Games(CFCore4j core)
	{
		this.core = core;
	}

	/**
	 * Get all games that are available to the provided API key.
	 *
	 * @param req GetGamesRequest
	 * @return GetGamesResponse
	 * @see GetGamesRequest
	 * @see GetGamesResponse
	 */
	public GetGamesResponse getGames(GetGamesRequest req)
	{
		return new GetGamesResponse(this, req,
				core.checkValid("Game List",
						core.getAuth("games", req)
				).jsonObjectBody()
		);
	}

	/**
	 * Get a single game. A private game is only accessible by its respective API key.
	 *
	 * @param req GetGameRequest
	 * @return GetGameResponse
	 * @see GetGameRequest
	 * @see GetGameResponse
	 */
	public GetGameResponse getGame(GetGameRequest req)
	{
		return new GetGameResponse(
				core.checkValid("Game " + req.gameId(),
						core.getAuth("games/" + req.gameId())
				).jsonObjectBody()
		);
	}

	/**
	 * Get a single game. A private game is only accessible by its respective API key.
	 *
	 * @param gameId The game to get.
	 * @return The {@link Game}
	 * @see Game
	 */
	public Game getGame(int gameId)
	{
		return getGame(GetGameRequest.create(gameId)).game;
	}

	/**
	 * Get all available versions for each known version type of the specified game. A private game is only accessible to its respective API key.
	 *
	 * @param req GetVersionsRequest
	 * @return GetVersionsResponse
	 * @see GetVersionsRequest
	 * @see GetVersionsResponse
	 */
	public GetVersionsResponse getVersions(GetVersionsRequest req)
	{
		return new GetVersionsResponse(
				core.checkValid("Game " + req.gameId() + " versions",
						core.getAuth("games/" + req.gameId() + "/versions")
				).jsonObjectBody()
		);
	}

	/**
	 * Get all available versions for each known version type of the specified game. A private game is only accessible to its respective API key.
	 *
	 * @param gameId The game to get versions for.
	 * @return List of {@link GameVersionsByType}
	 * @see GameVersionsByType
	 */
	public List<GameVersionsByType> getVersions(int gameId)
	{
		return getVersions(GetVersionsRequest.create(gameId)).data;
	}

	/**
	 * Get all available version types of the specified game.
	 * <p>
	 * A private game is only accessible to its respective API key.
	 * <p>
	 * Currently, when creating games via the CurseForge Core Console, you are limited to a single game version type. This means that this endpoint is probably not useful in most cases and is relevant mostly when handling existing games that have multiple game versions such as World of Warcraft and Minecraft (e.g. 517 for wow_retail, 432 for minecraft).
	 *
	 * @param req GetVersionTypesRequest
	 * @return GetVersionTypesResponse
	 * @see GetVersionTypesRequest
	 * @see GetVersionTypesResponse
	 */
	public GetVersionTypesResponse getVersionTypes(GetVersionTypesRequest req)
	{
		return new GetVersionTypesResponse(
				core.checkValid("Game " + req.gameId() + " version types",
						core.getAuth("games/" + req.gameId() + "/version-types")
				).jsonObjectBody()
		);
	}

	/**
	 * Get all available version types of the specified game.
	 * <p>
	 * A private game is only accessible to its respective API key.
	 * <p>
	 * Currently, when creating games via the CurseForge Core Console, you are limited to a single game version type. This means that this endpoint is probably not useful in most cases and is relevant mostly when handling existing games that have multiple game versions such as World of Warcraft and Minecraft (e.g. 517 for wow_retail, 432 for minecraft).
	 *
	 * @param gameId The game to get version types for.
	 * @return A list of {@link GameVersionType}
	 * @see GameVersionType
	 */
	public List<GameVersionType> getVersionTypes(int gameId)
	{
		return getVersionTypes(GetVersionTypesRequest.create(gameId)).data;
	}
}