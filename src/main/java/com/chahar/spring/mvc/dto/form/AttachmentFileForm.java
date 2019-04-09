package com.chahar.spring.mvc.dto.form;

import org.springframework.web.multipart.MultipartFile;

public class AttachmentFileForm {
	private String name;
	private MultipartFile attachment;
	
	@Override
	public String toString() {
		return "AttachmentFileForm [name=" + name + ", attachment=" + attachment + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getAttachment() {
		return attachment;
	}
	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}
}
