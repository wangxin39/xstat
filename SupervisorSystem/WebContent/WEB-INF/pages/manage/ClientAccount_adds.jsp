<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户帐户管理</title>
<script type="text/javascript">

	function selectProvince(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectClientAccount.do';
		var province = opt.value;//获取传入的省份值
		var pars = 'province='+province;
		
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
		// 字符转译 表示还没有结束
		//需要更新的城市内容
	
		var html = '<select name=\'cityID\' id=\'cityID\'>';
		var length = o.cityList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.cityList[i].cityID+'>'+o.cityList[i].name+'</option>';
		}
		html += '</select>';
		$('cityInfo').innerHTML = html;
	}	
	function selectClient(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectClientAccount.do';
		
		var clientID = opt.value;//获取传入的客户值
		
		var pars = 'clientID='+clientID;
		
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
		var length = o.inList.length;
		for(i=0;i<length;i++){
			html += '<option value='+o.inList[i].informantID+'>'+o.inList[i].name+'</option>';
		}
		html += '</select>';
		$('informant').innerHTML = html;
	}	

</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加客户帐户</div>
  <div class="container">	
	<s:actionmessage/>
	<s:actionerror/>
	<s:form action="addClientAccountProcess" namespace="/manage" method="post">
	<s:textfield label="帐户名称" name="clientName"></s:textfield>
	<s:textfield label="登录名称" name="loginName"></s:textfield>
	<s:password label="密码" name="passWord"></s:password>
	<tr>
	<td class="tdLabel"><label class="label">客户名称:</label></td>
	<td>
	<s:if test="null != #session.GLOBALCLIENTINFOLIST">
	<s:select list="%{#session.GLOBALCLIENTINFOLIST}" label="客户名称" name="clientID" listValue="company" value="%{#session.CLIENTVALUE}" listKey="clientID" onchange="selectClient(this);" theme="simple"></s:select>
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
	<s:select list="%{#session.INFORMANTLIST}" label="调查对象" name="informantID" value="%{#session.INFORMANTVALUE}" listValue="name" listKey="informantID" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" label="调查对象" name="informantID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<s:if test="null != #session.ACCOUNTTYPE">
	<s:select list="%{#session.ACCOUNTTYPE}" label="帐号类型" name="type"></s:select>
	</s:if>

	<s:if test="null != #session.COUNTRY">
	<s:select list="%{#session.COUNTRY}" label="国家" name="country"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" label="国家" name="country"></s:select>
	</s:else>
	<tr>
	<td class="tdLabel"><label class="label">所在省份:</label></td>
	<td>
	<s:if test="null != #session.PROVINCELIST">
	<s:select id="province" list="%{#session.PROVINCELIST}" label="所在省份" name="province" value="%{#session.PROVINCE}" onchange="selectProvince(this);" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="province" list="{}" label="所在省份" name="province" theme="simple"></s:select>
	</s:else>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">城市名称:</label></td>
	<td>
	<div id="cityInfo">
	<s:if test="null != #session.CITYLIST">
	<s:select id="cityID" list="%{#session.CITYLIST}" label="城市名称" name="cityID" value="%{#session.CITYVALUE}" listKey="cityID" listValue="name" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="cityID" list="{}" label="城市名称" name="cityID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>
	<s:textfield label="电话号码" name="telephone"></s:textfield>
	<s:textfield label="手机号码" name="mobile"></s:textfield>
	<s:if test="#request.FATHERINFOLIST != null">
	<s:select list="%{#request.FATHERINFOLIST}" label="上级编号" name="fatherID" listValue="clientName" listKey="accountID"></s:select>
	</s:if>
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

