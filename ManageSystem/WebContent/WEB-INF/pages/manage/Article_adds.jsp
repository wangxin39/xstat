<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文章管理</title>
<link href="<s:url value='/css/sample.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value='/fckeditor/fckeditor.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加文章信息</div>
  <div class="container">	
	<s:form name="form1" action="addArticleProcess" method="post">
	<tr>
	<td class="tdLabel"><label class="label">标题:</label>
	</td>
	<td><s:textfield label="标题" name="title" theme="simple"></s:textfield></td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">作者:</label>
	</td>
	<td><s:textfield label="作者" name="author" theme="simple"></s:textfield></td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">信息来源:</label>
	</td>
	<td><s:textfield label="信息来源" name="source" theme="simple"></s:textfield></td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">内容:</label></td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td colspan="2">
	<textarea name="content" cols="58" rows="15"></textarea>
	<script type="text/javascript">
	<!--
	var sBasePath = "<s:url value='/fckeditor/' encode='false' includeParams='none'/>";
	var oFCKeditor = new FCKeditor( 'content' );
	oFCKeditor.BasePath	= sBasePath;
	oFCKeditor.ToolbarSet ="Smgk";
	oFCKeditor.Width	= 580;
	oFCKeditor.Height	= 600;
	oFCKeditor.Value	= '请输入文章内容';
	oFCKeditor.ReplaceTextarea();
	//-->
	</script>
		</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
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

