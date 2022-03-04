package com.avesena.webservice.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avesena.webservice.models.*;
//import com.avesena.webservice.models.UserLoginDTO;


//@Repository
public interface UserLoginRepo { //extends JpaRepository<UserLoginDTO, Integer>{
	
	String loginQuery = "select u.user_id, u.username,u.password, u.email, u.enabled, string_agg(r.role_name,"+" '" +",'" +" ) as rolenames "
						+ "from user_login u, user_roles ur, roles r "
						+ " where u.user_id = ur.user_id and r.role_id = ur.role_id and u.enabled = true and u.username= :userName " 
						+ " group by u.user_id, u.username, u.email, u.password, u.enabled";
	
	//@Query(nativeQuery=true, value= loginQuery)
	//Optional<UserLoginDTO> findByUserName(@Param("userName") String userName);

}
