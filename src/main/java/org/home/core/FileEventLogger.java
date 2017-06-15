package org.home.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {
	private String fileName;
	private File file;

	public void logEvent(Event e) {
		try {
			FileUtils.writeStringToFile(file, e.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public FileEventLogger() {
	}

	public FileEventLogger(String fileName) {
		System.out.println("constructor");
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void init() throws IOException {
		System.out.println("init()");
		this.file = new File(fileName);
		System.out.println(this.file.canWrite());
		if(!file.canWrite()){
			throw new IOException("Can't write");
		}
	}
}
