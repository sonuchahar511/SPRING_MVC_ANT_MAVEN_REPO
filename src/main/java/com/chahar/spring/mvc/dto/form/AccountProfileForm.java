package com.chahar.spring.mvc.dto.form;

public class AccountProfileForm {
	
	private String firstName;
	private String lastName;
	private String email;
	
	@Override
	public String toString() {
		return "AccountProfileForm [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
