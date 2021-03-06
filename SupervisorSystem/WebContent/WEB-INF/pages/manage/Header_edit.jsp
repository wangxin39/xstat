<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表头管理</title>

<script type="text/javascript">
	var popQuestionWindow;
	function SelectWindowByQuestion()
	{
		if(!popQuestionWindow) {
			popQuestionWindow = window.open('<s:url value="listQuestionSelect.do" encode="false" includeParams="none"/>',"选择窗口","height=500,width=600,status=no,location=no,top=150,left=150,resizable=no");
		}		
	}
</script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">修改表头信息</div>
  <div class="container">	
	<s:form action="editHeaderProcess" name="form1">
	<tr>
	<td class="tdLabel"><label class="label">问题:</label></td>
	<td>
	<s:if test="#session.HEADEREDIT != null">
	<select name="questionID" id="questionID">
	<option value="#session.HEADEREDIT.questionID"><s:property value="#session.QUESTIONLI"/></option>
	</select>&nbsp;<input type="button" OnClick="SelectWindowByQuestion();" value="选择问题">
	</s:if>
	<s:else>
	<select id="questionID" name="questionID">
	<option value="-1">请选择问题</option>
	</select>&nbsp;<input type="button" OnClick="SelectWindowByQuestion();" value="选择问题">
	</s:else>
	</td>
	</tr>
	<tr>
	<td>
	<s:if test="#session.INQUISITIONLIST != null">
	<s:select list="%{#session.INQUISITIONLIST}" label="调查问卷" name="inquisitionID" listValue="title" listKey="inquisitionID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查问卷" name="inquisitionID" list="{}"></s:select>	
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">问题类型:</label></td>
	<td>
	<s:if test="#session.TYPELIST != null">
	<s:select list="%{#session.TYPELIST}" label="问题类型" name="questionType" value="%{#session.HEADEREDIT.questionType}" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="问题类型" name="questionType" list="{}"  theme="simple"></s:select>	
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">选项类型:</label></td>
	<td>
	<s:if test="#session.SELECTLIST != null">
	<s:select list="%{#session.SELECTLIST}" label="选项类型" name="selectType" value="%{#session.HEADEREDIT.selectType}" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="选项类型" name="selectType" list="{}"  theme="simple"></s:select>	
	</s:else>
	</td>
	</tr>
	<s:if test="#session.ISINPUTLIST != null">
	<s:select label="是否必须填写" name="isInput" list="%{#session.ISINPUTLIST}" value="%{#session.HEADEREDIT.isinput}"></s:select>
	</s:if>
	<s:else>
	<s:select label="是否必须填写" name="isInput" list="{}"></s:select>	
	</s:else>
	<s:textfield label="显示顺序" name="showOrder" value="%{#session.HEADEREDIT.showOrder}"></s:textfield>
	<tr>
	<td>&nbsp;</td>
	<td align="right">
	<s:submit value="修改" theme="simple"></s:submit>&nbsp;
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
