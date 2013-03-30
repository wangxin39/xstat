<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频管理</title>
<script type="text/javascript">
	function updatePanel(num){
		//请求的地址
		var url = 'ajaxVideo.do';
		var pars = 'num='+num;
		var clientID = $('clientID').value;
		if(clientID != '') {
			pars += '&clientID='+clientID;
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
    function processResponse(response){
		var o = response.responseText.evalJSON(true);
		var html = '<table  width=\"100%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" bordercolor=\"#FFFFFF\" bgcolor=\"#cccccc\">';
		var length = o.pageList.length;
		html +='<tr><td class=\"ttitle\"><strong class=\"font12red\">编号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">添加时间</strong></td><td class=\"ttitle\"><strong class=\"font12red\">状态</strong></td><td class=\"ttitle\"><strong class=\"font12red\">操作</strong></td></tr>';
		for(i=0;i<length;i++){
			var addTime = o.pageList[i].addTime;
			var index = addTime.split("T");
			var times = index[0];
			html += '<tr><td>'+o.pageList[i].videoID+'</td>';
			html += '<td><a href="#" OnClick="javascript:showDetail(\''+o.pageList[i].videoID+'\')">'+o.pageList[i].name+'</a></td>';
			html += '<td>'+times+'</td>';
			html += '<td>'+o.statusList[i]+'&nbsp;</td>';
			html += '<td><input type="button" onClick="ConfirmButton(\'editVideoInput.do?videoID='+o.pageList[i].videoID+',\'是否确认修改被视频信息!\');" value="修改">';
			html += '<input type="button" onClick="ConfirmButton(\'deleteVideoProcess.do?videoID='+o.pageList[i].videoID+',\'是否确认删除被视频信息!\');" value="删除">';
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
		window.open('detailVideoStore.do?videoID='+id,'详细信息','width=500,height=400,scrollbars=yes,status=yes,left=100,top=100');		
	}	
		function selectClient(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectVideo.do';
		
		var cID = opt.value;//获取传入的客户值
		
		var pars = 'clientID='+cID;
		
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
		
		//需要更新的内容
		var html = '<select name=\'informantID\' id=\'informantID\'>';
		var length = o.inforList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.inforList[i].informantID+'>'+o.inforList[i].name+'</option>';
		}
		html += '</select>';
		$('informant').innerHTML = html;
	}	
	function GoURL(urlStr)	{
		location.href=urlStr;
	}	
</script>

</head>

<body>
<div class="cright">
  <div class="title font16h">视频管理</div>
  <div class="container">	
	    <table width="100%" border="0" cellspacing="10">
	    	<tr>
	     	  <td align="right"><input type="button" name="button" value="增加新的视频" class="button" onclick="GoURL('addVideoInputs.do');"/>
	     	    &nbsp;&nbsp;&nbsp;&nbsp;</td>
	      </tr>
	    </table>
	<s:form action="listVideo.do">
	<tr>
	<td>
	<label class="label">客户名称:</label>
	<s:if test="#session.GLOBALCLIENTINFOLIST!=null">
	<s:select list="%{#session.GLOBALCLIENTINFOLIST}" label="客户名称" name="clientID" value="%{#request.CLIENTVALUE}" listValue="company" listKey="clientID" onchange="selectClient(this);" theme="simple" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" label="客户名称" name="clientID" theme="simple"></s:select>
	</s:else>
	<label class="label">调查对象:</label>
	<div id="informant">
	<s:if test="null != #session.INFORMANTLIST">	
	<s:select id="informantID" label="调查对象" list="%{#session.INFORMANTLIST}" name="informantID" listValue="name" listKey="informantID" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查对象" list="{}" name="informantID" theme="simple"></s:select>
	</s:else>
	</div>
	<s:submit value="查询" theme="simple"></s:submit>
	</td>
	</tr>
	</s:form>
	<div id="tablecontent">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr>
			<td class="ttitle"><strong class="font12red">编号</strong></td>
			<td class="ttitle"><strong class="font12red">名称</strong></td>
			<td class="ttitle"><strong class="font12red">添加时间</strong></td>
			<td class="ttitle"><strong class="font12red">状态</strong></td>
			<td class="ttitle"><strong class="font12red">操作</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td><s:property value="videoID"/></td>
				<td><a href="#" OnClick="showDetail('<s:property value="videoID"/>')"><s:property value="name"/></a></td>
				<td><s:date name="addTime" format="yyyy-MM-dd"/></td>
				<td><s:property value="statusList[#stat.index]"/></td>
				<td>
					<input type="button" onClick="ConfirmButton('editVideoInput.do?videoID=<s:property value="%{videoID}"/>','是否确认修改被视频信息!');" value="修改">
				    <input type="button" onClick="ConfirmButton('deleteVideoProcess.do?videoID=<s:property value="%{videoID}"/>','是否确认删除被视频信息!');" value="删除">
				</td>
			</tr>
		</s:iterator>
	</table>
	</div>
	<div id="pagination">
第<s:property value="pu.currentPage"/>页/总<s:property value="pu.totalPageNum" />页		
		<input type="button" value="转到" onClick="jumpPage('<s:property value="pu.totalPageNum" />');"/>&nbsp;第<input type="text" name="num" size="5" id="num"/>页<br/>
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