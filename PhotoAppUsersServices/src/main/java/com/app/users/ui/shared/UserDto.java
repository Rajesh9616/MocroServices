package com.app.users.ui.shared;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encriptedPassword;

	public UserDto() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncriptedPassword() {
		return encriptedPassword;
	}

	public void setEncriptedPassword(String encriptedPassword) {
		this.encriptedPassword = encriptedPassword;
	}

}
