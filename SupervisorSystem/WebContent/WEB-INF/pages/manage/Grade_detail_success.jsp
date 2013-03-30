<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">评分详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">评分编号:</td>
	<td align="left"><s:property value="%{#request.STATDETAIL.statID}"/></td>
	</tr>
	<tr>
	<td align="left">客户名称:</td>
	<td align="left"><s:property value="%{#request.CLIENTINFO}"/></td>
	</tr>
	<tr>
	<td align="left">项目名称:</td>
	<td align="left"><s:property value="%{#request.PROJECTINFO}"/></td>
	</tr>
	<tr>
	<td align="left">期次:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFO}"/></td>
	</tr>
	<tr>
	<td align="left">轮次:</td>
	<td align="left"><s:property value="%{#request.ROUND}"/></td>
	</tr>
	<tr>
	<td align="left">顾客名称:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO}"/></td>
	</tr>
	<tr>
	<td align="left">调查对象:</td>
	<td align="left"><s:property value="%{#request.INFORMANT}"/></td>
	</tr>
	<tr>
	<td align="left">调查问卷：</td>
	<td align="left"><s:property value="%{#request.INQUISITION}"/></td>
	</tr>
	<tr>
	<td align="left">计划名称：</td>
	<td align="left"><s:property value="%{#request.PLANINFO}"/></td>
	</tr>
	<tr>
	<td align="left">部分名称:</td>
	<td align="left"><s:property value="%{#request.PARTSELECT}"/></td>
	</tr>
	<tr>
	<td align="left">部分问题名称:</td>
	<td align="left"><s:property value="%{#request.PARTQUESTION}"/></td>
	</tr>
	<tr>
	<td align="left">选项信息:</td>
	<td align="left"><s:property value="%{#request.QUESTIONSELECTINFO}"/></td>
	</tr>
	<tr>
	<td align="left">权重:</td>
	<td align="left"><s:property value="%{#request.STATDETAIL.weight}"/></td>
	</tr>
	<tr>
	<td align="left">实际分数:</td>
	<td align="left"><s:property value="%{#request.STATDETAIL.marks}"/></td>
	</tr>
	<tr>
	<td align="left">年:</td>
	<td align="left"><s:property value="%{#request.STATDETAIL.year}"/></td>
	</tr>
	<tr>
	<td align="left">月:</td>
	<td align="left"><s:property value="%{#request.STATDETAIL.month}"/></td>
	</tr>
	<tr>
	<td align="left">日:</td>
	<td align="left"><s:property value="%{#request.STATDETAIL.day}"/></td>
	</tr>
	<tr>
	<td align="left">检测时间:</td>
	<td align="left"><s:date name="%{#request.STATDETAIL.checkTime}" format="yyyy-MM-dd"/></td>
	</tr>
	<tr>
	<td align="left">状态:</td>
	<td align="left"><s:property value="%{#request.STATUS}"/></td>
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

