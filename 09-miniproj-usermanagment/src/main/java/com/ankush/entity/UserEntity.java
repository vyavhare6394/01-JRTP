package com.ankush.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="user_accounts")
@Data
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="date_of_birth")
	private String dob;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="state_id")
	private Integer stateId;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_mobile")
	private Long mobileNumber;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="user_pwd")
	private String userPazzword;
	
	@Column(name="acc_status")
	private String accountStatus;
	
	
	
	@CreationTimestamp()
	@Temporal(TemporalType.DATE)
	@Column(name="created_date",updatable = false)
	private Date createDate;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="updated_date",insertable = false)
	private Date updateDate;
	
	/*
	 * public UserEntity(String email,String password) {
	 * 
	 * this.userEmail=email; this.userPazzword=password; }
	 * 
	 * public UserEntity() {
	 * 
	 * }
	 */

}
