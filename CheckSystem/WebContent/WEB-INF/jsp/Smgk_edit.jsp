<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘顾客管理</title>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
<script type="text/javascript">
	function selectProvince(opt)
	{//这个方法中只能有两个参数(url,pars);
		//请求的地址
		var url = 'selectEdit.do';
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
</head>

<body>
<div class="cright">
	<div class="title font16h">修改信息</div>
    <div class="container">
<s:form action="editSmgkProcess" method="post">
<!--  
	<s:password label="用户密码" name="passWord" value="%{session.SMGKEDIT.passWord}"></s:password>
	<s:textfield label="真实名称" name="realName" value="%{session.SMGKEDIT.realName}"></s:textfield>
	<s:textfield label="联系电话" name="telephone" value="%{session.SMGKEDIT.telephone}"></s:textfield>
	<s:textfield label="手机号码" name="mobile" value="%{session.SMGKEDIT.mobile}"></s:textfield>
	<s:datetimepicker label="出生日期" name="birthDay" displayFormat="yyyy-MM-dd" startDate="%{#session.TODAY}" toggleType="explode" value="today"></s:datetimepicker>
	<s:radio label="性别" list="{'男','女'}" name="sex" value="%{session.SMGKEDIT.sex}"></s:radio>
	<tr>
	<td class="tdLabel"><label class="label">所在省份:</label></td>
	<td>
	<s:if test="null != #session.PROVINCELIST">
	<s:select id="province" list="%{#session.PROVINCELIST}" label="所在省份" name="province" value="%{session.SMGKEDIT.province}" onchange="selectProvince(this);" theme="simple"></s:select>
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
	<s:select id="cityID" list="%{#session.CITYLIST}" label="城市名称" name="cityID" value="%{session.SMGKEDIT.cityID}" listKey="cityID" listValue="name" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select id="cityID" list="{}" label="城市名称" name="cityID" theme="simple"></s:select>
	</s:else>
	</div>
	</td>
	</tr>-->
	<s:select label="学历" list="%{#session.EDUCATION}" name="education" listValue="value" listKey="key"  headerKey="-1" value="%{#session.SMGKEDIT.education}"></s:select>
	<s:select label="民族" list="%{#session.NATION}" name="nation" value="%{#session.SMGKEDIT.nation}"></s:select>
	<s:textfield label="身高" name="stature" value="%{#session.SMGKEDIT.stature}"></s:textfield>
	<s:textfield label="体重" name="avoirdupois" value="%{#session.SMGKEDIT.avoirdupois}"></s:textfield>
	<s:textfield label="专业" name="speciality" value="%{#session.SMGKEDIT.speciality}"></s:textfield>
	<s:select label="婚姻状况" list="{'未婚','已婚'}" name="marriAge" value="%{#session.SMGKEDIT.marriAge}"></s:select>
	<td><s:textfield label="受教育情况" name="edu" value="%{#session.SMGKEDIT.edu}"></s:textfield>
    <s:textfield label="公司名称" name="company" value="%{#session.SMGKEDIT.company}"></s:textfield>
	<s:textfield label="公司所属行业" name="vocation" value="%{#session.SMGKEDIT.vocation}"></s:textfield>
	<s:textfield label="职位" name="job" value="%{#session.SMGKEDIT.job}"></s:textfield>
	<s:textfield label="邮编" name="postCode" value="%{#session.SMGKEDIT.postCode}"></s:textfield>
	<s:textfield label="通讯地址" name="address" value="%{#session.SMGKEDIT.address}"></s:textfield>
	<s:textfield label="QQ" name="qq" value="%{#session.SMGKEDIT.qq}"></s:textfield>
	<s:textfield label="MSN" name="msn" value="%{#session.SMGKEDIT.msn}"></s:textfield>
	<s:textfield label="兴趣爱好" name="interest" value="%{#session.SMGKEDIT.interest}"></s:textfield>
	<s:textfield label="拥有设备" name="device" value="%{#session.SMGKEDIT.device}"></s:textfield>
	<s:select label="是否具备" list="{'是','否'}" name="possession" value="%{#session.SMGKEDIT.possession}"></s:select>
	<s:textfield label="开户行" name="bank" value="%{#session.SMGKEDIT.bank}"></s:textfield>
	<s:textfield label="银行账号" name="bankID" value="%{#session.SMGKEDIT.bankID}"></s:textfield>
	<s:textfield label="户名" name="bankUserName" value="%{#session.SMGKEDIT.bankUserName}"></s:textfield>
<tr>
<td>&nbsp;</td>
<td align="right"><s:submit value="提交" theme="simple"/>&nbsp;
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

