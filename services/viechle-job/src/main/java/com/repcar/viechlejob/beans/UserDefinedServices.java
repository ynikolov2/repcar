package com.repcar.viechlejob.beans;
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

/**
 * UserDefinedServices generated by hbm2java
 */
@Entity
@Table(name = "user_defined_services", catalog = "repcar")
public class UserDefinedServices implements java.io.Serializable {

	private Integer udServiceId;
	private ServiceCategories serviceCategories;
	private String udServiceName;
	private int workshopServiceId;

	public UserDefinedServices() {
	}

	public UserDefinedServices(ServiceCategories serviceCategories, String udServiceName, int workshopServiceId) {
		this.serviceCategories = serviceCategories;
		this.udServiceName = udServiceName;
		this.workshopServiceId = workshopServiceId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ud_service_id", unique = true, nullable = false)
	public Integer getUdServiceId() {
		return this.udServiceId;
	}

	public void setUdServiceId(Integer udServiceId) {
		this.udServiceId = udServiceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_category_id", nullable = false)
	public ServiceCategories getServiceCategories() {
		return this.serviceCategories;
	}

	public void setServiceCategories(ServiceCategories serviceCategories) {
		this.serviceCategories = serviceCategories;
	}

	@Column(name = "ud_service_name", nullable = false, length = 45)
	public String getUdServiceName() {
		return this.udServiceName;
	}

	public void setUdServiceName(String udServiceName) {
		this.udServiceName = udServiceName;
	}

	@Column(name = "workshop_service_id", nullable = false)
	public int getWorkshopServiceId() {
		return this.workshopServiceId;
	}

	public void setWorkshopServiceId(int workshopServiceId) {
		this.workshopServiceId = workshopServiceId;
	}

}
