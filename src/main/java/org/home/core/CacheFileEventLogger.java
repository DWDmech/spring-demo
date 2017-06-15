package org.home.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CacheFileEventLogger extends FileEventLogger {
	private int cacheSize;
	private List<Event> cache;
	
	public CacheFileEventLogger() {
	}

	public CacheFileEventLogger(Integer cacheSize) {
		this.cacheSize = cacheSize.intValue();
		this.cache = new ArrayList<Event>();
	}
	
	public CacheFileEventLogger(Integer cacheSize, String fileName) {
		super(fileName);
		this.cacheSize = cacheSize.intValue();
		this.cache = new ArrayList<Event>();
	}
	
	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public List<Event> getCache() {
		return cache;
	}

	public void setCache(List<Event> cache) {
		this.cache = cache;
	}

	public void logEvent(Event e) {
		cache.add(e);
		
		if(cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}
	
	private void writeEventsFromCache() {
		for(Event e: cache){
			try {
				FileUtils.writeStringToFile(getFile(), e.getMsg());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void destroy(){
		System.out.println("dddd");
		if( !cache.isEmpty()){
			writeEventsFromCache();
		}
	}
}
