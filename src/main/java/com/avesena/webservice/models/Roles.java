package com.avesena.webservice.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Roles implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private Long id;

	@Column(name="role_name")
	private String roleName;
	/*
	@OneToMany(targetEntity = UserRoles.class, mappedBy = "roleId", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<UserRoles> userRoles;
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
/*
	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}
	*/

}
