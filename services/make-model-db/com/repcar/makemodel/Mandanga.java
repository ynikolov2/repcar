package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mandanga generated by hbm2java
 */
@Entity
@Table(name = "mandanga", catalog = "repcar")
public class Mandanga implements java.io.Serializable {

	private Long mandangaId;
	private String mandangaName;
	private String mandangaPassword;

	public Mandanga() {
	}

	public Mandanga(String mandangaName, String mandangaPassword) {
		this.mandangaName = mandangaName;
		this.mandangaPassword = mandangaPassword;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "mandanga_id", unique = true, nullable = false)
	public Long getMandangaId() {
		return this.mandangaId;
	}

	public void setMandangaId(Long mandangaId) {
		this.mandangaId = mandangaId;
	}

	@Column(name = "mandanga_name", length = 80)
	public String getMandangaName() {
		return this.mandangaName;
	}

	public void setMandangaName(String mandangaName) {
		this.mandangaName = mandangaName;
	}

	@Column(name = "mandanga_password", length = 80)
	public String getMandangaPassword() {
		return this.mandangaPassword;
	}

	public void setMandangaPassword(String mandangaPassword) {
		this.mandangaPassword = mandangaPassword;
	}

}