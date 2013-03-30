<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报告管理</title>
<script type="text/javascript">
function selectIssue(opt)
	{
		//请求的地址
		var url = 'selectReport.do';
		var issueID = opt.value;
		var pars = 'issueID='+issueID;
		
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:pars,
			//指定回调函数
			onComplete: processResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
  	function processResponse(response)
	{
		var o = response.responseText.evalJSON(true);
		
		//需要更新的内容
		var html = '<select name=\'informantID\' id=\'informantID\'>';
		var length = o.informantList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.informantList[i].informantID+'>'+o.informantList[i].name+'</option>';
		}
		html += '</select>';
		$('informant').innerHTML = html;
	}
</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">修改报告信息</div>
  <div class="container">	
	<s:form action="editReportProcess">
	<tr>
	<td class="tdLabel"><label class="label">期次:</label></td>
	<td>
	<s:if test="null != #session.ISSUELIST">	
	<s:select label="期次" list="%{#session.ISSUELIST}" name="issueID" listValue="issue" value="%{#request.REPORTEDIT.issueID}" listKey="issueID" headerKey="-1" onchange="selectIssue(this);" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="期次" list="{}" name="issueID" theme="simple"></s:select>
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">调查对象:</label></td>
	<td>
	<div id="informant">
	<s:if test="null != #session.INFORSELECT">	
	<s:select id="informantID" label="调查对象" list="%{#session.INFORSELECT}" name="informantID" value="%{#session.REPORTEDIT.informantID}" listValue="name" listKey="informantID" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查对象" list="{}" name="informantID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<s:if test="#session.THEMELIST != null">
	<s:select list="%{#session.THEMELIST}" name="themeID" label="主题名称" listKey="themeID" value="%{#session.REPORTEDIT.themeID}" listValue="title" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" name="themeID" label="主题名称"></s:select>
	</s:else>
	<s:if test="#session.REPORTTYPE != null">
	<s:select list="%{#session.REPORTTYPE}" name="reportType" label="报告类型" value="%{#session.REPORTEDIT.reportType}"></s:select>
	</s:if>
	<s:else>
	<s:select label="报告类型" list="{}" name="reportType"></s:select>
	</s:else>
	<s:textfield label="检测名称" name="checkName" value="%{#session.REPORTEDIT.checkName}"></s:textfield>
	<s:textfield label="报告中文名称" name="reportTitle" value="%{#session.REPORTEDIT.reportTitle}"></s:textfield>
	<s:textfield label="报告英文名称" name="enReportTitle" value="%{#session.REPORTEDIT.enReportTitle}"></s:textfield>
	<s:textfield label="季度标题" name="quarterTitle" value="%{#session.REPORTEDIT.quarterTitle}"></s:textfield>
	<s:textfield label="报告页数" name="pageCount" value="%{#session.REPORTEDIT.pageCount}"></s:textfield>
	
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

