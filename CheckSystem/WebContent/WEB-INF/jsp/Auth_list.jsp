<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘顾客管理</title>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
	<div class="title font16h">我的认证信息</div>
    <div class="container">
<a href="addAuthInputs.do">上传认证信息</a><br/>

<table border="0">
<tr>
<td width="10">&nbsp;</td>
<td>顾客名称：</td>
<td width="250"><s:property value="%{#request.SMGKINFO.userName}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>身份证号码：</td>
<td width="250"><s:property value="%{#request.SMGKINFO.idNumber}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>文件名称:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.idFileName}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>文件类型:</td>
<td width="250"><s:property value="%{#request.TYPE}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>状态:</td>
<td width="250"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
</tr>
</table>
</div>
</div>

</body>
</html>

