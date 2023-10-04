package com.example.exception;

import java.time.LocalDateTime;

public class UserDetailsException {
	
	private String message;
	private String detail;
	private LocalDateTime dateTime;
	public String getMessage() {
		return message;
	}
	public UserDetailsException(String message, String detail, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.detail = detail;
		this.dateTime = dateTime;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
