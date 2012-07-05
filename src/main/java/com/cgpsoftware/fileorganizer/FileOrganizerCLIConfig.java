package com.cgpsoftware.fileorganizer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;


public class FileOrganizerCLIConfig
{

	File src;
	File dest;
	List<IOFileFilter> fileFilters = new ArrayList<IOFileFilter>();
	List<IOFileFilter> dirFilters = new ArrayList<IOFileFilter>();
	String destSpec = null;
	
	public FileOrganizerCLIConfig(String[] args) throws ParseException {
		Options options = FileOrganizerCLIOptions.getOptions();		
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(options, args);
		String[] actualArgs = cmd.getArgs();
		if (actualArgs.length < 2) {
			System.out.println("Specify a source and destination.");
			System.exit(-1);
		}

		// TODO Make sure that the src is a directory or a file. If it's not a directory or a file, it is a file spec, 
		// and we should superscede the default * filter by adding a new IOFileFilter that will be picked up by FileFinder 		
		fileFilters.add(new WildcardFileFilter("*"));
		dirFilters.add(new WildcardFileFilter("*"));
		
		this.src = new File(actualArgs[0]); // this at some point will include multiple sources
		this.dest = new File(actualArgs[1]);
		this.destSpec = cmd.getOptionValue('d');
	}
}
