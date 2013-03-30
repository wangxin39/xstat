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
	<div class="title font16h">详细信息</div>
    <div class="container">
<table border="0">
<tr>
<td width="10">&nbsp;</td>
<td>所属行业:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.vocation}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>职位名称:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.job}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>公司名称:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.company}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>教育程度:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.edu}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>兴趣爱好:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.interest}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>设备名称:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.device}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>是否具备:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.possession}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>开户行:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.bank}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>户名:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.bankUserName}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>银行帐号:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.bankID}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>注册时间:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.regTime}"/>&nbsp;</td>
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

