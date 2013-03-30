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
	<div class="title">错误信息</div>
	<div class="header2">
		<s:actionerror/>
	</div>
	<div class="header2">
		<s:actionmessage/>
	</div>
	<div class="header2">
	<s:property value="exception"/>
	</div>

</div>
</div>
</div>
</div>
</body>
</html>