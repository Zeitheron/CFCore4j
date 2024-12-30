package org.zeith.cfcore4j;

import org.zeith.cfcore4j.files.*;
import org.zeith.cfcore4j.schemas.File;
import org.zeith.cfcore4j.schemas.StringResponse;

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
	 * @param req
	 * 		GetModFileRequest
	 *
	 * @return GetModFileResponse
	 *
	 * @see GetModFileRequest
	 * @see GetModFileResponse
	 */
	public GetModFileResponse getModFile(GetModFileRequest req)
	{
		return new GetModFileResponse(
				core.request(1, "mods/" + req.modId() + "/files/" + req.fileId(), null, "Mod " + req.modId() + " File " + req.fileId())
						.get()
		);
	}
	
	/**
	 * Get a single file of the specified mod.
	 *
	 * @param modId
	 * 		The mod to get file for.
	 * @param fileId
	 * 		The file id to get.
	 *
	 * @return An instance of a file
	 *
	 * @see GetModFileRequest
	 * @see GetModFileResponse
	 */
	public File getModFile(long modId, long fileId)
	{
		return getModFile(GetModFileRequest.create(modId, fileId)).data;
	}
	
	/**
	 * Get all files of the specified mod.
	 *
	 * @param req
	 * 		GetModFilesRequest
	 *
	 * @return GetModFilesResponse
	 *
	 * @see GetModFilesRequest
	 * @see GetModFilesResponse
	 */
	public GetModFilesResponse getModFiles(GetModFilesRequest req)
	{
		return new GetModFilesResponse(this, req,
				core.request(1, "mods/" + req.modId() + "/files", req, "Mod " + req.modId() + " Files")
						.get()
		);
	}
	
	/**
	 * Get all files of the specified mod.
	 *
	 * @param modId
	 * 		The mod id.
	 *
	 * @return GetModFilesResponse
	 *
	 * @see GetModFilesRequest
	 * @see GetModFilesResponse
	 */
	public GetModFilesResponse getModFiles(long modId)
	{
		return getModFiles(GetModFilesRequest.create(modId));
	}
	
	/**
	 * Get a list of files.
	 *
	 * @param req
	 * 		GetFilesRequest
	 *
	 * @return GetFilesResponse
	 *
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
	public GetFilesResponse getFiles(GetFilesRequest req)
	{
		return new GetFilesResponse(
				core.request(1, "mods/files", null, "Files " + req.fileIds(), req.toString())
						.post()
		);
	}
	
	/**
	 * Get a list of files.
	 *
	 * @param fileIds
	 * 		List of fileId to get files for.
	 *
	 * @return A List of {@link File}
	 *
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
	public List<File> getFiles(long... fileIds)
	{
		return getFiles(GetFilesRequest.create().addFile(fileIds)).data;
	}
	
	/**
	 * Get a list of files.
	 *
	 * @param fileIds
	 * 		List of fileId to get files for.
	 *
	 * @return A List of {@link File}
	 *
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
	public List<File> getFiles(Iterable<Long> fileIds)
	{
		return getFiles(GetFilesRequest.create().addFile(fileIds)).data;
	}
	
	/**
	 * Get a list of files.
	 *
	 * @param fileIds
	 * 		List of fileId to get files for.
	 *
	 * @return A List of {@link File}
	 *
	 * @see GetFilesRequest
	 * @see GetFilesResponse
	 */
	public List<File> getFiles(Collection<Long> fileIds)
	{
		return getFiles(GetFilesRequest.create().addFile(fileIds)).data;
	}
	
	/**
	 * Get the changelog of a file in HTML format.
	 *
	 * @param req
	 * 		GetModFileChangelogRequest
	 *
	 * @return GetModFileChangelogResponse
	 *
	 * @see GetModFileChangelogRequest
	 * @see StringResponse
	 */
	public StringResponse getModFileChangelog(GetModFileChangelogRequest req)
	{
		return new StringResponse(
				core.request(1, "mods/" + req.modId() + "/files/" + req.fileId() + "/changelog", null, "Mod " + req.modId() + " File " + req.fileId() + " Changelog")
						.get()
		);
	}
	
	/**
	 * Get the changelog of a file in HTML format.
	 *
	 * @param modId
	 * 		The mod of the file to get changelog for.
	 * @param fileId
	 * 		The file to get the changelog for.
	 *
	 * @return HTML formatted string with a complete changelog for a file.
	 *
	 * @see StringResponse
	 */
	public String getModFileChangelog(long modId, long fileId)
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
	 * @param req
	 * 		GetModFileDownloadURLRequest
	 *
	 * @return GetModFileDownloadURLResponse
	 *
	 * @see GetModFileDownloadURLRequest
	 * @see StringResponse
	 */
	public StringResponse getModFileDownloadURL(GetModFileDownloadURLRequest req)
	{
		return new StringResponse(
				core.request(1, "mods/" + req.modId() + "/files/" + req.fileId() + "/download-url", null, "Mod " + req.modId() + " File " + req.fileId() + " Download URL")
						.get()
		);
	}
	
	/**
	 * Get a download url for a specific file.
	 * <p>
	 * Untested. There is a toggle "Allow the distribution of this project outside the CurseForge-Overwolf ecosystem.".
	 * Timtower said "Would get a result for that when you try it", but if any issues arise, please report, and we'll add a proper handling behavior for those cases!!
	 *
	 * @param modId
	 * 		The mod of the file to get URL for.
	 * @param fileId
	 * 		The file to get the URL for.
	 *
	 * @return URL for downloading the mod.
	 *
	 * @see GetModFileDownloadURLRequest
	 */
	public String getModFileDownloadURL(long modId, long fileId)
	{
		return getModFileDownloadURL(GetModFileDownloadURLRequest.create(modId, fileId)).data;
	}
}