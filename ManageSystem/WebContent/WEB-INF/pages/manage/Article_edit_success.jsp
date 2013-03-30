<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>

</head>

<body>
<div class="cright">
  <div class="title font16h">文章修改成功！</div>
  <div class="container">	
	<script type="text/javascript">
	function GoUrl(url)
	{
	location.href=url;
	}
	</script>
	<input type="button" onclick="GoUrl('listArticle.do');" value="返回信息列表">
	</div>
</div>
</body>
</html>

