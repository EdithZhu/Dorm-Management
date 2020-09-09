package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TeacherUpdateSave extends ActionSupport {


	private String Teacher_ID ;
    private String Teacher_Username ;
    private String Teacher_Password ;
    private String Teacher_Name ;
    private String Teacher_Sex ;
    private String Teacher_Tel ;
	public String getTeacher_ID() {
		return Teacher_ID;
	}

	public void setTeacher_ID(String cookID) {
		Teacher_ID = cookID;
	}

	public String getTeacher_Username() {
		return Teacher_Username;
	}

	public void setTeacher_Username(String cookUsername) {
		Teacher_Username = cookUsername;
	}

	public String getTeacher_Password() {
		return Teacher_Password;
	}

	public void setTeacher_Password(String cookPassword) {
		Teacher_Password = cookPassword;
	}

	public String getTeacher_Name() {
		return Teacher_Name;
	}

	public void setTeacher_Name(String cookName) {
		Teacher_Name = cookName;
	}

	public String getTeacher_Sex() {
		return Teacher_Sex;
	}

	public void setTeacher_Sex(String cookSex) {
		Teacher_Sex = cookSex;
	}

	public String getTeacher_Tel() {
		return Teacher_Tel;
	}

	public void setTeacher_Tel(String cookTel) {
		Teacher_Tel = cookTel;
	}

	
	public String execute() throws Exception {
		
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
	
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('Please log in again!');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		List<TeacherBean> list=new TeacherDao().GetList("Teacher_Username='"+Teacher_Username+"' and Teacher_ID!="+Teacher_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('Username already existed!');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//modify
		TeacherBean cnbean=new TeacherBean();
		cnbean=new TeacherDao().GetBean(Integer.parseInt(Teacher_ID));
		cnbean.setTeacher_Username(Teacher_Username);
		cnbean.setTeacher_Name(Teacher_Name);
		cnbean.setTeacher_Sex(Teacher_Sex);
		cnbean.setTeacher_Tel(Teacher_Tel);
		if(!(isInvalid(Teacher_Password)))
		{
			cnbean.setTeacher_Password(Teacher_Password);
		}
		new TeacherDao().Update(cnbean);
		
		//go to
		out.print("<script language='javascript'>alert('Modified successfully!');window.location='TeacherManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	
}
