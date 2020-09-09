package com.action;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.dao.*;
import com.bean.*;

import com.opensymphony.xwork2.ActionSupport;

public class GoLogin extends ActionSupport {

	
	private String Type;
	private String Username;
	private String Password;
	private String Msg;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	
	public String execute() throws Exception {
		
		
		
		if(Type.equals("systemAdmin"))
		{
			if (null == new AdminDao().CheckLogin(Username, Password)) {
				Msg = "Username or password error!";
				return INPUT;
			}
			else
			{
				
				String Admin_ID=new AdminDao().CheckLogin(Username, Password);
				
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("id", Admin_ID);
				session.setAttribute("type", "1");
				return SUCCESS;
			}
		}
		else if(Type.equals("buildingAdmin"))
		{
			if (null == new TeacherDao().CheckLogin(Username, Password)) {
				Msg = "Username or password error!";
				return INPUT;
			}
			else
			{
				//get id 
				String Teacher_ID=new TeacherDao().CheckLogin(Username, Password);
				//create session
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("id", Teacher_ID);
				session.setAttribute("type", "2");
				
				return SUCCESS;
			}
		}
		else if(Type.equals("student"))
		{
			if (null == new StudentDao().CheckLogin(Username, Password)) {
				Msg = "Username or password error!";
				return INPUT;
			}
			else
			{
				
				String Student_ID=new StudentDao().CheckLogin(Username, Password);
				
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("id", Student_ID);
				session.setAttribute("type", "3");
				return SUCCESS;
			}
		}
		else
		{
			Msg = "ID type error!";
			return INPUT;
		}
		
	}
}
