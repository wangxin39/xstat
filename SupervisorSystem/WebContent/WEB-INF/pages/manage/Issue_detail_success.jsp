<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>期次管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">期次详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">期次编号:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFODETAIL.issueID}"/></td>
	</tr>
	<tr>
	<td align="left">期次:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFODETAIL.issue}"/></td>
	</tr>
	<tr>
	<td align="left">客户名称:</td>
	<td align="left"><s:property value="%{#request.COMPANY}"/></td>
	</tr>
	<tr>
	<td align="left">项目名称:</td>
	<td align="left"><s:property value="%{#request.PROJECTNAME}"/></td>
	</tr>
	<tr>
	<td align="left">调查问卷:</td>
	<td align="left"><s:property value="%{#request.TITLE}"/></td>
	</tr>

	<tr>
	<td align="left">开始日期:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFODETAIL.startDay}"/></td>
	</tr>
	<tr>
	<td align="left">结束日期:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFODETAIL.endDay}"/></td>
	</tr>
	<tr>
	<td align="left">开始时间:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFODETAIL.startTime}"/></td>
	</tr>
	<tr>
	<td align="left">结束时间:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFODETAIL.endTime}"/></td>
	</tr>
	<tr>
	<td align="left">检测时间:</td>
	<td align="left"><s:date name="%{#request.ISSUEINFODETAIL.checkTime}" format="yyyy-MM-dd"/></td>
	</tr>
	<tr>
	<td align="left">检测年度:</td>
	<td align="left"><s:property value="%{#request.ISSUEINFODETAIL.year}"/></td>
	</tr>
	<tr>
	<td align="left">比较类型:</td>
	<td align="left"><s:property value="%{#request.ISFRIST}"/></td>
	</tr>
	<tr>
	<td align="left">期次执行动作:</td>
	<td align="left"><s:property value="%{#request.ACTIONS}"/></td>
	</tr>
	<tr>
	<td align="left">统计图状态:</td>
	<td align="left"><s:property value="%{#request.CSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">统计状态:</td>
	<td align="left"><s:property value="%{#request.STATSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">评论状态:</td>
	<td align="left"><s:property value="%{#request.ESTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">报告状态:</td>
	<td align="left"><s:property value="%{#request.RSTATUS}"/></td>
	</tr>
	<tr>
	<td align="left">状态:</td>
	<td align="left"><s:property value="%{#request.STATUS}"/></td>
	</tr>
	<tr>
	<td align="left">添加时间:</td>
	<td align="left"><s:date name="%{#request.ISSUEINFODETAIL.addTime}" format="yyyy-MM-dd"/></td>
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

