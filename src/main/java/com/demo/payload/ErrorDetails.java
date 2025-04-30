package com.demo.payload;

import java.util.Date;

public class ErrorDetails {
	
	private String message;
	private Date date;
	private String url;
	
	public ErrorDetails(String message, Date date, String url) {
		this.message = message;
		this.date = date;
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	public String getUrl() {
		return url;
	}
}
