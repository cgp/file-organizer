package com.cgpsoftware.fileorganizer.actions;

import java.io.File;


public abstract class FileAction
{
	public final File src;
	public final File dest;
	public final FileActionEvent fileActionEvent;
	
	public FileAction(File src, File dest, FileActionEvent fileActionEvent) {
		this.src = src;
		this.dest = dest;	
		this.fileActionEvent = fileActionEvent;		
	}
	
	public abstract void act() throws Exception;	
}
