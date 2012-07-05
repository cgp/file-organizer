package com.cgpsoftware.fileorganizer.exif;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTime;

import com.cgpsoftware.fileorganizer.FileOrganizerUtil;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectory;
import com.drew.metadata.exif.ExifInteropDescriptor;

public class ExifExtractor {


	@SuppressWarnings("rawtypes")
	public static Map<String, String> getInfo(File f) {
		Map<String, String> result = new HashMap<String, String>();
		
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(f);
			
			Iterator directoryIterator = metadata.getDirectoryIterator();
			while (directoryIterator.hasNext()) {
				Directory directory = (Directory)directoryIterator.next();
				Iterator tagIterator = directory.getTagIterator();
			    while (tagIterator.hasNext()) {
			    	Tag tag = (Tag)tagIterator.next();			    			
			        try {
						result.put(tag.getDirectoryName()+":"+tag.getTagName()+"["+tag.getTagTypeHex()+"]", tag.getDescription());
					} catch (MetadataException e) {
						result.put(tag.getTagName(), e.getMessage());
						e.printStackTrace();
					}
			    }
			}			 
		} catch (ImageProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static DateTime getTaken(File f) throws ImageProcessingException, MetadataException {
		Metadata metadata = ImageMetadataReader.readMetadata(f);		
		Date date = metadata.getDirectory(ExifDirectory.class).getDate(FileOrganizerUtil.hextoint("9004"));		
		return new DateTime(date);
	}
	
	public static void main(String[] args) throws ImageProcessingException, MetadataException {
		File photo = new File("F:\\photo\\Unorganized\\unk\\Sept\\IMG_7565.JPG");
		/*
		Map<String, String> info = getInfo(photo);
		for(Entry<String, String> e:info.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}*/		
		System.out.println(getTaken(photo));
	}

}
