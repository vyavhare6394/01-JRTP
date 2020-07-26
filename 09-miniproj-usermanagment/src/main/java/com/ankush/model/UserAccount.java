package com.ankush.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserAccount {

	private Integer userId;
	private Integer cityId;
	private Integer countryId;
	private String dob;
	private String firstName;
	private String gender;
	private Integer stateId;
	private String userEmail;
	private Long mobileNumber;
	private String lastName;
	private String userPazzword;
	private String accountStatus;
	private Date createDate;
	private Date updateDate;

}
