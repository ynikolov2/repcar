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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cars generated by hbm2java
 */
@Entity
@Table(name = "cars", catalog = "repcar")
public class Cars implements java.io.Serializable {

	private Integer carD;
	private Workshop workshop;
	private String vin;
	private String model;
	private int modelYear;
	private String make;
	private String plateNumber;
	private Integer initialMileage;
	private Integer currentMileage;
	private String modelCode;
	private String modelSerial;
	private String bodyType;
	private String transmissionType;
	private String color;
	private String driveType;
	private String fuelType;
	private Date registeredAt;
	private Date lastInDate;
	private Date nextServiceDate;
	private String notes;

	public Cars() {
	}

	public Cars(Workshop workshop, String vin, String model, int modelYear,
			String make, String plateNumber, Date registeredAt) {
		this.workshop = workshop;
		this.vin = vin;
		this.model = model;
		this.modelYear = modelYear;
		this.make = make;
		this.plateNumber = plateNumber;
		this.registeredAt = registeredAt;
	}

	public Cars(Workshop workshop, String vin, String model, int modelYear,
			String make, String plateNumber, Integer initialMileage, Integer currentMileage, String modelCode,
			String modelSerial, String bodyType, String transmissionType, String color, String driveType,
			String fuelType, Date registeredAt, Date lastInDate, Date nextServiceDate, String notes) {
		this.workshop = workshop;
		this.vin = vin;
		this.model = model;
		this.modelYear = modelYear;
		this.make = make;
		this.plateNumber = plateNumber;
		this.initialMileage = initialMileage;
		this.currentMileage = currentMileage;
		this.modelCode = modelCode;
		this.modelSerial = modelSerial;
		this.bodyType = bodyType;
		this.transmissionType = transmissionType;
		this.color = color;
		this.driveType = driveType;
		this.fuelType = fuelType;
		this.registeredAt = registeredAt;
		this.lastInDate = lastInDate;
		this.nextServiceDate = nextServiceDate;
		this.notes = notes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "car_d", unique = true, nullable = false)
	public Integer getCarD() {
		return this.carD;
	}

	public void setCarD(Integer carD) {
		this.carD = carD;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workshop_id", nullable = false)
	public Workshop getWorkshop() {
		return this.workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	@Column(name = "vin", nullable = false, length = 18)
	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Column(name = "model", nullable = false, length = 50)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "model_year", nullable = false)
	public int getModelYear() {
		return this.modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	@Column(name = "make", nullable = false, length = 50)
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "plate_number", nullable = false, length = 20)
	public String getPlateNumber() {
		return this.plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Column(name = "initial_mileage")
	public Integer getInitialMileage() {
		return this.initialMileage;
	}

	public void setInitialMileage(Integer initialMileage) {
		this.initialMileage = initialMileage;
	}

	@Column(name = "current_mileage")
	public Integer getCurrentMileage() {
		return this.currentMileage;
	}

	public void setCurrentMileage(Integer currentMileage) {
		this.currentMileage = currentMileage;
	}

	@Column(name = "model_code", length = 20)
	public String getModelCode() {
		return this.modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	@Column(name = "model_serial", length = 45)
	public String getModelSerial() {
		return this.modelSerial;
	}

	public void setModelSerial(String modelSerial) {
		this.modelSerial = modelSerial;
	}

	@Column(name = "body_type", length = 45)
	public String getBodyType() {
		return this.bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	@Column(name = "transmission_type", length = 45)
	public String getTransmissionType() {
		return this.transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	@Column(name = "color", length = 45)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "drive_type", length = 45)
	public String getDriveType() {
		return this.driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	@Column(name = "fuel_type", length = 45)
	public String getFuelType() {
		return this.fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registered_at", nullable = false, length = 19)
	public Date getRegisteredAt() {
		return this.registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_in_date", length = 19)
	public Date getLastInDate() {
		return this.lastInDate;
	}

	public void setLastInDate(Date lastInDate) {
		this.lastInDate = lastInDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "next_service_date", length = 19)
	public Date getNextServiceDate() {
		return this.nextServiceDate;
	}

	public void setNextServiceDate(Date nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}

	@Column(name = "notes", length = 200)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
