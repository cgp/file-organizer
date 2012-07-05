package com.cgpsoftware.fileorganizer.actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class CopyFileAction extends FileAction
{

	public CopyFileAction(File src, File dest, FileActionEvent fileActionEvent) {
		super(src, dest, fileActionEvent);
	}

	// TODO Create an event for handling errors	
	@Override
	public void act() {
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
		

}
