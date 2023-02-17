package com.springrest.springrest.entities;

public class Courses {

	private long id;
	private String title;
	private String desc;
	
	public Courses(long id, String title, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
	}
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Courses [id=" + id + ", title=" + title + ", desc=" + desc + "]";
	}
	
	
}
