package org.zeith.cfcore4j.games;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.Game;
import org.zeith.cfcore4j.schemas.Pagination;

import java.util.List;

public class GetGamesResponse
{
	public final Pagination pagination;
	public final List<Game> games;

	public GetGamesResponse(JSONObject $)
	{
		this.pagination = new Pagination($.getJSONObject("pagination"));
		this.games = Util.parseList($.getJSONArray("data"), Game::new);
	}

	@Override
	public String toString()
	{
		return "GetGamesResponse{" +
				"pagination=" + pagination +
				", games=" + games +
				'}';
	}
}