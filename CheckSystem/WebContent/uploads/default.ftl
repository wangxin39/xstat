<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
<link href="css/question.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/jquery.treeview.css" />
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/prototype-1.6.0.js"></script>
<script type="text/javascript">
function check(frm)
{
<#list headerList as header>
<#if header.fieldType == 5>
	if(frm.${header.fieldName}.value == '') {
		frm.${header.fieldName}.focus();
		alert("请输入信息！");
		return false;
	}
</#if>
</#list>
<#list partList as part>
	<#list part.questionList as question>
		<#if question.questionType == 5>
	if(frm.${question.fieldName}.value == '') {
		frm.${question.fieldName}.focus();
		alert("请输入评价！");
		return false;
	}
		</#if>		
	</#list>
</#list>
	return true;
}

function isOk(fieldObj) {
		var len = fieldObj.length;
		var isCheck = false;
		for(i=0;i<len;i++) {
			if(fieldObj[i].checked){
				isCheck = true;
			}
		}
		return isCheck;
}
</script>
</head>

<body>
<div class="mainarea">
<div class="maininner">
<div class="bdrcontent">
<div align="title">
<h3>${title}</h3>
</div>
<div class="title"></div>
<form action="saveExam.do" method="post" onsubmit="return check(this);">
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
		<table border="0" width="99%" cellpadding="0" cellspacing="0">
		<tr>
			<td>开始检测日期</td>
			<td class="bfont">${startTime}</td>
			<td>结束检测日期</td>
			<td class="bfont">${endTime}</td>				
		</tr>			
		<#list headerList as header>
		<#if header_index%2 == 0>
		<tr>
		</#if>
			<td>${header.label}</td>
			<td bgcolor="#FFFFFF">
				<#if header.fieldType == 5>
				<input type="text" name="${header.fieldName}" value="${header.fieldValue!''}">
				</#if>
			</td>
		<#if header_index%2 == 1 || (headerList?size%2 == 1 && header_index == (headerList?size-1))>
		</tr>			
		</#if>
		</#list>
		</table>	
	</td>
	</tr>
</table>
<div class="title"></div>
<table width="95%" border="0" align="center">
	<tr class="question_item_header">
		<td width="75%" height="41">调查项目</td>
	</tr>
	<#list partList as part>
	<tr>
		<td class="question_item_part">${part.showNum}.${part.name}</td>
	</tr>	
	<tr>
		<td height="21" class="question_item">
		<div class="title"></div>
		<div class="wordContent2Down">
		  <table border="0" width="100%" align="center">
			<#list part.questionList as question>
								<tr>
				  <td>
				  <div class="title">${question.showNum}.${question.question}</div>
				  <#if question.questionType == 2>
				  	<#list question.selectList as select>
				  		<#if select.showOrder == 1>
					  		<input type="radio" name="${select.fieldName}" value="${select.fieldValue}" checked>${select.option}&nbsp;
				  		</#if>
				  		<#if select.showOrder != 1>
					  		<input type="radio" name="${select.fieldName}" value="${select.fieldValue}">${select.option}&nbsp;				  		
				  		</#if>
					  </#list>
				  </#if>
				  <#if question.questionType == 5>
				  <textarea name="${question.fieldName}" rows="6" cols="60"></textarea>
				  </#if>  
				  <#list question.questionList as qti>
				  	  <#if qti.question != ''>
					  <table border="0">
					  <tr>
					  <td> ${qti.question!''}</td>
					  <td><div class="brcontent">
						  <#if qti.questionType == 2 && qti.selectList?size != 0>						  	
						  	<#list qti.selectList as select>
						  		<input type="radio" name="${select.fieldName}" value="${select.fieldValue}">${select.option}&nbsp;
							  </#list>
						  </#if>
						  <#if qti.questionType == 5>
						  <textarea name="${qti.fieldName}" rows="5" cols="40"></textarea>
						  </#if>					  
					  </div>
					  </td>		  
					  </tr>
					  </table>					  
					  </#if>
				  </#list>
				  <div class="title">${question.zhExplain!''} </div>
					</td>
			  </tr>
		  </#list>
		</table>
		</div>
		<div class="title"></div>
	  </td>
	</tr>	
	</#list>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
<div class="title"></div>
<input type="submit" value="提交问卷">
</form>
</div>
</div>
</div>
</body>
</html>