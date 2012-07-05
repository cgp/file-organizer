package com.cgpsoftware.fileorganizer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.ParseException;

public class FileOrganizer {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ParseException, IOException {
		/**
		 * TODO Generate an "Action" 
		 * 
		 */
		FileOrganizerCLIConfig fileOrganizerCLIConfig = new FileOrganizerCLIConfig(args);
		
					
		FileFinder fileFinder = new FileFinder(fileOrganizerCLIConfig.src, fileOrganizerCLIConfig.fileFilters, fileOrganizerCLIConfig.dirFilters);
		List<FileInfo> foundFiles = fileFinder.find();
		
		for(FileInfo fileInfo:foundFiles) {
			//System.out.println(fileInfo.getFile().getAbsolutePath());
			
			String dest = fileOrganizerCLIConfig.dest.getCanonicalPath();
			
			Map<String, String> contextMap = createContextMap(fileInfo);			
			dest = dest + "/" + TemplateProcessor.process(contextMap, fileOrganizerCLIConfig.destSpec) + "/" + fileInfo.getFile().getName();
						
			//FileAction copyFileAction = new CopyFileAction(fileInfo.getFile(), new File(dest), null);
			System.out.println(dest);
		}
		System.out.println(fileFinder.src + " has :" + foundFiles.size());
		
	}

	private static Map<String, String> createContextMap(FileInfo fileInfo) {
		Map<String, String> result = new HashMap<String, String>();			
		result.put("year", (new SimpleDateFormat("yyyy")).format(fileInfo.getFile().lastModified()));
		result.put("month", (new SimpleDateFormat("MM")).format(fileInfo.getFile().lastModified()));
		result.put("day", (new SimpleDateFormat("dd")).format(fileInfo.getFile().lastModified()));
		return result;
	}

}
