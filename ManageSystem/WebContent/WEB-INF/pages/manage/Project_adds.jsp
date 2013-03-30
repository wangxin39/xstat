<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘顾客项目管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加项目信息</div>
  <div class="container">	
	<s:form action="addProjectProcess" namespace="/manage" method="post">
	<s:actionerror/>
<s:actionmessage/>
	<s:if test="#session.GLOBALCLIENTINFOLIST != null">
	<s:select list="%{#session.GLOBALCLIENTINFOLIST}" name="clientID" label="客户名称" listValue="company" listKey="clientID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select list="%{}" name="clientID" label="客户名称"></s:select>
	</s:else>
	<s:textfield name="name"  label="名称"></s:textfield>
	<s:textfield name="englishName"  label="英文名称"></s:textfield>
	<s:textarea name="description" label="描述" rows="10" cols="30"></s:textarea>
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

