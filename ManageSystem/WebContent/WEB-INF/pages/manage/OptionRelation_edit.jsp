<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑选项关系信息</title>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">编辑选项关系信息</div>
  <div class="container">	
	<s:actionerror/>
	<s:actionmessage/>
	<s:form action="editOptionRelationProcess" method="post" namespace="/manage">
	<s:if test="null != #session.OPTIONTEMPLATEINFOLIST">
	<s:select list="%{#session.OPTIONTEMPLATEINFOLIST}" name="optionTemplateID" label="选项模板" listValue="title" listKey="optionTemplateID" value="%{#session.OPTIONRELATIONINFOEDIT.optionTemplateID}"></s:select>
	</s:if>
	<s:else>	
	<s:select name="optionTemplateID" label="选项模板" list="{}"></s:select>	
	</s:else>
	<s:textfield label="显示编号" name="showNum" size="20" value="%{#session.OPTIONRELATIONINFOEDIT.showNum}"></s:textfield>	
	<s:textfield label="选项名字" name="optionName" size="40" value="%{#session.OPTIONRELATIONINFOEDIT.optionName}"></s:textfield>	
	<s:if test="null != #session.ALTEROPTIOINFOLIST">
	<s:select list="%{#session.ALTEROPTIOINFOLIST}" name="alterID" label="选项提示" listValue="chinaOption" listKey="optionID"  value="%{#session.OPTIONRELATIONINFOEDIT.alterID}"></s:select>
	</s:if>
	<s:else>	
	<s:select name="alterID" label="选项提示" list="{}"></s:select>	
	</s:else>
	<s:if test="null != #session.VALUEOPTIOINFOLIST">
	<s:select list="%{#session.VALUEOPTIOINFOLIST}" name="optionID" label="选项值" listValue="chinaOption" listKey="optionID"  value="%{#session.OPTIONRELATIONINFOEDIT.optionID}"></s:select>
	</s:if>
	<s:else>	
	<s:select name="optionID" label="选项值" list="{}"></s:select>	
	</s:else>
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="编辑" theme="simple"/>&nbsp;
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

