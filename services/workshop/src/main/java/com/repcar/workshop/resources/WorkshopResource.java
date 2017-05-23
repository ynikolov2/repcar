/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.resources;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.repcar.workshop.beans.Car;
import com.repcar.workshop.beans.Subscription;
import com.repcar.workshop.beans.User;
import com.repcar.workshop.beans.Workshop;
import com.repcar.workshop.beans.WorkshopCustomer;
import com.repcar.workshop.beans.WorkshopInvoiceDetails;
import com.repcar.workshop.beans.WorkshopSettings;
import com.repcar.workshop.beans.WorshopDefinedService;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "workshop", value = "workshop")
public class WorkshopResource extends ResourceSupport {
	private long workshopId;
	private String workshopName;
	private String workshopAddress;
	private Date created;
	private long parentWorkshopId;
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
	private WorkshopInvoiceDetails workshopInvoiceDetails;
	private Set<Car> cars = new HashSet<Car>(0);

	public WorkshopResource() {
	}

	@JsonCreator
	public WorkshopResource(@JsonProperty("workshopName") String workshopName,
			@JsonProperty("workshopAddress") String workshopAddress, @JsonProperty("created") Date created,
			@JsonProperty("parentWorkshopId") long parentWorkshopId, @JsonProperty("type") String type,
			@JsonProperty("city") String city, @JsonProperty("country") String country,
			@JsonProperty("timezone") String timezone, @JsonProperty("email") String email,
			@JsonProperty("telephone") String telephone, @JsonProperty("subscriptionType") String subscriptionType,
			@JsonProperty("subscriptionEndDate") Date subscriptionEndDate, @JsonProperty("status") String status,
			@JsonProperty("subscriptions") Set<Subscription> subscriptions,
			@JsonProperty("workshopSettings") Set<WorkshopSettings> workshopSettings,
			@JsonProperty("worshopDefinedService") Set<WorshopDefinedService> worshopDefinedService,
			@JsonProperty("users") Set<User> users,
			@JsonProperty("workshopCustomers") Set<WorkshopCustomer> workshopCustomers,
			@JsonProperty("workshopInvoiceDetails") WorkshopInvoiceDetails workshopInvoiceDetails,
			@JsonProperty("cars") Set<Car> cars) {
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

	public long getWorkshopId() {
		return this.workshopId;
	}

	public void setWorkshopId(long workshopId) {
		this.workshopId = workshopId;
	}

	public String getWorkshopName() {
		return this.workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getWorkshopAddress() {
		return this.workshopAddress;
	}

	public void setWorkshopAddress(String workshopAddress) {
		this.workshopAddress = workshopAddress;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getParentWorkshopId() {
		return this.parentWorkshopId;
	}

	public void setParentWorkshopId(long parentWorkshopId) {
		this.parentWorkshopId = parentWorkshopId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSubscriptionType() {
		return this.subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Date getSubscriptionEndDate() {
		return this.subscriptionEndDate;
	}

	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Set<WorkshopSettings> getWorkshopSettings() {
		return this.workshopSettings;
	}

	public void setWorkshopSettings(Set<WorkshopSettings> workshopSettings) {
		this.workshopSettings = workshopSettings;
	}

	public Set<WorshopDefinedService> getWorshopDefinedService() {
		return this.worshopDefinedService;
	}

	public void setWorshopDefinedService(Set<WorshopDefinedService> worshopDefinedService) {
		this.worshopDefinedService = worshopDefinedService;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<WorkshopCustomer> getWorkshopCustomers() {
		return this.workshopCustomers;
	}

	public void setWorkshopCustomers(Set<WorkshopCustomer> workshopCustomers) {
		this.workshopCustomers = workshopCustomers;
	}

	public WorkshopInvoiceDetails getWorkshopInvoiceDetails() {
		return this.workshopInvoiceDetails;
	}

	public void setWorkshopInvoiceDetails(WorkshopInvoiceDetails workshopInvoiceDetails) {
		this.workshopInvoiceDetails = workshopInvoiceDetails;
	}

	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}
