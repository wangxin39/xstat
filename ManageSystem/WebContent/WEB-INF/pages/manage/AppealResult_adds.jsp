<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申诉管理</title>
<s:head theme="ajax"/></head>
<body>
<div class="cright">
  <div class="title font16h">回复申诉信息</div>
  <div class="container">	
	<s:form action="addAppealResultProcess">
	<s:select list="%{#session.REQLIST}" label="申诉名称" name="reqID" value="%{#session.REQINFO.reqID}" listValue="name" listKey="reqID"></s:select>
	<s:textfield label="回复标题" name="title" ></s:textfield>
	<s:textarea label="回复内容" name="content" cols="30" rows="8"></s:textarea>
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="回复" theme="simple"/>&nbsp;
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

