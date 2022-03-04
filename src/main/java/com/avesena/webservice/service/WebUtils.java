package com.avesena.webservice.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class WebUtils {

	public static String toString(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("UserName.").append(user.getUsername());
		
		Collection<GrantedAuthority> authorities = user.getAuthorities();
		if (authorities != null && !authorities.isEmpty()) {
			sb.append(" (");
			boolean first = true;
			for (GrantedAuthority a :authorities) {
				if (first) {
					sb.append(a.getAuthority());
				}
				else {
					sb.append(a.getAuthority());
				}
			}
			sb.append(")");
		}
		System.out.println(" authority "+sb.toString());
		return sb.toString();
	}
}
