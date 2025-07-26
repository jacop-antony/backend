package com.tap.model;

import java.sql.Timestamp;

public class User {

	 int userId;
	 String name;
	 String userName;
	 String password;
	 String email;
	 String phoneNumber;
	 String address;
	 String role;
	 Timestamp createdDate;
	 Timestamp lastLoginDate;


	public User(){

	}


	public User(int userId, String name, String username, String password, String email, String phoneNumber,
			String address, String role, Timestamp createdDate, Timestamp lastLoginDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}


	public User(int userId, String name, String userName, String password, String email, String phoneNumber,
			String address, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setUserName(String username) {
		this.userName = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	public int getUserId() {
		return userId;
	}


	public String getName() {
		return name;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public String getRole() {
		return role;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", role=" + role
				+ ", createdDate=" + createdDate + ", lastLoginDate=" + lastLoginDate + "]";
	}


}