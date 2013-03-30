<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统菜单管理</title>
<script type="text/javascript">
	function ConfirmButton(url,altText)
	{
		if(confirm(altText)){
			location.href=url;
		}
	}
	function jumpPage(total,pageTotal) {
		var num = $('num').value;
		if(num >= 1 && num <= pageTotal) {
			updatePanel(num,total);					
		}else{
			alert("您要跳转的页面不存在.");	
		}
	}	
	function GoURL(urlStr)	{
		location.href=urlStr;
	}		
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">系统菜单管理</div>
  <div class="container">	
	    <table width="100%" border="0" cellspacing="10">
	    	<tr>
	     	  <td align="right">
	<s:if test="menuID != null && menuID > 0">
		<input type="button" name="button" value="返回" class="button" onclick="BackPage();"/>
		<script type="text/javascript">
		function BackPage() {
			history.back();
		}
		</script>
	</s:if>
	<s:else>
		<input type="button" name="button" value="增加菜单" class="button" onclick="GoURL('addMenuInputs.do');"/>
	</s:else>	
     	    &nbsp;&nbsp;&nbsp;&nbsp;</td>
	      </tr>
	    </table>
<div id="tablecontent">
	<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr>
			<td class="ttitle"><strong class="font12red">编号</strong></td>
			<td class="ttitle"><strong class="font12red">菜单</strong></td>
			<td class="ttitle"><strong class="font12red">系统</strong></td>
			<td class="ttitle"><strong class="font12red">上级</strong></td>
			<td class="ttitle"><strong class="font12red">链接</strong></td>
			<td class="ttitle"><strong class="font12red">操作</strong></td>
		</tr>
		<s:if test="pageList != null">
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td align="center"><s:property value="menuID"/></td>
				<td align="center"><s:property value="menu"/>&nbsp;</td>
				<td align="center"><s:property value="systemList[#stat.index]"/>&nbsp;</td>
				<td align="center"><s:property value="fatherList[#stat.index]"/>&nbsp;</td>
				<td align="center"><s:property value="url"/>&nbsp;</td>
				<td align="center">
					<s:if test="parentID == null || parentID == 0">
						<input type="button" onClick="ConfirmButton('listMenu.do?menuID=<s:property value="%{menuID}"/>','是否确认浏览系统菜单信息!');" value="浏览">&nbsp;
						<input type="button" onClick="ConfirmButton('addMenuInputs.do?menuID=<s:property value="%{menuID}"/>','是否确认增加系统菜单信息!');" 	value="增加">&nbsp;				
					</s:if>
					<input type="button" onClick="ConfirmButton('editMenuInput.do?menuID=<s:property value="%{menuID}"/>','是否确认修改系统菜单信息!');" value="修改">&nbsp;
					<input type="button" onClick="ConfirmButton('deleteMenuProcess.do?menuID=<s:property value="%{menuID}"/>','是否确认删除系统菜单信息!');"	value="删除">
				</td>
			</tr>
		</s:iterator>
		</s:if>
	</table>
</div>

	</div>
</div>
</body>
</html>

