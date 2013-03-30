<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计划管理</title>

<script type="text/javascript">
	var popQuestionWindow;
	function SelectWindowByQuestion()
	{
		if(!popQuestionWindow) {
			popQuestionWindow = window.open('<s:url value="/listQuestionSelect.do" encode="false" includeParams="none"/>',"选择窗口","height=500,width=600,status=no,location=no,top=150,left=150,resizable=no");
		}		
	}
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">添加计划信息完成</div>
  <div class="container">	
  	<s:a href="addPlanInputs.do">继续添加</s:a><br>
	<s:a href="listPlan.do">返回列表</s:a>
	</div>
</div>
</body>
</html>

