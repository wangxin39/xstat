<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模版管理</title>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">修改模版信息</div>
  <div class="container">	
	<s:actionerror/>
	<s:form action="editTemplateReportProcess" enctype="multipart/form-data" method="post">
	<s:textfield label="模板名称" name="name" value="%{#session.TEMPLATEEDIT.name}"></s:textfield>
	<s:file label="文件名称" name="upload"></s:file>
	<s:if test="#session.TEMPLATETYPE != null">
	<s:select list="%{#session.TEMPLATETYPE}" name="fileType" label="文件类型" value="%{#session.TEMPLATEEDIT.fileType}"></s:select>
	</s:if>
	<s:else>	
	<s:select label="文件类型" list="{}" name="fileType"></s:select>
	</s:else>
	<s:textarea label="描述" name="description" value="%{#session.TEMPLATEEDIT.description}" cols="20" rows="8"></s:textarea>
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

