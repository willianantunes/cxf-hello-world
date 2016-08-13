package br.com.willianantunes.test.cxf.model;

import java.time.LocalDateTime;

public class MyMessageModel {
	private LocalDateTime created;
	private String message;
	
	public MyMessageModel(LocalDateTime created, String message) {
		this.created = created;
		this.message = message;
	}
	
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
