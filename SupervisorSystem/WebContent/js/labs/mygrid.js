

Ext.onReady(function(){

  Ext.QuickTips.init();
      
	var sm = new Ext.grid.CheckboxSelectionModel();
		
	var colModel = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(),
		sm,
		{header: '员工', width:120, dataIndex:'employeeName'},
		{header: '日期', width:100, dataIndex:'hireDate'},
		{header: '工作', width:180, dataIndex:'jobTitle'},
		{header: '激活', width:100, dataIndex:'isActive'}
		]);

	var dataStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'../grid.do'}),
		reader: new Ext.data.JsonReader({
					totalProperty: 'total',
					root:'employees',
					successProperty :'success'
				}, [
				{name: 'id'}, 
				{name: 'employeeName'},
				{name: 'jobTitle'},
				{name: 'hireDate'},
				{name: 'isActive'}
		])	
	 });

	 var grid = new Ext.grid.GridPanel({
			store: dataStore,
			sm:sm,
	 		cm:colModel,
      viewConfig: {
        forceFit:true
      },
	 		width:700,
	 		height:280,
	 		bbar:new Ext.PagingToolbar({
	 		pageSize:25,
	 		store:dataStore,
	 		displayInfo:true,
	 		displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2}条',
	 		emptyMsg: '没有记录'
	 		}) // 页脚显示分页
	 	});

 	 grid.render('mygrid'); // 渲染表格
	 dataStore.load({params:{start:0,limit:25}}); // 加载数据

});	