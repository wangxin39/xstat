<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>城市管理</title>
<script type="text/javascript">
	function updatePanel(num)
	{
		var url = 'ajaxCity.do';
		var pars = 'num='+num;
		var province = $('province').value;
		if(province != '') {
			pars += '&province='+province;
		}
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
		var html = '<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">';
		var length = o.pageList.length;
		html +='<tr><td class=\"ttitle\"><strong class=\"font12red\">城市编号</strong></td><td class=\"ttitle\"><strong class=\"font12red\">中文名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">英文名称</strong></td><td class=\"ttitle\"><strong class=\"font12red\">所在省份</strong></td><td class=\"ttitle\"><strong class=\"font12red\">操作</strong></td></tr>';
		for(i=0;i<length;i++){
			html += '<tr><td>'+o.pageList[i].cityID+'</td>';
			html += '<td>'+o.pageList[i].name+'</td>';	
			html += '<td>'+o.pageList[i].englishName+'</td>';
			html += '<td>'+o.provinceList[i]+'</td>';
			html += '<td><input type="button" onClick="ConfirmButton(\'editCityInput.do?cityID='+o.pageList[i].cityID+'\',\'是否确认修改城市信息!\');" value="修改"/>';
			html += '<input type="button" onClick="ConfirmButton(\'deleteCityProcess.do?cityID='+o.pageList[i].cityID+'\',\'是否确认删除城市信息!\');" value="删除"/>';					
			html += '</td></tr>';				
		}
		html += '</table>';
		$('tablecontent').innerHTML = html;
		
		html = '第'+o.pu.currentPage+'页/总'+o.pu.totalPageNum+'页';
		html += '<input type="button" value="转到" onClick="javascript:jumpPage('+o.pu.totalPageNum+ ');"/>&nbsp;第<input type="text" name="num" size="5" id="num"/>页<br/>';
		$('pagination').innerHTML = html;
		
		// 分页数字
		html = '';
		length = o.pu.totalPageNum;
		for(i=1;i<=length;i++) {
			html += '[<a href="#" OnClick="javascript:updatePanel(\''+i+'\');">'+i+'</a>]';
			if(i%20 == 0 && i > 18) {
				html += '<br>';
			}else{
				html += '&nbsp;';
			}
		}
		$('page_link').innerHTML = html;	
	}	
	function jumpPage(pageTotal) {
		var num = $('num').value;
		if(num >= 1 && num <= pageTotal) {
			updatePanel(num);					
		}else{
			alert("您要跳转的页面不存在.");	
		}
	}	
	function ConfirmButton(url,altText)	{
		if(confirm(altText)){
			location.href=url;
		}
	}
	function GoURL(urlStr)	{
		location.href=urlStr;
	}	
</script>
</head>

<body>
<div class="cright">
  <div class="title font16h">城市管理</div>
  <div class="container">	
	    <table width="100%" border="0" cellspacing="10">
	    	<tr>
	     	  <td align="right"><input type="button" name="button" value="增加新的城市" class="button" onclick="GoURL('addCityInputs.do');"/>
	     	    &nbsp;&nbsp;&nbsp;&nbsp;</td>
	      </tr>
	    </table>
	<s:form action="listCity.do">
	<s:select list="%{#session.PROVINCE}" label="省份" name="province" value="%{#request.CURPROVINCE}"></s:select>
	<s:submit value="查询"></s:submit>
	</s:form>
<div id="tablecontent">
	<table  width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bgcolor="#cccccc">
		<tr>
			<td class="ttitle"><strong class="font12red">城市编号</strong></td>
			<td class="ttitle"><strong class="font12red">中文名称</strong></td>
			<td class="ttitle"><strong class="font12red">英文名称</strong></td>
			<td class="ttitle"><strong class="font12red">所在省份</strong></td>
			<td class="ttitle"><strong class="font12red">操作</strong></td>
		</tr>
		<s:iterator value="%{pageList}" status="stat">
			<tr>
				<td><s:property value="cityID"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="englishName" /></td>
				<td><s:property value="provinceList[#stat.index]"/></td>
				<td>
					<input type="button" onClick="ConfirmButton('editCityInput.do?cityID=<s:property value="%{cityID}"/>','是否确认修改城市信息!');" value="修改"> 
					<input type="button" onClick="ConfirmButton('deleteCityProcess.do?cityID=<s:property value="%{cityID}"/>','是否确认删除城市信息!');" value="删除">
				</td>
			</tr>
		</s:iterator>	
	</table>
</div>
	
	<div id="pagination">
	第<s:property value="pu.currentPage"/>页/总<s:property value="pu.totalPageNum" />页  	
	<input type="button" value="转到" onClick="javascript:jumpPage('<s:property value="pu.totalPageNum" />');"/>&nbsp;第<input type="text" name="num" size="5" id="num"/>页<br/>
	</div>
	<table border="0">
	<tr>
	<td>
	<div id="page_link">
	<s:bean name="org.apache.struts2.util.Counter" id="counter">
	   <s:param name="first" value="0" />
	   <s:param name="last" value="%{(pu != null && pu.totalPageNum > 1) ? (pu.totalPageNum-1) : 0}" />
	   <s:iterator>
		[<a href="#" onClick="javascript:updatePanel('<s:property value="current"/>','<s:property value="pu.totalRecordNum" />');"><s:property value="current"/></a>]
		<s:if test="(current%20) == 0 and current > 18"><br/></s:if>
		<s:else>&nbsp;</s:else>
	   </s:iterator>
	</s:bean>
	</div>
	</td>
	</tr>
	</table>

	</div>
</div>
</body>
</html>