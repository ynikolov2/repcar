/*
 * Copyright RepCar AD 2017
 */
//Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final
package com.repcar.workshop.beans;

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
	private String workshopAddress;
	private Date created;
	private Integer parentWorkshopId;
	private String type;
	private String city;
	private String country;
	private String timezone;
	private String email;
	private String telephone;
	private String subscriptionType;
	private Date subscriptionEndDate;
	private String status;
	private Set<Subscription> subscriptions = new HashSet<Subscription>(0);
	private Set<WorkshopSettings> workshopSettings = new HashSet<WorkshopSettings>(0);
	private Set<WorshopDefinedService> worshopDefinedService = new HashSet<WorshopDefinedService>(0);
	private Set<User> users = new HashSet<User>(0);
	private Set<WorkshopCustomer> workshopCustomers = new HashSet<WorkshopCustomer>(0);
	private Set<WorkshopInvoiceDetails> workshopInvoiceDetails = new HashSet<WorkshopInvoiceDetails>(0);
	private Set<Car> cars = new HashSet<Car>(0);

	public Workshop() {
	}

	public Workshop(String workshopName, String workshopAddress, Date created, String city, String country,
			String timezone, String subscriptionType, Date subscriptionEndDate, String status) {
		this.workshopName = workshopName;
		this.workshopAddress = workshopAddress;
		this.created = created;
		this.city = city;
		this.country = country;
		this.timezone = timezone;
		this.subscriptionType = subscriptionType;
		this.subscriptionEndDate = subscriptionEndDate;
		this.status = status;
	}

	public Workshop(String workshopName, String workshopAddress, Date created, Integer parentWorkshopId,
			String type, String city, String country, String timezone, String email, String telephone,
			String subscriptionType, Date subscriptionEndDate, String status, Set<Subscription> subscriptions,
			Set<WorkshopSettings> workshopSettings, Set<WorshopDefinedService> worshopDefinedService, Set<User> users,
			Set<WorkshopCustomer> workshopCustomers, Set<WorkshopInvoiceDetails> workshopInvoiceDetails,
			Set<Car> cars) {
		this.workshopName = workshopName;
		this.workshopAddress = workshopAddress;
		this.created = created;
		this.parentWorkshopId = parentWorkshopId;
		this.type = type;
		this.city = city;
		this.country = country;
		this.timezone = timezone;
		this.email = email;
		this.telephone = telephone;
		this.subscriptionType = subscriptionType;
		this.subscriptionEndDate = subscriptionEndDate;
		this.status = status;
		this.subscriptions = subscriptions;
		this.workshopSettings = workshopSettings;
		this.worshopDefinedService = worshopDefinedService;
		this.users = users;
		this.workshopCustomers = workshopCustomers;
		this.workshopInvoiceDetails = workshopInvoiceDetails;
		this.cars = cars;
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
	@Column(name = "created", nullable = false, length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	@Column(name = "city", nullable = false, length = 80)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	@Column(name = "telephone", length = 45)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public Set<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<WorkshopSettings> getWorkshopSettings() {
		return this.workshopSettings;
	}

	public void setWorkshopSettings(Set<WorkshopSettings> workshopSettings) {
		this.workshopSettings = workshopSettings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<WorshopDefinedService> getWorshopDefinedService() {
		return this.worshopDefinedService;
	}

	public void setWorshopDefinedService(Set<WorshopDefinedService> worshopDefinedService) {
		this.worshopDefinedService = worshopDefinedService;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<WorkshopCustomer> getWorkshopCustomers() {
		return this.workshopCustomers;
	}

	public void setWorkshopCustomers(Set<WorkshopCustomer> workshopCustomers) {
		this.workshopCustomers = workshopCustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<WorkshopInvoiceDetails> getWorkshopInvoiceDetails() {
		return this.workshopInvoiceDetails;
	}

	public void setWorkshopInvoiceDetails(Set<WorkshopInvoiceDetails> workshopInvoiceDetails) {
		this.workshopInvoiceDetails = workshopInvoiceDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workshop")
	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}