package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vehicles generated by hbm2java
 */
@Entity
@Table(name = "vehicles", catalog = "repcar")
public class Vehicles implements java.io.Serializable {

	private Integer vehicleId;
	private int year;
	private String make;
	private String model;

	public Vehicles() {
	}

	public Vehicles(int year, String model) {
		this.year = year;
		this.model = model;
	}

	public Vehicles(int year, String make, String model) {
		this.year = year;
		this.make = make;
		this.model = model;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "vehicle_id", unique = true, nullable = false)
	public Integer getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "year", nullable = false)
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "make", length = 50)
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "model", nullable = false, length = 50)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
