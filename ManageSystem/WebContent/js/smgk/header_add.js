
AddHeaderInfoFn=function() {
 	var sm = new Ext.grid.CheckboxSelectionModel({handleMouseDown: Ext.emptyFn});		
	var cm = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(),
		sm,
		{
			header: "编号",
			width:40, 
			dataIndex:"questionID",			
			tooltip:"问题唯一编号",
			sortable:true
		},
		{
			header: "中文题目",
			width:250,
			dataIndex:"question",
			tooltip:"问题中文题目名称",
			sortable:false
		},{
			header: "问题类型",
			width:50,
			dataIndex:"questionType",
			tooltip:"问题类型",
      		renderer: function(value) {   
      		var ret = '';
      		switch(value) {
      			case 1:
      				ret = "单选菜单";
      				break;
      			case 2:
      				ret = "单选按钮";
      				break;
      			case 3:
      				ret = "多选菜单";
      				break;
      			case 4:
      				ret = "多选检查框";
      				break;
      			case 5:
      				ret = "提示填空";
      				break;
      			case 6:
      				ret = "提示文本";
      				break;
      		}  		
          return ret;
      }      
		}				
		]);

	cm.defaultSortable = true;
	

	var templateStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'jsonOptionTemplate.do'}),
		reader: new Ext.data.JsonReader({
					totalProperty: 'total',
					root:'pageList',
					successProperty :'success'				  
				}, [
				{name: 'optionTemplateID',mapping:'optionTemplateID'}, 
				{name: 'title',mapping:'title'}
		])	
	 });
	
	var dataStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'ajaxQuestion.do'}),
		reader: new Ext.data.JsonReader({
					totalProperty: 'total',
					root:'pageList',
					successProperty :'success'				  
				}, [
				{name: 'questionID',mapping:'questionID'}, 
				{name: 'question',mapping:'question'},
				{name: 'questionType',mapping:'questionType'}
		])	
	 });
	 
	dataStore.load({params:{start:0,limit:SMGK_MAX_RESULT}}); // 加载数据

	var grid = new Ext.grid.EditorGridPanel({
			store: dataStore,
			sm:sm,
	 		cm:cm,
		      viewConfig: {
		        forceFit:true
		      },
		      title:"选择问题",
	 		width:820,
	 		height:350,
	 		bbar:new Ext.PagingToolbar({
	 		pageSize:SMGK_MAX_RESULT,
	 		store:dataStore,
	 		displayInfo:true,
	 		displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2}条',
	 		emptyMsg: '没有记录'
	 		}) // 页脚显示分页
	 	});

  var AddHeaderInfoForm=new Ext.form.FormPanel({
			width:850,
			height:600,
			plain:true,
			layout:"form",
			defaultType:"textfield",
			labelWidth:80,
			baseCls:"x-plain",
			defaults:{anchor:"95%",msgTarget:"side"},
			buttonAlign:"center",
			bodyStyle:"padding:0 0 0 0",
			items:[{
			    name:"isInput",
				xtype:"combo",
				fieldLabel:"是否必须填写",
				//传入后台真实值value field /value
				hiddenName:"isInput",
				editable: false,
				mode:"local",
				displayField:"show",
				valueField:"value",
				triggerAction:"all",
				value:"1",
				store:new Ext.data.SimpleStore({
					fields:["show","value"],
					data:[["必须填空","1"],["可以为空","2"]]
				})
				},				
				{
					xtype:'fieldset',
					checkboxToggle:true,
					checkboxName:'isTemplate',
					title:'使用选项模板',
					defaultType:'textfield',
					width:330,
					autoHeight:true,
					items:[
						{
							name:"optionTemplateID",
							xtype:"combo",
							fieldLabel:"选项模板",						
							hiddenName:"optionTemplateID",
							editable: false,
							mode:"remote",
							displayField:"title",
							valueField:"optionTemplateID",
							triggerAction:"all",
							store:templateStore	
						}
					]	
				
				},				
				grid
				
			]}); 	 


			
	 var AddHeaderInfoWin=new Ext.Window({
				title:"添加表头问题",
				width:860,
				height:620,
				plain:true,
				layout:"form",
				iconCls:"addicon",
				//不可以随意改变大小
				resizable:false,
				//是否可以拖动
				//draggable:false,
				defaultType:"textfield",
				labelWidth:100,
				collapsible:true, //允许缩放条
		        closeAction : 'hide',
		        closable:true,
		      //弹出模态窗体
				modal: 'true', 
				buttonAlign:"center",
				bodyStyle:"padding:10px 0 0 15px",
				items:[AddHeaderInfoForm],
				listeners:{
				    "show":function()
				    {
				        AddHeaderInfoForm.getForm().reset();
				    }
				},
				buttons:[{
					text:"保存信息",
					minWidth:70,
					handler:function()
					{
						if(AddHeaderInfoForm.getForm().isValid())
	            		{
		                  //弹出效果
		                  Ext.MessageBox.show
		                  (
		                      {
		                        msg: '正在保存，请稍等...',
					            progressText: 'Saving...',
					            width:300,
					            wait:true,
					            waitConfig: {interval:200},
					            icon:'download',
					            animEl: 'saving'
		                      }
		                  );	            	
                    setTimeout(function(){}, 1000);
                     var isSuccess = false;
                     var isFailure = false;
        			 // 取出当前选择的问题
        			 var sID = grid.getSelectionModel().getSelections();
        			 var sQuestionID = "";
      				 for(i=0;i<sID.length;i++)
      				 {
      					 sQuestionID  += sID[i].get("questionID");
      					 sQuestionID += " ";
      				 }
                    AddHeaderInfoForm.form.submit({
                      url:"addHeaderProcess.do?arrQuestionID="+sQuestionID,
                      method:"POST",
                      success:function(form,action)
                      {
                		Ext.MessageBox.alert("恭喜","添加表头问题成功!");
                      },
                      failure:function(form,action)
                      {
                    	  Ext.MessageBox.alert("提示!","添加表头问题失败!");
                      }
                      });

     				 // 2秒后自动关闭当前窗口和刷新当前页
  				    setTimeout(function(){
						  AddHeaderInfoWin.hide();	
      				   	  location.reload();
      				 	}, 2000);                    
                    
	             }
						}
				},{
				    text:"重置",
				    minWidth:70,
				    qtip:"重置数据",
				    handler:function()
				    {
				        AddHeaderInfoForm.getForm().reset();
				    }
				},{
						text:"取 消",
						minWidth:70,
						handler:function()
						{
						    AddHeaderInfoWin.hide();
						}
				}]
		
		});
		AddHeaderInfoWin.show();

} 

function addPanel() {
	
  Ext.QuickTips.init();
  new AddHeaderInfoFn();	
	
}