<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮件内容管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">邮件详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">邮件编号:</td>
	<td align="left"><s:property value="%{#request.SENDDETAIL.sendID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">通讯录名称：</td>
	<td align="left"><s:property value="%{#request.ADDRESS}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">分类名称：</td>
	<td align="left"><s:property value="%{#request.CATALOG}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">发送地址:</td>
	<td align="left"><s:property value="%{#request.SENDDETAIL.sendTo}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">附件:</td>
	<td align="left"><s:property value="%{#request.SENDDETAIL.att}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">发送主题:</td>
	<td align="left"><s:property value="%{#request.SENDDETAIL.topic}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">发送内容:</td>
	<td align="left"><s:property value="%{#request.SENDDETAIL.content}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">员工名称:</td>
	<td align="left"><s:property value="%{#request.EMPLOYEE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">发送时间:</td>
	<td align="left"><s:date format="yyyy-MM-dd HH:mm:ss" name="%{#request.SENDDETAIL.sendTime}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">状态:</td>
	<td align="left"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
	</tr>
	<tr>
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


