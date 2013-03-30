<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查问卷部分管理</title>
<s:head theme="ajax"/></head>
<body>

<div class="cright">
  <div class="title font16h">修改问卷部分信息</div>
  <div class="container">	
	<s:form action="editMakePartProcess" method="post" namespace="/manage">
	<s:if test="null != #session.GLOBALINQUISITIONINFOLIST">
	<s:select label="调查问卷" list="%{#session.GLOBALINQUISITIONINFOLIST}" name="inquisitionID" listValue="title" value="%{#session.EDITPARTINTO.InquisitionID}" listKey="inquisitionID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查问卷" list="{}" name="inquisitionID"></s:select>
	</s:else>
	<s:textfield label="部分名称" name="name" value="%{#session.EDITPARTINTO.name}"></s:textfield>
	<s:textfield label="部分英文名称" name="englishName" value="%{#session.EDITPARTINTO.englishName}"></s:textfield>
	<s:textfield label="显示顺序" name="showOrder" value="%{#session.EDITPARTINTO.showOrder}"></s:textfield>
	<s:textfield label="显示编号" name="showNum" value="%{#session.EDITPARTINTO.showNum}"></s:textfield>
	<tr>
	<td>&nbsp;</td>
	<td align="right">
	<s:submit value="修改" theme="simple"></s:submit>&nbsp;
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

