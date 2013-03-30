<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布管理</title>
<script type="text/javascript">
	var popQuestionWindow;
	function SelectWindowBySmgk()
	{
		if(!popQuestionWindow) {
			popQuestionWindow = window.open('<s:url value="listSmgkSelect.do" encode="false" includeParams="none"/>',"选择窗口","height=500,width=600,status=no,location=no,top=150,left=150,resizable=no");
		}		
	}
	function check(frm){
		if(frm.smgkID.value == -1){
			alert('请选择顾客名称！');
			frm.smgkID.focus();
			return false;
		}
		return true;
	}
</script>
<s:head theme="ajax"/></head>

<body>

<div class="cright">
  <div class="title font16h">修改文章发布信息</div>
  <div class="container">	
	<s:form action="editPublishProcess" name="form1" onsubmit="return check(this);">
	<tr>
	<td class="tdLabel"><label class="label">顾客名称:</label></td>
	<td>
	<s:if test="#session.SMGKSELECT != null">
	<select name="smgkID" id="smgkID">
	<option value="<s:property value="#request.SMGKID"/>"><s:property value="#session.SMGKVALUE"/></option>
	</select>&nbsp;<input type="button" OnClick="SelectWindowBySmgk();" value="选择顾客信息">
	</s:if>
	<s:else>
	<select id="smgkID" name="smgkID">
		<option value="-1">请选择顾客信息</option>
	</select>&nbsp;<input type="button" OnClick="SelectWindowBySmgk();" value="选择顾客信息">
	</s:else>
	</td>
	</tr>
	<s:if test="#session.ARTICLESELECT != null">
	<s:select list="%{#session.ARTICLESELECT}" label="文章标题" name="articleID" listValue="title" value="%{#session.PUBLISHEDIT.articleID}" listKey="articleID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="文章标题" name="articleID" list="{}"></s:select>	
	</s:else>
	<s:if test="#session.TYPE != null">
	<s:select list="%{#session.TYPE}" label="文章类型" value="%{#session.PUBLISHEDIT.type}" name="type"></s:select>
	</s:if>
	<s:else>
	<s:select label="文章类型" name="type" list="{}"></s:select>	
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

