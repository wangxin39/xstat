<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申诉管理</title>
<script type="text/javascript">
function updatePanel(num)
	{
		//请求的地址
		var url = 'ajaxAppeal.do';
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
		html +='<tr><td class=\"ttitle\"><strong class=\"font12red\">申诉编号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">申诉名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">客户名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">员工名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">操作</strong></td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].reqID+'</td>';
			html += '<td><a href="#" OnClick="javascript:showDetail(\''+o.pageList[i].reqID+'\')">'+o.pageList[i].name+'</a></td>';
			html += '<td>'+o.clientAccountList[i]+'</td>';	
			html += '<td>'+o.employeeList[i]+'</td>';	
			html += '<td><input type="button" onClick="ConfirmButton(\'addAppealResultInputs.do?reqID='+o.pageList[i].reqID+'\',\'是否确认回复申诉信息!\');" value="回复"/>';
			html += '<input type="button" onClick="ConfirmButton(\'detailAppealResult.do?reqID='+o.pageList[i].reqID+'\',\'是否确认浏览申诉信息!\');" value="浏览"/></td></tr>';				
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
	function showDetail(id) {
		window.open('detailAppealStore.do?reqID='+id,'详细信息','width=500,height=400,scrollbars=yes,status=yes,left=100,top=100');		
	}
	function GoURL(urlStr)	{
		location.href=urlStr;
	}			
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">申诉管理</div>
  <div class="container">	
<div id="tablecontent">
	<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">	
		<tr>
			<td class="ttitle"><strong class="font12red">申诉编号</strong></td>
			<td class="ttitle"><strong class="font12red">申诉名称</strong></td>
			<td class="ttitle"><strong class="font12red">客户名称</strong></td>
			<td class="ttitle"><strong class="font12red">员工名称</strong></td>
			<td class="ttitle"><strong class="font12red">操作</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td><s:property value="reqID" /></td>
				<td><a href="#" OnClick="javascript:showDetail('<s:property value="reqID"/>')"><s:property value="name" /></a></td>
				<td><s:property value="clientAccountList[#stat.index]" /></td>
				<td><s:property value="employeeList[#stat.index]" /></td>
				<td>
					<input type="button" onClick="ConfirmButton('addAppealResultInputs.do?reqID=<s:property value="%{reqID}"/>','是否确认回复申诉信息!');" value="回复"/>
					<input type="button" onClick="ConfirmButton('detailAppealResult.do?reqID=<s:property value="%{reqID}"/>','是否确认浏览申诉信息!');" value="浏览"/>
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
