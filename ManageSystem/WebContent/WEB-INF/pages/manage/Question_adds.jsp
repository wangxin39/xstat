<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查问卷问题管理</title>

<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加问题信息</div>
  <div class="container">	
	<s:form action="addQuestionProcess" onsubmit="return check(this)">
	<s:textarea label="中文题目" name="question" cols="30" rows="8"></s:textarea>
	<s:textarea label="英文题目" name="englishQuestion" cols="30" rows="8"></s:textarea>
	<s:textarea label="中文说明" name="zhExplain" cols="30" rows="8"></s:textarea>
	<s:textarea label="英文说明" name="englishExplain" cols="30" rows="8"></s:textarea>
	<s:if test="null != #session.QUESTIONTYPE">
	<s:select label="问题类型" name="questionType" list="%{#session.QUESTIONTYPE}"></s:select>
	</s:if>
	<s:else>
	<s:select label="问题类型" list="{}" name="questionType"></s:select>
	</s:else>
	<s:if test="null != #session.FIELDTYPE">
	<s:select label="字段类型" name="fieldType" list="%{#session.FIELDTYPE}"></s:select>
	</s:if>
	<s:else>
	<s:select label="字段类型" list="{}" name="fieldType"></s:select>
	</s:else>
	<s:textfield label="答案格式" name="format" size="25"></s:textfield>
	<s:textfield label="字段值" name="fieldValue" size="25"></s:textfield>
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

