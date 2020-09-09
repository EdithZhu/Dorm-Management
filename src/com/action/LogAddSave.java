package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class LogAddSave extends ActionSupport {

	
	private String Log_Date ;
    private String Log_Remark ;

	public String getLog_Date() {
		return Log_Date;
	}

	public void setLog_Date(String logDate) {
		Log_Date = logDate;
	}

	public String getLog_Remark() {
		return Log_Remark;
	}

	public void setLog_Remark(String logRemark) {
		Log_Remark = logRemark;
	}

	private String Log_StudentID;
	public String getLog_StudentID() {
		return Log_StudentID;
	}

	public void setLog_StudentID(String logStudentID) {
		Log_StudentID = logStudentID;
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
		
		
		LogBean cnbean=new LogBean();
		cnbean.setLog_StudentID(Integer.parseInt(Log_StudentID));
		cnbean.setLog_TeacherID(Integer.parseInt(session.getAttribute("id").toString()));
		cnbean.setLog_Date(Log_Date);
		cnbean.setLog_Remark(Log_Remark);

		new LogDao().Add(cnbean);
		    
		//go to
		out.print("<script language='javascript'>alert('Absence registed successfully!');window.location='Index.jsp';</script>");
		out.flush();out.close();return null;
		
	}
	
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	
}
