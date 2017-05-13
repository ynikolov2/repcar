/*
 * Copyright RepCar AD 2017
 */
package com.repcar.user.beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user", catalog = "repcar")
public class User extends ResourceSupport {

	public interface Update {
	}

	public interface Create {
	}

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
	public User() {
	}

	@JsonCreator
	public User(@JsonProperty("username") String username, @JsonProperty("userEmail") String userEmail,
			@JsonProperty("userPassword") String userPassword, @JsonProperty("userFirstName") String userFirstName,
			@JsonProperty("userLastName") String userLastName, @JsonProperty("userRoleId") Long userRoleId,
			@JsonProperty("workshopId") Long workshopId, @JsonProperty("tel") String tel,
			@JsonProperty("forcePasswordChange") boolean forcePasswordChange, @JsonProperty("status") String status,
			@JsonProperty("parentUserId") Long parentUserId,@JsonProperty("userSettingsId") Long userSettingsId ) {
		this.setUsername(username);
		this.setUserEmail(userEmail);
		this.setUserPassword(userPassword);
		this.setUserFirstName(userFirstName);
		this.setUserLastName(userLastName);
		this.setUserRoleId(userRoleId);
		this.setWorkshopId(workshopId);
		this.setForcePasswordChange(forcePasswordChange);
		this.setStatus(status);
		this.setParentUserId(parentUserId);
		this.setTel(tel);
		this.setUserSettingsId(userSettingsId);

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	@NotNull(groups = { Update.class })
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 80)
	@Column(name = "user_name", length = 80)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 80)
	@Column(name = "user_email", length = 80)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 80)
	@Column(name = "user_password", length = 80)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 45)
	@Column(name = "user_first_name", length = 45)
	public String getUserFirstName() {
		return this.userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 45)
	@Column(name = "user_last_name", length = 45)
	public String getUserLastName() {
		return this.userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@NotNull(groups = { Create.class, Update.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	@Column(name = "role_id", length = 11)
	public Long getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workshop_id", nullable = false)
	@NotNull(groups = { Create.class, Update.class })
	@Column(name = "workshop_id", length = 11)
	public Long getWorkshopId() {
		return workshopId;
	}

	
	@Column(name = "workshop_id", nullable = false, length = 11)
	public void setWorkshopId(Long workshopId) {
		this.workshopId = workshopId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "tel", length = 45)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "force_pass_change")
	public boolean isForcePasswordChange() {
		return forcePasswordChange;
	}

	public void setForcePasswordChange(boolean forcePasswordChange) {
		this.forcePasswordChange = forcePasswordChange;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "parent_user_id", length = 11)
	public Long getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(Long parentUserId) {
		this.parentUserId = parentUserId;
	}
	
	@Column(name = "user_settings_id", length = 11)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_settings_id")
	public Long getUserSettingsId() {
		return userSettingsId;
	}
	
	public void setUserSettingsId(Long userSettingsId) {
		this.userSettingsId = userSettingsId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + (forcePasswordChange ? 1231 : 1237);
		result = prime * result + ((parentUserId == null) ? 0 : parentUserId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
		result = prime * result + ((userSettingsId == null) ? 0 : userSettingsId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((workshopId == null) ? 0 : workshopId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (forcePasswordChange != other.forcePasswordChange)
			return false;
		if (parentUserId == null) {
			if (other.parentUserId != null)
				return false;
		} else if (!parentUserId.equals(other.parentUserId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		if (userSettingsId == null) {
			if (other.userSettingsId != null)
				return false;
		} else if (!userSettingsId.equals(other.userSettingsId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (workshopId == null) {
			if (other.workshopId != null)
				return false;
		} else if (!workshopId.equals(other.workshopId))
			return false;
		return true;
	}

}
