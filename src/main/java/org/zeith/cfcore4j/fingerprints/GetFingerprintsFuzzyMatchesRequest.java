package org.zeith.cfcore4j.fingerprints;

import org.json.JSONObject;
import org.zeith.cfcore4j.schemas.FolderFingerprint;

import java.util.*;
import java.util.stream.Collectors;

public class GetFingerprintsFuzzyMatchesRequest
{
	private long gameId;
	private final List<FolderFingerprint> fingerprints = new ArrayList<>();

	public GetFingerprintsFuzzyMatchesRequest(long gameId)
	{
		this.gameId = gameId;
	}

	public static GetFingerprintsFuzzyMatchesRequest create(long gameId)
	{
		return new GetFingerprintsFuzzyMatchesRequest(gameId);
	}
	
	public GetFingerprintsFuzzyMatchesRequest gameId(long gameId)
	{
		this.gameId = gameId;
		return this;
	}
	
	public GetFingerprintsFuzzyMatchesRequest addFingerprint(FolderFingerprint... fingerprint)
	{
		this.fingerprints.addAll(Arrays.asList(fingerprint));
		return this;
	}

	public GetFingerprintsFuzzyMatchesRequest addFingerprint(Collection<FolderFingerprint> fingerprint)
	{
		this.fingerprints.addAll(fingerprint);
		return this;
	}

	public GetFingerprintsFuzzyMatchesRequest addFingerprint(Iterable<FolderFingerprint> fingerprint)
	{
		for(FolderFingerprint i : fingerprint)
			this.fingerprints.add(i);
		return this;
	}

	public List<FolderFingerprint> fingerprints()
	{
		return Collections.unmodifiableList(fingerprints);
	}

	@Override
	public String toString()
	{
		JSONObject $ = new JSONObject();
		$.put("gameId", gameId);
		$.put("fingerprints", fingerprints.stream().map(FolderFingerprint::serialize).collect(Collectors.toList()));
		System.out.println($.toString(4));
		return $.toString();
	}
}