<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统菜单管理</title>

<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加菜单信息</div>
  <div class="container">	
	<s:form action="addMenuProcess">
	<s:textfield label="菜单名称" name="menu" ></s:textfield>
	<s:if test="#session.TYPE != null">
	<s:select list="%{#session.TYPE}" label="所属系统" name="type"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" label="所属系统" name="type"></s:select>
	</s:else>
	<s:if test=" menuID != null && menuID > 0">
		<s:if test="#request.FATHERMENUINFO != null">
		<s:select label="上级菜单" list="%{#request.FATHERMENUINFO}" name="parentID" listKey="menuID" listValue="menu" headerKey="-1" value="%{#request.FATHERMENUINFO.menuID}"></s:select>
		</s:if>
		<s:textfield label="链接地址" name="url" ></s:textfield>
	</s:if>
	<tr>
	<td>&nbsp;</td>
	<td align="right">
	<s:submit value="添加" theme="simple"></s:submit>&nbsp;
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
</body>
</html>

