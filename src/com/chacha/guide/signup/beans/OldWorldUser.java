package com.chacha.guide.signup.beans;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.joda.time.DateMidnight;

public class OldWorldUser {
	
	private Long userId;
	
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String emailAddress;
	private String password;
	private String handle;
	private Gender gender;
	private DateMidnight birthDate;
	private String phoneNumber;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalCode;
	
	/* vendor fields */
	private GovernmentIdentifierType governmentIdType;
	private String governmentId;
	
	

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public DateMidnight getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(DateMidnight birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public GovernmentIdentifierType getGovernmentIdType() {
		return governmentIdType;
	}
	public void setGovernmentIdType(GovernmentIdentifierType governmentIdType) {
		this.governmentIdType = governmentIdType;
	}
	public String getGovernmentId() {
		return governmentId;
	}
	public void setGovernmentId(String governmentId) {
		this.governmentId = governmentId;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
