package com.ankush.controller;

import java.util.Map;


import org.apache.tomcat.jni.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ankush.entity.UserEntity;
import com.ankush.model.UnloackAccount;
import com.ankush.model.UserAccount;
import com.ankush.service.UserMangmentService;

@Controller
public class UserController {

	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserMangmentService userService;

	
	
	
    
	
	  @GetMapping(value= {"/","/loadForm"}) 
	  public String loadForm(Model model){
	 
		  logger.info("************method loaded from getCountries***********");
		 
		  
		  UserEntity user = new UserEntity( );
		  
		  model.addAttribute("userAcc",user);
		 try { 
		  
			 logger.debug("*****countries*******");
	  Map<Integer, String> cmap = userService.getAllCountries( );
	  model.addAttribute("countriesMap", cmap); 

		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
	
	  
	  logger.info("**********Method  Ended  from getCountries***");
	  
	  return "addUser"; 
	  
	
	  
	  }
	  
	  @RequestMapping("/getStates")
	  
	  @ResponseBody public Map<Integer, String>
	  getStatesByCountryId(@RequestParam("cid") Integer countryId) 
	  { 

		  logger.info("************method loaded from getStates***********");
		  
			 logger.debug("*****states*******");
		  return  userService.getStatesByCountryId(countryId);
		  

	  
	  }
	  
	  @RequestMapping("/getCities")
	  
	  @ResponseBody public Map<Integer, String>
	  getCitiesByStateId(@RequestParam("sid") Integer stateId)
	  { 

		  logger.info("************method loaded from getCities***********");
		  
			 logger.debug("*****cities*******");
		  return  userService.getCitiesByStateId(stateId);
	  
	  
	  }
	  
	  
	  @PostMapping("/userAccReg") public String regUser( @ModelAttribute("userAcc")
	  UserAccount user,Model theModel) {
	  
			 logger.info("*****save user details*******");
 	  
	  userService.storeUsrDetail(user);
	  
	  
	  return "userAccReg"; }
	  
	  
	  
	  @GetMapping("/unlockAcc")
	  
	  public String unloackAccount( @RequestParam("email") String email,Model theModel) {
			 logger.info("*****Unloack user email*******");
		  theModel.addAttribute("email",email);
		  
		  UnloackAccount unloack=new UnloackAccount();
		  
		  unloack.setEmail(email);
		  
		 theModel.addAttribute("unloack", unloack);
		 
		 
		  
		  
		  return"unloack-acc";
		  
	  }
	  
	  
	  
	  
	  
	  @PostMapping("/unlockUserAcc")
		public String unlockUserAcc(@ModelAttribute("unloack") UnloackAccount acc, Model model) {
			
		  
		UserAccount usrAcc = userService.getUserAccountByPazzword(acc.getTempPwd());
		
		
		if(usrAcc!=null)
		{
			usrAcc.setAccountStatus("UN-LOCKED");
			usrAcc.setUserPazzword(acc.getNewPwd());
			
			
			boolean isUpdate = userService.updateUserAccount(usrAcc);
			
			if(isUpdate) {
				
				return "unlockAccountSuccess";
			}
			
			
		}
		  model.addAttribute("errMsg", "please enter correct temperory password...!");

			return "unloack-acc";
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
	  
	 	 
}
