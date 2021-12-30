package com.hardiksethi.contactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hardiksethi.contactmanager.dao.UserDao;
import com.hardiksethi.contactmanager.entities.User;

public class UserDetailsServiceIMPL implements UserDetailsService {

	public UserDetailsServiceIMPL() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private UserDao userdao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userdao.getUserByUserName(username);
		System.out.println(username);
		System.out.println(user);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomUserDetails(user);
	}

}
