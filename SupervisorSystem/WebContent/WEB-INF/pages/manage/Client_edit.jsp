<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">修改客户信息</div>
  <div class="container">	
	<s:actionerror/>
	<s:form action="editClientProcess" namespace="/manage" method="post">
	<s:textfield label="客户名称" name="company" value="%{#session.CLIENTINFOEDIT.company}"></s:textfield>
	<s:textfield label="客户英文名称" name="enCompany" value="%{#session.CLIENTINFOEDIT.enCompany}"></s:textfield>
	<s:textarea label="描述" name="description" value="%{#session.CLIENTINFOEDIT.description}" rows="8" cols="25"></s:textarea>
	<tr>
	<td>&nbsp;</td>
	<td align="right">
	<s:submit value="修改" theme="simple"></s:submit>&nbsp;
	<input type="button" value="返回" onClick="BackPage()"/>
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

