<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">模板详细信息</div>
  <div class="container">	
<table border="0" align="left" cellspacing="3" cellpadding="2">
<tr>
<td align="left">模板编号:</td>
<td align="left"><s:property value="%{#request.TEMPLATE.templateID}"/>&nbsp;</td>
</tr>
<tr>
<td align="left">模板名称：</td>
<td align="left"><s:property value="%{#request.TEMPLATE.name}"/>&nbsp;</td>
</tr>
<tr>
<td align="left">文件类型:</td>
<td align="left"><s:property value="%{#request.TEMPLATETYPE}"/>&nbsp;</td>
</tr>
<tr>
<td align="left">模板描述:</td>
<td align="left"><s:property value="%{#request.TEMPLATE.description}"/>&nbsp;</td>
</tr>
<tr>
<td align="left">文件名称:</td>
<td align="left"><s:property value="%{#request.TEMPLATE.fileName}"/>&nbsp;</td>
</tr>
<tr>
<td align="left">存储路径:</td>
<td align="left"><s:property value="%{#request.TEMPLATE.savePath}"/>&nbsp;</td>
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

