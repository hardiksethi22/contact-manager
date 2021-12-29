package com.hardiksethi.contactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardiksethi.contactmanager.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
