package com.ankush.model;

import lombok.Data;

@Data
public class UnloackAccount {
	
	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;

}
