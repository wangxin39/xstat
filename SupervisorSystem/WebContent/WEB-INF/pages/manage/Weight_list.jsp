<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查问卷权重管理</title>
<script type="text/javascript">
function updatePanel(num)
	{
		//请求的地址
		var url = 'ajaxWeight.do';
		var pars = 'num='+num;
		var inquisitionID = $('inquisitionID').value;
		if(inquisitionID != '') {
			pars += '&inquisitionID='+inquisitionID;
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
		html +='<tr><td class=\"ttitle\"><strong class=\"font12red\">编号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">调查问卷</strong></td><td class=\"ttitle\"><strong class=\"font12red\">部分</strong></td><td class=\"ttitle\"><strong class=\"font12red\">部分问题</strong></td><td class=\"ttitle\"><strong class=\"font12red\">选项信息</strong></td><td class=\"ttitle\"><strong class=\"font12red\">分数</strong></td><td class=\"ttitle\"><strong class=\"font12red\">操作</strong></td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].selectWeightID+'&nbsp;</td>';
			html += '<td>'+o.inquisitionList[i]+'&nbsp;</td>';	
			html += '<td>'+o.partList[i]+'&nbsp;</td>';	
			html += '<td><a href="#" OnClick="javascript:showDetail(\''+o.pageList[i].selectWeightID+'\')">'+o.questionList[i]+'</a>&nbsp;</td>';	
			html += '<td>'+o.selectList[i]+'&nbsp;</td>';	
			html += '<td>'+o.pageList[i].weight+'&nbsp;</td>';	
			html += '<td><input type="button" onClick="ConfirmButton(\'editWeightInput.do?selectWeightID='+o.pageList[i].selectWeightID+'\',\'是否确认修改权重信息!\');" value="修改">';
			html += '<input type="button" onClick="ConfirmButton(\'deleteWeightProcess.do?selectWeightID='+o.pageList[i].selectWeightID+'\',\'是否确认删除权重信息!\');" value="删除">';
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
	function showDetail(id) {
		window.open('detailWeightStore.do?selectWeightID='+id,'详细信息','width=500,height=400,scrollbars=yes,status=yes,left=100,top=100');		
	}
	function GoURL(urlStr)	{
		location.href=urlStr;
	}		
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">调查问卷权重管理</div>
  <div class="container">	
		<s:form action="listWeight.do">
		<tr>
		<td class="tdLabel"><label class="label">调查问卷:</label></td>
		<td>		
		<s:if test="null != #session.INQUISITIONLIST">
		<s:select id="inquisitionID" label="调查问卷" list="%{#session.INQUISITIONLIST}" name="inquisitionID" listKey="inquisitionID" listValue="title" headerKey="-1" theme="simple"></s:select>
		</s:if>
		<s:else>
		<s:select id="inquisitionID" label="调查问卷" name="inquisitionID" list="{}" theme="simple"></s:select>
		</s:else>
		<s:submit value="查询" theme="simple"></s:submit>
		</td>
		</tr>		
	</s:form>
    <table width="100%" border="0" cellspacing="10">
    	<tr>
     	  <td align="right"><input type="button" name="button" value="增加新的权重" class="button" onclick="GoURL('addWeightInputs.do');"/>
     	    &nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
    </table>
	<div id="tablecontent">
	<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr>
			<td class="ttitle"><strong class="font12red">编号</strong></td>
			<td class="ttitle"><strong class="font12red">调查问卷</strong></td>
			<td class="ttitle"><strong class="font12red">部分</strong></td>
			<td class="ttitle"><strong class="font12red">部分问题</strong></td>
			<td class="ttitle"><strong class="font12red">选项信息</strong></td>
			<td class="ttitle"><strong class="font12red">分数</strong></td>
			<td class="ttitle"><strong class="font12red">操作</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td><s:property value="selectWeightID" />&nbsp;</td>
				<td><s:property value="inquisitionList[#stat.index]" />&nbsp;</td>
				<td><s:property value="partList[#stat.index]" />&nbsp;</td>
				<td><a href="#" OnClick="javascript:showDetail('<s:property value="selectWeightID"/>')"><s:property value="questionList[#stat.index]" /></a>&nbsp;</td>
				<td><s:property value="selectList[#stat.index]" />&nbsp;</td>
				<td><s:property value="weight" />&nbsp;</td>
				<td>
					<input type="button" onClick="ConfirmButton('editWeightInput.do?selectWeightID=<s:property value="%{selectWeightID}"/>','是否确认修改权重信息!');" value="修改">
					<input type="button" onClick="ConfirmButton('deleteWeightProcess.do?selectWeightID=<s:property value="%{selectWeightID}"/>','是否确认删除权重信息!');" value="删除">
				</td>
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