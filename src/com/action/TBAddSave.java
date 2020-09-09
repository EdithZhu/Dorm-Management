package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TBAddSave extends ActionSupport {


	private String TB_TeacherID ;
    private String TB_BuildingID ;
	public String getTB_TeacherID() {
		return TB_TeacherID;
	}

	public void setTB_TeacherID(String tBTeacherID) {
		TB_TeacherID = tBTeacherID;
	}

	public String getTB_BuildingID() {
		return TB_BuildingID;
	}

	public void setTB_BuildingID(String tBBuildingID) {
		TB_BuildingID = tBBuildingID;
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
		
		//check if exist
		List<TBBean> list=new TBDao().GetList("TB_TeacherID='"+TB_TeacherID+"' and TB_BuildingID="+TB_BuildingID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('Admin already managed the building!');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//add
		TBBean cnbean=new TBBean();
		cnbean.setTB_TeacherID(Integer.parseInt(TB_TeacherID));
		cnbean.setTB_BuildingID(Integer.parseInt(TB_BuildingID));

		new TBDao().Add(cnbean);
		    
		//go to
		out.print("<script language='javascript'>alert('Add successfully!');window.location='TBManager.action?Building_ID="+TB_BuildingID+"';</script>");
		out.flush();out.close();return null;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	
}
