package com.connectivity.vikray.entity;
// Generated 27 Dec, 2018 3:06:26 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AccountActivity generated by hbm2java
 */
@Entity
@Table(name = "ACCOUNT_ACTIVITY", catalog = "namcrm")
public class AccountActivity implements java.io.Serializable {

	private long id;
	private AccountDetail accountDetail;
	private UserDetails userDetails;
	private Date activityOn;
	private String comment;
	private String medium;
	private String sincedays;
	private Set<AccountDetail> accountDetails = new HashSet<AccountDetail>(0);

	public AccountActivity() {
	}

	public AccountActivity(long id) {
		this.id = id;
	}

	public AccountActivity(long id, AccountDetail accountDetail, UserDetails userDetails, Date activityOn,
			String comment, String medium, String sincedays, Set<AccountDetail> accountDetails) {
		this.id = id;
		this.accountDetail = accountDetail;
		this.userDetails = userDetails;
		this.activityOn = activityOn;
		this.comment = comment;
		this.medium = medium;
		this.sincedays = sincedays;
		this.accountDetails = accountDetails;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_DK")
	public AccountDetail getAccountDetail() {
		return this.accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER")
	public UserDetails getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACTIVITY_ON", length = 19)
	public Date getActivityOn() {
		return this.activityOn;
	}

	public void setActivityOn(Date activityOn) {
		this.activityOn = activityOn;
	}

	@Column(name = "COMMENT")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "MEDIUM")
	public String getMedium() {
		return this.medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	@Column(name = "SINCEDAYS")
	public String getSincedays() {
		return this.sincedays;
	}

	public void setSincedays(String sincedays) {
		this.sincedays = sincedays;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountActivity")
	public Set<AccountDetail> getAccountDetails() {
		return this.accountDetails;
	}

	public void setAccountDetails(Set<AccountDetail> accountDetails) {
		this.accountDetails = accountDetails;
	}

}
