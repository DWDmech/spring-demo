package org.home.core;

import java.text.DateFormat;
import java.util.Date;

public class Event {
	private int id;
	private String msg;
	private Date date;
	private DateFormat df;

	public Event() {
	}
	
	public Event(Date date, DateFormat df) {
		this.date = date;
		this.df = df;
	}
	

	public Event(int id, String msg, Date date, DateFormat df) {
		this.id = id;
		this.msg = msg;
		this.date = date;
		this.df = df;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static boolean isDay(){
		return true;
	}
	
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + df.format(date) + "]";
	}
}
