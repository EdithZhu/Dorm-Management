package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class AdminLogList extends ActionSupport {

	private List<LogBean> list;
	public List<LogBean> getList() {
		return list;
	}
	public void setList(List<LogBean> list) {
		this.list = list;
	}
	
	private String Building_ID;
	private String Domitory_ID;
	private String Student_Username;
	
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}
	public String getDomitory_ID() {
		return Domitory_ID;
	}
	public void setDomitory_ID(String domitoryID) {
		Domitory_ID = domitoryID;
	}
	public String getStudent_Username() {
		return Student_Username;
	}
	public void setStudent_Username(String studentUsername) {
		Student_Username = studentUsername;
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

		String strWhere="Student_State='moveIn'";
		if(!(isInvalid(Building_ID)))
		{
			strWhere+=" and Building_ID='"+Building_ID+"'";
		}
		if(!(isInvalid(Domitory_ID)))
		{
			strWhere+=" and Domitory_ID='"+Domitory_ID+"'";
		}
		if(!(isInvalid(Student_Username)))
		{
			strWhere+=" and Student_Username='"+Student_Username+"'";
		}

		list=new LogDao().GetList(strWhere,"Log_Date desc");
		
	
		return SUCCESS;
		
	}
	

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	
}
