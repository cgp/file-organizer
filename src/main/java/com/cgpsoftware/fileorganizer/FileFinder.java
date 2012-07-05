package com.cgpsoftware.fileorganizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * Finds files in a directory using the apache tool.
 * 
 * Eventually, this could be tuned for very large datasets so that we didn't have to process the entire filelist 
 * in memory. I imagine, since we are eventually going to store these file lists off in a database eventually, 
 * we can just have multiple stages for filtering and processing:
 * 
 * 1. First stage scans the directories/files. (there could stage specific filters, based on filesystem information such as name, date, path)
 * 2. Second stage scans the information from those files (there could be stage specific filters based on metadata within the files)
 * 3. (processing stage)
 * 4. Fourth stage could utilize information from any processing results and filter from there 
 * (more processing or rinse and repeat 3rd and fourth steps -- technically, the second stage might be folded into the third, 
 * even the first stage could get folded, but it might make sense to default the first and second to a typical usage scenario 
 * instead of making everything abstract)
 * 
 * @author cpall
 *
 */
public class FileFinder {

	public final File src;
	public final List<IOFileFilter> fileFilters;
	public final List<IOFileFilter> dirFilters;	
	
	public FileFinder(File src, List<IOFileFilter> fileFilters, List<IOFileFilter> dirFilters) {
		this.src = src;
		this.fileFilters = fileFilters;
		this.dirFilters = dirFilters;
		
	}
	
	public List<FileInfo> find() {		
		
		Collection<File> listFiles = FileUtils.listFiles(src, new AndFileFilter(fileFilters), new AndFileFilter(dirFilters));
		
		List<FileInfo> fileList = new ArrayList<FileInfo>();		
		for(File f:listFiles) {
			FileInfo fileInfo = new FileInfo(f);
			fileList.add(fileInfo);
		}
		return fileList;
		
	}

}
