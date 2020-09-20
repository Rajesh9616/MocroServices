package com.sharma.app.ws.mobileappws.ui.model.response;

import java.util.Date;

public class CustomExceptionMessage {
	
	private Date timeStamp;
	private String message;
	
	
	public CustomExceptionMessage(Date timeStamp,String msg) {
		this.timeStamp = timeStamp;
		this.message = msg;
	}
	
	
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
