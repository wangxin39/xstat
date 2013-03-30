<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类信息管理</title>

<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加分类信息信息</div>
  <div class="container">	
	<s:form action="addEmailCatalogProcess">
	<s:textfield label="分类名称" name="name"></s:textfield>
	<s:textfield label="国家" name="country"></s:textfield>
	<s:textfield label="语言" name="lang"></s:textfield>
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

