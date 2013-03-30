<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权重管理</title>
<script type="text/javascript">
	function selectPart(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'jsonWeight.do';
		
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
			onComplete: partResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
    function partResponse(response)
	{
		var o = response.responseText.evalJSON(true);		
		// 字符转译 表示还没有结束
		//需要更新的城市内容
		var html = '<select name=\'partID\' id=\'partID\' onchange=\'selectQuestion(this);\'>';
		var length = o.partInfoList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.partInfoList[i].partID+'>'+o.partInfoList[i].name+'</option>';
		}
		html += '</select>';
		$('part').innerHTML = html;
	}
	function selectQuestion(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'jsonWeight.do';
		
		var partID = opt.value;//获取传入的客户值
		
		var pars = 'partID='+partID;
		
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:pars,
			//指定回调函数
			onComplete: questionResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
    function questionResponse(response)
	{
		var o = response.responseText.evalJSON(true);		
		// 字符转译 表示还没有结束
		//需要更新的城市内容
		var html = '<select name=\'partQuestionID\' id=\'partQuestionID\' onchange=\'selectType(this);\'>';
		var length = o.partQuestionIDList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.partQuestionIDList[i]+'>'+o.partQuestionInfoMap[o.partQuestionIDList[i]]+'</option>';
		}
		html += '</select>';
		$('question').innerHTML = html;
	}

	function selectType(opt) 
	{	
		//请求的地址
		var url = 'jsonWeight.do';
		
		var partQuestionID = opt.value;//获取传入的客户值
		
		var pars = 'partQuestionID='+partQuestionID;
		
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:pars,
			//指定回调函数
			onComplete: selectTypeResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
    function selectTypeResponse(response)
	{
    	var o = response.responseText.evalJSON(true);
		var html = "<table>";
		if(o.selectType != null && o.selectType == 1) {
			html = '<tr><td class="tdLabel"><label class="label">选项模板:</label></td><td><select name="optionTemplateID" id="optionTemplateID" onchange="selectTemplate(this);">';
			var length = o.optionTemplateInfoList.length;
			if(length > 0) {
				for(i=0;i<length;i++) {
					html += '<option value="'+o.optionTemplateInfoList[i].optionTemplateID+'">'+o.optionTemplateInfoList[i].title+'</option>';
				}
			}
			html += '</select></td></tr>';
		}		
		if(o.selectType != null && o.selectType == 2) {
			html += '<tr><td class="tdLabel"><label class="label">部分选项:</label></td><td><select name="partSelectID">';
			var length = o.partSelectIDList.length;			
			for(var i=0;i<length;i++){
				html += '<option value="'+o.partSelectIDList[i]+'">'+o.partSelectInfoMap[o.partSelectIDList[i]]+'</option>';
			}
			html += '</select></td></tr>';
		}
		html += '</table>';	
		$('selecttypediv').innerHTML = html;
	}
	function selectTemplate(opt) {
		//请求的地址
		var url = 'jsonWeight.do';
		
		var optionTemplateID = opt.value;//获取传入的客户值
		
		var pars = 'optionTemplateID='+optionTemplateID;
		
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:pars,
			//指定回调函数
			onComplete: selectTemplateResponse,
			//是否异步发送请求
			asynchronous:true
		});
		
	}
  function selectTemplateResponse(response)
	{
    	var o = response.responseText.evalJSON(true);
    	var html = "<table>";
    	html += '<tr><td class="tdLabel"><label class="label">选项关系:</label></td><td><select name="optionRelationID">';
		var length = o.partSelectIDList.length;
		for(var i=0;i<length;i++){
			html += '<option value="'+o.partSelectIDList[i]+'">'+o.partSelectInfoMap[o.partSelectIDList[i]]+'</option>';
		}
    	html += '</select></td></tr></table>';		
		$('selecttemplatediv').innerHTML = html;
    }
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">修改权重信息</div>
  <div class="container">	
	<s:form action="editWeightProcess" method="post" namespace="/manage">
	<tr>
	<td class="tdLabel"><label class="label">调查问卷:</label></td>
	<td>
	<s:if test="null != inquisitionInfoList">
	<s:select id="inquisitionID" label="调查问卷" list="%{inquisitionInfoList}" name="inquisitionID" listKey="inquisitionID" value="%{#session.WEIGHTEDIT.inquisitionID}"   onchange="selectPart(this);" listValue="title" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="inquisitionID" label="调查问卷" name="inquisitionID" list="{}" theme="simple"></s:select>
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">部分名称:</label></td>
	<td>
	<div id="part">
	<s:if test="null != partInfoList">
	<s:select id="partID" label="部分名称" list="%{partInfoList}" name="partID" listKey="partID" value="%{#session.WEIGHTEDIT.partID}" listValue="name" onchange="selectQuestion(this);" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="partID" label="部分名称" name="partID" list="{}" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">部分问题:</label></td>
	<td>
	<div id="question">
	<s:if test="partQuestionInfoList != null">
	<s:select label="部分问题" list="%{partQuestionInfoList}" name="partQuestionID" listValue="fieldName" value="%{#session.WEIGHTEDIT.partQuestionID}"  listKey="partQuestionID" headerKey="-1" theme="simple" onchange="selectType(this);"></s:select>
	</s:if>
	<s:else>
	<s:select label="部分问题" name="partQuestionID" list="{}" theme="simple" onchange="selectType(this);"></s:select>	
	</s:else>
	</div>
	</td>
	</tr>
	</table>
	<div id="selecttypediv"></div>
	<div id="selecttemplatediv"></div>
	<table>
	<s:textfield label="权重" name="weight" value="%{#session.WEIGHTEDIT.weight}"></s:textfield>
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

