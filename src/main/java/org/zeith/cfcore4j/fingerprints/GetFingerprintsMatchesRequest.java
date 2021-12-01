package org.zeith.cfcore4j.fingerprints;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetFingerprintsMatchesRequest
{
	private final List<Long> fingerprints = new ArrayList<>();

	public static GetFingerprintsMatchesRequest create()
	{
		return new GetFingerprintsMatchesRequest();
	}

	public GetFingerprintsMatchesRequest addFingerprint(long... fingerprint)
	{
		for(long i : fingerprint)
			this.fingerprints.add(i);
		return this;
	}

	public GetFingerprintsMatchesRequest addFingerprint(Collection<Long> fingerprint)
	{
		this.fingerprints.addAll(fingerprint);
		return this;
	}

	public GetFingerprintsMatchesRequest addFingerprint(Iterable<Long> fingerprint)
	{
		for(long i : fingerprint)
			this.fingerprints.add(i);
		return this;
	}

	public List<Long> fingerprints()
	{
		return Collections.unmodifiableList(fingerprints);
	}

	@Override
	public String toString()
	{
		JSONObject $ = new JSONObject();
		$.put("fingerprints", fingerprints);
		return $.toString();
	}
}