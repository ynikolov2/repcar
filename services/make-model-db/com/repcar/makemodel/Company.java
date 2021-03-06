package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name = "company", catalog = "repcar")
public class Company implements java.io.Serializable {

	private Integer companyId;
	private String companyName;
	private String companyAddress;
	private Date creationDate;

	public Company() {
	}

	public Company(String companyName, String companyAddress, Date creationDate) {
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.creationDate = creationDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "company_id", unique = true, nullable = false)
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "company_name", nullable = false, length = 45)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "company_address", nullable = false)
	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, length = 19)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
