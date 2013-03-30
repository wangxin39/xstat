<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计划管理</title>
<script type="text/javascript">
	function selectIssue(opt)
	{
		//请求的地址
		var url = 'selectPlan.do';
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
		var length = o.inList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.inList[i].informantID+'>'+o.inList[i].name+'</option>';
		}
		html += '</select>';
		$('informant').innerHTML = html;
	}
	
	var popQuestionWindow;
	function SelectWindowBySmgk()
	{
		if(!popQuestionWindow) {
			popQuestionWindow = window.open('<s:url value="listSmgkSelect.do" encode="false" includeParams="none"/>',"选择窗口","height=500,width=600,status=no,location=no,top=150,left=150,resizable=no");
		}		
	}
	function check(frm){
		if(frm.smgkID.value == "-1"){
			alert("请选择顾客信息!");
			frm.smgkID.focus();
			return false;
		}
		if(frm.startDay.value >= frm.endDay.value){
			alert("开始日期不能大于结束日期");
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript" src="<s:url value="/js/smgk/plan_cu.js"/>"></script>
<s:head theme="ajax"/></head>

<body>
<body>
<div class="cright">
  <div class="title font16h">添加计划信息</div>
  <div class="container">	
	<s:actionerror/>
	<s:actionmessage/>
	<s:form action="addPlanProcess" name="form1" onsubmit="return check(this);" method="post" namespace="/manage">	
	<s:textfield name="name" label="计划名称"></s:textfield>
	<tr>
	<td class="tdLabel"><label class="label">顾客名称:</label></td>
	<td>
	<select id="smgkID" name="smgkID">
	<option value="-1">请选择顾客信息</option>
	</select>&nbsp;<input type="button" OnClick="SelectWindowBySmgk();" value="选择顾客信息"></td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">期次:</label></td>
	<td>
	<s:if test="null != #session.GLOBALISSUEMAP">	
	<s:select label="期次" list="%{#session.GLOBALISSUEMAP}" name="issueID" listValue="value"  listKey="key" headerKey="-1" onchange="selectIssue(this);" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="期次" list="{}" name="issueID" theme="simple"></s:select>
	</s:else>
	</td>
	</tr>
	<s:if test="null != #session.GLOBALROUNDDICT">
	<s:select name="round" label="轮次" list="%{#session.GLOBALROUNDDICT}" listValue="value" listKey="key" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" name="round" label="轮次"></s:select>
	</s:else>	
	<tr>
	<td class="tdLabel"><label class="label">调查对象:</label></td>
	<td>
	<div id="informant">
	<s:if test="null != #session.GLOBALINFORMANTINFOLIST">	
	<s:select id="informantID" label="调查对象" list="%{#session.GLOBALINFORMANTINFOLIST}" name="informantID" listValue="name" listKey="informantID" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查对象" list="{}" name="informantID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>		
	<s:if test="null != #session.GLOBALWEIFHTDICT">	
	<s:select label="权重模式" list="%{#session.GLOBALWEIFHTDICT}" name="weightPattern"  headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select label="权重模式" list="{}" name="weightPattern"></s:select>
	</s:else>
	<s:textfield label="任务编号" name="jobID"></s:textfield>
	<tr>
		<td class="tdLabel"><label class="label">开始时间(HH:mm):</label></td>
		<td><div id="startTime"></div></td>
	</tr>
	<tr>
		<td class="tdLabel"><label class="label">结束时间 (HH:mm):</label></td>
		<td><div id="endTime"></div></td>
	</tr>		

	<tr>
		<td class="tdLabel"><label class="label">开始日期 (yyyy-MM-dd):</label></td>
		<td><div id="startDay"></div></td>
	</tr>
	<tr>
		<td class="tdLabel"><label class="label">结束日期 (yyyy-MM-dd):</label></td>
		<td><div id="endDay"></div></td>
	</tr>
	<s:radio name="planType" label="计划类型" list="#{'1':'调查','2':'测试'}" value="1" required="true"/>
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="增加" theme="simple"/>
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

