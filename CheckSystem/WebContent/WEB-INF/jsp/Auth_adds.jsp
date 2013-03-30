<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘顾客管理</title>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
	<div class="title font16h">身份认证</div>
    <div class="container">
<s:form action="addAuthProcess" method="post" enctype="multipart/form-data">
<s:textfield label="身份证" name="idNumber"></s:textfield>
<s:file label="证件" name="upload"></s:file>
<tr>
<td>&nbsp;</td>
<td align="right"><s:submit value="增加" theme="simple"/>&nbsp;
<input type="button" value="返回" onClick="BackPage()">
<script type="text/javascript">
function BackPage() {
	history.back();
}
</script>
</td>
</tr>
</s:form>
</div>
</div>
</body>
</html>

