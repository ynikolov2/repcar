package com.repcar.workshop.beans;
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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WorkshopInvoiceDetails generated by hbm2java
 */
@Entity
@Table(name = "workshop_invoice_details", catalog = "repcar")
public class WorkshopInvoiceDetails extends ResourceSupport {

	private long invoiceId;
	private String companyName;
	private String identificationNumber;
	private String vatNumber;
	private String address;

	@JsonCreator
	public WorkshopInvoiceDetails() {
	}

	@JsonCreator
	public WorkshopInvoiceDetails(@JsonProperty("invoiceId") long invoiceId,
			@JsonProperty("companyName") String companyName,
			@JsonProperty("identificationNumber") String identificationNumber,
			@JsonProperty("vatNumber") String vatNumber, @JsonProperty("address") String address) {
		this.invoiceId = invoiceId;
		this.companyName = companyName;
		this.identificationNumber = identificationNumber;
		this.vatNumber = vatNumber;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "invoice_id", unique = true, nullable = false)
	public long getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "company_name", nullable = false)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "id_number", nullable = false)
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	@Column(name = "vat", nullable = false)
	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((identificationNumber == null) ? 0 : identificationNumber.hashCode());
		result = prime * result + (int) (invoiceId ^ (invoiceId >>> 32));
		result = prime * result + ((vatNumber == null) ? 0 : vatNumber.hashCode());
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
		WorkshopInvoiceDetails other = (WorkshopInvoiceDetails) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (identificationNumber == null) {
			if (other.identificationNumber != null)
				return false;
		} else if (!identificationNumber.equals(other.identificationNumber))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		if (vatNumber == null) {
			if (other.vatNumber != null)
				return false;
		} else if (!vatNumber.equals(other.vatNumber))
			return false;
		return true;
	}

}
