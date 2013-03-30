<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部分选项问题管理</title>
<script type="text/javascript">	
	function optionSelect(opt) {
		//请求的地址
		var url = '../partOptionList.do';
		var pars = 'optionType='+opt.value;
	
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
	function processResponse(response) {
		var o = response.responseText.evalJSON(true);
		var arrs = o.options;
		var len = arrs.length;
		var html = "选项值:<select name=\"optionID\">";
		for(i=0;i<len;i++){
			var arr = arrs[i].split(",");
			html += "<option value=\""+arr[0]+"\">"+arr[1]+"</option>";
		}
		html += "</select>";
		document.getElementById("optiondiv1").innerHTML = html;
	}
</script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">修改部分问题选项信息</div>
  <div class="container">	
	<s:form name="form1" action="editPartOptionProcess" method="post">
	<s:if test="null != #session.ALTEROPTIOINFOLIST">
	<s:select list="%{#session.ALTEROPTIOINFOLIST}" name="alterID" label="选项信息" listValue="chinaOption" listKey="optionID" value="%{#session.EDITPARTSELECTINFO.selectID}"></s:select>
	</s:if>
	<s:else>	
	<s:select name="alterID" label="选项信息" list="{}"></s:select>	
	</s:else>
	<s:if test="null != #session.EDITPARTSELECTINFO">
	<s:textarea label="解释说明" name="comment" cols="30" rows="8" value="%{#session.EDITPARTSELECTINFO.comment}"></s:textarea> 
	<s:textarea label="英文解释" name="englishComment" cols="30" rows="8" value="%{#session.EDITPARTSELECTINFO.englishComment}"></s:textarea> 
	<s:textfield label="显示顺序" name="showOrder" value="%{#session.EDITPARTSELECTINFO.showOrder}"></s:textfield>	
	<s:textfield label="显示编号" name="showNum" value="%{#session.EDITPARTSELECTINFO.showNum}"></s:textfield>		
	<s:select name="optionType" label="选项类型" list="#{'1':'选择项','2':'部分问题'}" onchange="optionSelect(this);" value="%{#session.EDITPARTSELECTINFO.optionType}"></s:select>
 	</s:if>
	<s:else>
	<s:textarea label="解释说明" name="comment" cols="30" rows="8"></s:textarea> 
	<s:textarea label="英文解释" name="englishComment" cols="30" rows="8"></s:textarea> 
	<s:textfield label="显示顺序" name="showOrder"></s:textfield>	
	<s:textfield label="显示编号" name="showNum"></s:textfield>		
	<s:select name="optionType" label="选项类型" list="#{'1':'选择项','2':'部分问题'}" onchange="optionSelect(this);"></s:select>

	</s:else>
	<tr>
		<td colspan="2">	
		<div id="optiondiv1">
		<s:if test="null != #session.SELECTPARTQUESTIONINFOMAP">
		选项值:<s:select name="optionID" label="选项值" list="%{#session.SELECTPARTQUESTIONINFOMAP}" listValue="value" listKey="key" theme="simple" value="%{#session.EDITPARTSELECTINFO.optionID}"></s:select>
		</s:if>
		<s:else>
		选项值:<select name="optionID"></select>
		</s:else>
		</div>&nbsp;
		</td>	
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td align="right"><s:submit value="修改" theme="simple"/>&nbsp;
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

