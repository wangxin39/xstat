<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分标准管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">编辑评分标准</div>
  <div class="container">	
	<s:form id="form" action="editGradeStdProcess" validate="true" namespace="/manage" method="post">
	<s:if test="#session.GLOBALINQUISITIONINFOLIST != null">
	<s:select label="调查问卷标题" list="%{#session.GLOBALINQUISITIONINFOLIST}" name="inquisitionID" listValue="title" listKey="inquisitionID" headerKey="-1" value="%{#session.EDITGRADESTDINFO.inquisitionID}"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查问卷标题" name="inquisitionID" list="{}"></s:select>	
	</s:else>
	<s:textfield label="标题" name="title" value="%{#session.EDITGRADESTDINFO.title}"></s:textfield>
	<s:textarea label="描述" name="description" rows="8" cols="60" value="%{#session.EDITGRADESTDINFO.descrption}"></s:textarea>
	<tr>
	<td>&nbsp;</td>
	<td align="right">&nbsp;<s:submit value="提交" theme="simple"/>
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

