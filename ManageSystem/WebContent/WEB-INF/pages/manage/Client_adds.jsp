<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加客户</div>
  <div class="container">
	<s:form action="addClientProcess" namespace="/manage" method="post">
	<tr>
		<td>客户名称:</td>
		<td><s:textfield name="company" theme="simple"></s:textfield></td>
	</tr>	
	<tr>
		<td>客户英文名称:</td>
		<td><s:textfield name="enCompany" theme="simple"></s:textfield></td>
	</tr>	
	<tr>
		<td>描述:</td>
		<td><s:textarea name="description" rows="8" cols="25" theme="simple"></s:textarea></td>
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

