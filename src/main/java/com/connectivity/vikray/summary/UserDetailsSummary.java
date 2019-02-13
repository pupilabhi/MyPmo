package com.connectivity.vikray.summary;

import com.connectivity.vikray.entity.UserDetails;

public class UserDetailsSummary {

	private long id;
	private String firstName;
	private String forgotPassGuid;
	private String guid;
	private String inviteGuid;
	private String lastName;
	private String userLoginId;
	private String password;
	private String userEmail;
	private String userPhone;
	
	public UserDetailsSummary(UserDetails userDetails) {
		this.setId(userDetails.getId());
		this.setFirstName(userDetails.getFirstName());
		this.setForgotPassGuid(userDetails.getForgotPassGuid());
		this.setGuid(userDetails.getGuid());
		this.setInviteGuid(userDetails.getInviteGuid());
		this.setLastName(userDetails.getLastName());
		this.setUserLoginId(userDetails.getUserLoginId());
		this.setPassword(userDetails.getPassword());
		this.setUserEmail(userDetails.getUserEmail());
		this.setUserPhone(userDetails.getUserPhone());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getForgotPassGuid() {
		return forgotPassGuid;
	}

	public void setForgotPassGuid(String forgotPassGuid) {
		this.forgotPassGuid = forgotPassGuid;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getInviteGuid() {
		return inviteGuid;
	}

	public void setInviteGuid(String inviteGuid) {
		this.inviteGuid = inviteGuid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}
