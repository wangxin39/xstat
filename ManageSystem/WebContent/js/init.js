
function ShowMenuGoUrl(url,id) {
	location.href=url+"?selectMenuID="+id;	
}

Ext.onReady(function(){	
	Ext.QuickTips.init();	
	Ext.getBody().mask("菜单初始化中.请稍等...","x-mask-loading");	

	Ext.Ajax.request({
		url:'../LeftMenu.do',
		success:function(response,options){
			Ext.getBody().unmask();
		 	var objs = Ext.util.JSON.decode(response.responseText);
		 	html = "<div class=\"cleft\">";
	 	    for(var i=0;i<objs.length;i++)
		    {
			 	 html += "<div class=\"menu\">";
			  	 html += "<dl><dt><a href=\"###\" onclick=\"showHide('items"+i+"','"+objs.menusList[i].menuID+"');\">"+objs.menusList[i].menu+"</dt>";
			  	 var ml = objs.menuMapLength[objs.menusList[i].menu];
			  	 var mi = objs.menuMap[objs.menusList[i].menu];
			  	 if(objs.showMenuID == i) {
				  	 html += "<dd id=\"items"+i+"\" style=\"display:block;\"><ul>";			  		 
			   	 }else{
				  	 html += "<dd id=\"items"+i+"\" style=\"display:none;\"><ul>";		   		 
			   	 }
			  	 for(var j=0;j<ml;j++) 
			  	 {
			  	   html += "<li><a href=\"#\" onclick=\"ShowMenuGoUrl('"+mi[j].url+"','"+i+"');\">"+mi[j].menu+"</a></li>";   	
			  	 }
			  	 html += "</ul></dd></dl></div>";
		   }
		   html += "</div>";
		   $("leftmenu").innerHTML=html;		
			
		},
		failure:function() {
			Ext.getBody().unmask();
			Ext.Msg.alert("菜单初始化","菜单初始化失败");	
		}
	});	
});

