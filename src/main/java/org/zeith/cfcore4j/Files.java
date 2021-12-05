package org.zeith.cfcore4j;

import org.zeith.cfcore4j.files.*;
import org.zeith.cfcore4j.schemas.File;
import org.zeith.httplib.HttpRequest;

import java.util.Collection;
import java.util.List;

public class Files
{
	final CFCore4j core;

	public Files(CFCore4j core)
	{
		this.core = core;
	}

	/**
	 * Get a single file of the specified mod.
	 *
	 * @param req GetModFileRequest
	 * @return GetModFileResponse
	 * @see GetModFileRequest
	 * @see GetModFileResponse
	 */
	public GetModFileResponse getModFile(GetModFileRequest req)
	{
		return new GetModFileResponse(
				core.checkValid("Mod " + req.modId() + " File " + req.fileId(),
						core.getAuth("mods/" + req.modId() + "/files/" + req.fileId())
				).jsonObjectBody()
		);
	}

	/**
	 * Get a single file of the specified mod.
	 *
	 * @param modId  The mod to get file for.
	 * @param fileId The file id to get.
	 * @return An instance of a file
	 * @see GetModFileRequest
	 * @see GetModFileResponse
	 */
	public File getModFile(int modId, int fileId)
	{
		return getModFile(GetModFileRequest.create(modId, fileId)).data;
	}

	/**
	 * Get all files of the specified mod.
	 *
	 * @param req GetModFilesRequest
	 * @return GetModFilesResponse
	 * @see GetModFilesRequest
	 * @see GetModFilesResponse
	 */
	public GetModFilesResponse getModFiles(GetModFilesRequest req)
	{
		return new GetModFilesResponse(this, req,
				core.checkValid("Mod " + req.modId() + " Files",
						core.getAuth("mods/" + req.modId() + "/files", req)
				).jsonObjectBody()
		);
	}

	/**
	 * Get a list of files.
	 *
	 * @param req GetFilesRequest
	 * @return GetFilesResponse
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
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

	/**
	 * Get a list of files.
	 *
	 * @param fileIds List of fileId to get files for.
	 * @return A List of {@link File}
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
	public List<File> getFiles(int... fileIds)
	{
		return getFiles(GetFilesRequest.create().addFile(fileIds)).data;
	}

	/**
	 * Get a list of files.
	 *
	 * @param fileIds List of fileId to get files for.
	 * @return A List of {@link File}
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
	public List<File> getFiles(Iterable<Integer> fileIds)
	{
		return getFiles(GetFilesRequest.create().addFile(fileIds)).data;
	}

	/**
	 * Get a list of files.
	 *
	 * @param fileIds List of fileId to get files for.
	 * @return A List of {@link File}
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
	public List<File> getFiles(Collection<Integer> fileIds)
	{
		return getFiles(GetFilesRequest.create().addFile(fileIds)).data;
	}

	/**
	 * Get the changelog of a file in HTML format.
	 *
	 * @param req GetModFileChangelogRequest
	 * @return GetModFileChangelogResponse
	 * @see GetModFileChangelogRequest
	 * @see GetModFileChangelogResponse
	 */
	public GetModFileChangelogResponse getModFileChangelog(GetModFileChangelogRequest req)
	{
		return new GetModFileChangelogResponse(
				core.checkValid("Mod " + req.modId() + " File " + req.fileId() + " Changelog",
						core.getAuth("mods/" + req.modId() + "/files/" + req.fileId() + "/changelog")
				).jsonObjectBody()
		);
	}

	/**
	 * Get the changelog of a file in HTML format.
	 *
	 * @param modId  The mod of the file to get changelog for.
	 * @param fileId The file to get the changelog for.
	 * @return HTML formatted string with a complete changelog for a file.
	 * @see GetModFileChangelogResponse
	 */
	public String getModFileChangelog(int modId, int fileId)
	{
		return getModFileChangelog(GetModFileChangelogRequest.create(modId, fileId)).data;
	}

	/**
	 * Get a download url for a specific file.
	 * <p>
	 * Untested. There is a toggle "Allow the distribution of this project outside the CurseForge-Overwolf ecosystem.".
	 * Timtower said "Would get a result for that when you try it", but if any issues arise, please report, and we'll add a proper handling behavior for those cases!!
	 * <a href="https://discord.com/channels/428228256236306434/909494727341121607/915679409313300550">https://discord.com/channels/428228256236306434/909494727341121607/915679409313300550</a>
	 *
	 * @param req GetModFileDownloadURLRequest
	 * @return GetModFileDownloadURLResponse
	 * @see GetModFileDownloadURLRequest
	 * @see GetModFileDownloadURLResponse
	 */
	public GetModFileDownloadURLResponse getModFileDownloadURL(GetModFileDownloadURLRequest req)
	{
		return new GetModFileDownloadURLResponse(
				core.checkValid("Mod " + req.modId() + " File " + req.fileId() + " Download URL",
						core.getAuth("mods/" + req.modId() + "/files/" + req.fileId() + "/download-url")
				).jsonObjectBody()
		);
	}

	/**
	 * Get a download url for a specific file.
	 * <p>
	 * Untested. There is a toggle "Allow the distribution of this project outside the CurseForge-Overwolf ecosystem.".
	 * Timtower said "Would get a result for that when you try it", but if any issues arise, please report, and we'll add a proper handling behavior for those cases!!
	 * <a href="https://discord.com/channels/428228256236306434/909494727341121607/915679409313300550">https://discord.com/channels/428228256236306434/909494727341121607/915679409313300550</a>
	 *
	 * @param modId  The mod of the file to get URL for.
	 * @param fileId The file to get the URL for.
	 * @return URL for downloading the mod.
	 * @see GetModFileDownloadURLRequest
	 */
	public String getModFileDownloadURL(int modId, int fileId)
	{
		return getModFileDownloadURL(GetModFileDownloadURLRequest.create(modId, fileId)).data;
	}
}