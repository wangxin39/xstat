<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上级逻辑题管理</title>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/css.css' encode='false' includeParams='none'/>"/>
<link rel="stylesheet" type="text/css" href="<s:url value='/css/ext-all.css' encode='false' includeParams='none'/>" />
<script type="text/javascript" src="<s:url value='/js/adapter/jquery/jquery.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/adapter/jquery/ext-jquery-adapter.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.3.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/adapter/ext/ext-base.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/ext/ext-all.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/ext/locale/ext-lang-zh_CN.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/shared/common.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/sh.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
<script type="text/javascript">

	/**
	* 切开字符串
	*/
	function splitStr(str)
	{
		var values = new Array(2);
		var pos = str.indexOf(",");		
		if(pos != -1) {
			var tmp = str;
			values[0] = tmp.substring(0,pos);
			values[1] = tmp.substring(pos+1,tmp.length);
		}
		return values;
	}
	
	/**
	* 获取当前选择的数据索引
	*/
	function getSelectedRadio(radios) {
		for(var i=0;i<radios.length;i++) {
			if(radios[i].checked) {
				return i;
			}
		}
		return -1;
	}
	
	function setSelectToOpener(form)
	{
		var list = form.questionID;
		var i = getSelectedRadio(list);
		if(i != -1 ) {
			var newOpt = opener.document.form1.questionID[0];
			var values = splitStr(list[i].value);	
			newOpt.text = values[1];
			newOpt.value = values[0];
			newOpt.selected = true;
							
			opener.document.form1.questionID[0] = newOpt;	
		}else if(list.value != 'undefined'){
			var newOpt = opener.document.form1.questionID[0];
			var values = splitStr(list.value);	
			newOpt.text = values[1];
			newOpt.value = values[0];
			newOpt.selected = true;
							
			opener.document.form1.questionID[0] = newOpt;	
		}
		
		opener.popQuestionWindow.close();
		opener.popQuestionWindow = null;
	}		
	function updatePanel(num)
	{
		//请求的地址
		var url = 'ajaxQuestionSelect.do';
		var pars = 'num='+num;
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
		var html = '<table  width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" bordercolor=\"#FFFFFF\" bgcolor=\"#cccccc\">';
		var length = o.pageList.length;
		html +='<tr style="background-color: #a8c5d9;"><td class=\"ttitle\"><strong class=\"font12red\">&nbsp;</strong></td><td class=\"ttitle\"><strong class=\"font12red\">中文题目</strong></td><td class=\"ttitle\"><strong class=\"font12red\">字段类型</strong></td><td class=\"ttitle\"><strong class=\"font12red\">问题类型</strong></td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].questionID+'</td>';
			html += '<td>'+o.pageList[i].question+'</td>';	
			html += '<td>'+o.fieldTypeList[i]+'</td>';	
			html += '<td>'+o.questionList[i]+'&nbsp;</td>';
			html += '</tr>';				
		}
		html += '<tr><td>&nbsp;</td><td><input type="button" value="确认选择" OnClick="setSelectToOpener(this.form)" /></td></tr></table>';
		$('tablecontent').innerHTML = html;	
	}	
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">逻辑题管理</div>
  <div class="container">
	<form action="listQuestionSelect.do">
	<div id="tablecontent">
	<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr style="background-color: #a8c5d9;">
			<td class="ttitle"><strong class="font12red">&nbsp;</strong></td>
			<td class="ttitle"><strong class="font12red">中文题目</strong></td>
			<td class="ttitle"><strong class="font12red">字段类型</strong></td>
			<td class="ttitle"><strong class="font12red">问题类型</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td ><input type="radio" name="questionID" id="questionID" value="<s:property value="questionID" />,<s:property value="question" />">&nbsp;<s:property value="questionID" /></td>
				<td ><s:property value="question" /></td>
				<td ><s:property value="fieldTypeList[#stat.index]" /></td>
				<td ><s:property value="questionList[#stat.index]" /></td>
			</tr>
		</s:iterator>	
		<tr>
		<td>&nbsp;</td>
		<td colspan="9">&nbsp;<input type="button" value="确认选择" OnClick="setSelectToOpener(this.form)" /></td>
		</tr>
	</table>
	</div>
	</form>
	</div>
</div>
</body>
</html>
