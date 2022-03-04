package com.avesena.webservice.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="user_login")
public class UserLogin implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="created_on")
	private Timestamp createdOn;
	
	@Column(name="last_login")
	private Timestamp lastLogin;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Override
	public String toString( ) {
		return "User = " +userName;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
/*	
	@OneToMany(targetEntity = UserRoles.class, mappedBy = "uid", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<UserRoles> userRoles;
	*/
	

}
