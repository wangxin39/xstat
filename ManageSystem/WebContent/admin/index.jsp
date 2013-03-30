<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘顾客检测平台</title>
<link type="text/css" rel="stylesheet" href="<s:url value="/css/css.css"/>" media="all"/>
<script type="text/javascript">
	function refresh(){
		document.getElementById("authImg").src='<s:url value="/authImage.do"/>?now='+new Date();
	}
	function btnSubmit() {
		document.from1.submit();
	}
	function btnReset() {
		document.from1.reset();
	}
	
</script>
</head>
<body>
<s:form name="form1" action="Login" namespace="/" method="get" theme="simple">
<table width="100%" height="100%">
<tr>
	<td align="center" valign="middle">
<div id="wrap">
	<div id="loginPanel">
    	<div class="logo"><img src="<s:url value="/images/logo.gif"/>"></div>
		<script src="<s:url value="/js/showtime.js"/>" type="text/javascript"></script>
        <div id="showtime"></div>
        <div class="login">
        	<ul>
				<li class="title">&nbsp;</li>
				<li class="input"><s:actionerror/>&nbsp;</li>
            	<li class="title">登录名称：</li>
                <li class="input"><input type="text" name="loginName" value="" style="width:198px"></li>
                <li class="title">用户密码：</li>
                <li class="input"><input type="password" name="passWord" value="" style="width:198px"></li>
                <li class="title">验证码：</li>
                <li class="input"><img src="<s:url value="/authImage.do"/>" id="authImg" name="code"> 看不清楚？请[<a href="#" style="color:#FFFFFF" onclick="refresh()">刷新</a>]</li>
                <li class="title"></li>
                <li class="input"><input type="text" name="authCode" value="" style="width:100px"></li>
                <li class="btn"><input type="image" src="<s:url value="/images/submit.gif"/>" onclick="btnSubmit();">&nbsp;&nbsp;<input type="image" src="<s:url value="/images/reset.gif"/>" onclick="btnReset();"></li>
				<li class="title">&nbsp;</li>
				<li class="input">&nbsp;</li>
            </ul>
        </div>
        <div class="loginCopyright">
        	中国神秘检测网 copyright &copy; 2008-2009
        </div>
    </div>
</div>
</td></tr></table>
</s:form>
</body>
</html>

