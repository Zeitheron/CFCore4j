package org.zeith.cfcore4j;

public class CFCoreBuilder
{
	public String apiKey;

	public CFCoreBuilder authorize(String apiKey)
	{
		this.apiKey = apiKey;
		return this;
	}

	public CFCore4j build()
	{
		return new CFCore4j(apiKey);
	}
}