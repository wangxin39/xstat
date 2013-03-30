
var tools;
var viewport;

var header_panel;

// 处理右侧主功能显示，根据菜单不同，显示不同Grid
function ShowPanel(menuID) {
	var portal = viewport.getComponent(1);

	header_panel = getHeader();
	portal.add(header_panel);
				
	switch(menuID)
	{
		case 21:  //表头管理
			if(!header_panel) {
				//header_panel = getHeader();
				//portal.add(header_panel);
			}
		break;
	}	

	viewport.doLayout();
}

// 处理左侧菜单
function ShowMenu(menuID)  {
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
			  	 var ml = objs.menuMapLength[objs.menusList[i].menu];
			  	 var mi = objs.menuMap[objs.menusList[i].menu];
			  	 html += "<dl><dt><a href=\"###\" onclick=\"showHide('items"+i+"');\">"+objs.menusList[i].menu+"</dt>";
			  	 // 默认主菜单
				 if(menuID == objs.menusList[i].menuID) {
				  	 html += "<dd id=\"items"+i+"\" style=\"display:block;\"><ul>";
				 }else{
				  	 html += "<dd id=\"items"+i+"\" style=\"display:none;\"><ul>";					 
				 }
			  	 for(var j=0;j<ml;j++)
			  	 {
			  	   html += "<li><a href=\"#\" onclick=\"ShowPanel("+mi[j].menuID+");\">"+mi[j].menu+"</a></li>";   	
			  	 }
			  	 html += "</ul></dd></dl></div>";
		   }
		   html += "</div>";  
		   var submenu = Ext.get('submenu');
		   submenu.dom.innerHTML=html;	
		},
		failure:function() {
			Ext.getBody().unmask();
			Ext.Msg.alert("菜单初始化","菜单初始化失败");	
		}
	});	
	
}



// 主界面自动初始化数据

Ext.onReady(function(){	
					 
	Ext.QuickTips.init();
	
    tools = [{
        id:'gear',
        handler: function(){
            Ext.Msg.alert('Message', 'The Settings tool was clicked.');
        }
    },{
        id:'close',
        handler: function(e, target, panel){
            panel.ownerCt.remove(panel, true);
        }
    }];

    viewport = new Ext.Viewport({
        layout:'border',
        items:[{
            region:'west',
            id:'west-panel',
            title:'神秘客检测管理系统',
            split:true,
            width: 200,
            minSize: 175,
            maxSize: 400,
            collapsible: true,
            margins:'100 0 5 5',
            cmargins:'100 5 5 5',
            layout:'accordion',
            layoutConfig:{
                animate:true
            },
            items: [{
				html: '<div id="submenu"></div>',
                title:'控制面板',
                autoScroll:true,
                border:false,
                iconCls:'nav'
            },{
                title:'设置',
                html: Ext.mainmenu.shortBogusMarkup,
                border:false,
                autoScroll:true,
                iconCls:'settings'
            }]
        },{
            xtype:'portal',
            region:'center',
            margins:'100 5 5 0'
            }]
    });
	
	//Ext.reg('portal',viewport);
	

	Ext.getBody().mask("菜单初始化中.请稍等...","x-mask-loading");	

	// 初始化导航图标
	var tab = new Ext.Panel({
			layout:'table',
			defaults: {
				bodyStyle:'margin: 0 0; padding: 0 25px;font-family: "宋体";font-size: 14px;height:70px;'
			},
			layoutConfig: {
				columns: 11
			},
			items: [{
				html: '<img src="../images/logo.gif" alt="神秘客检测管理系统"/>'
			},
			{
				html: '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'	
			},
			{
				html: '<a href="#" onclick="ShowMenu(1)"><img src="../images/menus/client.png"><br/>客户管理</a>'
			}
			,
			{
				html: '<a href="#" onclick="ShowMenu(2)"><img src="../images/menus/smgk.png"><br/>神秘顾客</a>'
			}
			,
			{
				html: '<a href="#" onclick="ShowMenu(3)"><img src="../images/menus/qt.png"><br/>调查问卷</a>'
			}
			,
			{
				html: '<a href="#" onclick="ShowMenu(4)"><img src="../images/menus/ct.png"><br/>题库管理</a>'
			}
			,
			{
				html: '<a href="#" onclick="ShowMenu(5)"><img src="../images/menus/stat.png"><br/>报告管理</a>'
			}
			,
			{
				html: '<a href="#" onclick="ShowMenu(6)"><img src="../images/menus/plan.png"><br/>邮件管理</a>'
			}
			,
			{
				html: '<a href="#" onclick="ShowMenu(7)"><img src="../images/menus/sys.png"><br/>系统管理</a>'
			}
			,
			{
				html: '<a href="#" onclick="ShowMenu(8)"><img src="../images/menus/ct.png"><br/>审核管理</a>'
			},
			{
				html: '<a href="../manage/Logout.do"><img src="../images/menus/exit.png"><br/>退出系统</a>'
			}]
	});	
	tab.render('mtable');
	Ext.getBody().unmask();
	
	//Ext.util.CSS.swapStyleSheet("theme", "../../theme/xtheme-slate/css/xtheme-slate.css");
	// 默认初始化菜单为客户信息管理
	ShowMenu(1);
});