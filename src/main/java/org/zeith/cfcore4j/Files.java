package org.zeith.cfcore4j;

import org.zeith.cfcore4j.files.*;
import org.zeith.cfcore4j.mods.GetModsRequest;
import org.zeith.cfcore4j.mods.GetModsResponse;
import org.zeith.httplib.HttpRequest;

public class Files
{
	final CFCore4j core;

	public Files(CFCore4j core)
	{
		this.core = core;
	}

	public GetModFileResponse getModFile(GetModFileRequest req)
	{
		return new GetModFileResponse(
				core.checkValid("Mod " + req.modId() + " File " + req.fileId(),
						core.getAuth("mods/" + req.modId() + "/files/" + req.fileId())
				).jsonObjectBody()
		);
	}

	public GetModFilesResponse getModFiles(GetModFilesRequest req)
	{
		return new GetModFilesResponse(
				core.checkValid("Mod " + req.modId() + " Files",
						core.getAuth("mods/" + req.modId() + "/files", req)
				).jsonObjectBody()
		);
	}

	public GetFilesResponse getFiles(GetFilesRequest req)
	{
		return new GetFilesResponse(
				core.checkValid("Files " + req.fileIds(),
						core.postAuth("mods/files")
								.contentType(HttpRequest.CONTENT_TYPE_JSON)
								.send(req.toString())
				).jsonObjectBody()
		);
	}

	public GetModFileChangelogResponse getModFileChangelog(GetModFileChangelogRequest req)
	{
		return new GetModFileChangelogResponse(
				core.checkValid("Mod " + req.modId() + " File " + req.fileId() + " Changelog",
						core.getAuth("mods/" + req.modId() + "/files/" + req.fileId() + "/changelog")
				).jsonObjectBody()
		);
	}

	/**
	 * Untested. There is a toggle "Allow the distribution of this project outside the CurseForge-Overwolf ecosystem.".
	 * Timtower said "Would get a result for that when you try it", but if any issues arise, please report, and we'll add a proper handling behavior for those cases!!
	 * 		https://discord.com/channels/428228256236306434/909494727341121607/915679409313300550
	 */
	public GetModFileDownloadURLResponse getModFileDownloadURL(GetModFileDownloadURLRequest req)
	{
		return new GetModFileDownloadURLResponse(
				core.checkValid("Mod " + req.modId() + " File " + req.fileId() + " Download URL",
						core.getAuth("mods/" + req.modId() + "/files/" + req.fileId() + "/download-url")
				).jsonObjectBody()
		);
	}
}