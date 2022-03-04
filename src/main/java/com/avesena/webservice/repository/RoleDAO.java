package com.avesena.webservice.repository;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avesena.webservice.models.*;

@Repository
@Transactional
public class RoleDAO {

	@Autowired
	EntityManager em;
	
	public List<String> getRoleNames(Long userId ) {
	
		try {
			String sql ="Select ur.roles.roleName from "+UserRoles.class.getName() + " ur "
					+" where ur.userLogin.user_id = :userId";
			
			Query query = em.createQuery(sql, String.class);
			query.setParameter("userId", userId);
			
			return query.getResultList();
		}
		catch (NoResultException nre) {
			return null;
		}
	}
	

}
