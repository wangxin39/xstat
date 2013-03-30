<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查对象管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">调查对象详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">对象编号:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.informantID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">客户名称：</td>
	<td align="left"><s:property value="%{#request.COMPANY}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">中文别名：</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.aliasName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">英文别名:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.englishAliasName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">中文名称：</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.name}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">英文名称:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.englishName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">国家:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.country}"/>&nbsp;</td>
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
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.telephone}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">手机号码:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.mobile}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">电子邮件:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.email}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">地址:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.address}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">邮编:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.postCode}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">服务时间:</td>
	<td align="left"><s:date format="yyyy-MM-dd" name="%{#request.INFORMANTDETAIL.serviceTime}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">服务语言:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.serviceLang}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">服务类型:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.serviceType}"/></td>
	</tr>
	<tr>
	<td align="left">片区:</td>
	<td align="left"><s:property value="%{#request.INFORMANTDETAIL.area}"/></td>
	</tr>
	<tr>
	<td align="left">状态:</td>
	<td width="250" align="left"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
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

