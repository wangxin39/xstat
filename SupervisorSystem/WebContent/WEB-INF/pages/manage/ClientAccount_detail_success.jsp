<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户账户管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/css.css' encode='false' includeParams='none'/>" media="all"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">账户详细信息</div>
  <div class="container">	
	<table border="0">
	<tr>
	<td align="left">帐户编号:</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.accountID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">调查对象：</td>
	<td align="left"><s:property value="%{#request.INFORMANT}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">客户名称：</td>
	<td align="left"><s:property value="%{#request.COMPANY}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">用户名称：</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.clientName}"/>&nbsp;</td>
	</tr>
	<tr>
	<tr>
	<td align="left">登录名称：</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.loginName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">密码:</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.passWord}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">国家:</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.country}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">所在省份:</td>
	<td align="left"><s:property value="%{#request.PROVINCE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">城市名称:</td>
	<td align="left"><s:property value="%{#request.CITY}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">电话号码:</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.telephone}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">手机号码:</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.mobile}"/>&nbsp;</td>
	</tr>
	
	<tr>
	<td align="left">最后登陆时间:</td>
	<td align="left"><s:date format="yyyy-MM-dd HH:mm:ss" name="%{#request.ACCOUNTINFO.lastLogin}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">最后登陆IP:</td>
	<td align="left"><s:property value="%{#request.ACCOUNTINFO.lastIP}"/>&nbsp;</td>
	</tr>
	
	<tr>
	<td align="left">上级账户:</td>
	<td width="250" align="left"><s:property value="%{#request.ACCOUNTINFO.fatherID}"/>&nbsp;</td>
	</tr>
	
	<tr>
	<td align="left">状态:</td>
	<td width="250" align="left"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td align="left">
	<input type="button" value="关闭" onClick="ClosePage()">
	<script type="text/javascript">
	function ClosePage() {
		windown.close();
	}
	</script>
	</td>
	</tr>
	</table>
	</div>
</div>
</body>
</html>



