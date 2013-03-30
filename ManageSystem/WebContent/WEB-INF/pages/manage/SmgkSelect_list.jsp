<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘客管理</title>
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
		var list = form.smgkID;
		var i = getSelectedRadio(list);
		if(i != -1 ) {
			var newOpt = opener.document.form1.smgkID[0];
			var values = splitStr(list[i].value);	
			newOpt.text = values[1];
			newOpt.value = values[0];
			newOpt.selected = true;
							
			opener.document.form1.smgkID[0] = newOpt;	
		}else if(list.value != 'undefined'){
			var newOpt = opener.document.form1.smgkID[0];
			var values = splitStr(list.value);	
			newOpt.text = values[1];
			newOpt.value = values[0];
			newOpt.selected = true;
							
			opener.document.form1.smgkID[0] = newOpt;	
		}
		
		opener.popQuestionWindow.close();
		opener.popQuestionWindow = null;
	}		
	function updatePanel(num)
	{
		//请求的地址
		var url = 'ajaxSmgkSelect.do';
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
		html +='<tr style="background-color: #a8c5d9;"><td class=\"ttitle\"><strong class=\"font12red\">&nbsp;</strong></td><td class=\"ttitle\"><strong class=\"font12red\">登录名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">电子邮件</strong></td><td class=\"ttitle\"><strong class=\"font12red\">手机号码</strong></td><td class=\"ttitle\"><strong class=\"font12red\">顾客状态</strong></td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td><input type="radio" name="smgkID" id="smgkID" value='+o.pageList[i].userName+'/>,'+o.pageList[i].userName+'</td>';
			html += '<td>'+o.pageList[i].userName+'</td>';	
			html += '<td>'+o.pageList[i].email+'</td>';	
			html += '<td>'+o.pageList[i].mobile+'</td>';	
			html += '<td>'+o.statusList[i]+'&nbsp;</td>';
			html += '</tr>';				
		}
		html += '<tr><td>&nbsp;</td><td><input type="button" value="确认选择" OnClick="setSelectToOpener(this.form)" /></td></tr></table>';
		$('tablecontent').innerHTML = html;
		
		html = '第'+o.pu.currentPage+'页/总'+o.pu.totalPageNum+'页';
		html += '<input type="button" value="转到" onClick="javascript:jumpPage('+o.pu.totalPageNum+ ');"/>&nbsp;第<input type="text" name="num" size="5" id="num"/>页<br/>';
		$('pagination').innerHTML = html;
		
		// 分页数字
		html = '';
		length = o.pu.totalPageNum;
		for(i=1;i<=length;i++) {
			html += '[<a href="#" OnClick="javascript:updatePanel(\''+i+'\');">'+i+'</a>]';
			if(i%20 == 0 && i > 18) {
				html += '<br>';
			}else{
				html += '&nbsp;';
			}
		}
		$('page_link').innerHTML = html;	
	}	
	function jumpPage(pageTotal) {
		var num = $('num').value;
		if(num >= 1 && num <= pageTotal) {
			updatePanel(num);					
		}else{
			alert("您要跳转的页面不存在.");	
		}
	}	
	function ConfirmButton(url,altText)	{
		if(confirm(altText)){
			location.href=url;
		}
	}
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">选择神秘客</div>
  <div class="container">	
	<form action="listSmgkSelect.do">
	<div id="tablecontent">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr style="background-color: #a8c5d9;">
			<td>&nbsp;</td>
			<td class="ttitle"><strong class="font12red">登录名称</strong></td>
			<td class="ttitle"><strong class="font12red">电子邮件</strong></td>
			<td class="ttitle"><strong class="font12red">手机号码</strong></td>
			<td class="ttitle"><strong class="font12red">顾客状态</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td><input type="radio" name="smgkID" id="smgkID" value="<s:property value="smgkID" />,<s:property value="userName" />">&nbsp;<s:property value="smgkID" /></td>
				<td><s:property value="userName" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="mobile" /></td>
				<td><s:property value="statusList[#stat.index]" /></td>
			</tr>
		</s:iterator>	
		<tr>
		<td>&nbsp;</td>
		<td colspan="9">&nbsp;<input type="button" value="确认选择" OnClick="setSelectToOpener(this.form)" /></td>
		</tr>
	</table>
	</div>
	</form>
	<div id="pagination">
第<s:property value="pu.currentPage"/>页/总<s:property value="pu.totalPageNum" />页
	
	<input type="button" value="转到" onClick="javascript:jumpPage('<s:property value="pu.totalPageNum" />');"/>&nbsp;第<input type="text" name="num" size="5" id="num"/>页<br/>
	</div>
	<table border="0">
	<tr>
	<td>
	<div id="page_link">
	<s:bean name="org.apache.struts2.util.Counter" id="counter">
	   <s:param name="first" value="0" />
	   <s:param name="last" value="%{(pu != null && pu.totalPageNum > 1) ? (pu.totalPageNum-1) : 0}" />
	   <s:iterator>
		[<a href="#" onClick="javascript:updatePanel('<s:property value="current"/>','<s:property value="pu.totalRecordNum" />');"><s:property value="current"/></a>]
		<s:if test="(current%20) == 0 and current > 18"><br/></s:if>
		<s:else>&nbsp;</s:else>
	   </s:iterator>
	</s:bean>
	</div>
	</td>
	</tr>
	</table>
	</div>
</div>
</body>
</html>
