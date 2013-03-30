/**
 * 问题库管理
 * 
 */

Ext.onReady(function(){
  Ext.QuickTips.init();      
	var sm = new Ext.grid.CheckboxSelectionModel();		
	var colModel = new Ext.grid.ColumnModel([		
		sm,
		{header: '编号', width:40, dataIndex:'questionID'},
		{header: '题目', width:480, dataIndex:'question'},
		{header: '字段类型', width:60, dataIndex:'fieldType'},
		{header: '问题类型', width:60, dataIndex:'questionType'}
		]);

	var dataStore = new Ext.data.Store({
    proxy: new Ext.data.HttpProxy({url:'../question/ajaxTestQuestions.do?start=0&limit='+SMGK_MAX_RESULT}),
		reader: new Ext.data.JsonReader({
					totalProperty: 'total',
					root:'questions',					
					successProperty:'success'
				}, 
				[
					{name: 'englishExplain'},
					{name: 'englishQuestion'},
					{name: 'fieldType'},
					{name: 'fieldValue'},
					{name: 'format'},
					{name: 'question'},
					{name: 'questionID'},
					{name: 'questionType'},
					{name: 'zhExplain'}
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
            {contentEl:'detail',title: '详细'},
            {contentEl:'add',title: '增加'},
            {contentEl:'edit',title: '编辑'}
        ]
    });    		

    var typeStore = new Ext.data.SimpleStore({
        fields: ['type', 'name'],
        data: Ext.questionTypeData.selects
    });     	


	 var grid = new Ext.grid.GridPanel({
			store:dataStore,
			sm:sm,
	 		cm:colModel,
      viewConfig: {forceFit:false},     
      tbar:[
      		'-',     		
      		new Ext.form.ComboBox({
      			xtype:'combo',
      			store:typeStore,
      			fieldLabel:'问题类型',
      			hiddenName:'questionType',
      			name:'name',
      			anchor:'90%',
      			displayField:'name',
      			valueField:'type',
      			blankText:'请选择问题类型',
      			emptyText:'选择问题类型...',
						allowBlank:false, //验证不为空
      			editable:false,
      			mode: 'local',
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
	 		alert(record.get('questionID'));	
	 }
	 	

 	 grid.render('list'); // 渲染表格
	 dataStore.load({params:{start:0,limit:SMGK_MAX_RESULT}}); // 加载数据

});	