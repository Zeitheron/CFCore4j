package org.zeith.cfcore4j.fingerprints;

import org.json.JSONObject;

import java.util.*;

public class GetFingerprintsMatchesByGameIdRequest
{
	private long gameId;
	private final List<Long> fingerprints = new ArrayList<>();
	
	public GetFingerprintsMatchesByGameIdRequest(long gameId)
	{
		this.gameId = gameId;
	}
	
	public static GetFingerprintsMatchesByGameIdRequest create(long gameId)
	{
		return new GetFingerprintsMatchesByGameIdRequest(gameId);
	}
	
	public GetFingerprintsMatchesByGameIdRequest gameId(long gameId)
	{
		this.gameId = gameId;
		return this;
	}

	public GetFingerprintsMatchesByGameIdRequest addFingerprint(long... fingerprint)
	{
		for(long i : fingerprint)
			this.fingerprints.add(i);
		return this;
	}

	public GetFingerprintsMatchesByGameIdRequest addFingerprint(Collection<Long> fingerprint)
	{
		this.fingerprints.addAll(fingerprint);
		return this;
	}

	public GetFingerprintsMatchesByGameIdRequest addFingerprint(Iterable<Long> fingerprint)
	{
		for(long i : fingerprint)
			this.fingerprints.add(i);
		return this;
	}

	public List<Long> fingerprints()
	{
		return Collections.unmodifiableList(fingerprints);
	}
	
	public long gameId()
	{
		return gameId;
	}
	
	@Override
	public String toString()
	{
		JSONObject $ = new JSONObject();
		$.put("fingerprints", fingerprints);
		return $.toString();
	}
}