<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题管理</title>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">修改主题信息</div>
  <div class="container">	
	<s:form action="editThemeProcess">
	<s:textfield label="主题名称" name="title" value="%{#session.THEMEEDIT.title}"></s:textfield>
	<s:textarea label="描述" name="description" cols="25" rows="8" value="%{#session.THEMEEDIT.description}"></s:textarea>
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

