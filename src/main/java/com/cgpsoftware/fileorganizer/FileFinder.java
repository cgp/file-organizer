package com.cgpsoftware.fileorganizer;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class FileFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("F:/photo/Unorganized");
		Collection<File> listFiles = FileUtils.listFiles(file, null, true);
		
		for(File f:listFiles) {
			String fileInfo;
			
			System.out.println(f);
		}
		System.out.println(listFiles.size());
	}

}
