<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分析管理</title>
<script type="text/javascript">
function selectClient(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectReality.do';
		
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
		
		var html = '<select name=\'inquisitionID\' id=\'inquisitionID\'>';
		var length = o.inquisitionList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.inquisitionList[i].inquisitionID+'>'+o.inquisitionList[i].title+'</option>';
		}
		html += '</select>';
		$('inquisition').innerHTML = html;
		
		html = '<select name=\'projectID\' id=\'projectID\'>';
		length = o.projectList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.projectList[i].projectID+'>'+o.projectList[i].name+'</option>';
		}
		html += '</select>';
		$('project').innerHTML = html;
	}
</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加分析信息</div>
  <div class="container">	
	<s:form action="addRealityProcess">
	<tr>
	<td class="tdLabel"><label class="label">客户名称:</label></td>
	<td>
	<s:if test="#session.GLOBALCLIENTINFOLIST != null">
	<s:select label="客户名称" list="%{#session.GLOBALCLIENTINFOLIST}" name="clientID" listValue="company" value="%{#request.CLIENTVALUE}" listKey="clientID" headerKey="-1" onchange="selectClient(this);" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="客户名称" list="{}" name="clientID" theme="simple"></s:select>
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">项目名称:</label></td>
	<td>
	<div id="project">
	<s:if test="null != #session.PROJECTLIST">	
	<s:select id="projectID" label="项目名称" list="%{#session.PROJECTLIST}" name="projectID" listValue="name" listKey="projectID" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="projectID" label="项目名称" list="{}" name="projectID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">调查问卷:</label></td>
	<td>
	<div id="inquisition">
	<s:if test="#session.INQUISITIONLIST != null">
	<s:select id="inquisitionID" label="调查问卷" list="%{#session.INQUISITIONLIST}" name="inquisitionID" listValue="title" listKey="inquisitionID" headerKey="-1" onchange="selectInquisition(this);" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="inquisitionID" label="调查问卷" list="{}" name="inquisitionID"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">期次:</label></td>
	<td>
	<div id="issue">
	<s:if test="null != #session.ISSUELIST">	
	<s:select id="issueID" label="期次" list="%{#session.ISSUELIST}" name="issueID" listValue="issue" listKey="issueID" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="期次" list="{}" name="issueID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<s:textarea label="当前提示语" name="thisTime" cols="50" rows="8"></s:textarea>
	<s:textarea label="英文当前提示语" name="enThisTime" cols="50" rows="8"></s:textarea>
	<s:textarea label="最近提示语" name="soFarTime" cols="50" rows="8"></s:textarea>
	<s:textarea label="英文最近提示语" name="enSoFarTime" cols="50" rows="8"></s:textarea>
	<s:textarea label="得分评语" name="markReal" cols="50" rows="8"></s:textarea>
	<s:textarea label="英文得分评语" name="enMarkReal" cols="50" rows="8"></s:textarea>
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

