<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问题资源管理</title>

<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加问题资源信息</div>
  <div class="container">	
	<s:form action="addResourceProcess" enctype="multipart/form-data" method="POST">
	<s:file label="文件名称" name="upload"></s:file>
	<s:if test="#session.TYPE != null">
	<s:select list="%{#session.TYPE}" label="类型" name="fileType"></s:select>
	</s:if>
	<s:else>
	<s:select label="类型" list="{}" name="fileType"></s:select>
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

