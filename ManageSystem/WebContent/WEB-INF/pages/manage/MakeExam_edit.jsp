<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查问卷管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">修改调查问卷信息</div>
  <div class="container">	
	<s:form action="editMakeExamProcess">
	<s:textfield label="标题" name="title" value="%{#session.INQUISITIONEDIT.title}"></s:textfield>
	<s:if test="null != #session.GLOBALCLIENTINFOLIST">
	<s:select label="客户名称" list="%{#session.GLOBALCLIENTINFOLIST}" name="clientID" listValue="company" value="%{#session.INQUISITIONEDIT.clientID}" listKey="clientID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="客户名称" list="{}" name="clientID"></s:select>
	</s:else>
	<s:if test="null != #session.TEMPLATELIST">
	<s:select label="模板名称" list="%{#session.TEMPLATELIST}" name="templateID" listValue="name" listKey="templateID" value="%{#session.INQUISITIONEDIT.templateID}" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="模板名称" list="{}" name="templateID"></s:select>
	</s:else>
	<tr>
	<td>&nbsp;</td>
	<td align="right">
	<s:submit value="修改" theme="simple"></s:submit>
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

