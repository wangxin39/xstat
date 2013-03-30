<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>浏览信息</title>
</head>

<body>
<div class="cright">
	<div class="title font16h"><s:property value="%{#request.ARTICLEINFO.title}"/></div>
    <div class="container">
<div class="title">
<s:property value="%{#request.ARTICLEINFO.content}" escape="false"/>
</div>
<input type="button" value="关闭" onclick="CloseWin()">
<script type="text/javascript">
function CloseWin() {
	window.close();	
}
</script>
</div>
</div>
</body>
</html>