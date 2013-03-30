<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调查对象管理</title>
<script type="text/javascript">
function selectProvince(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectInformant.do';
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
</script>
<s:head theme="ajax"/></head>

<body>
<div class="cright">
  <div class="title font16h">添加调查对象信息</div>
  <div class="container">	
	<s:form action="addInformantProcess" namespace="/manage" method="post">
	<s:actionerror/>
<s:actionmessage/>
	<s:if test="#session.GLOBALCLIENTINFOLIST != null">
	<s:select list="%{#session.GLOBALCLIENTINFOLIST}" label="客户名称" name="clientID" listValue="company" listKey="clientID" headerKey="-1"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" label="客户名称" name="clientID"></s:select>
	</s:else>
	<s:textfield label="中文名称" name="name"></s:textfield>
	<s:textfield label="英文名称" name="englishName"></s:textfield>
	<s:textfield label="中文别名" name="aliasName"></s:textfield>
	<s:textfield label="英文别名" name="englishAliasName"></s:textfield>
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
	<s:textfield label="联系电话" name="telephone"></s:textfield>
	<s:textfield label="手机" name="mobile"></s:textfield>
	<s:textfield label="电子邮件" name="email"></s:textfield>
	<s:textfield label="地址" name="address"></s:textfield>
	<s:textfield label="邮编" name="postCode"></s:textfield>
	<s:textfield label="服务语言" name="serviceLang"></s:textfield>
	<s:textfield label="服务类型" name="serviceType"></s:textfield>
	<s:textfield label="片区" name="area"></s:textfield>
	
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


