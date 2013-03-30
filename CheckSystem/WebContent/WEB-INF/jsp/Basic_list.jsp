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
	<div class="title font16h">基本信息</div>
    <div class="container">
<table border="0">
<tr>
<td width="10">&nbsp;</td>
<td>顾客名称：</td>
<td width="250"><s:property value="%{#request.SMGKINFO.userName}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>密码：</td>
<td width="250"><s:property value="%{#request.SMGKINFO.passWord}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>真实姓名:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.realName}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>所在省份:</td>
<td width="250"><s:property value="%{#request.PROVINCE}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>城市名称:</td>
<td width="250"><s:property value="%{#request.NAME}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>电话号码:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.telephone}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>手机号码:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.mobile}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>出生日期:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.birthDay}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>性别:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.sex}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>民族:</td>
<td width="250"><s:property value="%{#request.NATION}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>婚姻状况:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.marriAge}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>身高:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.stature}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>体重:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.avoirdupois}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>最高学历:</td>
<td width="250"><s:property value="%{#request.EDUCATION}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>专业:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.speciality}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>公司名称:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.company}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>公司所属行业:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.vocation}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>MSN帐号：</td>
<td width="250"><s:property value="%{#request.SMGKINFO.MSN}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>QQ帐号：</td>
<td width="250"><s:property value="%{#request.SMGKINFO.QQ}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>邮政编码:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.postCode}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>通讯地址:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.address}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>受教育情况:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.edu}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>兴趣爱好:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.interest}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>拥有设备:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.device}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>是否具备:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.possession}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>开户行:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.bank}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>银行账号:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.bankID}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>户名:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.bankUserName}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>注册状态:</td>
<td width="250"><s:property value="%{#request.REGSTATUS}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>身份证号码:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.idNumber}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>身份证文件名:</td>
<td width="250"><s:property value="%{#request.SMGKINFO.idFileName}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>文件类型:</td>
<td width="250"><s:property value="%{#request.FILETYPE}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>认证状态:</td>
<td width="250"><s:property value="%{#request.AUTHSTATUS}"/>&nbsp;</td>
</tr>
<tr>
<td width="10">&nbsp;</td>
<td>状态:</td>
<td width="250"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
</tr>

</table>
</div>
</div>
</body>
</html>

