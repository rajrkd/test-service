package com.avesena.webservice.models;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails {//implements UserDetails{
	
//	private Long uid;
	private String userName;
	private String password;
	private String email;
	private boolean enabled;
	//private List<GrantedAuthority> authorities;
/*	
	public MyUserDetails() {
	}
	
	public MyUserDetails(UserLoginDTO userLogin) {
		super();
//		this.uid = userLogin.getUserid();
		this.userName = userLogin.getUserName();
		this.password = userLogin.getPassword();
		this.email = userLogin.getEmail();;
		this.enabled = userLogin.isEnabled();
		this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(userLogin.getRoleNames());
				
	}
	
//	public Long getUid() {
//		return uid;
//	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
*/
}
