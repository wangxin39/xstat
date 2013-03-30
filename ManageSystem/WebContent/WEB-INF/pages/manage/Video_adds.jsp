<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频管理</title>
<script type="text/javascript">
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
</script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">添加视频信息</div>
  <div class="container">		
	<s:form action="addVideoProcess" namespace="/manage" method="post">
	<s:actionerror/>
<s:actionmessage/>
	<s:textfield label="连接地址" name="url"></s:textfield>
	<s:textfield label="名称" name="name"></s:textfield>
	<s:textfield name="englishName" label="英文名称"></s:textfield>
	<tr>
	<td class="tdLabel"><label class="label">客户名称:</label></td>
	<td>
	<s:if test="#session.GLOBALCLIENTINFOLIST!=null">
	<s:select list="%{#session.GLOBALCLIENTINFOLIST}" label="客户名称" name="clientID" value="%{#request.CLIENTVALUE}" listValue="company" listKey="clientID" onchange="selectClient(this);" theme="simple" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" label="客户名称" name="clientID" theme="simple"></s:select>
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">调查对象:</label></td>
	<td>
	<div id="informant">
	<s:if test="null != #session.INFORMANTLIST">	
	<s:select id="informantID" label="调查对象" list="%{#session.INFORMANTLIST}" name="informantID" listValue="name" listKey="informantID" headerKey="-1" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select label="调查对象" list="{}" name="informantID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	
	
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="增加" theme="simple"/>&nbsp;
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


