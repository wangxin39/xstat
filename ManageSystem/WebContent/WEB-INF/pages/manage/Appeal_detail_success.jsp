<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申诉管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">申诉详细信息</div>
  <div class="container">	
<table border="0" align="left" cellspacing="3" cellpadding="2">
<tr>
<td align="left">申诉编号：</td>
<td align="left"><s:property value="%{#request.REQDETAIL.reqID}"/></td>
</tr>
<tr>
<td align="left">申诉名称：</td>
<td align="left"><s:property value="%{#request.REQDETAIL.name}"/></td>
</tr>
<tr>
<td align="left">员工名称：</td>
<td align="left"><s:property value="%{#request.EMPLOYEE}"/></td>
</tr>
<tr>
<td align="left">用户名称：</td>
<td align="left"><s:property value="%{#request.ACCOUNT}"/></td>
</tr>
<tr>
<td align="left">电话号码：</td>
<td align="left"><s:property value="%{#request.REQDETAIL.telephone}"/></td>
</tr>
<tr>
<td align="left">电子邮件：</td>
<td align="left"><s:property value="%{#request.REQDETAIL.email}"/></td>
</tr>
<tr>
<td align="left">申诉描述：</td>
<td align="left"><s:property value="%{#request.REQDETAIL.description}"/></td>
</tr>
<tr>
<td align="left">申述时间：</td>
<td align="left"><s:date name="%{#request.REQDETAIL.reqTime}" format="yyyy-mm-dd"/></td>
</tr>
<tr>
<td align="left">申诉状态：</td>
<td align="left"><s:property value="%{#request.REQSTATUS}"/></td>
</tr>
<tr>
<td align="left">状态：</td>
<td align="left"><s:property value="%{#request.STATUS}"/></td>
</tr>
<tr>
<td>&nbsp;</td>
<td align="left">
<input type="button" value="关闭" onClick="ClosePage()"/>
<script type="text/javascript">
function ClosePage() {
	window.close();
}
</script>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>

