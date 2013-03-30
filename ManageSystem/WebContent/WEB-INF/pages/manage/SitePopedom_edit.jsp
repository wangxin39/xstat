<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站权限管理</title>

<script type="text/javascript">

	function SelectPopedom()
	{
		var s = document.getElementById("popedomSelect");
		var opt = document.getElementById("popedom");		
		if(s.selectedIndex == -1)
		{
			alert("请先选择权限,然后再点添加！");		
		}else{
			var isNotAdd = true;
			var tmp = s.options[s.selectedIndex].text;
			for(i=0;i<opt.length;i++)
			{		
				if(opt.options[i].text == tmp)
				{
					isNotAdd = false;
				}
			}
			if(isNotAdd) {
			    
				var popedom = document.getElementById("popedom");
				popedom.add(new Option(tmp,s.options[s.selectedIndex].value,false,true));
				for(i=0;i<popedom.length;i++){
					
					popedom.options[i].selected = true;
					
					
				}
				s.remove(s.selectedIndex);	
			}else{
				alert("你已经添加过此选项了!");
			}
		}
	}
	function DeletePopedom()
	{
	    var s = document.getElementById("popedomSelect");
		var opt = document.getElementById("popedom");
		var tmp = opt.options[opt.selectedIndex].text;			
		if(opt.selectedIndex == -1)
		{
		alert("请选择要删除的权限，然后再点删除！");
		}else{
			s.add(new Option(tmp,opt.options[opt.selectedIndex].value,false,true));	
			opt.remove(opt.selectedIndex);		
			
			for(i=0;i<opt.length;i++){
					opt.options[i].selected = true;
					}
		}
	}
</script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">修改网站权限信息</div>
  <div class="container">	
<SCRIPT type="text/javascript">
	document.getElementById("popedom").select();
</SCRIPT>
<s:form action="editSitePopedomProcess">
<table border="0">
		<tr>
			<td>可选择的权限</td>
			<td>&nbsp;</td>
			<td>已选择的权限</td>
		</tr>
		<tr>
			<td><s:select name="popedomSelect"
				list="%{#session.POPEDOMLIST}" multiple="true" size="8"
				headerKey="-1" theme="simple"></s:select></td>
			<td><input type="button" value="添加权限" onClick="SelectPopedom()" /><br />
			<input type="button" value="删除权限" onClick="DeletePopedom()" /></td>
			<td align="right"><s:select name="popedom" multiple="true"
				labelposition="top" theme="simple" size="8"
				list="%{#session.HADPOPLIST}" value="%{#session.SITEPOPEDOMLIST.popedom}" onselect="true"  >
			</s:select></td>
		</tr>
	</table>
<tr>
<td>&nbsp;</td>
<td align="right">
<s:submit value="修改" theme="simple"></s:submit>&nbsp;
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

