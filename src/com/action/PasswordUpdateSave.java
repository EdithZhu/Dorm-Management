package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class PasswordUpdateSave extends ActionSupport {

	
	private String Password;
	private String Password2;
	private String Msg;
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPassword2() {
		return Password2;
	}

	public void setPassword2(String password2) {
		Password2 = password2;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
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
		String type=session.getAttribute("type").toString();
		if(type.equals("1"))//system admin
		{
			
			if (new AdminDao().CheckPassword(session.getAttribute("id").toString(), Password)) {
				
				AdminBean cnbean=new AdminBean();
				cnbean=new AdminDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				cnbean.setAdmin_Password(Password2);
				new AdminDao().Update(cnbean);
				out.print("<script language='javascript'>alert('Modified successfully!');window.location='PasswordUpdate.jsp';</script>");
				out.flush();out.close();return null;
			}
			else
			{
				Msg = "Username or password error!";
				return INPUT;
			}
		}
		else if(type.equals("2"))//building admin
		{
			//check if the original password is correct
			if (new TeacherDao().CheckPassword(session.getAttribute("id").toString(), Password)) {
				//change password
				TeacherBean cnbean=new TeacherBean();
				cnbean=new TeacherDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				cnbean.setTeacher_Password(Password2);
				new TeacherDao().Update(cnbean);
				out.print("<script language='javascript'>alert('Modified successfully!');window.location='PasswordUpdate.jsp';</script>");
				out.flush();out.close();return null;
			}
			else
			{
				Msg = "Username or password error!";
				return INPUT;
			}
		}
		else if(type.equals("3"))//student
		{
			
			if (new StudentDao().CheckPassword(session.getAttribute("id").toString(), Password)) {
				
				StudentBean cnbean=new StudentBean();
				cnbean=new StudentDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				cnbean.setStudent_Password(Password2);
				new StudentDao().Update(cnbean);
				out.print("<script language='javascript'>alert('Modified successfully!');window.location='PasswordUpdate.jsp';</script>");
				out.flush();out.close();return null;
			}
			else
			{
				Msg = "Username or password error!";
				return INPUT;
			}
		}
		else
		{
			out.print("<script language='javascript'>alert('Please log in again!');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		

	}
	

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	
}
