/**
 * 被调查对象管理
 * 
 */

Ext.onReady(function(){

  Ext.QuickTips.init();
      
	var sm = new Ext.grid.CheckboxSelectionModel();
		
	var colModel = new Ext.grid.ColumnModel([		
		sm,
		{header: '编号', width:40, dataIndex:'informantID'},
		{header: '项目', width:100, dataIndex:'projectID'},
		{header: '被调查对象', width:100, dataIndex:'name'},
		{header: '区域', width:100, dataIndex:'area'},
		{header: '城市', width:100, dataIndex:'cityID'},
		{header: '客户', width:100, dataIndex:'clientID'}
		]);

	var dataStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'../client/ajaxInformant.do?start=0&limit='+SMGK_MAX_RESULT}),
		reader: new Ext.data.JsonReader({
					totalProperty: 'total',
					root:'informants',					
					successProperty:'success'
				}, 
				[
					{name:'address'},
					{name:'area'},
					{name:'areaManager'},
					{name:'areaManagerEmail'},
					{name:'cityID'},
					{name:'clientID'},
					{name:'informantID'},
					{name:'manager'},
					{name:'managerEmail'},
					{name:'name'},
					{name:'postCode'},
					{name:'projectID'},
					{name:'serviceLang'},
					{name:'serviceTime'},
					{name:'serviceType'},
					{name:'telephone'}

		])	
	 });
	 
    var tabs = new Ext.TabPanel({
    		renderTo: 'main',
				activeTab: 0,
		 		width: 700,
		 		height: 550,
		 		defaults:{autoScroll:SMGK_AUTO_SCROLL},
        items:[
            {contentEl:'list',title: '浏览'},
            {contentEl:'add',title: '增加'}
        ]
    });    		
     	
 	 	var clientStore = new Ext.data.Store({
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
	 clientStore.load(); 	 

	 var grid = new Ext.grid.GridPanel({	 		
			store:dataStore,
			sm:sm,
	 		cm:colModel,
      viewConfig: {forceFit:false},
      tbar:[
      		'-',     		
      		new Ext.form.ComboBox({
      			xtype:'combo',
      			store:clientStore,
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

	 var	panel;
   var isShow = false;

	 grid.addListener('cellclick',cellclick);
	 function cellclick(grid,rowIndex,columnIndex,E) {
	 		var record = grid.getStore().getAt(rowIndex);
	 	 if(isShow){ 
	 	 		panel.destroy(); 
	 	 		isShow = false;
	 	 }
	 	 
	 	 if(!isShow){
	 	 	
			 	 	var store = new Ext.data.JsonStore({
		    		url:'../client/detailInformantStore.do?id='+record.get('informantID'),
			 	 		root:'informant',
			 	 		fields:[
			 	 			'name','informantID','serviceLang',
							{name:'address'},
							{name:'area'},
							{name:'areaManager'},
							{name:'areaManagerEmail'},
							{name:'cityID'},
							{name:'clientID'},
							{name:'informantID'},
							{name:'manager'},
							{name:'managerEmail'},
							{name:'name'},
							{name:'postCode'},
							{name:'projectID'},
							{name:'serviceLang'},
							{name:'serviceTime'},
							{name:'serviceType'},
							{name:'telephone'}
						]	
				 });
				 
					store.load();
					
					var tpl = new Ext.XTemplate(
						'<tpl for=".">',
						'<div class="thumb-wrap" id="{informantID}">',
						'<div class="thumb">名称：{name}</div>',
						'<span class="x-editable">语言：{serviceLang}</span></div>',
						'</tpl>',
						'<div class="x-clear"></div>'					
					);
					
		 	    panel = new Ext.Panel(
		 	    { 	
		 	    	renderTo: 'container',    	
		        title: '详细信息',
		        collapsible:true,
		        width:700,
		        autoHeight:true,
		        layout:'fit',		        
		        items: new Ext.DataView({
		        	store:store,
		        	tpl:tpl,
		        	autoHeight:true,
		        	multiSelect:true,
		        	overClass:'x-view-over',
		        	itemSelector:'div.thumb-wrap',
		        	emptyText:'无数据'
		        	
		        	})
		    	});
		    	
		    	panel.render('container');
					
     }
			isShow = true;
	 }	 	
	 	

 	 grid.render('list'); // 渲染表格
	 dataStore.load({params:{start:0,limit:SMGK_MAX_RESULT}}); // 加载数据




});	