<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回收站管理</title>
<script type="text/javascript">
	function updatePanel(num)
	{
		var url = 'ajaxRecycled.do';
		var pars = 'num='+num;
		var id = $('id').value;
		if(id != '') {
			pars += '&id='+id;
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
		var html = '<table border="0" width="100%" cellspacing="3" cellpadding="2">'
		var length = o.pageList.length;
		html +='<tr><td width="100">编号</td><td width="200">名称</td><td width="100">操作</td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].id+'</td>';
			html += '<td>'+o.pageList[i].name+'</td>';	
			html += '<td><input type="button" onClick="ConfirmButton(\'editRecycledInputs.do?type='+o.pageList[i].type+'&id='+o.pageList[i].id+'\',\'是否确认恢复正常!\');" value="恢复">';
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
	function ConfirmButton(url,altText)	{
		if(confirm(altText)){
			location.href=url;
		}
	}	
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">回收站管理</div>
  <div class="container">	
<div id="tablecontent">
	<s:form action="listRecycled">		
		<s:if test="#request.DELLIST !=null">
			<s:select list="%{#request.DELLIST}" label="菜单列表" name="id" value="#request.DELTYPE"></s:select>
		</s:if>
		<s:else>
			<s:select list="%{}" name="id" label="菜单列表"></s:select>
		</s:else>
		<s:submit value="查询"></s:submit>
	</s:form>
	<table border="0" width="100%" cellspacing="3" cellpadding="2">
		<tr>
			<td width="100">编号</td>
			<td width="200">名称</td>
			<td width="100">操作</td>
		</tr>
		<s:iterator value="%{pageList}">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td>
					<input type="button" onClick="ConfirmButton('recoverRecycled.do?type=<s:property value="type"/>&id=<s:property value="id"/>','是否确认恢复正常!');" value="恢复"> 
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