/*
 * Copyright RepCar AD 2017
 */
package com.repcar.user.beans;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user",catalog = "repcar") 
public class User extends ResourceSupport {

	public interface Update {
	}

	public interface Create {
	}

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
	public User() {
	}

	@JsonCreator
	public User(@JsonProperty("username") String username, @JsonProperty("userEmail") String userEmail, @JsonProperty("userPassword")  String userPassword, @JsonProperty("userFirstName") String userFirstName,  @JsonProperty("userLastName") String userLastName,
			@JsonProperty("userImage") String userImage, @JsonProperty("userRole")  UserRole userRole, @JsonProperty("workshop") Workshop workshop,@JsonProperty("forcePassChange") Boolean forcePassChange, @JsonProperty("telephone") String telephone,
			@JsonProperty("status") String status, @JsonProperty("parentUserId") long parentUserId, @JsonProperty("userSettings") UserSettings userSettings) {
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

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	@Null(groups = { Create.class })
	@NotNull(groups = { Update.class })
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 80)
	@Column(length = 80)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 80)
	@Column(length = 80)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 80)
	@Column(length = 80)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "force_pass_change")
	public Boolean getForcePassChange() {
		return this.forcePassChange;
	}

	public void setForcePassChange(Boolean forcePassChange) {
		this.forcePassChange = forcePassChange;
	}
	
	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 45)
	@Column(length = 45)
	public String getUserFirstName() {
		return this.userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	@NotNull(groups = { Create.class, Update.class })
	@Size(min = 1, max = 45)
	@Column(length = 45)
	public String getUserLastName() {
		return this.userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@Column(length = 45)
	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workshop_id", nullable = false)
	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	@OneToOne(cascade = { CascadeType.ALL, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "user_settings_id", unique = true)
	public UserSettings getUserSettings() {
		return userSettings;
	}

	public void setUserSettings(UserSettings userSettings) {
		this.userSettings = userSettings;
	}
	
	@Column(name = "created", nullable = false, length = 19)
	@Temporal(TemporalType.TIMESTAMP)
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
	
	@Column(name = "telephone", length = 45)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "parent_user_id")
	public long getParentUserId() {
		return this.parentUserId;
	}

	public void setParentUserId(long parentUserId) {
		this.parentUserId = parentUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((forcePassChange == null) ? 0 : forcePassChange.hashCode());
		result = prime * result + (int) (parentUserId ^ (parentUserId >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((userAttributes == null) ? 0 : userAttributes.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userImage == null) ? 0 : userImage.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((userSettings == null) ? 0 : userSettings.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((workshop == null) ? 0 : workshop.hashCode());
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
		if (forcePassChange == null) {
			if (other.forcePassChange != null)
				return false;
		} else if (!forcePassChange.equals(other.forcePassChange))
			return false;
		if (parentUserId != other.parentUserId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (userAttributes == null) {
			if (other.userAttributes != null)
				return false;
		} else if (!userAttributes.equals(other.userAttributes))
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
		if (userId != other.userId)
			return false;
		if (userImage == null) {
			if (other.userImage != null)
				return false;
		} else if (!userImage.equals(other.userImage))
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
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userSettings == null) {
			if (other.userSettings != null)
				return false;
		} else if (!userSettings.equals(other.userSettings))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (workshop == null) {
			if (other.workshop != null)
				return false;
		} else if (!workshop.equals(other.workshop))
			return false;
		return true;
	}

}
