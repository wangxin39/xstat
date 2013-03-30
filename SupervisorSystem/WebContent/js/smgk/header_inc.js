function getHeader() {
	
	var sm = new Ext.grid.CheckboxSelectionModel();	
	
	var cm = new Ext.grid.ColumnModel([
    	new Ext.grid.RowNumberer(),
	    sm,
		{header:"调查问卷",width:140,dataIndex:"inquisitionID"},
		{header:"问题",width:140,dataIndex:"questionID"},
		{header:"类型",width:140,dataIndex:'questionType'}
	]);
	
	cm.defaultSortable = true;
	
	var ds = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy({url:'../inquisition/ajaxHeader.do'}),
		reader:new Ext.data.JsonReader({
			totalProperty: 'totalProperty',
			root:'pageList',
			successProperty :'success'
		},[
		{name:"inquisitionID"},
		{name:"questionID"},
		{name:"questionType"}			
		])
	});
	
	ds.load({params:{start:0,limit:10}});

	var grid = new Ext.grid.GridPanel({
		store:ds,
		sm:sm,
		cm:cm,
		viewConfig: {forceFit:true},
	 	width:680,
	 	height:500,
		tools: tools,
		bbar:new Ext.PagingToolbar({
			pageSize:10,
			store:ds,
			displayInfo:true,
			displayMsg:'显示第{0}条到{1}条记录，一共{2}条',
			emptyMsg:'没有记录'				
			}),
			tbar:new Ext.Toolbar({
				items:[
					{
						id:'btnAdd',
						text:'增加',
						handler:function(){Ext.MessageBox.alert('show','增加信息');	}
					},
					'-',
					{
						id:'btnEdit',
						text:'编辑',
						handler:function() {Ext.MessageBox.alert('show','编辑信息');}
					},
					'-',
					{
						id:'btnDelete',
						text:'删除',
						handler:function() { Ext.MessageBox.alert('show','删除信息'); }
					}]
			})
		});
	
		var panel = new HeaderInfoGrid({
			title:'表头管理',
			layout:'fit',
            tools: tools,
			items:[grid]
		});
		
	return panel;	
}