package com.repcar.user.beans;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserSettings generated by hbm2java
 */
@Entity
@Table(name = "user_settings", catalog = "repcar")
public class UserSettings extends ResourceSupport {

	private long userSettingsId;
	private String avatar;
	private String theme;
	private String local;
	private String language;


	@JsonCreator
	public UserSettings() {
	}

	@JsonCreator
	public UserSettings(@JsonProperty("avatar") String avatar,
			@JsonProperty("theme") String theme, @JsonProperty("local") String local,
			@JsonProperty("language") String language) {
		this.setAvatar(avatar);
		this.setTheme(theme);
		this.setLocal(local);
		this.setLanguage(language);
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_settings_id", unique = true, nullable = false)
	public long getUserSettingsId() {
		return this.userSettingsId;
	}

	public void setUserSettingsId(long userSettingsId) {
		this.userSettingsId = userSettingsId;
	}

	@Column(name = "avatar", length = 45)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "theme", length = 45)
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Column(name = "local", length = 45)
	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Column(name = "language", length = 45)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		result = prime * result + (int) (userSettingsId ^ (userSettingsId >>> 32));
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
		UserSettings other = (UserSettings) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		if (userSettingsId != other.userSettingsId)
			return false;
		return true;
	}

}
