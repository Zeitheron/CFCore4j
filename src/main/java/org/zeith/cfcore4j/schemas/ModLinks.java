package org.zeith.cfcore4j.schemas;

import org.json.JSONObject;

public class ModLinks
{
	public final String websiteUrl;
	public final String wikiUrl;
	public final String issuesUrl;
	public final String sourceUrl;

	public ModLinks(JSONObject $)
	{
		this.websiteUrl = $.optString("websiteUrl");
		this.wikiUrl = $.optString("wikiUrl");
		this.issuesUrl = $.optString("issuesUrl");
		this.sourceUrl = $.optString("sourceUrl");
	}

	@Override
	public String toString()
	{
		return "ModLinks{" +
				"websiteUrl='" + websiteUrl + '\'' +
				", wikiUrl='" + wikiUrl + '\'' +
				", issuesUrl='" + issuesUrl + '\'' +
				", sourceUrl='" + sourceUrl + '\'' +
				'}';
	}
}