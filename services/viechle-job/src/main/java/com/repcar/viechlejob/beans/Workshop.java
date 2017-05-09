package com.repcar.viechlejob.beans;
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
	private String subscriptionType;
	private Date subscriptionEndDate;


	public Workshop() {
	}

	public Workshop(String workshopName, String subscriptionType, Date subscriptionEndDate) {
		this.workshopName = workshopName;
		this.subscriptionType = subscriptionType;
		this.subscriptionEndDate = subscriptionEndDate;
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

}