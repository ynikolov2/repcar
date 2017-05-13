/*
 * Copyright RepCar AD 2017
 */
package com.repcar.user.resources;

import java.sql.Timestamp;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "users", value = "user")
public class UserResource extends ResourceSupport {

	private Long userId;
	private String username;
	private String userPassword;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private Long userRoleId;
	private Long workshopId;
	private Timestamp creationDate;
	private String tel;
	private boolean forcePasswordChange;
	private String status;
	private Long parentUserId;
	private Long userSettingsId;

	@JsonCreator
	public UserResource(@JsonProperty("username") String username, @JsonProperty("userEmail") String userEmail,
			@JsonProperty("userPassword") String userPassword, @JsonProperty("userFirstName") String userFirstName,
			@JsonProperty("userLastName") String userLastName, @JsonProperty("userRoleId") Long userRoleId,
			@JsonProperty("workshopId") Long workshopId, @JsonProperty("tel") String tel,
			@JsonProperty("forcePasswordChange") boolean forcePasswordChange, @JsonProperty("status") String status,
			@JsonProperty("parentUserId") Long parentUserId, @JsonProperty("userSettingsId") Long userSettingsId) {
		this.username = username;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userRoleId = userRoleId;
		this.workshopId = workshopId;
		this.forcePasswordChange = forcePasswordChange;
		this.status = status;
		this.parentUserId = parentUserId;
		this.tel = tel;
		this.userSettingsId = userSettingsId;
	}

	@JsonCreator
	public UserResource() {

	}

	public Long getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public Long getWorkshopId() {
		return workshopId;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public String getTel() {
		return tel;
	}

	public boolean isForcePasswordChange() {
		return forcePasswordChange;
	}

	public String getStatus() {
		return status;
	}

	public Long getParentUserId() {
		return parentUserId;
	}

	public Long getUserSettingsId() {
		return userSettingsId;
	}

}
