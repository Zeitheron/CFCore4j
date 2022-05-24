package org.zeith.cfcore4j;

import org.zeith.cfcore4j.fingerprints.GetFingerprintsFuzzyMatchesRequest;
import org.zeith.cfcore4j.fingerprints.GetFingerprintsFuzzyMatchesResponse;
import org.zeith.cfcore4j.fingerprints.GetFingerprintsMatchesRequest;
import org.zeith.cfcore4j.fingerprints.GetFingerprintsMatchesResponse;
import org.zeith.httplib.HttpRequest;

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
	 * @param req GetFingerprintsMatchesRequest
	 * @return GetFingerprintsMatchesResponse
	 * @see GetFingerprintsMatchesRequest
	 * @see GetFingerprintsMatchesResponse
	 */
	public GetFingerprintsMatchesResponse getFingerprintsMatches(GetFingerprintsMatchesRequest req)
	{
		return new GetFingerprintsMatchesResponse(
				core.getCachedJSON("fingerprints\n" + req.toString(), () ->
						core.checkValid("Fingerprints " + req.fingerprints(),
								core.postAuth("fingerprints")
										.contentType(HttpRequest.CONTENT_TYPE_JSON)
										.send(req.toString())
						)
				)
		);
	}
	
	/**
	 * Get mod files that match a list of fingerprints using fuzzy matching.
	 *
	 * @param req GetFingerprintsFuzzyMatchesRequest
	 * @return GetFingerprintsFuzzyMatchesResponse
	 * @see GetFingerprintsFuzzyMatchesRequest
	 * @see GetFingerprintsFuzzyMatchesResponse
	 */
	public GetFingerprintsFuzzyMatchesResponse getFingerprintsFuzzyMatches(GetFingerprintsFuzzyMatchesRequest req)
	{
		return new GetFingerprintsFuzzyMatchesResponse(
				core.getCachedJSON("fingerprints/fuzzy\n" + req.toString(), () ->
						core.checkValid("Fuzzy Fingerprints",
								core.postAuth("fingerprints/fuzzy")
										.contentType(HttpRequest.CONTENT_TYPE_JSON)
										.send(req.toString())
						)
				)
		);
	}
}