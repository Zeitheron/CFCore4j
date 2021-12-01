package org.zeith.cfcore4j.fingerprints;

import org.json.JSONObject;
import org.zeith.cfcore4j.Util;
import org.zeith.cfcore4j.schemas.FingerprintMatch;

import java.util.List;
import java.util.Map;

public class GetFingerprintsMatchesResponse
{
	public final boolean isCacheBuilt;
	public final List<FingerprintMatch> exactMatches;
	public final List<Long> exactFingerprints;
	public final List<FingerprintMatch> partialMatches;
	public final Map<String, List<Long>> partialMatchFingerprints;
	public final List<Long> installedFingerprints;
	public final List<Long> unmatchedFingerprints;

	public GetFingerprintsMatchesResponse(JSONObject $)
	{
		$ = $.getJSONObject("data");
		this.isCacheBuilt = $.getBoolean("isCacheBuilt");
		this.exactMatches = Util.parseList($.optJSONArray("exactMatches"), FingerprintMatch::new);
		this.exactFingerprints = Util.parseListLong($.optJSONArray("exactFingerprints"));
		this.partialMatches = Util.parseList($.optJSONArray("partialMatches"), FingerprintMatch::new);
		this.partialMatchFingerprints = Util.parseMap($.getJSONObject("partialMatchFingerprints"), JSONObject::getJSONArray, Util::parseListLong);
		this.installedFingerprints = Util.parseListLong($.optJSONArray("installedFingerprints"));
		this.unmatchedFingerprints = Util.parseListLong($.optJSONArray("unmatchedFingerprints"));
	}

	@Override
	public String toString()
	{
		return "GetFingerprintsMatchesResponse{" +
				"isCacheBuilt=" + isCacheBuilt +
				", exactMatches=" + exactMatches +
				", exactFingerprints=" + exactFingerprints +
				", partialMatches=" + partialMatches +
				", partialMatchFingerprints=" + partialMatchFingerprints +
				", installedFingerprints=" + installedFingerprints +
				", unmatchedFingerprints=" + unmatchedFingerprints +
				'}';
	}
}