package com.cgpsoftware.fileorganizer.actions;


public class FileActionEvent
{	
	public final FileAction action; 
	public final boolean success;
	public final String errorMsg;

	public FileActionEvent(boolean success, String errorMsg, FileAction action) {
		this.success = success;
		this.errorMsg = errorMsg;
		this.action = action;
		
	}
	
	public void onActionEvent() {
		System.out.println(action.getClass().getSimpleName() + ": " + action.src + ", " + action.dest);
	}
		
	
}
