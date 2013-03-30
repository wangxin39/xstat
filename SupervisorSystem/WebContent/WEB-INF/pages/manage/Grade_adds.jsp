<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加评分信息</div>
  <div class="container">	
	<s:form action="addGradeProcess" validate="true" method="post">
	<s:if test="#session.CLIENTSELECT != null">
	<s:select label="客户名称" list="%{#session.CLIENTSELECT}" name="clientID" listValue="company" listKey="clientID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="客户名称" name="clientID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.INQUISITIONSELECT != null">
	<s:select label="调查问卷标题" list="%{#session.INQUISITIONSELECT}" name="inquisitionID" listValue="title" listKey="inquisitionID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查问卷标题" name="inquisitionID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.INFORMANTSELECT != null">
	<s:select label="被调查对象名称" list="%{#session.INFORMANTSELECT}" name="informantID" listValue="name" listKey="informantID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="被调查对象名称" name="informantID" list="{}"></s:select>	
	</s:else>
	<s:textfield label="年度" name="annual"></s:textfield>
	<s:if test="#session.QUARTER != null">
	<s:select label="季度" list="%{#session.QUARTER}" name="quarter"></s:select>
	</s:if>
	<s:else>
	<s:select label="季度" name="quarter" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.INQUISITIONTYPE != null">
	<s:select list="%{#session.INQUISITIONTYPE}" label="问卷类型" name="inquisitionType"></s:select>
	</s:if>
	<s:else>
	<s:select label="问卷类型" name="inquisitionType" list="{}"></s:select>	
	</s:else>
	<s:select list="{1,2}" label="第几轮检测" name="round"></s:select>
	<s:textfield label="可能总计分数" name="possbileTotalMarks"></s:textfield>
	<s:textfield label="实际总计分数" name="actualTotalMarks"></s:textfield>
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

