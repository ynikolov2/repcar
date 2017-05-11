/*
 * Copyright RepCar AD 2017
 */
package com.repcar.customer.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class User extends ResourceSupport {

	public interface Update {
	}

	public interface Create {
	}

	private Long userId;
	private Workshop workshop;
	private String username;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private Roles userRole;

	public User() {
	}

	public User(String username, String userEmail, String userPassword, String userFirstName, String userLastName,
			String userImage, Roles userRole, Long companyId) {
		this.username = username;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userRole = userRole;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workshop_id", nullable = false)
	public Workshop getWorkshop() {
		return this.workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
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

	@NotNull(groups = { Create.class, Update.class })
	@Enumerated(EnumType.STRING)
	public Roles getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

	public enum Roles {
		ROLE_ADMIN, ROLE_USER, ROLE_ANONYMOUS, ROLE_OPERATOR
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
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
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
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
