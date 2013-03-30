<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部分问题管理</title>

<script type="text/javascript">
	var popQuestionWindow;
	function SelectWindowByQuestion()
	{
		if(!popQuestionWindow) {
			popQuestionWindow = window.open('<s:url value="listQuestionSelect.do" encode="false" includeParams="none"/>',"选择窗口","height=500,width=600,status=no,location=no,top=150,left=150,resizable=no");
		}		
	}
	function check(frm){
		if(frm.questionID.value == -1){
			alert('请选择问题！');
			frm.questionID.focus();
			return false;
		}
		return true;
	}
</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">修改部分问题信息</div>
  <div class="container">	
	<s:form name="form1" action="editPartQuestionProcess" onsubmit="return check(this);">
	<tr>
	<td class="tdLabel"><label class="label">部分名称:</label></td>
	<td><s:property value="%{#session.PARTNAME}"/></td>
	</tr>
	<s:if test="#session.PARTQUESTIONINFOEDIT.fatherPqID != null && #session.PARTQUESTIONINFOEDIT.fatherPqID != 0">
	<s:select list="%{#request.FATHERINFOMAP}" name="fatherPqID" listKey="key" listValue="value" headerKey="-1" label="上级部分问题" value="#session.PARTQUESTIONINFOEDIT.fatherPqID"></s:select>
	</s:if>
	<tr>
	<td class="tdLabel"><label class="label">问题:</label></td>
	<td>
	<select id="questionID" name="questionID">
	<s:if test="null != #session.EDITQUESTIONNAME">
	<option value="<s:property value="%{#session.EDITQUESTIONVALUE}"/>"><s:property value="%{#session.EDITQUESTIONNAME}"/></option>
	</s:if>
	<s:else>
	<option value="-1">请选择问题</option>
	</s:else>
	</select>&nbsp;<input type="button" OnClick="SelectWindowByQuestion();" value="选择问题"></td>
	</tr>
	<s:if test="null != #session.VALIDATIONSELECT && null != #session.PAETEDIT">
	<s:select list="%{#session.VALIDATIONSELECT}" name="validation" label="表单验证" value="%{#session.PARTQUESTIONINFOEDIT.validation}"></s:select>
	</s:if>
	<s:textfield label="显示编号" name="showNum" value="%{#session.PARTQUESTIONINFOEDIT.showNum}" size="40"></s:textfield>
	<s:select list="#{'1':'选项模板','2':'部分选项'}" label="选项类型" name="selectType"></s:select>
	<s:if test="#session.OPTIONTEMPLATEINFOLIST != null">
	<s:select list="%{#session.OPTIONTEMPLATEINFOLIST}" label="选项模板" name="optionTemplateID" listValue="title" listKey="optionTemplateID" headerKey="-1"></s:select>	
	</s:if>
	<s:else>
	<s:select list="%{}" label="选项模板" name="optionTemplateID"></s:select>	
	</s:else>
	<tr>  
	<td>&nbsp;</td>
	<td align="right"><s:submit value="修改" theme="simple"/>&nbsp;
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

