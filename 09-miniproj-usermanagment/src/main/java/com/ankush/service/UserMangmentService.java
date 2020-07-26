package com.ankush.service;

import java.util.Map;

import com.ankush.entity.UserEntity;
import com.ankush.model.UserAccount;

public interface UserMangmentService {
	
	public Map<Integer, String> getAllCountries();
	
	
	public Map<Integer, String> getStatesByCountryId(Integer countryId);
	

	public Map<Integer, String> getCitiesByStateId(Integer stateId);
	
	public boolean storeUsrDetail(UserAccount user) ;
	
	public UserAccount getUserAccountByPazzword(String tempPWD);
	
	public boolean updateUserAccount(UserAccount user);

	
	//public UserEntity getByUserEmail(String email);
	
	
	
}
