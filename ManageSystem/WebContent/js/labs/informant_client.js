/**
 * 被调查对象管理
 * 
 */

Ext.onReady(function(){

  Ext.QuickTips.init();
      
	var sm = new Ext.grid.CheckboxSelectionModel();
		
	var colModel = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(),
		sm,
		{header: '编号', width:120, dataIndex:'informantID'},
		{header: '名称', width:100, dataIndex:'name'},
		{header: '邮箱', width:180, dataIndex:'areaManagerEmail'},
		{header: '语言', width:100, dataIndex:'serviceLang'}
		]);

	var dataStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'../client/ajaxInformant.do'}),
		reader: new Ext.data.JsonReader({
					totalProperty: 'total',
					root:'informants',
					successProperty :'success'
				}, [
				{name: 'informantID'}, 
				{name: 'name'},
				{name: 'areaManagerEmail'},
				{name: 'serviceLang'}
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
	 		pageSize:10,
	 		store:dataStore,
	 		displayInfo:true,
	 		displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2}条',
	 		emptyMsg: '没有记录'
	 		}) // 页脚显示分页
	 	});

 	 grid.render('informant'); // 渲染表格
	 dataStore.load({params:{start:0,limit:10}}); // 加载数据

});	