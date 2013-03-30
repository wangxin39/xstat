<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导出管理</title>
<script type="text/javascript">
	function updatePanel(num)
	{
		//请求的地址
		var url = 'ajaxOutput.do';
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
		var html = '<table border="0" width="100%" cellspacing="3" cellpadding="2">';
		var length = o.pageList.length;
		html +='<tr><td class=\"ttitle\"><strong class=\"font12red\">导出编号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">文件名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">客户名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">文件类型</strong></td><td class=\"ttitle\"><strong class=\"font12red\">存储路径</strong></td><td class=\"ttitle\"><strong class=\"font12red\">添加时间</strong></td><td class=\"ttitle\"><strong class=\"font12red\">状态</strong></td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].outputID+'</td>';
			html += '<td><a href="#" OnClick="javascript:showDetail(\''+o.pageList[i].outputID+'\')">'+o.pageList[i].fileName+'</a></td>';	
			html += '<td>'+o.clientList[i]+'</td>';	
			html += '<td>'+o.typeList[i]+'</td>';
			html += '<td>'+o.pageList[i].savePath+'</td>';
			html += '<td>'+o.pageList[i].makeTime+'</td>';
			html += '<td>'+o.statusList[i]+'</td></tr>';				
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
	function selectClient(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'ajaxOutput.do';
		
		var issueID = opt.value;//获取传入的客户值
		
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
		var html = '<select name=\'informantID\' id=\'informantID\'>';
		var length = o.informantInfoList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.informantInfoList[i].informantID+'>'+o.informantInfoList[i].name+'</option>';
		}
		html += '</select>';
		$('informant').innerHTML = html;
	}	
	function showDetail(id) {
		window.open('detailOutputStore.do?outputID='+id,'详细信息','width=500,height=400,scrollbars=yes,status=yes,left=100,top=100');		
	}	
	function GoURL(urlStr)	{
		location.href=urlStr;
	}		
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">导出管理</div>
  <div class="container">	
	<s:form action="listOutput.do">
		<tr>
		<td class="tdLabel"><label class="label">期次:</label></td>
		<td>
		<s:if test="null != #session.ISSUELIST">
		<s:select label="期次" list="%{#session.ISSUELIST}" name="issueID" value="%{#request.ISSUESELECT.issueID}" listKey="issueID" listValue="issue" onchange="selectClient(this);" theme="simple" headerKey="-1"></s:select>
		</s:if>
		<s:else>
		<s:select label="期次" name="issueID" theme="simple" list="{}" ></s:select>
		</s:else>
		</td>
		</tr>
		<tr>
		<td class="tdLabel"><label class="label">调查对象:</label></td>
		<td>
		<div id="informant">
		<s:if test="null != #session.INFORSELECT">
		<s:select id="informantID" label="调查对象" list="%{#session.INFORSELECT}" name="informantID" listKey="informantID" listValue="name" headerKey="-1" theme="simple"></s:select>
		</s:if>
		<s:else>
		<s:select id="informantID" label="调查对象" name="informantID" list="{}" theme="simple"></s:select>
		</s:else>
		</div>
		</td>
		</tr>
		<s:submit value="查询"></s:submit>
	</s:form>
<div id="tablecontent">
	<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr>
			<td class="ttitle"><strong class="font12red">导出编号</strong></td>
			<td class="ttitle"><strong class="font12red">文件名称</strong></td>
			<td class="ttitle"><strong class="font12red">客户名称</strong></td>
			<td class="ttitle"><strong class="font12red">文件类型</strong></td>
			<td class="ttitle"><strong class="font12red">存储路径</strong></td>
			<td class="ttitle"><strong class="font12red">添加时间</strong></td>
			<td class="ttitle"><strong class="font12red">状态</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td><s:property value="outputID"/></td>
				<td><a href="#" OnClick="javascript:showDetail('<s:property value="outputID"/>')"><s:property value="fileName"/></a></td>
				<td><s:property value="clientList[#stat.index]"/></td>
				<td><s:property value="fileType"/></td>
				<td><s:property value="savePath"/></td>
				<td><s:property value="makeTime"/></td>
				<td><s:property value="statusList[#stat.index]"/></td>
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
