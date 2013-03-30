<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="decorator" uri="/decorator"%>
<%@taglib prefix="page" uri="/page"%>
<%
String objs = request.getParameter("selectMenuID");
if(objs != null) {
	session.setAttribute("SELECTMENUID",objs);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache,no-store,must-revalidate"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="神秘顾客检测平台"/></title>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/css.css' encode='false' includeParams='none'/>"/>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/ext-all.css' encode='false' includeParams='none'/>" />
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.3.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/adapter/ext/ext-base.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/ext/ext-all.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/ext/locale/ext-lang-zh_CN.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/shared/common.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/sh.js' encode='false' includeParams='none'/>"></script>
<decorator:head />
</head>

<body>
<div id="wrap">
	<div id="header">
		<div class="logo"><a href="http://www.smgk.com" title="神秘顾客"><img src="../images/logo.gif" alt="神秘顾客"/></a></div>
		<div class="hright">
		<s:if test="null != #session.LOGINUSERNAME">
			欢迎您，<a href="detailEmployee.do?employeeID=<s:property value="%{#session.LOGINID}"/>"><s:property value="#session.LOGINUSERNAME"/></a> |
		</s:if>
		<s:else>
			<s:a href="../admin/index.jsp">重新登陆</s:a> |
		</s:else>
		<a href="<s:url value="/Logout.do"/>">退出</a>		
		</div>	
	</div>

	<div id="content">
		<script type="text/javascript" src="<s:url value='/js/init.js' encode='false' includeParams='none'/>"></script>
		<div id="leftmenu" class="side"></div>
		<decorator:body />
	</div>
				
	<div id="footer">
		<p>Powered by <a href="http://www.smgk.com" target="_blank" title="20080612">神秘顾客检测平台</a> 2.0 
		, &copy; 2008 - 2009 <a href="http://www.smgk.com/" target="_blank">www.smgk.com</a></p>
	</div>
</div>
</body>
</html>