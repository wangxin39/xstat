	window.onload=function() {
		var url = "LeftMenu.do";
		var params = "";
		var myAjax = new Ajax.Request(url,{
			method:'post',
		  	parameters:params,
		  	onComplete:processMenu,
		  	asynchronous:true
		 	});		
	}
	function processMenu(response) {
	 	var objs = response.responseText.evalJSON(true);	 	 
	 	html = "";
		html = "<div class=\"cleft\">";
	 	html += "<div class=\"menu\">";
	  	html += "<dl><dt><a href=\"###\" onclick=\"showHide('items1');\">快捷菜单</dt>";
	  	html += "<dd id=\"items1\" style=\"display:block;\"><ul>";
	  	for(var i=0;i<objs.length;i++)
	   {
  	     html += "<li><a href=\""+objs.menusList[i].url+"\">"+objs.menusList[i].menu+"</a></li>";   	
	   }
	   html += "</ul></dd></dl></div>";
	   html += "</div>";
  	   $("leftmenu").innerHTML=html;
	}