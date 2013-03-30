<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
</head>

<body>
<div class="cright">
  <div class="title font16h">员工详细信息</div>
  <div class="container">	
	<table border="0">
	<tr>
	<td align="left">员工编号:</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.employeeID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">姓名：</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.name}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">性别：</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.sex}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">部门:</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.depart}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">职位:</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.job}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">岗位描述:</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.description}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">登陆名称:</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.loginName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">登陆密码:</td>
	<td align="left"><s:property value="%{#request.EMPLOYEEETAIL.passWord}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">增加时间:</td>
	<td align="left"><s:date format="yyyy-MM-dd" name="%{#request.EMPLOYEEETAIL.addTime}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">状态:</td>
	<td align="left"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
	</tr>
	</table>
	</div>
</div>
</body>
</html>



