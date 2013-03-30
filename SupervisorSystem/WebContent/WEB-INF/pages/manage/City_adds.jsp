<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中文城市管理</title>

<script type="text/javascript">
	function check(frm)
	{
		if(frm.name.value == '')
		{
			frm.name.focus();
			alert("标题不能为空!");
			return false;	
		}
		if(frm.province.value == '')
		{
			frm.province.focus();
			alert("内容不能为空!");
			return false;	
		}
		return true;
	}
	
</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加城市信息</div>
  <div class="container">	
	<script type="text/javascript" src="/js/city.js"></script>
	<s:form action="addCityProcess" onsubmit="return check(this)">
	<s:textfield label="城市中文名称" name="name"></s:textfield>
	<s:textfield label="城市英文名称" name="englishName"></s:textfield>
	<s:if test="#session.PROVINCE != null">
	<s:select list="%{#session.PROVINCE}" label="所在省份" name="province"></s:select>
	</s:if>
	<s:else>
	<s:select label="所在省份" list="{}" name="province"></s:select>
	</s:else>
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="增加" theme="simple"/>&nbsp;
	<input type="button" value="返回" onClick="BackPage()">
	<script type="text/javascript">
	function BackPage() {
		history.back();
	}
	</script>
	</td>
	</tr>
	</s:form>
	</div>
</div>
</html>