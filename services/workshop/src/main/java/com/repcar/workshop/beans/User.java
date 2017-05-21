/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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

	private long userId;
	private String username;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private Workshop workshop;
	private String status;

	@JsonCreator
	public User() {
	}

	@JsonCreator
	public User(@JsonProperty("username") String username, @JsonProperty("userEmail") String userEmail, @JsonProperty("userFirstName") String userFirstName, @JsonProperty("userLastName") String userLastName, @JsonProperty("workshop") Workshop workshop,
			@JsonProperty("status") String status) {
		this.username = username;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.workshop = workshop;
		this.setStatus(status);
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
	public String getUserName() {
		return this.username;
	}

	public void setUserName(String userName) {
		this.username = userName;
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
	
	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		if (workshop == null) {
			if (other.workshop != null)
				return false;
		} else if (!workshop.equals(other.workshop))
			return false;
		return true;
	}

	

}
