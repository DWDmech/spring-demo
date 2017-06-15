package org.home.core;

public class Client {
	private String id;
	private String fillName;
	
	public Client(String id, String fillName) {
		super();
		this.id = id;
		this.fillName = fillName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFillName() {
		return fillName;
	}
	public void setFillName(String fillName) {
		this.fillName = fillName;
	}
}
