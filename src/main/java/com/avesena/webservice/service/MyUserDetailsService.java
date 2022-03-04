package com.avesena.webservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

//import com.avesena.webservice.models.MyUserDetails;
import com.avesena.webservice.models.UserLogin;
//import com.avesena.webservice.models.UserLoginDTO;
import com.avesena.webservice.repository.RoleDAO;
import com.avesena.webservice.repository.UserLoginDAO;


@Service
public class MyUserDetailsService  implements UserDetailsService{

	@Autowired
	UserLoginDAO userLoginDAO;
	
	@Autowired
	RoleDAO roleDAO;
	//UserLoginRepo userLoginRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserLogin userLogin = userLoginDAO.findUserAccount(userName);
		if (userLogin == null) {
			System.out.println(" User Not Found "+userName);
			throw new UsernameNotFoundException("User " +userName+ " not found");
		}
		
		List<String> roleNames = roleDAO.getRoleNames(userLogin.getUser_id());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		System.out.println(" Roles "+roleNames);
		if (roleNames != null) {
			for (String role:roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		System.out.println(" user "+userLogin.getUserName());
		System.out.println(" pass  "+userLogin.getPassword());
		System.out.println(" grant  "+grantList);

		UserDetails userDetails = (UserDetails)new User(userLogin.getUserName(), userLogin.getPassword(), grantList);
		
		return userDetails;
		/*Optional<UserLoginDTO> userLoginDTO = userLoginRepo.findByUserName(userName);
		
		userLoginDTO.orElseThrow(() -> new UsernameNotFoundException(userName + " Not found"));
		return userLoginDTO.map(MyUserDetails::new).get();
		*/
	}

}
