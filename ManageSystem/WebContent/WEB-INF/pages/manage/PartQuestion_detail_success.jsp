<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部分问题管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">部分问题详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">问题编号:</td>
	<td align="left"><s:property value="%{#request.DETAILPARTQUESTIONINFO.partQuestionID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">调查问卷：</td>
	<td align="left"><s:property value="%{#request.INQUISITIONSELECT}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">部分名称:</td>
	<td align="left"><s:property value="%{#request.PARTSELECT}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">问题信息:</td>
	<td align="left"><s:property value="%{#request.QUESTIONSELEST}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">问题类型:</td>
	<td align="left"><s:property value="%{#request.TYPESELEST}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">显示编号:</td>
	<td align="left"><s:property value="%{#request.DETAILPARTQUESTIONINFO.showNum}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">字段名称:</td>
	<td align="left"><s:property value="%{#request.DETAILPARTQUESTIONINFO.fieldName}"/>&nbsp;</td>
	</tr>
	<s:if test="null != #request.FATHERNAME">
	<tr>
	<td align="left">上级部分问题:</td>
	<td align="left"><s:property value="%{#request.FATHERNAME}"/>&nbsp;</td>
	</tr>
	</s:if>
	<tr>
	<td align="left">表单验证:</td>
	<td align="left"><s:property value="%{#request.VALIDATIONSELECT}"/>&nbsp;</td>
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

