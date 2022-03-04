package com.avesena.webservice.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="user_roles")
public class UserRoles implements Serializable{
    @Id
	@Column(name = "user_id")
	private Long uid;
	
    @Id
	@Column(name = "role_id")
	private Long roleId;
	
	
	@Column(name = "grant_date")
	private Timestamp grantDate;
	
	@ManyToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private UserLogin userLogin;
	
	@ManyToOne
	@JoinColumn(name="role_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Roles roles;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Timestamp getGrantDate() {
		return grantDate;
	}

	public void setGrantDate(Timestamp grantDate) {
		this.grantDate = grantDate;
	}

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
}
