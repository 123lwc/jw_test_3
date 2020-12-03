package com.lwc.upload;

import java.util.Date;

public class Img {
	private String firstName;
	private String lastName;
	private String time;
	private String img;
	public Img() {
		super();
	}
	public Img(String firstName, String lastName, String time, String img) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.time = time;
		this.img = img;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	

}
