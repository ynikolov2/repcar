package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * OauthAccessToken generated by hbm2java
 */
@Entity
@Table(name = "oauth_access_token", catalog = "repcar", uniqueConstraints = @UniqueConstraint(columnNames = "authentication_id"))
public class OauthAccessToken implements java.io.Serializable {

	private String tokenId;
	private byte[] token;
	private String authenticationId;
	private String userName;
	private String clientId;
	private byte[] authentication;
	private String refreshToken;

	public OauthAccessToken() {
	}

	public OauthAccessToken(String tokenId, String clientId) {
		this.tokenId = tokenId;
		this.clientId = clientId;
	}

	public OauthAccessToken(String tokenId, byte[] token, String authenticationId, String userName, String clientId,
			byte[] authentication, String refreshToken) {
		this.tokenId = tokenId;
		this.token = token;
		this.authenticationId = authenticationId;
		this.userName = userName;
		this.clientId = clientId;
		this.authentication = authentication;
		this.refreshToken = refreshToken;
	}

	@Id

	@Column(name = "token_id", unique = true, nullable = false, length = 256)
	public String getTokenId() {
		return this.tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Column(name = "token")
	public byte[] getToken() {
		return this.token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	@Column(name = "authentication_id", unique = true, length = 256)
	public String getAuthenticationId() {
		return this.authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	@Column(name = "user_name", length = 256)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "client_id", nullable = false, length = 256)
	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Column(name = "authentication")
	public byte[] getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	@Column(name = "refresh_token", length = 256)
	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
