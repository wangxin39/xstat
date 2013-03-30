/**
 * 帐号
 * 
 */

Ext.onReady(function(){

  Ext.QuickTips.init();
      
	var sm = new Ext.grid.CheckboxSelectionModel();
		
	var colModel = new Ext.grid.ColumnModel([
		sm,
		{header: '编号', width:40, dataIndex:'projectID'},
		{header: '客户', width:100, dataIndex:'clientID'},
		{header: '项目', width:100, dataIndex:'name'},
		{header: '描述', width:180, dataIndex:'description'}
		]);

	var dataStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'../client/ajaxProject.do'}),
		reader: new Ext.data.JsonReader({
					totalProperty: 'total',
					root:'projects',
					id:'projectID',
					successProperty :'success'
				}, 
				[
				{name: 'projectID'}, 
				{name: 'clientID'},
				{name: 'name'},
				{name: 'description'}				
		])	
	 });

    var tabs = new Ext.TabPanel({
    		renderTo:'projects',
        activeTab: 0,
		 		width:700,
		 		height:550,
		 		defaults:{autoScroll:SMGK_AUTO_SCROLL},
        items:[
            {contentEl:'list',title: '浏览'},
            {contentEl:'add',title: '增加'}
        ]
    });
    		
    function handleActivate(tab){
        alert(tab.title + ' was activated.');
    } 
		
 	 	var store = new Ext.data.Store({
 	 		proxy: new Ext.data.HttpProxy({url:'../client/ajaxClient.do?start=0&limit='+SMGK_INT_VALUE}),
			reader: new Ext.data.JsonReader({
					root:'clients',
					successProperty :'success'
				}, 
 	 		[{name: 'account'},
			 {name: 'clientID'},
			 {name: 'company'},
			 {name: 'description'}
			])
	 });
	store.load();    
	
	var grid = new Ext.grid.GridPanel({
			store: dataStore,
			sm:sm,
	 		cm:colModel,
      viewConfig: {
        forceFit:true
      },
      tbar:[
      		'-',     		
      		new Ext.form.ComboBox({
      			xtype:'combo',
      			store:store,
      			fieldLabel:'客户',
      			hiddenName:'account',
      			name:'account',
      			anchor:'90%',
      			displayField:'company',
      			valueField:'account',
      			blankText:'请选择客户',
      			emptyText:'选择客户...',
						allowBlank:false, //验证不为空
      			editable:false,
      			mode: 'remote',
      			width:120,
      			triggerAction: 'all',
      			typeAhead: true,
      			selectOnFocus:true
      			}),
      		{text:'查看'},
      		'-',
      		new Ext.form.TextField({width:120}),
      		{text:'搜索'}
      ],       
	 		width:680,
	 		height:500,
	 		bbar:new Ext.PagingToolbar({
	 		pageSize:SMGK_MAX_RESULT,
	 		store:dataStore,
	 		displayInfo:true,
	 		displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2}条',
	 		emptyMsg: '没有记录'
	 		}) // 页脚显示分页
	 	});
	
	 grid.addListener('cellclick',cellclick);
	 function cellclick(grid,rowIndex,columnIndex,E) {
	 	var record = grid.getStore().getAt(rowIndex);
	 	var fieldName = grid.getColumnModel().getDataIndex(columnIndex);
	 	var data = record.get(fieldName);
	 	Ext.MessageBox.alert('show','当前选中的数据是'+data);	
	 }
	 
	 grid.addListener('rowcontextmenu',rightClickFn);
	 var rightClick = new Ext.menu.Menu({
	 	id:'rightClickCont', //在HTML文件中必须有个rightClickCont的DIV元素
	 	items:[
	 		{
	 			id:'rMenuList',
	 			handler:rMenuListFn, //点后触发的事件
	 			text:'帐户管理'	
	 		},
	 		{
	 			id:'rMenuEdit',
	 			handler:rMenuEditFn, //点后触发的事件
	 			text:'编辑信息'	
	 		},
	 		{
	 			id:'rMenuDelete',
	 			handler:rMenuDeleteFn, //点后触发的事件
	 			text:'删除客户'	
	 		}
	 	]	 	
	 	});

		function rightClickFn(grid,rowIndex,e){
			e.preventDefault();
			rightClick.showAt(e.getXY());
		}
	  function rMenuListFn() {
	  	Ext.messageBox.alert('right','帐户管理');	  	
	  }
	  function rMenuEditFn() {
	  	Ext.messageBox.alert('right','编辑信息');	  	
	  }
	  function rMenuDeleteFn() {
	  	Ext.messageBox.alert('right','删除客户');	  	
	  }	  	

 	 grid.render('list'); // 渲染表格
	 dataStore.load({params:{start:0,limit:SMGK_MAX_RESULT}}); // 加载数据

	 
	 
	 
	 
});	