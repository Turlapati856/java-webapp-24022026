package com.codegnan.javawebapp24022026.entity;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfJoining;
	private String emailAddress;
	private String loginPassword;
	
	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, String dateOfJoining, String emailAddress, String loginPassword) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
		this.emailAddress = emailAddress;
		this.loginPassword = loginPassword;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}