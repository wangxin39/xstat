/**
* 初始化系统菜单
* 
*/

Ext.onReady(function(){	
	Ext.QuickTips.init();
	Ext.getBody().mask("菜单初始化中.请稍等...","x-mask-loading");
	Ext.Ajax.request({
		url:'../LeftMenu.do',
		success:function(response,options){
			Ext.getBody().unmask();
		 	var objs = Ext.util.JSON.decode(response.responseText);
			
			var arrs = new Array('ct.png','client.png','stat.png','smgk.png','sys.png','qt.png','plan.png','btb.png','exit.png');
			
		 	html = "<table border=\0\" width=\"100%\"><tr>";
	 	    for(var i=0;i<objs.length;i++)
		    {
			 	 //html += "<div class=\"menu\">";
				 html += "<td><img src='../images/menus/"+arrs[i]+"' alt='img'><br/>"+objs.menusList[i].menu+"</td>";

				//html += "<dl><dt><a href=\"###\" onclick=\"showHide('items"+i+"');\">"+objs.menusList[i].menu+"</dt>";
			  	 //var ml = objs.menuMapLength[objs.menusList[i].menu];
			  	 //var mi = objs.menuMap[objs.menusList[i].menu];
			  	 //html += "<dd id=\"items"+i+"\" style=\"display:block;\"><ul>";
			  	 //for(var j=0;j<ml;j++) 
			  	 //{
			  	   //html += "<li><a href=\""+mi[j].url+"\">"+mi[j].menu+"</a></li>";   	
			  	 //}
			  	 //html += "</ul></dd>";
				 //html += "</dl></div>";
		   }
			html += "<td><a href=\"../manage/Logout.do\"><img src='../images/menus/"+arrs[8]+"' alt='img'><br/>退出系统</a></td>";
			html += "</tr></table>";	  
		   //var leftmenu = Ext.get('leftmenu');
		   //leftmenu.innerHTML=html;	
		},
		failure:function() {
			Ext.getBody().unmask();
			Ext.Msg.alert("菜单初始化","菜单初始化失败");	
		}
	});	
}); 


