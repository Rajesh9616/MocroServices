package com.sharma.app.ws.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequest {
	@NotNull(message = "First name should not empty")
	private String firstName;
	
	@NotNull(message = "Last name should not empty")
	private String lastName;
	
	@NotNull(message = "Enail name should not empty")
	@Email
	private String email;
	
	@NotNull(message = "Password name should not empty")
	@Size(min = 2,max = 10, message = "Password must in specified size")
	private String password;
	
	

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
