package org.zeith.cfcore4j.games;

import org.json.JSONObject;
import org.zeith.cfcore4j.schemas.Game;

public class GetGameResponse
{
	public final Game game;

	public GetGameResponse(JSONObject $)
	{
		this.game = new Game($.getJSONObject("data"));
	}

	@Override
	public String toString()
	{
		return "GetGameResponse{" +
				"game=" + game +
				'}';
	}
}