package com.ankush.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


import com.ankush.model.UserAccount;

@Component
public class EmailUtil {
	
	
	
	@Autowired
	private JavaMailSender javaMailSender;

	
	  public boolean sendEmail(String to, String subject, String body) { try {
	  SimpleMailMessage msg = new SimpleMailMessage(); msg.setTo(to);
	  msg.setSubject(subject); msg.setText(body);
	  
	  javaMailSender.send(msg);
	  
	  return true; } catch (Exception e) { e.printStackTrace(); } return false; }
	 

public boolean sendUserAccUnloackEmail(UserAccount user) {
	
	boolean isSent =false;
	
	try {
		System.out.println("--------unloack method 2-------");

			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);

			helper.setTo(user.getUserEmail());
			helper.setSubject("Unloacked Account ");
			System.out.println("--------unloack method 3-------");
			helper.setText(getUnlockAccEmailBody(user), true);
			System.out.println("--------unloack method 4-------");
			javaMailSender.send(mimeMsg);
			System.out.println("--------unloack method 5-------");
			isSent =true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}

private String getUnlockAccEmailBody(UserAccount user) throws IOException {
	StringBuffer sb = new StringBuffer("");

	FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
	BufferedReader br = new BufferedReader(fr);
	String line = br.readLine();

	while (line != null) {
		sb.append(line);
		line = br.readLine();
	}
	
	br.close();

	// format mail body
	String mailBody = sb.toString();
	mailBody = mailBody.replace("{FNAME}", user.getFirstName());
	mailBody = mailBody.replace("{LNAME}", user.getLastName());
	mailBody = mailBody.replace("{TEMP-PWD}", user.getUserPazzword());
	mailBody = mailBody.replace("{EMAIL}", user.getUserEmail());

	return mailBody;
}




	
	

}
