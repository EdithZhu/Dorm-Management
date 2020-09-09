package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DomitoryAddSave extends ActionSupport {

	
	private String Domitory_BuildingID ;
    private String Domitory_Name ;
    private String Domitory_Type ;
    private String Domitory_Number ;
    private String Domitory_Tel ;


	public String getDomitory_BuildingID() {
		return Domitory_BuildingID;
	}

	public void setDomitory_BuildingID(String domitoryBuildingID) {
		Domitory_BuildingID = domitoryBuildingID;
	}

	public String getDomitory_Name() {
		return Domitory_Name;
	}

	public void setDomitory_Name(String domitoryName) {
		Domitory_Name = domitoryName;
	}

	public String getDomitory_Type() {
		return Domitory_Type;
	}

	public void setDomitory_Type(String domitoryType) {
		Domitory_Type = domitoryType;
	}

	public String getDomitory_Number() {
		return Domitory_Number;
	}

	public void setDomitory_Number(String domitoryNumber) {
		Domitory_Number = domitoryNumber;
	}

	public String getDomitory_Tel() {
		return Domitory_Tel;
	}

	public void setDomitory_Tel(String domitoryTel) {
		Domitory_Tel = domitoryTel;
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
		
		
		List<DomitoryBean> list=new DomitoryDao().GetList("Domitory_Name='"+Domitory_Name+"' and Domitory_BuildingID="+Domitory_BuildingID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('RoomNo already existed in the building!');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		DomitoryBean cnbean=new DomitoryBean();
		cnbean.setDomitory_BuildingID(Integer.parseInt(Domitory_BuildingID));
		cnbean.setDomitory_Name(Domitory_Name);
		cnbean.setDomitory_Type(Domitory_Type);
		cnbean.setDomitory_Number(Domitory_Number);
		cnbean.setDomitory_Tel(Domitory_Tel);
		new DomitoryDao().Add(cnbean);
		
		//add    
		out.print("<script language='javascript'>alert('Added successfully!');window.location='DomitoryManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	

	public static void main(String[] args) {
		System.out.println();
	}
	
}
