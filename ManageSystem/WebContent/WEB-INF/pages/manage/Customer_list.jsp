<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘客管理</title>
<script type="text/javascript">
	function updatePanel(num)
	{
		var url = 'ajaxCustomer.do';
		var pars = 'num='+num;
		var RegStatus = $('RegStatus').value;
		if(RegStatus != '') {
			pars += '&RegStatus='+RegStatus;
		}
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
		html +='<tr><td class=\"ttitle\"><strong class=\"font12red\">编号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">用户</strong></td><td class=\"ttitle\"><strong class=\"font12red\">城市</strong></td><td class=\"ttitle\"><strong class=\"font12red\">真实姓名</strong></td><td class=\"ttitle\"><strong class=\"font12red\">登陆密码</strong></td><td class=\"ttitle\"><strong class=\"font12red\">操作</strong></td></tr>';
			for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].smgkID+'</td>';
			html += '<td><a href="#" OnClick="javascript:showDetail(\''+o.pageList[i].smgkID+'\')">'+o.pageList[i].userName+'</a></td>';
			html += '<td>'+o.cityList[i]+'</td>';
			html += '<td>'+o.pageList[i].realName+'</td>';
			html += '<td>'+o.pageList[i].passWord+'</td>';
			html += '<td>';
			if(o.pageList[i].authStatus == 1) {
				html += '<input type="button" onClick="ConfirmButton(\'editAuditCustomerProcess.do?smgkID='+o.pageList[i].smgkID+'\',\'是否确认审核通过神秘顾客!\');" value="审核"/>';
			}
			html += '&nbsp;<input type="button" onClick="ConfirmButton(\'deleteCustomerProcess.do?smgkID='+o.pageList[i].smgkID+'\',\'是否确认删除神秘顾客信息!\');" value="删除"/>';
			html += '</td></tr>';
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
	function showDetail(id) {
		window.open('detailCustomerStore.do?smgkID='+id,'详细信息','width=500,height=400,scrollbars=yes,status=yes,left=100,top=100');		
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
  <div class="title font16h">神秘客管理</div>
  <div class="container">	
	<s:form action="listCustomer">
	<s:if test="#session.SMGKSTATUSDICT != null">
	<s:select list="%{#session.SMGKSTATUSDICT}" name="regStatus" label="注册状态"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" name="regStatus" label="注册状态"></s:select>
	</s:else>
	<s:submit value="查询"></s:submit>
	</s:form>
	<div id="tablecontent">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr>
			<td class="ttitle"><strong class="font12red">编号</strong></td>
			<td class="ttitle"><strong class="font12red">用户名称</strong></td>
			<td class="ttitle"><strong class="font12red">城市名称</strong></td>
			<td class="ttitle"><strong class="font12red">真实姓名</strong></td>
			<td class="ttitle"><strong class="font12red">登录密码</strong></td>
			<td class="ttitle"><strong class="font12red">操作</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td><s:property value="smgkID" /></td>
				<td><a href="#" OnClick="javascript:showDetail('<s:property value="smgkID"/>')"><s:property value="userName" /></a></td>
				<td><s:property value="cityList[#stat.index]" /></td>
				<td><s:property value="realName" /></td>
				<td><s:property value="passWord" /></td>
				<td>
					<s:if test="authStatus == 1">
						<input type="button" onClick="ConfirmButton('editAuditCustomerProcess.do?smgkID=<s:property value="%{smgkID}"/>','是否确认审核通过神秘顾客!');" value="审核"> 
					</s:if>
					<input type="button" onClick="ConfirmButton('deleteCustomerProcess.do?smgkID=<s:property value="%{smgkID}"/>','是否确认删除神秘顾客信息!');"	value="删除"> 
				</td>
			</tr>
		</s:iterator>
	</table>
	</div>
	<div id="pagination">
	第<s:property value="pu.currentPage"/>页/
	总<s:property value="pu.totalPageNum" />页  
	
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