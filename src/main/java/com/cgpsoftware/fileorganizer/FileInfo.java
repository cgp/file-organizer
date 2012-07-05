package com.cgpsoftware.fileorganizer;

import java.io.File;

public class FileInfo {

	private File file;

	public FileInfo(File file) {
		this.setFile(file);		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
