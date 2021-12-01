package org.zeith.cfcore4j.fingerprints;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.FingerprintFuzzyMatch;

import java.util.List;

public class GetFingerprintsFuzzyMatchesResponse
{
	public final List<FingerprintFuzzyMatch> fuzzyMatches;

	public GetFingerprintsFuzzyMatchesResponse(JSONObject $)
	{
		$ = $.getJSONObject("data");
		this.fuzzyMatches = Util.parseList($.optJSONArray("fuzzyMatches"), FingerprintFuzzyMatch::new);
	}

	@Override
	public String toString()
	{
		return "GetFingerprintsFuzzyMatchesResponse{" +
				"fuzzyMatches=" + fuzzyMatches +
				'}';
	}
}