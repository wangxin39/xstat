<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>草稿箱管理</title>

<script type="text/javascript" src="<s:url value='/fckeditor/fckeditor.js' encode='false' includeParams='none'/>"></script>

<script type="text/javascript">
function check(frm)
{
	if(frm.sendTo.value == '')
	{
		frm.sendTo.focus();
		alert("发送到不能为空!");
		return false;	
	}
	if(frm.content.value == '')
	{
		frm.content.focus();
		alert("内容不能为空!");
		return false;	
	}
	return true;
}
</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加草稿信息</div>
  <div class="container">	
	<s:form action="addDraftProcess" onsubmit="return check(this)">
	<s:actionerror/>
<s:actionmessage/>
	<s:textfield label="发送主题" name="topic"></s:textfield>
	<s:file label="附件" name="att"></s:file>
	<s:textfield label="发送到" name="sendTo"></s:textfield>
	<s:if test="#session.EMPLOYEESELECT != null">
	<s:select label="员工名称" list="%{#session.EMPLOYEESELECT}" name="employeeID" listValue="realName" listKey="employeeID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="员工名称" name="employeeID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.EMAILSELEST != null">
	<s:select label="通讯录名" list="%{#session.EMAILSELEST}" name="addressID" listValue="firstName" listKey="addressID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="通讯录名" name="addressID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.CATALOGSELECT != null">
	<s:select label="分类名称" list="%{#session.CATALOGSELECT}" name="acID" listValue="name" listKey="acID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="分类名称" name="acID" list="{}"></s:select>	
	</s:else>
	<tr>
	<td>内容：</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td colspan="2">
	${sessionScope.typeError}
	<script type="text/javascript">
	<!--
	var sBasePath = "<s:url value='/fckeditor/' encode='false' includeParams='none'/>";
	var oFCKeditor = new FCKeditor( "content" );
	oFCKeditor.BasePath	= sBasePath;
	oFCKeditor.ToolbarSet ="Smgk";
	oFCKeditor.Width	= "580";
	oFCKeditor.Height	= 600;
	oFCKeditor.Value	= '';
	oFCKeditor.Create();
	//-->
	</script>
		</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="增加" theme="simple"/>&nbsp;
	<input type="button" value="返回" onClick="BackPage()">
	<script type="text/javascript">
	function BackPage() {
		history.back();
	}
	</script>
	</td>
	</tr>
	</s:form>
	</div>
</div>
</body>
</html>

