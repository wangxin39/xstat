<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目信息</title>

<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
	<div class="title font16h">项目信息</div>
    <div class="container">
<table border="0">
<tr>
<td>客户名称</td>
<td>项目名称</td>
<td>调查对象</td>
<td>期次</td>
<td>调查问卷</td>
</tr>
<s:iterator value="%{pageList}" status="idx">
<tr>
<td>&nbsp;<s:property value="planHeaderList[#idx.index].company"/></td>
<td>&nbsp;<s:property value="planHeaderList[#idx.index].projectName"/></td>
<td>&nbsp;<s:property value="planHeaderList[#idx.index].informantName"/></td>
<td>&nbsp;<s:property value="planHeaderList[#idx.index].issue"/></td>
<td>&nbsp;<s:property value="planHeaderList[#idx.index].inquisition"/></td>
</tr>
</s:iterator>
</table>
</div>
</div>
</body>
</html>

