package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

import java.util.Optional;
import java.util.stream.Stream;

public class FileHash
{
	public final String value;
	public final HashAlgo algo;

	public FileHash(String value, HashAlgo algo)
	{
		this.value = value;
		this.algo = algo;
	}

	public FileHash(JSONObject $)
	{
		this.value = $.getString("value");
		this.algo = HashAlgo.fromJson($.getInt("algo"));
	}

	@Override
	public String toString()
	{
		return "FileHash{" +
				"value='" + value + '\'' +
				", algo=" + algo +
				'}';
	}

	public static Optional<String> find(HashAlgo algo, Iterable<FileHash> hashes)
	{
		for(FileHash hash : hashes)
			if(hash.algo == algo)
				return Optional.of(hash.value);
		return Optional.empty();
	}

	public static Optional<String> find(HashAlgo algo, FileHash... hashes)
	{
		for(FileHash hash : hashes)
			if(hash.algo == algo)
				return Optional.of(hash.value);
		return Optional.empty();
	}

	public static Optional<String> find(HashAlgo algo, Stream<FileHash> hashes)
	{
		return hashes
				.filter(f -> f.algo == algo)
				.map(f -> f.value)
				.findFirst();
	}
}