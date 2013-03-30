<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>浏览信息</title>
<script type="text/javascript" src="<s:url value='/js/prototype-1.6.0.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json.js' encode='false' includeParams='none'/>"></script>
<s:head theme="ajax"/>
<script type="text/javascript">
function showPage(id)
{
	window.open('<s:url value="/detailPublishProcess.do" encode="false" includeParams="none"/>?id='+id,'浏览窗口','height=500,width=600,status=no,location=no,top=150,left=150,scrollbars=yes,resizable=no');
}
</script>
</head>

<body>

<div class="cright">
	<div class="title font16h">浏览信息</div>
    <div class="container">
<table border="0" width="100%">
<tr>
<td width="60">编号</td>
<td width="60%">名称</td>
<td>操作</td>
</tr>
<s:iterator value="%{pageList}" status="idx">
<tr>
<td><s:property value="publishID"/></td>
<td><s:property value="articleList[#idx.index]"/></td>
<td><input type="button" value="浏览" onclick="showPage('<s:property value="articleID"/>')"></td>
</tr>
</s:iterator>
</table>
</div>
</div>
</body>
</html>