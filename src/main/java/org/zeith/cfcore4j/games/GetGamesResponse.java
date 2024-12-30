package org.zeith.cfcore4j.games;

import org.json.JSONArray;
import org.json.JSONObject;
import org.zeith.cfcore4j.Games;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.base.PaginatedResponse;
import org.zeith.cfcore4j.schemas.Game;

import java.util.List;

public class GetGamesResponse
		extends PaginatedResponse<Game, GetGamesResponse>
{
	final Games games;
	final GetGamesRequest req;

	public GetGamesResponse(Games games, GetGamesRequest req, JSONObject $)
	{
		super($);
		this.games = games;
		this.req = req.clone();
	}

	@Override
	protected List<Game> decodeData(JSONArray data)
	{
		return Util.parseList(data, Game::new);
	}

	@Override
	public GetGamesResponse fromIndex(long index)
	{
		return games.getGames(req.clone().index(index));
	}
}