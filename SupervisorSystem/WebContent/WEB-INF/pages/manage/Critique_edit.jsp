<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查问卷评语管理</title>
<script type="text/javascript">
	function selectClient(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectCritique.do';
		
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
		
		html = '<select name=\'informantID\' id=\'informantID\'>';
		length = o.informantList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.informantList[i].informantID+'>'+o.informantList[i].name+'</option>';
		}
		html += '</select>';
		$('informant').innerHTML = html;
		
		html = '<select name=\'projectID\' id=\'projectID\'>';
		length = o.projectList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.projectList[i].projectID+'>'+o.projectList[i].name+'</option>';
		}
		html += '</select>';
		$('project').innerHTML = html;
	}	

	function selectInquisition(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectCritique.do';
		
		var inquisitionID = opt.value;//获取传入的客户值
		
		var pars = 'inquisitionID='+inquisitionID;
		
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
		
		var html = '<select name=\'partID\' id=\'partID\'>';
		var length = o.partInfoList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.partInfoList[i].partID+'>'+o.partInfoList[i].name+'</option>';
		}
		html += '</select>';
		$('part').innerHTML = html;
		
		html = '<select name=\'issueID\' id=\'issueID\'>';
		length = o.issueList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.issueList[i].issueID+'>'+o.issueList[i].issue+'</option>';
		}
		html += '</select>';
		$('issue').innerHTML = html;
	}	
</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">修改评语信息</div>
  <div class="container">	
<s:form action="editCritiqueProcess">
<tr>
<td class="tdLabel"><label class="label">客户名称:</label></td>
<td>
<s:if test="#session.GLOBALCLIENTINFOLIST != null">
<s:select label="客户名称" list="%{#session.GLOBALCLIENTINFOLIST}" name="clientID" listValue="company" value="%{#session.REMARKEDIT.clientID}" listKey="clientID" headerKey="-1" onchange="selectClient(this);" theme="simple"></s:select>
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
<s:if test="null != #session.GLOBALPROJECTLIST">	
<s:select id="projectID" label="项目名称" list="%{#session.GLOBALPROJECTLIST}" name="projectID" listValue="name" value="%{#session.REMARKEDIT.projectID}" listKey="projectID" headerKey="-1" theme="simple"></s:select>
</s:if>
<s:else>
<s:select id="projectID" label="项目名称" list="{}" name="projectID" theme="simple"></s:select>
</s:else>
</div>
</td>
</tr>
<tr>
<td class="tdLabel"><label class="label">调查对象:</label></td>
<td>
<div id="informant">
<s:if test="null != #session.GLOBALINFORMANTLIST">	
<s:select id="informantID" label="调查对象" list="%{#session.GLOBALINFORMANTLIST}" name="informantID" listValue="name" value="%{#session.REMARKEDIT.informantID}" listKey="informantID" headerKey="-1" theme="simple"></s:select>
</s:if>
<s:else>
<s:select label="调查对象" list="{}" name="informantID" theme="simple"></s:select>
</s:else>
</div>
</td>
</tr>
<tr>
<td class="tdLabel"><label class="label">调查问卷:</label></td>
<td>
<div id="inquisition">
<s:if test="#session.GLOBALINQUISITIONLIST != null">
<s:select id="inquisitionID" label="调查问卷" list="%{#session.GLOBALINQUISITIONLIST}" name="inquisitionID" value="%{#session.REMARKEDIT.inquisitionID}" listValue="title" listKey="inquisitionID" headerKey="-1" onchange="selectInquisition(this);" theme="simple"></s:select>
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
<s:if test="null != #session.GLOBALISSUELIST">	
<s:select id="issueID" label="期次" list="%{#session.GLOBALISSUELIST}" name="issueID" listValue="issue" value="%{#session.REMARKEDIT.issueID}" listKey="issueID" headerKey="-1" theme="simple"></s:select>
</s:if>
<s:else>
<s:select id="issueID" label="期次" list="{}" name="issueID" theme="simple"></s:select>
</s:else>
</div>
</td>
</tr>
<tr>
<td class="tdLabel"><label class="label">部分名称:</label></td>
<td>
<div id="part">
<s:if test="#session.GLOBALPARTLIST != null">
<s:select id="partID" label="部分名称" list="%{#session.GLOBALPARTLIST}" name="partID" value="%{#session.REMARKEDIT.partID}" listValue="name" listKey="partID" headerKey="-1" theme="simple"></s:select>
</s:if>
<s:else>
<s:select id="partID" label="部分名称" list="{}" name="partID" theme="simple"></s:select>
</s:else>
</div>
</td>
</tr>
<s:textarea label="优点" name="strengths" value="%{#session.REMARKEDIT.strengths}" cols="50" rows="8"></s:textarea>
<s:textarea label="英文优点" name="enStrengths" value="%{#session.REMARKEDIT.enStrengths}" cols="50" rows="8"></s:textarea>
<s:textarea label="缺点" name="weaknesses" value="%{#session.REMARKEDIT.weaknesses}" cols="50" rows="8"></s:textarea>
<s:textarea label="英文缺点" name="enWeaknesses" value="%{#session.REMARKEDIT.enWeaknesses}" cols="50" rows="8"></s:textarea>
<s:textarea label="总结建议" name="conclusion" value="%{#session.REMARKEDIT.conclusion}" cols="50" rows="8"></s:textarea>
<s:textarea label="英文总结建议" name="enConclusion" value="%{#session.REMARKEDIT.enConclusion}" cols="50" rows="8"></s:textarea>
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

