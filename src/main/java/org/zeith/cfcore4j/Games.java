package org.zeith.cfcore4j;

import org.zeith.cfcore4j.games.*;

public class Games
{
	final CFCore4j core;

	public Games(CFCore4j core)
	{
		this.core = core;
	}

	public GetGamesResponse getGames(GetGamesRequest req)
	{
		return new GetGamesResponse(
				core.checkValid("Game List",
						core.getAuth("games", req)
				).jsonObjectBody()
		);
	}

	public GetGameResponse getGame(GetGameRequest req)
	{
		return new GetGameResponse(
				core.checkValid("Game " + req.gameId(),
						core.getAuth("games/" + req.gameId())
				).jsonObjectBody()
		);
	}

	public GetVersionsResponse getVersions(GetVersionsRequest req)
	{
		return new GetVersionsResponse(
				core.checkValid("Game " + req.gameId() + " versions",
						core.getAuth("games/" + req.gameId() + "/versions")
				).jsonObjectBody()
		);
	}

	public GetVersionTypesResponse getVersionTypes(GetVersionTypesRequest req)
	{
		return new GetVersionTypesResponse(
				core.checkValid("Game " + req.gameId() + " version types",
						core.getAuth("games/" + req.gameId() + "/version-types")
				).jsonObjectBody()
		);
	}
}