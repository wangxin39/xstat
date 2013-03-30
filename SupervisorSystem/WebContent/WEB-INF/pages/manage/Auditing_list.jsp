<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核注册</title>
<script type="text/javascript">
function updatePanel(num)
	{
		//请求的地址
		var url = 'ajaxAuditing.do';
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
		var html = '<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">';
		var length = o.pageList.length;
		html +='<tr><td class=\"ttitle\"><strong class=\"font12red\">编号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">公司名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">帐号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">描述</strong></td><td>操作</td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].clientID+'</td>';
			html += '<td><a href="#" OnClick="javascript:showDetail(\''+o.pageList[i].clientID+'\')">'+o.pageList[i].company+'</a></td>';	
			html += '<td>'+o.pageList[i].account+'</td>';	
			html += '<td>'+o.pageList[i].description+'&nbsp;</td>';
			html += '<td><a href="editClientInput.do?clientID='+o.pageList[i].clientID+'">编辑</a></td></tr>';				
		}
		html += '</table>';
		$('tablecontent').innerHTML = html;
		//页数信息	
	
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
	function GoURL(urlStr)	{
		location.href=urlStr;
	}		
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">审核注册</div>
  <div class="container">	
<div id="tablecontent">
	<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr>
			<td class="ttitle"><strong class="font12red">报告编号</strong></td>
			<td class="ttitle"><strong class="font12red">问卷标题</strong></td>
			<td class="ttitle"><strong class="font12red">报告名称</strong></td>
			<td class="ttitle"><strong class="font12red">报告类型</strong></td>
			<td class="ttitle"><strong class="font12red">描述</strong></td>
			<td class="ttitle"><strong class="font12red">报告语言</strong></td>
			<td class="ttitle"><strong class="font12red">添加时间</strong></td>
			<td class="ttitle"><strong class="font12red">操作</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td ><s:property value="reportID" /></td>
				<td ><s:property value="list[#stat.index]" />&nbsp;</td>
				<td ><s:property value="title" />&nbsp;</td>
				<td ><s:property value="typeList[#stat.index]" />&nbsp;</td>
				<td ><s:property value="description" />&nbsp;</td>
				<td ><s:property value="languageList[#stat.index]" />&nbsp;</td>
				<td ><s:date format="yyyy-MM-dd HH:mm:ss" name="addTime" />&nbsp;</td>
				<td >
					<input type="button" onClick="ConfirmButton('editReportInput.do?reportID=<s:property value="%{reportID}"/>','是否确认修改报告信息!');"	value="修改">
					<input type="button" onClick="ConfirmButton('deleteReportProcess.do?reportID=<s:property value="%{reportID}"/>','是否确认删除报告信息!');" value="删除">
				</td>
			</tr>
		</s:iterator>
	</table>
</div>
	
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
