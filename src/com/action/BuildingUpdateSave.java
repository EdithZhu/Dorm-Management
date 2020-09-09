package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class BuildingUpdateSave extends ActionSupport {

	
	private String Building_ID ;
    private String Building_Name ;
    private String Building_Introduction ;
	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}

	public String getBuilding_Name() {
		return Building_Name;
	}

	public void setBuilding_Name(String buildingName) {
		Building_Name = buildingName;
	}

	public String getBuilding_Introduction() {
		return Building_Introduction;
	}

	public void setBuilding_Introduction(String buildingIntroduction) {
		Building_Introduction = buildingIntroduction;
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
		
		
		List<BuildingBean> list=new BuildingDao().GetList("Building_Name='"+Building_Name+"' and Building_ID!="+Building_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('Name already existed!');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//modify
		BuildingBean cnbean=new BuildingBean();
		cnbean=new BuildingDao().GetBean(Integer.parseInt(Building_ID));
		cnbean.setBuilding_Name(Building_Name);
		cnbean.setBuilding_Introduction(Building_Introduction);
		new BuildingDao().Update(cnbean); 
		//go to
		out.print("<script language='javascript'>alert('Info updated successfully!');window.location='BuildingManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	
}
