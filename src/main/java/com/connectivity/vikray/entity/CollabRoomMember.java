package com.connectivity.vikray.entity;
// Generated 27 Dec, 2018 3:06:26 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CollabRoomMember generated by hbm2java
 */
@Entity
@Table(name = "COLLAB_ROOM_MEMBER", catalog = "namcrm")
public class CollabRoomMember implements java.io.Serializable {

	private long id;
	private CollabRoom collabRoom;
	private String sparkMembershipId;
	private long userFk;

	public CollabRoomMember() {
	}

	public CollabRoomMember(long id, long userFk) {
		this.id = id;
		this.userFk = userFk;
	}

	public CollabRoomMember(long id, CollabRoom collabRoom, String sparkMembershipId, long userFk) {
		this.id = id;
		this.collabRoom = collabRoom;
		this.sparkMembershipId = sparkMembershipId;
		this.userFk = userFk;
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
	@JoinColumn(name = "COLLAB_ROOM_FK")
	public CollabRoom getCollabRoom() {
		return this.collabRoom;
	}

	public void setCollabRoom(CollabRoom collabRoom) {
		this.collabRoom = collabRoom;
	}

	@Column(name = "SPARK_MEMBERSHIP_ID")
	public String getSparkMembershipId() {
		return this.sparkMembershipId;
	}

	public void setSparkMembershipId(String sparkMembershipId) {
		this.sparkMembershipId = sparkMembershipId;
	}

	@Column(name = "USER_FK", nullable = false)
	public long getUserFk() {
		return this.userFk;
	}

	public void setUserFk(long userFk) {
		this.userFk = userFk;
	}

}
