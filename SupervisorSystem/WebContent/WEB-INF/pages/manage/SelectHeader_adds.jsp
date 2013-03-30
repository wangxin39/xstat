<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表头选项管理</title>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">添加表头选项信息</div>
  <div class="container">	
	<s:form action="addSelectHeaderProcess">
	<s:if test="#session.SELECTLIST != null">
	<s:select label="选项信息" name=alterID" list="%{#session.ALTERLIST}" listValue="chinaOption" listKey="optionID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="选项信息" name="alterID" list="{}"></s:select>	
	</s:else>
	<s:textfield label="显示顺序" name="showOrder"></s:textfield>
	<s:textfield label="显示编号" name="showNum"></s:textfield>
	<s:if test="null != #session.SELECTLIST">
	<s:select name="optionID" label="选项值" list="%{#session.OPTIONLIST}" listValue="chinaOption" listKey="optionID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select name="optionID" label="选项值" list="%{}"></s:select>
	</s:else>
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

