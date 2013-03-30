<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评语管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">评语详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">评语编号：</td>
	<td align="left"><s:property value="%{#request.REMAEKETAIL.remarkID}"/></td>
	</tr>
	<tr>
	<td align="left">调查问卷：</td>
	<td align="left"><s:property value="%{#request.INQUISITION}"/></td>
	</tr>
	<tr>
	<td align="left">员工名称：</td>
	<td align="left"><s:property value="%{#request.EMPLOYEE}"/></td>
	</tr>
	<tr>
	<td align="left">期次</td>
	<td align="left"><s:property value="%{#request.ISSUE}"/></td>
	</tr>
	<tr>
	<td align="left">调查对象：</td>
	<td align="left"><s:property value="%{#request.INFORMANT}"/></td>
	</tr>
	<tr>
	<td align="left">客户名称：</td>
	<td align="left"><s:property value="%{#request.CLIENT}"/></td>
	</tr>
	<tr>
	<td align="left">项目名称：</td>
	<td align="left"><s:property value="%{#request.PROJECT}"/></td>
	</tr>
	<tr>
	<td align="left">部分名称：</td>
	<td align="left"><s:property value="%{#request.PARTSELECT}"/></td>
	</tr>
	<tr>
	<td align="left">优点：</td>
	<td align="left"><s:property value="%{#request.REMAEKETAIL.strengths}"/></td>
	</tr>
	<tr>
	<td align="left">英文优点：</td>
	<td align="left"><s:property value="%{#request.REMAEKETAIL.enStrengths}"/></td>
	</tr>
	<tr>
	<td align="left">缺点：</td>
	<td align="left"><s:property value="%{#request.REMAEKETAIL.weaknesses}"/></td>
	</tr>
	<tr>
	<td align="left">英文缺点：</td>
	<td align="left"><s:property value="%{#request.REMAEKETAIL.enWeaknesses}"/></td>
	</tr>
	<tr>
	<td align="left">总结及建议：</td>
	<td align="left"><s:property value="%{#request.REMAEKETAIL.conclusion}"/></td>
	</tr>
	<tr>
	<td align="left">英文总结建议：</td>
	<td align="left"><s:property value="%{#request.REMAEKETAIL.enConclusion}"/></td>
	</tr>
	<tr>
	<td align="left">添加时间：</td>
	<td align="left"><s:date name="%{#request.REMAEKETAIL.addTime}" format="yyyy-mm-dd"/></td>
	</tr>
	<tr>
	<td align="left">翻译状态：</td>
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

