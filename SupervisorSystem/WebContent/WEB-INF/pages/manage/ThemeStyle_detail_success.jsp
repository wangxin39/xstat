<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题风格管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">主题风格详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">风格编号:</td>
	<td align="left"><s:property value="%{#request.STYLEDETAIL.styleID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">主题名称：</td>
	<td align="left"><s:property value="%{#request.THEME}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">模板名称:</td>
	<td align="left"><s:property value="%{#request.TEMPLATE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">标题:</td>
	<td align="left"><s:property value="%{#request.STYLEDETAIL.title}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">内容:</td>
	<td align="left"><s:property value="%{#request.STYLEDETAIL.content}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">图片名称:</td>
	<td align="left"><s:property value="%{#request.STYLEDETAIL.imageName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">存储路径:</td>
	<td align="left"><s:property value="%{#request.STYLEDETAIL.savePath}"/>&nbsp;</td>
	</tr>
	
	<tr>
	<td align="left">统计类型:</td>
	<td align="left"><s:property value="%{#request.STATTYPE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">统计图名称:</td>
	<td align="left"><s:property value="%{#request.STYLEDETAIL.statChart}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">背景启用:</td>
	<td align="left"><s:property value="%{#request.BACK}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">状态:</td>
	<td align="left"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">页号:</td>
	<td align="left"><s:property value="%{#request.STYLEDETAIL.pageNum}"/>&nbsp;</td>
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

