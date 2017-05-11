package com.repcar.customer.beans;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

/**
 * Service generated by hbm2java
 */
@Entity
@Table(name = "service", catalog = "repcar")
public class Service extends ResourceSupport {

	private Integer serviceId;
	private String serviceName;
	private int workshopServiceId;
	private WorkshopCustomer workshopCustomer;

	public Service() {
	}

	public Service(String serviceName, int workshopServiceId) {
		this.serviceName = serviceName;
		this.workshopServiceId = workshopServiceId;
		this.workshopCustomer = workshopCustomer;
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

	@Column(name = "service_name", nullable = false, length = 45)
	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "workshop_service_id", nullable = false)
	public int getWorkshopServiceId() {
		return this.workshopServiceId;
	}

	public void setWorkshopServiceId(int workshopServiceId) {
		this.workshopServiceId = workshopServiceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public WorkshopCustomer getWorkshopCustomer() {
		return this.workshopCustomer;
	}

	public void setWorkshopCustomer(WorkshopCustomer workshopCustomer) {
		this.workshopCustomer = workshopCustomer;
	}
}