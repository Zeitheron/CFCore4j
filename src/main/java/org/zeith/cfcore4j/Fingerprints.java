package org.zeith.cfcore4j;

import org.zeith.cfcore4j.fingerprints.*;

public class Fingerprints
{
	final CFCore4j core;
	
	public Fingerprints(CFCore4j core)
	{
		this.core = core;
	}
	
	/**
	 * Get mod files that match a list of fingerprints.
	 *
	 * @param req
	 * 		GetFingerprintsMatchesRequest
	 *
	 * @return GetFingerprintsMatchesResponse
	 *
	 * @see GetFingerprintsMatchesRequest
	 * @see GetFingerprintsMatchesResponse
	 */
	public GetFingerprintsMatchesResponse getFingerprintsMatches(GetFingerprintsMatchesRequest req)
	{
		return new GetFingerprintsMatchesResponse(
				core.request(1, "fingerprints", null, "Fingerprints " + req.fingerprints(), req.toString())
						.post()
		);
	}
	
	/**
	 * Get mod files that match a list of fingerprints.
	 *
	 * @param req
	 * 		GetFingerprintsMatchesRequest
	 *
	 * @return GetFingerprintsMatchesResponse
	 *
	 * @see GetFingerprintsMatchesRequest
	 * @see GetFingerprintsMatchesResponse
	 */
	public GetFingerprintsMatchesResponse getFingerprintsMatchesByGameId(GetFingerprintsMatchesByGameIdRequest req)
	{
		return new GetFingerprintsMatchesResponse(
				core.request(1, "fingerprints/" + req.gameId(), null, "Fingerprints " + req.fingerprints() + " by Game " + req.gameId(), req.toString())
						.post()
		);
	}
	
	/**
	 * Get mod files that match a list of fingerprints using fuzzy matching.
	 *
	 * @param req
	 * 		GetFingerprintsFuzzyMatchesRequest
	 *
	 * @return GetFingerprintsFuzzyMatchesResponse
	 *
	 * @see GetFingerprintsFuzzyMatchesRequest
	 * @see GetFingerprintsFuzzyMatchesResponse
	 */
	public GetFingerprintsFuzzyMatchesResponse getFingerprintsFuzzyMatches(GetFingerprintsFuzzyMatchesRequest req)
	{
		return new GetFingerprintsFuzzyMatchesResponse(
				core.request(1, "fingerprints/fuzzy", null, "Fuzzy Fingerprints " + req.fingerprints(), req.toString())
						.post()
		);
	}
	
	/**
	 * Get mod files that match a list of fingerprints using fuzzy matching.
	 *
	 * @param req
	 * 		GetFingerprintsFuzzyMatchesRequest
	 *
	 * @return GetFingerprintsFuzzyMatchesResponse
	 *
	 * @see GetFingerprintsFuzzyMatchesRequest
	 * @see GetFingerprintsFuzzyMatchesResponse
	 */
	public GetFingerprintsFuzzyMatchesResponse getFingerprintsFuzzyMatchesByGameId(GetFingerprintsFuzzyMatchesRequest req)
	{
		return new GetFingerprintsFuzzyMatchesResponse(
				core.request(1, "fingerprints/fuzzy/" + req.gameId(), null, "Fuzzy Fingerprints " + req.fingerprints() + " by Game " + req.gameId(), req.toString())
						.post()
		);
	}
}