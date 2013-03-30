<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分标准管理</title>
</head>

<body>
<div class="cright">
  <div class="title font16h">修改评分标准管理成功！</div>
  <div class="container">	
	<s:a href="addGradeStdInputs.do">添加</s:a><br>
	<input type="button" value="返回信息列表" onClick="DoUrl('url')">
	<script type="text/javascript">
	function DoUrl(url) {
		window.location.href('listGradeStd.do');
	}
	</script>
	</div>
</div>
</body>
</html>

