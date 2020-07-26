package com.ankush.util;




public class pwdUtils {
	
	public static  final String ALPHA_NUMERIC_STRING ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static final String generatedTempPwd(int count) {
		
		StringBuilder builder=new StringBuilder();
		
		
		while(count--!=0) {
			
			int character=(int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			
		}
		
		return builder.toString();
		
	}

}
