<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>


<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加员工信息</div>
  <div class="container">	
	<s:form action="addEmployeeProcess">
	<s:textfield label="姓名" name="name"></s:textfield>
	<s:select list="{'女性','男性'}" name="sex" label="性别"></s:select>
	<s:textfield label="部门" name="depart"></s:textfield>
	<s:textfield label="职位" name="job"></s:textfield>
	<s:textfield label="登录名称" name="loginName"></s:textfield>
	<s:password name="passWord" label="登录密码"></s:password>
	<s:textarea label="岗位描述" name="description" rows="10" cols="30"></s:textarea>
	<tr>
	<td>&nbsp;</td>
	<td align="right">
	<s:submit value="增加" theme="simple"></s:submit>&nbsp;
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

