<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报告管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">报告详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">报告编号:</td>
	<td align="left"><s:property value="%{#request.REPORTINFO.reportID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">检测名称：</td>
	<td align="left"><s:property value="%{#request.REPORTINFO.checkName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">报告中文名称:</td>
	<td align="left"><s:property value="%{#request.REPORTINFO.reportTitle}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">报告英文名称:</td>
	<td align="left"><s:property value="%{#request.REPORTINFO.enReportTitle}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">报告类型:</td>
	<td align="left"><s:property value="%{#request.REPORTTYPE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">季度标题:</td>
	<td align="left"><s:property value="%{#request.REPORTINFO.quarterTitle}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">报告页数：</td>
	<td align="left"><s:property value="%{#request.REPORTINFO.pageCount}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">主题名称:</td>
	<td align="left"><s:property value="%{#request.THEME}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">期次:</td>
	<td align="left"><s:property value="%{#request.ISSUE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">调查对象:</td>
	<td align="left"><s:property value="%{#request.INFORMANT}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">添加时间:</td>
	<td align="left"><s:date format="yyyy-MM-dd" name="%{#request.REPORTINFO.addTime}"/></td>
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

