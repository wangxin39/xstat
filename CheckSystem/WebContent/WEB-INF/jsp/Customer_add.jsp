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
</head>

<body>
<div class="cright">
	<div class="title font16h">增加信息</div>
    <div class="container">
<s:form action="addCustomerProcess" >
<s:textfield label="用户名称" name="userName"></s:textfield>
<s:password label="登录密码" name="passWord"></s:password>
<s:textfield label="电子邮件" name="email"></s:textfield>
<s:select label="选择城市" list="%{#request.CITYSELECT}" name="cityID" listValue="name" listKey="cityID"  headerKey="-1"></s:select>
<s:select label="性别" list="{'男性','女性'}" name="sex" headerKey="-1"></s:select>
<s:select list="%{#request.PROVINCE}" label="所在省份" name="province"></s:select>
<s:textfield label="真实姓名" name="realName"></s:textfield>
<s:textfield label="电话号码" name="telephone"></s:textfield>
<s:textfield label="手机号码" name="mobile"></s:textfield>
<s:datetimepicker name="birthDay" label="出生日期" displayFormat="yyyy-MM-dd" startDate="%{#session.TODAY}" toggleType="explode" value="today"></s:datetimepicker>
<s:select label="民族" name="nation" list="%{#request.NATION}" headerKey="-1"></s:select>
<s:select label="婚姻状况" list="{'未婚','已婚'}" name="marriAge" headerKey="-1"></s:select>
<s:textfield label="身高" name="stature"></s:textfield>
<s:textfield label="体重" name="avoirdupois"></s:textfield>
<s:select list="%{#request.EDUCATION}" label="最高学历" name="education" headerKey="-1"></s:select>
<s:textfield label="专业" name="speciality"></s:textfield>
<s:textfield label="所属行业" name="vocation"></s:textfield>
<s:textfield label="职位名称" name="job"></s:textfield>
<s:textfield label="公司名称" name="company"></s:textfield>
<s:textfield label="邮政编码" name="postCode"></s:textfield>
<s:textfield label="QQ" name="QQ"></s:textfield>
<s:textfield label="MSN" name="MSN"></s:textfield>
<s:textfield label="通讯地址" name="address"></s:textfield>
<s:textfield label="教育程度" name="edu"></s:textfield>
<s:textfield label="兴趣爱好" name="interest"></s:textfield>
<s:textfield label="设备名称" name="device"></s:textfield>
<s:select label="是否具备" list="{'是','否'}" name="possession" headerKey="-1"></s:select>
<s:textfield label="开户行" name="bankID"></s:textfield>
<s:textfield label="银行名称" name="bank"></s:textfield>
<s:textfield label="银行帐号" name="bankUserName"></s:textfield>
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

