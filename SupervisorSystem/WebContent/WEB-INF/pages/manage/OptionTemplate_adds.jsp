<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加选项模板信息</title>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">添加选项模板信息</div>
  <div class="container">	
	<s:actionerror/>
	<s:actionmessage/>
	<s:form action="addOptionTemplateProcess" method="post" namespace="/manage">
	<s:textfield label="名称" name="title" size="40"></s:textfield>
	<s:textarea label="描述" name="description" cols="40" rows="8"></s:textarea>
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

