package com.chahar.spring.mvc.dto;

import java.util.Date;

public class UserDto {
	private String id;
	private String name;
	private Date createTime;
	
	public UserDto(String id, String name, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", createTime=" + createTime + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getCreateTime()=" + getCreateTime() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public UserDto() {
		super();
	}
}
