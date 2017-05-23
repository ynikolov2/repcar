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
import com.repcar.user.beans.UserRole;
import com.repcar.user.beans.UserSettings;
import com.repcar.user.beans.Workshop;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "users", value = "user")
public class UserResource extends ResourceSupport {

	private long userId;
	private String username;
	private String userPassword;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String userImage;
	private String userAttributes;
	private UserRole userRole;
	private Workshop workshop;
	private UserSettings userSettings;
	private Timestamp creationDate;
	private Boolean forcePassChange;
	private String telephone;
	private String status;
	private long parentUserId;

	@JsonCreator
	public UserResource() {

	}

	@JsonCreator
	public UserResource(@JsonProperty("username") String username, @JsonProperty("userEmail") String userEmail,
			@JsonProperty("userPassword") String userPassword, @JsonProperty("userFirstName") String userFirstName,
			@JsonProperty("userLastName") String userLastName, @JsonProperty("userImage") String userImage,
			@JsonProperty("userRole") UserRole userRole, @JsonProperty("workshop") Workshop workshop,
			@JsonProperty("forcePassChange") Boolean forcePassChange, @JsonProperty("telephone") String telephone,
			@JsonProperty("status") String status, @JsonProperty("parentUserId") long parentUserId,
			@JsonProperty("userSettings") UserSettings userSettings) {
		this.username = username;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userImage = userImage;
		this.userRole = userRole;
		this.workshop = workshop;
		this.forcePassChange = forcePassChange;
		this.telephone = telephone;
		this.status = status;
		this.parentUserId = parentUserId;
		this.userSettings = userSettings;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Boolean getForcePassChange() {
		return this.forcePassChange;
	}

	public void setForcePassChange(Boolean forcePassChange) {
		this.forcePassChange = forcePassChange;
	}

	public String getUserFirstName() {
		return this.userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return this.userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	public UserSettings getUserSettings() {
		return userSettings;
	}

	public void setUserSettings(UserSettings userSettings) {
		this.userSettings = userSettings;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserAttributes() {
		return userAttributes;
	}

	public void setUserAttributes(String userAttributes) {
		this.userAttributes = userAttributes;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getParentUserId() {
		return this.parentUserId;
	}

	public void setParentUserId(long parentUserId) {
		this.parentUserId = parentUserId;
	}

}
