<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Campus Dormitory Management System</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Log_Date.value)){  
   alert("Please enter the absence date"); 
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">Campus Dormitory Management System</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">Student Absence Record</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="LogAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="30" colspan="2" align="center" style="color:red;">Please check info, you cannot modify later!</td>
                    </tr>
                  <tr>
                    <td width="33%" height="30" align="right">Student ID: </td>
                    <td width="67%"><s:property value='cnbean.Student_Username'/>
                      <label for="Log_StudentID"></label>
                      <input name="Log_StudentID" type="text" class="noshow" id="Log_StudentID" value="<s:property value='cnbean.Student_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">Name: </td>
                    <td><s:property value='cnbean.Student_Name'/></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">Gender: </td>
                    <td><s:property value='cnbean.Student_Sex'/></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">Class: </td>
                    <td><s:property value='cnbean.Student_Class'/></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">Room: </td>
                    <td><s:property value='cnbean.Domitory_Name'/></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Absence Date: </td>
                    <td><label for="Log_Date"></label>
                      <input type="text" name="Log_Date" id="Log_Date" class="Wdate" onClick="WdatePicker()"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">Absence Memo: </td>
                    <td><textarea name="Log_Remark" id="Log_Remark" cols="45" rows="5"></textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="Submit">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="Go Back" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
