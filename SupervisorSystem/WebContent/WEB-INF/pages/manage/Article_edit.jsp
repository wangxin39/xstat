<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>

<script type="text/javascript" src="<s:url value='/fckeditor/fckeditor.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/></head>
<body>

<div class="cright">
  <div class="title font16h">修改文章信息</div>
  <div class="container">	
	<s:form action="editArticleProcess" enctype="multipart/form-data" onsubmit="return check(this)" method="POST">
	<tr>
	<td class="tdLabel"><label class="label">标题:</label>
	</td>
	<td><s:textfield label="标题" name="title" value="%{#session.ARTICLEEDIT.title}" theme="simple"></s:textfield></td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">作者:</label>
	</td>
	<td><s:textfield label="作者" name="author" value="%{#session.ARTICLEEDIT.author}" theme="simple"></s:textfield></td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">信息来源:</label>
	</td>
	<td><s:textfield label="信息来源" name="source" value="%{#session.ARTICLEEDIT.source}" theme="simple"></s:textfield></td>
	</tr>
	<tr>
	<td>内容：</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td colspan="2">
	<script type="text/javascript">
	<!--
	var sBasePath = "<s:url value='/fckeditor/' encode='false' includeParams='none'/>";
	var oFCKeditor = new FCKeditor( "content" );
	oFCKeditor.BasePath	= sBasePath;
	oFCKeditor.ToolbarSet ="Smgk";
	oFCKeditor.Width	= "580";
	oFCKeditor.Height	= 600;
	oFCKeditor.Value	= '<s:property value="%{#session.ARTICLECONTENT}" escape="false"/>';
	oFCKeditor.Create();
	//-->
	</script>
		</td>
	</tr>
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

