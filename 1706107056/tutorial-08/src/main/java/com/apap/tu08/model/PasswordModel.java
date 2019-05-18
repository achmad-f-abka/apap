package com.apap.tu08.model;

public class PasswordModel {
	private String oldPassword;
	private String newPassword;
	private String confirmationPassword;
	
	public String getoldPassword() {
		return oldPassword;
	}
	public void setoldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getnewPassword() {
		return newPassword;
	}
	public void setnewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getconfirmationPassword() {
		return confirmationPassword;
	}
	public void setconfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}
}
