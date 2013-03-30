<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>错误页面</title>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
	<div class="title font16h">异常信息</div>
    <div class="container">
<s:actionerror/>
<s:actionmessage/>
<hr>
<s:property value="exception"/>
</div>
</div>
</body>
</html>