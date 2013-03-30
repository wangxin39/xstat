<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分关系管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加评分关系</div>
  <div class="container">	
	<s:form action="addGradeRelationProcess" method="post">
	<s:if test="#session.GLOBALCLIENTINFOLIST != null">
	<s:select list="%{#session.GLOBALCLIENTINFOLIST}" label="客户名称" name="clientID" listValue="company" listKey="clientID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" label="客户名称" name="clientID"></s:select>
	</s:else>
	<s:if test="#session.GLOBALISSUEINFOLIST != null">
	<s:select label="期次" list="%{#session.GLOBALISSUEINFOLIST}" name="issueID" listValue="issue" listKey="issueID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="期次" name="inquisitionID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.GLOBALINFORMANTINFOLIST != null">
	<s:select label="调查对象" list="%{#session.GLOBALINFORMANTINFOLIST}" name="informantID" listValue="name" listKey="informantID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查对象" name="informantID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.GLOBALGRADESTDINFOLIST != null">
	<s:select label="评分标准" list="%{#session.GLOBALGRADESTDINFOLIST}" name="gradeStdID" listValue="title" listKey="gradeStdID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="评分标准" name="gradeStdID" list="{}"></s:select>	
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

