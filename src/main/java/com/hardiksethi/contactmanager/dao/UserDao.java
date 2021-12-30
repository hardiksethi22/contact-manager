package com.hardiksethi.contactmanager.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hardiksethi.contactmanager.entities.User;

public interface UserDao extends CrudRepository<User, Integer>{
	
	@Query("select u from User u where u.user_email =:email")
	public User getUserByUserName(@Param("email") String email);
}
