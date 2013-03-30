<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查问卷问题管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">问题详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">问题编号：</td>
	<td align="left"><s:property value="#request.QUESTIONINFO.questionID"/></td>
	</tr>
	<tr>
	<td align="left">中文问题：</td>
	<td align="left"><s:property value="#request.QUESTIONINFO.question"/></td>
	</tr>
	<tr>
	<td align="left">英文问题：</td>
	<td align="left"><s:property value="#request.QUESTIONINFO.englishQuestion"/></td>
	</tr>
	<tr>
	<td align="left">中文说明：</td>
	<td align="left"><s:property value="#request.QUESTIONINFO.zhExplain"/></td>
	</tr>
	<tr>
	<td align="left">英文说明：</td>
	<td align="left"><s:property value="#request.QUESTIONINFO.englishExplain"/></td>
	</tr>
	<tr>
	<td align="left">问题类型：</td>
	<td align="left"><s:property value="#request.QUESTIONTYPE"/></td>
	</tr>
	<tr>
	<td align="left">字段类型：</td>
	<td align="left"><s:property value="#request.FIELDTYPE"/></td>
	</tr>
	<tr>
	<td align="left">答案格式：</td>
	<td align="left"><s:property value="#request.QUESTIONINFO.format"/></td>
	</tr>
	<tr>
	<td align="left">字段值：</td>
	<td align="left"><s:property value="#request.QUESTIONINFO.fieldValue"/></td>
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

