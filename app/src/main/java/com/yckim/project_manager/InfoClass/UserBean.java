package com.yckim.project_manager.InfoClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBean {
	private int UserId;
	private String Email;
	private String PassWord;
	
	public int getUserId(){ return UserId;}
	public String getEmail(){ return Email;}
	public String getPassWord(){ return PassWord;}
	
	public void setUserId(int val){ UserId = val; }
	public void setEmail(String val){ Email = val; }
	public void setPassWord(String val){ PassWord = val;}
}
