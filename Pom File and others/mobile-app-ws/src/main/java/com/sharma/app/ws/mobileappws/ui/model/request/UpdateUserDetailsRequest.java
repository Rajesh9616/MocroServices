package com.sharma.app.ws.mobileappws.ui.model.request;

import javax.validation.constraints.NotNull;


public class UpdateUserDetailsRequest {
	@NotNull(message = "First name should not empty")
	private String firstName;
	
	@NotNull(message = "Last name should not empty")
	private String lastName;
	
	

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

	


}
