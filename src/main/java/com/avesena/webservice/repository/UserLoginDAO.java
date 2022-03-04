package com.avesena.webservice.repository;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avesena.webservice.models.UserLogin;

@Repository
@Transactional
public class UserLoginDAO {
	
	@Autowired
	EntityManager em;
	
	public UserLogin findUserAccount(String userName ) {
	
		try {
			String sql ="Select e from "+UserLogin.class.getName() + " e where e.userName = :userName";
			
			Query query = em.createQuery(sql, UserLogin.class);
			query.setParameter("userName", userName);
			
			return (UserLogin)query.getSingleResult();
		}
		catch (NoResultException nre) {
			return null;
		}
	}
	

}
