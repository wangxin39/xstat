<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<s:form action="Login" namespace="/" method="get">
<div id="wrap">
	<div id="loginPanel">
    	<div class="header">
    	<div id="logo"><img src="<s:url value="/images/logo.gif"/>" /></div>
		<script src="<s:url value="/js/showtime.js"/>" type="text/javascript"></script>
        <div id="showtime"></div>
        </div>
        <div class="login">
        	<ul>
            	<li class="title">登陆名称：</li>
                <li class="input"><input type="text" name="username" value="" style="width:198px" /></li>
                <li class="title">登陆密码：</li>
                <li class="input"><input type="password" name="password" value="" style="width:198px" /></li>
                <li class="title">验  证  码：</li>
                <li class="input"><img src="authImage.do" id="authImg"/> 看不清?请 [<a href="#" style="color:#FFFFFF" onclick="refresh();">刷新</a>]</li>
                <li class="title"></li>
                <li class="input"><input type="text" name="authCode" value="" style="width:100px" /></li>
                <li class="btn"><input type="image" src="<s:url value="/images/submit.gif"/>"  onclick="btnSubmit();"/>&nbsp;&nbsp;<input type="image" src="<s:url value="/images/reset.gif"/>" onclick="btnReset();"/>
				&nbsp;&nbsp;<a href="<s:url value="/Register.do"/>"><img src="<s:url value="/images/reg.gif"/>"></a></li>
            </ul>
        </div>
        <div class="loginCopyright">
        中国神秘检测网 copyright &copy; 2008-2009        </div>
    </div>
</div>
</s:form>
</body>
</html>

