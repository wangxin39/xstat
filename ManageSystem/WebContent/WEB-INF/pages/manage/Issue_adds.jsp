<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>期次管理</title>
<script type="text/javascript">

	function checkIssue() {
		var name = $('issue').value;
		//请求的地址
		var url = 'selectIssue.do';
		var pars = 'issue='+name;
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:pars,
			//指定回调函数
			onComplete: checkResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
	function checkResponse(response) {
		var o = response.responseText.evalJSON(true);
		if(!o.isRegister) {
			$('isRegister').value="false";
		}else{
			alert("该期次已存在，请重新输入!");
			$('isRegister').value="true";
		}
	}
	function check(){

		var startTime = dojo.widget.byId("startTime");
		var endTime = dojo.widget.byId("endTime");
	
		if(startTime.getValue() >= endTime.getValue()){
			alert("起始时间不能大于结束时间");
			return false;
		}
		
		document.getElementById("check").action="addIssueProcess.do";
		document.getElementById("check").submit();
		
	}	
	function selectClient(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectIssue.do';
		
		var clientID = opt.value;//获取传入的客户值
		
		var pars = 'clientID='+clientID;
		
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:pars,
			//指定回调函数
			onComplete: clientResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
    function clientResponse(response)
	{
		var o = response.responseText.evalJSON(true);		
		// 字符转译 表示还没有结束
		//需要更新的城市内容
		var html = '<select name=\'projectID\' id=\'projectID\'>';
		var length = o.projectInfoList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.projectInfoList[i].projectID+'>'+o.projectInfoList[i].name+'</option>';
		}
		html += '</select>';
		$('project').innerHTML = html;
		
		html = '<select name=\'inquisitionID\' id=\'inquisitionID\'>';
		length = o.inquisitionInfoList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.inquisitionInfoList[i].inquisitionID+'>'+o.inquisitionInfoList[i].title+'</option>';
		}
		html += '</select>';
		$('inquisition').innerHTML = html;
	}	
</script>
<script type="text/javascript" src="<s:url value="/js/smgk/issue_cu.js"/>"></script>
<s:head theme="ajax"/></head>
<body>
<div class="cright">
  <div class="title font16h">添加期次信息</div>
  <div class="container">	
	<s:actionerror/>
	<s:form action="addIssueProcess">		
	<s:textfield label="期次" name="issue"></s:textfield>
	<tr>
	<td class="tdLabel"><label class="label">客户名称:</label></td>
	<td>
	<s:if test="#session.GLOBALCLIENTINFOLIST != null">
	<s:select label="客户名称" list="%{#session.GLOBALCLIENTINFOLIST}" name="clientID" value="%{#request.CLIENTVALUE}" listValue="company" listKey="clientID" onchange="selectClient(this);" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="客户名称" list="%{}" name="clientID" theme="simple"></s:select>
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">项目名称:</label></td>
	<td>
	<div id="project">
	<s:if test="#session.PROJECTSELECT != null">
	<s:select id="projectID" label="项目名称" list="%{#session.PROJECTSELECT}" name="projectID" listValue="name" listKey="projectID" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="projectID" label="项目名称" list="%{}" name="projectID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">调查问卷:</label></td>
	<td>
	<div id="inquisition">
	<s:if test="inquisitionInfoList != null">
	<s:select id="inquisitionID" label="调查问卷" list="%{inquisitionInfoList}" name="inquisitionID" listValue="title" listKey="inquisitionID" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="inquisitionID" label="调查问卷" list="%{}" name="inquisitionID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<tr>
		<td class="tdLabel"><label class="label">开始日期 (yyyy-MM-dd):</label></td>
		<td><div id="startDay"></div></td>
	</tr>
	<tr>
		<td class="tdLabel"><label class="label">结束日期 (yyyy-MM-dd):</label></td>
		<td><div id="endDay"></div></td>
	</tr>
	<tr>
		<td class="tdLabel"><label class="label">开始时间(HH:mm):</label></td>
		<td><div id="startTime"></div></td>
	</tr>
	<tr>
		<td class="tdLabel"><label class="label">结束时间 (HH:mm):</label></td>
		<td><div id="endTime"></div></td>
	</tr>		
	<tr>
		<td class="tdLabel"><label class="label">检测时间(yyyy-MM-dd):</label></td>
		<td><div id="checkTime"></div></td>
	</tr>	
	<tr>
		<td class="tdLabel"><label class="label">检测年度:</label></td>
		<td><div id="year"></div></td>
	</tr>
	<s:radio name="isFirst" label="比较类型" list="#{'1':'当年第一期','2':'不是第一期'}" value="2" required="true"/>
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

