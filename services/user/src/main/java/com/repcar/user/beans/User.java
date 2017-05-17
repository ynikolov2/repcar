/*
 * Copyright RepCar AD 2017
 */
package com.repcar.user.beans;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.persistence.UniqueConstraint;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user") 
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
	private String userImage;
	private String userAttributes;
	private UserRole userRole;
	private Workshop workshop;
	private UserSettings userSettings;
	private Timestamp creationDate;
	private Boolean forcePassChange;
	private String telephone;
	private String status;
	private Integer parentUserId;

	@JsonCreator
	public User() {
	}

	@JsonCreator
	public User(String username, String userEmail, String userPassword, String userFirstName, String userLastName,
			String userImage, UserRole userRole, Workshop workshop, Boolean forcePassChange, String telephone,
			String status, Integer parentUserId, UserSettings userSettings) {
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


	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH })
	@JoinColumn(name = "role_id", nullable = false)
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH })
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
	public Integer getParentUserId() {
		return this.parentUserId;
	}

	public void setParentUserId(Integer parentUserId) {
		this.parentUserId = parentUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((workshop == null) ? 0 : workshop.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userImage == null) ? 0 : userImage.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((userAttributes == null) ? 0 : userAttributes.hashCode());
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
		if (workshop == null) {
			if (other.workshop != null)
				return false;
		} else if (!workshop.equals(other.workshop))
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
		if (userAttributes == null) {
			if (other.userAttributes != null)
				return false;
		} else if (!userAttributes.equals(other.userAttributes))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userRole != other.userRole)
			return false;
		return true;
	}

}
