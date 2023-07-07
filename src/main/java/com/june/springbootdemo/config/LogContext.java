package com.june.springbootdemo.config;

public class LogContext {

	private long methodEntryTime = 0;

	public long getMethodEntryTime() {
		return this.methodEntryTime;
	}

	public void setMethodEntryTime(final long methodEntryTime) {
		this.methodEntryTime = methodEntryTime;
	}

}
