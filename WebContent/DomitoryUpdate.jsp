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
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Domitory_BuildingID.value)){  
   alert("Please choose a building!"); 
   return false;
   }
   if(isNull(form1.Domitory_Name.value)){
   alert("Please enter room number!");
   return false;
   }
   if(isNull(form1.Domitory_Type.value)){
   alert("Please enter room type!");
   return false;
   }
   if(isNull(form1.Domitory_Number.value)){
   alert("Please enter amount of beds!");
   return false;
   }
   if(isNull(form1.Domitory_Tel.value)){
   alert("Please enter phone number!");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">Modify Room</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="DomitoryUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Domitory_ID" type="text" class="noshow" id="Domitory_ID" value="<s:property value='cnbean.Domitory_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Building: </td>
                    <td><select name="Domitory_BuildingID" id="Domitory_BuildingID">
                      <option value="">Please choose</option>
                      <s:iterator id="aa" value="list">
                        <option value="${Building_ID}" <s:if test="cnbean.Domitory_BuildingID==Building_ID">selected</s:if>>${Building_Name}</option>
                      </s:iterator>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Room Number: </td>
                    <td><input name="Domitory_Name" type="text" class="text2" id="Domitory_Name" value="<s:property value='cnbean.Domitory_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Room Type: </td>
                    <td><input name="Domitory_Type" type="text" class="text2" id="Domitory_Type" value="<s:property value='cnbean.Domitory_Type'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Amount of beds: </td>
                    <td><input name="Domitory_Number" type="text" class="text2" id="Domitory_Number" value="<s:property value='cnbean.Domitory_Number'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Phone Number: </td>
                    <td><input name="Domitory_Tel" type="text" class="text2" id="Domitory_Tel" value="<s:property value='cnbean.Domitory_Tel'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="Modify Room">
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
