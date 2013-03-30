<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模版管理</title>

<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">修改模版信息</div>
  <div class="container">	
	<div align="right"><a href="../help/Template.html">帮助</a></div>
	<s:form action="editReportTemplateProcess" enctype="multipart/form-data"  method="POST">
	<s:textfield label="名称" name="name" value="%{sesstion.TEMPLATEEDIT.name}"></s:textfield>
	<s:if test="#session.TYPE !=null">
	<s:select list="%{#session.TYPE}" name="type" label="类型" value="%{sesstion.TEMPLATEEDIT.type}"></s:select>
	</s:if>
	<s:else>
	<s:select list="%{}" name="type" label="类型"></s:select>
	</s:else>
	<s:file label="文件名称" name="upload" value="%{sesstion.TEMPLATEEDIT.upload}"></s:file>
	<s:textfield label="存储路径" name="path" value="%{sesstion.TEMPLATEEDIT.path}"></s:textfield>
	<s:textarea label="描述" name="description" value="%{sesstion.TEMPLATEEDIT.description}" cols="25" rows="8"></s:textarea>
	
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

