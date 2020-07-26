package com.ankush.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ankush.entity.UserEntity;


@EnableJpaRepositories
@Repository
public interface UserManagmentRepo extends JpaRepository<UserEntity, Serializable> {
	
	//public UserEntity findByUserPassword(String tempPwd);
	
	public UserEntity findByUserPazzword(String tempPwd);
	
	public UserEntity findByUserEmail(String email);
	

}
