<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>错误页面</title>
</head>

<body>
<div id="content">
<div class="mainarea">
<div class="maininner">
<div class="bdrcontent">
	<div class="title">找不到该页面</div>
	<div class="header2">
		<s:a href="/admin/index.jsp">重新登陆</s:a>
		<input type="button" value="返回" onClick="DoUrl()">
		<script type="text/javascript">
		function DoUrl() {
			window.history.back();
		}
		</script>
	</div>
</div>
</div>
</div>
</div>
</body>
</html>