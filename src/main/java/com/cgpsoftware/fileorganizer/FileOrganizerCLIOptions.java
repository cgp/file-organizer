package com.cgpsoftware.fileorganizer;

import org.apache.commons.cli.Options;


public class FileOrganizerCLIOptions
{
	
	enum FileOrganizerOptions {
		CHANGE_NOTHING("n", "change_nothing", false, "Change nothing. (only display changes)"),
		DESTINATION_SPEC("d", "destination_spec", true, "Destination spec (provides a template to append to the destination. Without this, default is to flatten"),
		MIRROR("m", "mirror", false, "Mirrors the directory structure of the found files");
		
		String shortFlag;
		String longFlag;
		boolean hasArg;
		String description;
		
		FileOrganizerOptions(String shortFlag, String longFlag, boolean hasArg, String description) {
			this.shortFlag = shortFlag;
			this.longFlag = longFlag;
			this.hasArg = hasArg;
			this.description = description;
		}
	}
	
	public static Options getOptions() {
		Options options = new Options();

		// add t option
		for(FileOrganizerOptions foo:FileOrganizerOptions.values()) {
			options.addOption(foo.shortFlag, foo.longFlag, foo.hasArg, foo.description);
			
		}
		
		return options;
		
	}

}
