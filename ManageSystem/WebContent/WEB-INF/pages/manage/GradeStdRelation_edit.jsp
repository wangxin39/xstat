<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分标准关系管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">编辑评分标准关系</div>
  <div class="container">	
	<s:form action="editGradeStdRelationProcess" method="post">
	<s:if test="#session.GLOBALGRADESTDINFOLIST != null">
	<s:select label="评分标准" list="%{#session.GLOBALGRADESTDINFOLIST}" name="gradeStdID" listValue="title" listKey="gradeStdID" headerKey="-1" value="%{#session.EDITGRADESTDRELATIONINFO.gradeStdID}"></s:select>
	</s:if>
	<s:else>
	<s:select label="评分标准" name="gradeStdID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.GLOBALSELECTWEIGHTINFOLIST != null">
	<s:select label="权重" list="%{#session.GLOBALSELECTWEIGHTINFOLIST}" name="selectWeightID" listValue="weight" listKey="selectWeightID" headerKey="-1" value="%{#session.EDITGRADESTDRELATIONINFO.selectWeightID}"></s:select>
	</s:if>
	<s:else>
	<s:select label="权重" name="selectWeightID" list="{}"></s:select>	
	</s:else>
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="提交" theme="simple"/>&nbsp;
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

