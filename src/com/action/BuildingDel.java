package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class BuildingDel extends ActionSupport {

	
	private String Building_ID ;
	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String userID) {
		Building_ID = userID;
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
		
		
		//delete
		new BuildingDao().Delete("Building_ID="+Building_ID);
		    
		return SUCCESS;
		
	}
	
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
