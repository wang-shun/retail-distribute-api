package cn.wonhigh.retail.scheduler.distribute.mail.impl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{

	private String username;
	private String password;
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		
		return new PasswordAuthentication(username, password);
	}
	
	public MyAuthenticator(String username,String password){
		this.username = username;
		this.password = password;
	}

}
