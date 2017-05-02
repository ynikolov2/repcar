package com.repcar.makemodel.beans;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Workshop generated by hbm2java
 */
@Entity
@Table(name = "workshop", catalog = "repcar")
public class Workshop implements java.io.Serializable {

	private Integer workshopId;
	private String workshopName;
	private String workshopAddress;
	private Date creationDate;
	private Integer parentWorkshopId;
	private String type;
	private String sity;
	private String country;
	private String timezone;
	private String email;
	private String tel;
	private String subscriptionType;
	private Date subscriptionEndDate;
	private String status;
	private Set<WorshopServices> worshopServiceses = new HashSet<WorshopServices>(0);
	private Set<User> users = new HashSet<User>(0);


	public Workshop() {
	}

	public Workshop(String workshopName, String workshopAddress, Date creationDate, String sity, String country,
			String timezone, String subscriptionType, Date subscriptionEndDate, String status) {
		this.workshopName = workshopName;
		this.workshopAddress = workshopAddress;
		this.creationDate = creationDate;
		this.sity = sity;
		this.country = country;
		this.timezone = timezone;
		this.subscriptionType = subscriptionType;
		this.subscriptionEndDate = subscriptionEndDate;
		this.status = status;
	}

	public Workshop(String workshopName, String workshopAddress, Date creationDate, Integer parentWorkshopId,
			String type, String sity, String country, String timezone, String email, String tel,
			String subscriptionType, Date subscriptionEndDate, String status,
			Set<WorshopServices> worshopServiceses, Set<User> users) {
		this.workshopName = workshopName;
		this.workshopAddress = workshopAddress;
		this.creationDate = creationDate;
		this.parentWorkshopId = parentWorkshopId;
		this.type = type;
		this.sity = sity;
		this.country = country;
		this.timezone = timezone;
		this.email = email;
		this.tel = tel;
		this.subscriptionType = subscriptionType;
		this.subscriptionEndDate = subscriptionEndDate;
		this.status = status;
		this.worshopServiceses = worshopServiceses;
		this.users = users;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "workshop_id", unique = true, nullable = false)
	public Integer getWorkshopId() {
		return this.workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	@Column(name = "workshop_name", nullable = false, length = 45)
	public String getWorkshopName() {
		return this.workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	@Column(name = "workshop_address", nullable = false)
	public String getWorkshopAddress() {
		return this.workshopAddress;
	}

	public void setWorkshopAddress(String workshopAddress) {
		this.workshopAddress = workshopAddress;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, length = 19)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "parent_workshop_id")
	public Integer getParentWorkshopId() {
		return this.parentWorkshopId;
	}

	public void setParentWorkshopId(Integer parentWorkshopId) {
		this.parentWorkshopId = parentWorkshopId;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "sity", nullable = false, length = 80)
	public String getSity() {
		return this.sity;
	}

	public void setSity(String sity) {
		this.sity = sity;
	}

	@Column(name = "country", nullable = false, length = 48)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "timezone", nullable = false, length = 45)
	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tel", length = 45)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "subscription_type", nullable = false, length = 45)
	public String getSubscriptionType() {
		return this.subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "subscription_end_date", nullable = false, length = 10)
	public Date getSubscriptionEndDate() {
		return this.subscriptionEndDate;
	}

	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<WorshopServices> getWorshopServiceses() {
		return this.worshopServiceses;
	}

	public void setWorshopServiceses(Set<WorshopServices> worshopServiceses) {
		this.worshopServiceses = worshopServiceses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}