<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神秘客管理</title>
<link type="text/css" rel="stylesheet" href="<s:url value='/css/style.css' encode='false' includeParams='none'/>" media="all"/>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.2.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">神秘客详细信息</div>
  <div class="container">	
	<table border="0" align="left" cellspacing="3" cellpadding="2">
	<tr>
	<td align="left">神秘客名称：</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.userName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">登录密码:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.passWord}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">所在省份:</td>
	<td align="left"><s:property value="%{#request.PROVINCE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">城市名称:</td>
	<td align="left"><s:property value="%{#request.NAME}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">真实姓名:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.realName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">电话号码:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.telephone}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">手机号码:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.mobile}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">出生日期:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.birthDay}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">性别:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.sex}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">民族:</td>
	<td align="left"><s:property value="%{#request.NATION}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">婚姻状况:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.marriAge}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">身高:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.stature}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">体重:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.avoirdupois}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">最高学历:</td>
	<td align="left"><s:property value="%{#request.EDUCATION}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">专业:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.speciality}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">所属行业:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.vocation}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">职位名称:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.job}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">MSN帐号：</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.MSN}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">QQ帐号：</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.QQ}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">公司名称:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.company}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">邮政编码:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.postCode}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">通讯地址:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.address}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">教育程度:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.edu}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">兴趣爱好:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.interest}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">设备名称:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.device}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">是否具备:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.possession}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">开户行:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.bank}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">户名:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.bankUserName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">银行帐号:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.bankID}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">注册时间:</td>
	<td align="left"><s:date name="%{#request.SMGKINFO.regTime}" format="yyyy-MM-dd"/></td>
	</tr>
	<tr>
	<td align="left">验证码字符串:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.code}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">身份证号码:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.idNumber}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">身份证文件名称:</td>
	<td align="left"><s:property value="%{#request.SMGKINFO.idFileName}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">文件类型:</td>
	<td align="left"><s:property value="%{#request.TYPE}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">验证状态:</td>
	<td align="left"><s:property value="%{#request.AUTHSTATUS}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">注册状态:</td>
	<td align="left"><s:property value="%{#request.REGSTATUS}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">状态:</td>
	<td align="left"><s:property value="%{#request.STATUS}"/>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">
	<input type="button" value="关闭" onClick="ClosePage()"/>
	<script type="text/javascript">
	function ClosePage() {
		window.close();
	}
	</script>
	</td>
	</tr>
	</table>
	</div>
</div>
</body>
</html>

