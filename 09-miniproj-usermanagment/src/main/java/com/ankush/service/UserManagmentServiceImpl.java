package com.ankush.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankush.constants.AppConstants;
import com.ankush.entity.CityEntity;
import com.ankush.entity.CountryEntity;
import com.ankush.entity.StateEntity;
import com.ankush.entity.UserEntity;
import com.ankush.exception.UserNotFoundException;
import com.ankush.model.UnloackAccount;
import com.ankush.model.UserAccount;
import com.ankush.repository.CityRepository;
import com.ankush.repository.CountryRepo;
import com.ankush.repository.StateRepository;
import com.ankush.repository.UserManagmentRepo;
import com.ankush.util.EmailUtil;
import com.ankush.util.pwdUtils;

@Service
public class UserManagmentServiceImpl implements UserMangmentService {

	@Autowired
	private UserManagmentRepo uRepo;

	@Autowired
	private CountryRepo cmRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository citymRepo;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Map<Integer, String> getAllCountries() {

		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		List<CountryEntity> countriesList = cmRepo.findAll();
		countriesList.forEach(countryEntity -> {
			map.put(countryEntity.getId(), countryEntity.getCountryName());
		});

		return map;
	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {

		Map<Integer, String> statesMap = new LinkedHashMap();
		List<StateEntity> states = stateRepo.findAllByCountryId(countryId);

		states.forEach(state -> {
			statesMap.put(state.getId(), state.getStateName());
		});

		return statesMap;
	}

	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {

		Map<Integer, String> citiesMap = new LinkedHashMap();

		List<CityEntity> entitiesList = citymRepo.findAllByStateId(stateId);

		entitiesList.forEach(entity -> {
			citiesMap.put(entity.getId(), entity.getCityName());
		});

		return citiesMap;

	}

	@Override
	public boolean storeUsrDetail(UserAccount user) {

		user.setUserPazzword(pwdUtils.generatedTempPwd(AppConstants.Temp_Pwd_length));

		user.setAccountStatus(AppConstants.Locked_str);

		UserEntity entity = new UserEntity();

		BeanUtils.copyProperties(user, entity);

		UserEntity saveEntity = uRepo.save(entity);

		if (saveEntity.getUserId() != null) {

			return emailUtil.sendUserAccUnloackEmail(user);

		}

		return false;
	}

	@Override
	public UserAccount getUserAccountByPazzword(String tempPWD) {

		UserEntity entity = uRepo.findByUserPazzword(tempPWD);

		UserAccount account = null;

		if (entity != null) {

			account = new UserAccount();

			BeanUtils.copyProperties(entity, account);
		}

		return account;

	}

	@Override
	public boolean updateUserAccount(UserAccount user) {

		UserEntity entity = new UserEntity();

		BeanUtils.copyProperties(user, entity);

		UserEntity userEntity = uRepo.save(entity);

		if (userEntity != null) {
			return true;
		}

		return false;

	}

	/*
	 * @Override public UserEntity getByUserEmail(String email) {
	 * 
	 * 
	 * UserEntity user = uRepo.findByUserEmail(email);
	 * 
	 * if(user==null) { throw new UserNotFoundException("Invalid User Name");
	 * 
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * return new UserEntity(user.getUserEmail(),user.getUserPazzword());
	 * 
	 * 
	 * }
	 * 
	 * }
	 */
	
	
	


}
