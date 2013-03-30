Ext.onReady(function(){   
    Ext.QuickTips.init();   
    var win;   
    if(!win){   
            win = new Ext.Window({   
                el:'login-win',   
                layout:'fit',   
                width:450,   
                height:250,   
                minWidth:300,   
                minHeight:200,   
                closeAction:'hide',   
                plain: true,   
                items: new Ext.TabPanel({   
                    el: 'login-tabs',   
                    autoTabs:true,   
                    activeTab:0,   
                    deferredRender:false,   
                    border:false  
                }),   
             buttons: [{   
                    text:'登陆',   
                    handler: function(){   
                     var responseSuccess = function(o){   
                       //alert("succeed");
                     }   
                     var responseFailure = function(o){   
                       //alert("failure");
                     }   
                     var cb ={"success":responseSuccess,"failure":responseFailure}   
                     var pd = Ext.lib.Ajax.serializeForm("loginForm");   
                     //var x  = Ext.lib.Ajax.asyncRequest("POST","",cb,pd);   
                     //alert(x);
                     new Ext.Ajax.request({
                    	    form: '../Login.do',
                    	    params: 'username='+$('username').value+'&password='+$('password').value;
                    	});
                    }   
                },{   
                    text: '离开',   
                    handler: function(){   
                        win.hide();   
                    }   
                }]   
            });   
        }  
    win.show();   
}); 