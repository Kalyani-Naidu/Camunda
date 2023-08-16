package com.saas.camunda.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FIXED_DEPOSIT")
public class customerDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "AADHAR_NUMBER")
	private String aadhar;
	
	@Column(name = "PAN_NUMBER")
	private String pan;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "NATIONALITY")
	private String nationality;
	
	@Column(name = "FD_OPENING_DATE")
	private String fdOpeningDate;
	
	@Column(name = "MONTHLY_INCOME")
	private String monthlyIncome;

	public customerDataEntity(int id, String firstName, String lastName, String accountNumber, String phoneNumber,
			String aadhar, String pan, String gender, String nationality, String fdOpeningDate, String monthlyIncome) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.aadhar = aadhar;
		this.pan = pan;
		this.gender = gender;
		this.nationality = nationality;
		this.fdOpeningDate = fdOpeningDate;
		this.monthlyIncome = monthlyIncome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFdOpeningDate() {
		return fdOpeningDate;
	}

	public void setFdOpeningDate(String fdOpeningDate) {
		this.fdOpeningDate = fdOpeningDate;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	
	@Override
	public String toString() {
		return "customerDataEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountNumber=" + accountNumber + ", phoneNumber=" + phoneNumber + ", aadhar=" + aadhar + ", pan="
				+ pan + ", gender=" + gender + ", nationality=" + nationality + ", fdOpeningDate=" + fdOpeningDate
				+ ", monthlyIncome=" + monthlyIncome + "]";
	}

	public customerDataEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}