<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部分问题管理</title>
<script type="text/javascript">
	var popQuestionWindow;
	function SelectWindowByQuestion()
	{
		if(!popQuestionWindow) {
			popQuestionWindow = window.open('<s:url value="listQuestionSelect.do" encode="false" includeParams="none"/>',"选择窗口","height=500,width=600,status=no,location=no,top=150,left=150,resizable=no");
		}		
	}
</script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">添加部分问题信息</div>
  <div class="container">	
	<form action="addPartQuestionProcess.do" method="post">
	<table border="0" width="100%">
	<tr>
	<td class="tdLabel"><label class="label">部分名称:</label></td>
	<td>
	<s:if test="null != #session.PARTSELECT">
		<s:property value="%{#session.PARTSELECT}"/>
	</s:if>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">问题:</label></td>
	<td>
	<select id="questionID" name="questionID">
	<option value="-1">请选择问题</option>
	</select>&nbsp;<input type="button" OnClick="SelectWindowByQuestion();" value="选择问题"></td>
	</tr>
	<s:if test="partQuestionID != null">
	<s:select list="%{#request.FATHERINFOMAP}" name="fatherID" listKey="key" listValue="value" headerKey="-1" label="上级部分问题"></s:select>
	</s:if>
	<s:if test="null != #session.VALIDATIONSELECT">
	</s:if>
	<s:select list="%{#session.VALIDATIONSELECT}" name="validation" label="是否需要验证"></s:select>
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
	</table>
	</form>
	</div>
</div>
</body>
</html>

