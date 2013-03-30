<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘客检测系统</title>
<decorator:head />
<link type="text/css" rel="stylesheet" href="css/css.css" media="all">
<link type="text/css" rel="stylesheet" href="css/style.css" media="all">
<script type="text/javascript" src="<s:url value='/js/sh.js' encode='false' includeParams='none'/>"></script>
<script language="javascript" type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/prototype-1.6.0.js"></script>
<script type="text/javascript" src="js/json.js"></script>
</head>

<body>
<div id="wrap">
	<div id="header">
		<div class="logo"><a href="http://www.smgk.com" title="神秘顾客"><img src="<s:url value="/images/logo.gif"/>" alt="神秘顾客"/></a></div>
		<div class="hright">
		<s:if test="null != #session.LOGINUSERNAME">
			欢迎您，<a href="listBasic.do"><s:property value="#session.LOGINUSERNAME"/></a> |
		</s:if>
		<a href="listLogout.do">退出</a>
		<script src="<s:url value="/js/showtime.js"/>" type="text/javascript"></script>
		<div id="showtime"></div>
		</div>	
		<div class="toolbars font12white"><marquee><s:property value="%{#session.LOGINUSERNAME}"/>您好，欢迎您使用神秘客检测系统，祝你工作愉快！</marquee></div>  
	</div>

	<div id="content">
		<script type="text/javascript" src="<s:url value='/js/init.js' encode='false' includeParams='none'/>"></script>
		<div id="leftmenu" class="side"></div>	
		<decorator:body />
	</div>
				
	<div id="footer">
		<p>Powered by <a href="http://www.smgk.com" target="_blank" title="20080612">神秘客检测系统</a> 
		, &copy; 2008 - 2009 <a href="http://www.smgk.com/" target="_blank">www.smgk.com</a></p>
	</div>
</div>
</body>
</html>