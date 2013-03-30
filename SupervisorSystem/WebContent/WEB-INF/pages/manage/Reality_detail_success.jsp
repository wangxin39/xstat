<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分析管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">分析详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">分析编号：</td>
	<td align="left"><s:property value="%{#request.REALITYDETAIL.realityCheckID}"/></td>
	</tr>
	<tr>
	<td align="left">调查问卷：</td>
	<td align="left"><s:property value="%{#request.INQUISITION}"/></td>
	</tr>
	<tr>
	<td align="left">当前提示语：</td>
	<td align="left"><s:property value="%{#request.REALITYDETAIL.thisTime}"/></td>
	</tr>
	<tr>
	<td align="left">英文当前提示语：</td>
	<td align="left"><s:property value="%{#request.REALITYDETAIL.enThisTime}"/></td>
	</tr>
	<tr>
	<td align="left">最近提示语：</td>
	<td align="left"><s:property value="%{#request.REALITYDETAIL.soFarTime}"/></td>
	</tr>
	<tr>
	<td align="left">英文最近提示语：</td>
	<td align="left"><s:property value="%{#request.REALITYDETAIL.enSoFarTime}"/></td>
	</tr>
	<tr>
	<td align="left">得分评语：</td>
	<td align="left"><s:property value="%{#request.REALITYDETAIL.markReal}"/></td>
	</tr>
	<tr>
	<td align="left">英文得分评语：</td>
	<td align="left"><s:property value="%{#request.REALITYDETAIL.enMarkReal}"/></td>
	</tr>
	<tr>
	<td align="left">添加时间：</td>
	<td align="left"><s:date name="%{#request.REALITYDETAIL.addTime}" format="yyyy-mm-dd"/></td>
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

