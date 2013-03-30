<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">文章信息</div>
  <div class="container">	
	<table border="0">
	<tr>
	<td >&nbsp;&nbsp;</td>
	<td align="center"><div class="title"><h3><s:property value="%{#request.ARTICLEINFO.title}"/></h3></div>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">&nbsp;&nbsp;</td>
	<td align="left"><s:property value="%{#request.ARTICLEINFO.content}"  escape="false"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">作者：</td>
	<td align="left"><s:property value="%{#request.ARTICLEINFO.author}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">信息来源：</td>
	<td align="left"><s:property value="%{#request.ARTICLEINFO.source}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">状态：</td>
	<td align="left"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">时间：</td>
	<td align="left"><s:date format="yyyy-MM-dd" name="%{#request.ARTICLEINFO.addTime}"/></td>
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

