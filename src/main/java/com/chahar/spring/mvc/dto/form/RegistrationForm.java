package com.chahar.spring.mvc.dto.form;

public class RegistrationForm {
	private String firstname;
	private String lastname;
	private String email;
	
	@Override
	public String toString() {
		return "RegistrationForm [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getEmail()="
				+ getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public RegistrationForm(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public RegistrationForm() {
		super();
	}
}
