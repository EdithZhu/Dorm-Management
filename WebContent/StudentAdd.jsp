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
   if(isNull(form1.Student_Username.value)){  
   alert("Please enter username!"); 
   return false;
   }
   if(isNull(form1.Student_Password.value)){
   alert("Please enter password!");
   return false;
   }
   if(isNull(form1.Student_Password2.value)){
   alert("Please enter password again!");
   return false;
   }
   if (document.form1.Student_Password.value != document.form1.Student_Password2.value) { 
   alert("Your password is wrong, Please enter password again!"); 
   return false; 
   }  
   if(isNull(form1.Student_Name.value)){
   alert("Please enter your name!");
   return false;
   }
   if(isNull(form1.Student_Sex.value)){
   alert("Please enter your gender!");
   return false;
   }
   if(isNull(form1.Student_Class.value)){
   alert("Please enter your class!");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">Add Student</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="StudentAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Username: </td>
                    <td><input name="Student_Username" type="text" class="text2" id="Student_Username"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Password: </td>
                    <td><input name="Student_Password" type="password" class="text2" id="Student_Password"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Password again: </td>
                    <td><input name="Student_Password2" type="password" class="text2" id="Student_Password2"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Name: </td>
                    <td><input name="Student_Name" type="text" class="text2" id="Student_Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Gender: </td>
                    <td><select name="Student_Sex" id="Student_Sex">
                      <option value="">Please choose</option>
                      <option value="male">male</option>
                      <option value="female">female</option>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Class: </td>
                    <td><input name="Student_Class" type="text" class="text2" id="Student_Class"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="Add student">
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
