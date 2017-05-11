package com.repcar.workshop.beans;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.hateoas.ResourceSupport;

/**
 * WorshopDefinedService generated by hbm2java
 */
@Entity
@Table(name = "worshop_defined_service", catalog = "repcar")
public class WorshopDefinedService extends ResourceSupport {

	private Integer serviceId;
	private Car cars;
	private User user;
	private Workshop workshop;
	private WorkshopCustomer workshopClients;
	private Integer parentServiceId;
	private Date startDate;
	private Float spendedHours;
	private Date endDate;

	public WorshopDefinedService() {
	}

	public WorshopDefinedService(Car cars, User user, Workshop workshop, WorkshopCustomer workshopClients, Date startDate) {
		this.cars = cars;
		this.user = user;
		this.workshop = workshop;
		this.workshopClients = workshopClients;
		this.startDate = startDate;
	}

	public WorshopDefinedService(Car cars, User user, Workshop workshop, WorkshopCustomer workshopClients,
			Integer parentServiceId, Date startDate, Float spendedHours, Date endDate) {
		this.cars = cars;
		this.user = user;
		this.workshop = workshop;
		this.workshopClients = workshopClients;
		this.parentServiceId = parentServiceId;
		this.startDate = startDate;
		this.spendedHours = spendedHours;
		this.endDate = endDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "service_id", unique = true, nullable = false)
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", nullable = false)
	public Car getCars() {
		return this.cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workshop_id", nullable = false)
	public Workshop getWorkshop() {
		return this.workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	public WorkshopCustomer getWorkshopClients() {
		return this.workshopClients;
	}

	public void setWorkshopClients(WorkshopCustomer workshopClients) {
		this.workshopClients = workshopClients;
	}

	@Column(name = "parent_service_id")
	public Integer getParentServiceId() {
		return this.parentServiceId;
	}

	public void setParentServiceId(Integer parentServiceId) {
		this.parentServiceId = parentServiceId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "spended_hours", precision = 12, scale = 0)
	public Float getSpendedHours() {
		return this.spendedHours;
	}

	public void setSpendedHours(Float spendedHours) {
		this.spendedHours = spendedHours;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
