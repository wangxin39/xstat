<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选项管理</title>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">添加选项信息</div>
  <div class="container">	
	<s:form name="form1" action="addSelectManageProcess">
	<s:select label="类型" list="#{'1':'选项提示','2':'选项值'}" name="type"></s:select>
	<s:textarea label="中文选项" name="chinaOption" cols="25" rows="10"></s:textarea>
	<s:textarea label="英文选项" name="englishOption" cols="25" rows="10"></s:textarea>
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
</body>
</html>

