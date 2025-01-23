package Refugees_Management_System;

public class Admin {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean verifyLogin(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
}
