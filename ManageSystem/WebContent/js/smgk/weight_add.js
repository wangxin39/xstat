/**
 * 权重
 * 
 */
 
AddWeightFn=function() {

 	var sm = new Ext.grid.CheckboxSelectionModel({handleMouseDown: Ext.emptyFn});		
	var cm = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(),
		sm,
		{
			header: "部分问题编号",
			width:40,
			dataIndex:"partQuestionID",
			tooltip:"部分问题唯一编号",
			sortable:true
		},
		{
			header: "中文题目",
			width:250,
			dataIndex:"questionID",
			tooltip:"问题中文题目名称",
			sortable:false
		},		
		{
			header: "问题类型",
			width:50,
			dataIndex:"questionType",
			tooltip:"问题类型",			
			sortable:true,
		      renderer:function(value)
		      {   
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
	
	var dataStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'jsonPart.do'}),
		reader: new Ext.data.JsonReader({
					root:'pageList',
					successProperty :'success'				  
				}, [
				{name: 'partQuestionID',mapping:'partQuestionID'}, 
				{name: 'questionID',mapping:'questionID'},
				{name: 'questionType',mapping:'questionType'}
		])	
	 });
 
	 
	dataStore.load({params:{start:0,limit:SMGK_MAX_RESULT}}); // 加载数据

	var grid = new Ext.grid.GridPanel({
			store: dataStore,
			sm:sm,
	 		cm:cm,
      viewConfig: {
        forceFit:true
      },
      title:"选择部分问题",
	 		width:720,
	 		height:350,
	 		bbar:new Ext.PagingToolbar({
	 		pageSize:SMGK_MAX_RESULT,
			store:dataStore,
	 		displayInfo:true,
	 		displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2}条',
	 		emptyMsg: '没有记录'
	 		}) // 页脚显示分页
	 	});

  var AddWeightForm=new Ext.form.FormPanel({
			width:750,
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
			    name:"inquisitionID",
					xtype:"combo",
					fieldLabel:"调查问卷",
					// 传入后台真实值value field /value
					hiddenName:"inquisitionID",
					editable: false					
				},
				{
			    name:"partID",
					xtype:"combo",
					fieldLabel:"部分",
					// 传入后台真实值value field /value
					hiddenName:"partID",
					editable: false
				},
				{
					xtype:'fieldset',
					checkboxToggle:true,
					checkboxName:'isTemplate',
					title:'使用选项模板',
					defaultType:'textfield',
					width:330,
					autoHeight:true		
				}
				,				
				grid
				
			]});
 

	 var AddWeightWin=new Ext.Window({
				title:"添加选项权重",
				width:760,
				height:620,
				plain:true,
				layout:"form",
				iconCls:"addicon",
				// 不可以随意改变大小
				resizable:false,
				// 是否可以拖动
				// draggable:false,
				defaultType:"textfield",
				labelWidth:100,
				collapsible:true, // 允许缩放条
			      closeAction : 'hide',
			      closable:true,
			      // 弹出模态窗体
				modal: 'true', 
				buttonAlign:"center",
				bodyStyle:"padding:10px 0 0 15px",
				items:[AddWeightForm],
				listeners:{
				    "show":function()
				    {
				        AddWeightForm.getForm().reset();
				    }
				},
				buttons:[{
						text:"保存信息",
						minWidth:70,
						handler:function()
						{
							if(AddWeightForm.getForm().isValid())
	            {
	                  // 弹出效果
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
        			 var sPartQuestionID = "";
      				 for(i=0;i<sID.length;i++)
      				 {
      					 sPartQuestionID  += sID[i].get("partQuestionID");
      					 sPartQuestionID += " ";
      				 }
                    AddWeightForm.form.submit({
                      url:"addWeightProcess.do?arrPartQuestionID="+sPartQuestionID,
                      method:"POST",
                      success:function(form,action)
                      {
                		Ext.MessageBox.alert("恭喜","添加选项权重成功!");
                      },
                      failure:function(form,action)
                      {
                    	  Ext.MessageBox.alert("提示!","添加选项权重失败!");
                      }
                      });

     				 // 2秒后自动关闭当前窗口和刷新当前页
  				    setTimeout(function(){
						  AddWeightWin.hide();	
      				   	  location.reload();
      				 	}, 2000);                    
                    
	             }
						}
				},
				{
				    text:"重置",
				    minWidth:70,
				    qtip:"重置数据",
				    handler:function()
				    {
				        AddWeightForm.getForm().reset();
				    }
				},
				{
						text:"取 消",
						minWidth:70,
						handler:function()
						{
						    AddWeightWin.hide();
						}
				}]
		
		});
		AddWeightWin.show();

} 

function addPanel() {	
  Ext.QuickTips.init();
  new AddWeightFn();
}