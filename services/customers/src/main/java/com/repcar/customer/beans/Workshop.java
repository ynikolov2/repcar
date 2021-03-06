/*
 * Copyright RepCar AD 2017
 */
//Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final
package com.repcar.customer.beans;

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

import org.springframework.hateoas.ResourceSupport;

/**
* Workshop generated by hbm2java
*/
@Entity
@Table(name = "workshop", catalog = "repcar")
public class Workshop extends ResourceSupport {

	private Integer workshopId;
	private String workshopName;
	private Integer parentWorkshopId;
	private String type;
	private String timezone;
	private String subscriptionType;
	private Set<WorkshopCustomer> workshopCustomers = new HashSet<WorkshopCustomer>(0);

	public Workshop() {
	}

	public Workshop(String workshopName,
			String timezone, String subscriptionType) {
		this.workshopName = workshopName;
		this.timezone = timezone;
		this.subscriptionType = subscriptionType;
	}

	public Workshop(String workshopName, Integer parentWorkshopId,
			String type, String timezone, String email, String telephone,
			String subscriptionType, Set<User> users,
			Set<WorkshopCustomer> workshopCustomers) {
		this.workshopName = workshopName;
		this.parentWorkshopId = parentWorkshopId;
		this.type = type;
		this.timezone = timezone;
		this.subscriptionType = subscriptionType;
		this.workshopCustomers = workshopCustomers;
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

	@Column(name = "timezone", nullable = false, length = 45)
	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Column(name = "subscription_type", nullable = false, length = 45)
	public String getSubscriptionType() {
		return this.subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<WorkshopCustomer> getWorkshopCustomers() {
		return this.workshopCustomers;
	}

	public void setWorkshopCustomers(Set<WorkshopCustomer> workshopCustomers) {
		this.workshopCustomers = workshopCustomers;
	}
}