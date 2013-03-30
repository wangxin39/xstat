<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘顾客管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value="/css/style.css"/>" media="all"/>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/ext-all.css"/>"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
<script type="text/javascript">
	function checkLoginName() {
		var name = $('loginName').value;
		//请求的地址
		var url = 'checkRegister.do';
		var pars = 'loginName='+name;
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:pars,
			//指定回调函数
			onComplete: checkResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
	function checkResponse(response) {
		var o = response.responseText.evalJSON(true);
		if(!o.isRegister) {
			alert("该用户不存在，可以注册此用户!");
			$('isRegister').value="false";
		}else{
			alert("该用户已存在，请重新输入!");
			$('isRegister').value="true";
		}
	}

	function refresh(){
		document.getElementById("authImg").src='authImage.do?now='+new Date();
	}
	function goUrl() {
		location.href="admin";
	}
	
	function selectProvince(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectProvince.do';
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
	
	function check(frm){
		if(frm.isRegister.value) {
			frm.loginName.focus();
			alert("此用户名称已存在，请重试！");
			return false;
		}
		return true;
	}		
</script>
</head>

<body>
	
<div class="cright">
	<div class="title font16h">神秘顾客注册</div>
    <div class="container">
<s:form action="addRegProcess" name="From1" onsubmit="return check(frm);" method="post">
<s:textfield id="loginName" label="用户名称" name="loginName"></s:textfield>
<tr>
<td>&nbsp;</td>
<td><input type="button" value="检查用户名" onclick="checkLoginName()">
<input type="hidden" name="isRegister" id="isRegister" value="true">
</td>
</tr>
<s:password label="用户密码" name="passWord"></s:password>
<s:password label="确认密码" name="confirm"></s:password>
<s:textfield label="真实名称" name="realName" ></s:textfield>
<s:radio label="性别" list="{'男','女'}" name="sex" value="男"></s:radio>
<s:datetimepicker label="出生日期" name="birthDay" displayFormat="yyyy-MM-dd" startDate="%{#session.TODAY}" toggleType="explode" value="today"></s:datetimepicker>
<s:textfield label="联系电话" name="telephone"></s:textfield>
<s:textfield label="手机号码" name="mobile"></s:textfield>
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
<s:select label="学历" list="%{#session.EDUCATION}" name="education" listValue="value" listKey="key"  headerKey="-1"></s:select>
<s:textfield label="验证码" name="authCode"></s:textfield>
<tr>
<td>&nbsp;</td>
<td><img src="authImage.do" id="authImg"/>&nbsp;&nbsp;看不清?<s:a href="#" onclick="refresh()">单击此处刷新</s:a></td>
</tr>
<tr>
<td>&nbsp;</td>
<td><s:submit value="提交" theme="simple"></s:submit><s:reset value="重置" theme="simple"/>&nbsp;<input type="button" value="登陆" onclick="goUrl()"></td>
</tr>
</s:form>
</div>
</div>

</body>
</html>

