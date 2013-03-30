<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计划管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">计划详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">计划编号:</td>
	<td align="left"><s:property value="%{#request.PLANDETAIL.planID}"/></td>
	</tr>
	<tr>
	<td align="left">计划名称:</td>
	<td align="left"><s:property value="%{#request.PLANDETAIL.name}"/></td>
	</tr>
	<tr>
	<td align="left">期次:</td>
	<td align="left"><s:property value="%{#request.ISSUE}"/></td>
	</tr>
	<tr>
	<td align="left">轮次:</td>
	<td align="left"><s:property value="%{#request.PLANDETAIL.round}"/></td>
	</tr>
	<tr>
	<td align="left">客户名称:</td>
	<td align="left"><s:property value="%{#request.CLIENT}"/></td>
	</tr>
	<tr>
	<td align="left">项目名称:</td>
	<td align="left"><s:property value="%{#request.PROJECT}"/></td>
	</tr>
	<tr>
	<td align="left">调查对象:</td>
	<td align="left"><s:property value="%{#request.INFORMANT}"/></td>
	</tr>
	<tr>
	<td align="left">顾客名称:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO}"/></td>
	</tr>
	<tr>
	<td align="left">任务编号:</td>
	<td align="left"><s:property value="%{#request.PLANDETAIL.jobID}"/></td>
	</tr>
	<tr>
	<td align="left">权重模式:</td>
	<td align="left"><s:property value="%{#request.WEIFHT}"/></td>
	</tr>
	<tr>
	<td align="left">开始日期:</td>
	<td align="left"><s:date name="%{#request.PLANDETAIL.startDay}" format="yyyy-MM-dd"/></td>
	</tr>
	<tr>
	<td align="left">结束日期:</td>
	<td align="left"><s:date name="%{#request.PLANDETAIL.endDay}" format="yyyy-MM-dd"/></td>
	</tr>
	<tr>
	<td align="left">开始时间:</td>
	<td align="left"><s:property value="%{#request.PLANDETAIL.startTime}"/></td>
	</tr>
	<tr>
	<td align="left">结束时间:</td>
	<td align="left"><s:property value="%{#request.PLANDETAIL.endTime}"/></td>
	</tr>
	<tr>
	<td align="left">检测状态:</td>
	<td align="left"><s:property value="%{#request.CHECKSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">统计状态:</td>
	<td align="left"><s:property value="%{#request.STATSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">评论状态:</td>
	<td align="left"><s:property value="%{#request.EVALUATIONSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">报告状态:</td>
	<td align="left"><s:property value="%{#request.REPORTSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">统计图状态:</td>
	<td align="left"><s:property value="%{#request.CHARTSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">状态:</td>
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

