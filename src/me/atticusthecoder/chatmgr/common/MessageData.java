package me.atticusthecoder.chatmgr.common;

public class MessageData {
	private String message;
	private long timeSent;
	
	public MessageData(String message) {
		this(message, System.currentTimeMillis());
	}
	
	public MessageData(String message, long timeSent) {
		this.message = message;
		this.timeSent = timeSent;
	}
	
	public String getMessage() { 
		return message; 
	}
	
	public long getTimeSent() {
		return timeSent;
	}
}
