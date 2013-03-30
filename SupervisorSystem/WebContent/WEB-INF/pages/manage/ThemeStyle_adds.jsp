<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题风格管理</title>
<script type="text/javascript">
	function selectTypeShow(opt) {
		var value = opt[opt.selectedIndex].value;
		if(value == 0) {
			// 表头选项，隐藏客户和调查对象选项
			$('statChartDiv').style.visibility="hidden";
		}		
		if(value == 1) {
			//
			$('statChartDiv').style.visibility="visible";
		}
		if(value == 2) {
			$('statChartDiv').style.visibility="visible";
		}		
	}
	function selectBackShow(opt) {
		var value = opt[opt.selectedIndex].value;
		if(value == 2) {
			// 表头选项，隐藏客户和调查对象选项
			$('imageNameDiv').style.visibility="hidden";
			$('savePathDiv').style.visibility="hidden";
		}		
		if(value == 1) {
			//
			$('imageNameDiv').style.visibility="visible";
			$('savePathDiv').style.visibility="visible";
		}	
	}
</script>
<s:head theme="ajax"/>
</head>

<body>
<div class="cright">
  <div class="title font16h">添加主题风格信息</div>
  <div class="container">	
	<s:form action="addThemeStyleProcess">
	<s:actionerror/>
<s:actionmessage/>
	<s:textfield label="页号" name="pageNum"></s:textfield>
	<s:if test="#session.THEMELIST">
	<s:select list="%{#session.THEMELIST}" name="themeID" label="主题名称" listValue="title" listKey="themeID"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" name="themeID" label="主题名称" ></s:select>
	</s:else>
	<s:if test="#session.TEMPLATE">
	<s:select list="%{#session.TEMPLATE}" name="reportTemplateID" label="模板名称" listValue="name" listKey="reportTemplateID"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" name="reportTemplateID" label="模板名称"></s:select>
	</s:else>
	<tr>
	<td class="tdLabel"><label class="label">统计类型:</label></td>
	<td>
	<s:if test="#session.STATTYPE">
	<s:select list="%{#session.STATTYPE}" name="statType" label="统计类型" onchange="selectTypeShow(this);"  theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" name="statType" label="统计类型" theme="simple"></s:select>
	</s:else>
	<tr>
	<td class="tdLabel"><label class="label">统计图名称:</label></td>
	<td>
	<div id="statChartDiv" style="visibility:hidden">
	<s:textfield label="统计图名称" name="statChart" theme="simple"></s:textfield>
	</div>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">启用背景:</label></td>
	<td>
	<s:if test="#session.BACK">
	<s:select list="%{#session.BACK}" name="isBackImage" label="启用背景" onchange="selectBackShow(this);" theme="simple"></s:select>
	</s:if>
	<s:else>
	<s:select list="{}" name="isBackImage" label="启用背景" theme="simple"></s:select>
	</s:else>
	<tr>
	<td class="tdLabel"><label class="label">图片名称:</label></td>
	<td>
	<div id="imageNameDiv" style="visibility:visible">
	<s:textfield label="图片名称" name="imageName" theme="simple"></s:textfield>
	</div>
	</td>
	</tr>
	<tr>
	<td class="tdLabel"><label class="label">存储路径:</label></td>
	<td>
	<div id="savePathDiv" style="visibility:visible">
	<s:textfield label="存储路径" name="savePath" theme="simple"></s:textfield>
	</div>
	</td>
	</tr>
	<s:textfield label="标题" name="title"></s:textfield>
	<s:textarea label="内容" name="content" cols="25" rows="8"></s:textarea>	
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

