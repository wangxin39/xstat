<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线测验</title>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
<script type="text/javascript">
function goPage(id,planID)
{
  location.href= '<s:url value="/iqList.do" encode="false" includeParams="none"/>?id='+id+'&amp;planID='+planID;
}
</script>
</head>

<body>
<div class="cright">
	<div class="title font16h">在线测验</div>
    <div class="container">
<table border="0">
<tr>
<td>计划</td>
<td>轮次</td>
<td>调查问卷</td>
<td>开始时间</td>
<td>结束时间</td>
<td>状态</td>
<td>操作</td>
</tr>
<s:iterator value="%{pageList}" status="idx">
<tr>
<td>&nbsp;<s:property value="name"/></td>
<td>&nbsp;<s:property value="round"/></td>
<td>&nbsp;<s:property value="inquisitionList[#idx.index].title"/></td>
<td>&nbsp;<s:date name="startDay" format="yyyy-MM-dd"/></td>
<td>&nbsp;<s:date name="endDay" format="yyyy-MM-dd"/></td>
<td>&nbsp;<s:property value="statusList[#idx.index]"/></td>
<td>&nbsp;
<s:if test="statStatus == 1 && checkStatus == 1">
<input type="button" value="测试" onclick="goPage('<s:property value="inquisitionList[#idx.index].inquisitionID"/>','<s:property value="planID"/>')">
</s:if>
</td>
</tr>
</s:iterator>
</table>
</div>
</div>

</body>
</html>

