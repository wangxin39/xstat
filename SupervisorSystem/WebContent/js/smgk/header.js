/**
 * 表头管理
 * 
 */
 
var grid;
var win;
var form;
var store; 

Ext.onReady(function(){
	Ext.QuickTips.init();
  Ext.lib.Ajax.defaultPostHeader += '; charset=utf-8'; 	
 	
 	Ext.form.Field.prototype.msgTarget = 'side';     
  form = new Ext.BasicForm(Ext.get("form1"), {});

   //创建一个用于访问WCF服务的HttpProxy,且访问方法为GET。
   var proxy = new Ext.data.HttpProxy({
      url:'ajaxHeader.do',
      method:'GET'
   });
  
  Ext.menu.RangeMenu.prototype.icons = {
	  gt: '../images/greater_then.png', 
	  lt: '../images/less_then.png',
	  eq: '../images/equals.png'
	};
	
  Ext.grid.filter.StringFilter.prototype.icon = '../images/find.png';
  Ext.grid.filter.BooleanFilter.prototype.displayText ={
      yes:'是',
      no:'否'
  };
  Ext.grid.filter.DateFilter.prototype.displayText ={
    before:'前',
	  after:'后',
	  on:'中'
  };
  Ext.state.Manager.setProvider(new Ext.state.CookieProvider());     
 	
   var readerOption = {
      root:'pageList',
      totalProperty :'pu.totalRecordNum',
      id:'headerID'
   };
   //创建js下header对象，和WCF端的header对象对应
   var header = Ext.data.Record.create([
       {name: 'headerID',mapping:'headerID'},
       {name: 'inquisitionID'},   
       {name: 'questionID'},    
       {name: 'questionType'},   
       {name: 'isinput'},
       {name: 'showOrder'},   
       {name: 'fieldName'},   
       {name: 'selectType'},    
       {name: 'clientID'},    
       {name: 'informantID'},   
       {name: 'status'}
   ]);   
   var reader = new Ext.data.JsonReader(
     readerOption,
     header
   );
   
   
   //用代理和读取器创建用于ExtJs的数据存储器   
    store = new Ext.data.Store({
      proxy:proxy,
      reader:reader,
      remoteSort: true
     });
    //设置默认排序
    store.setDefaultSort('headerID', 'desc');    
    
    //此处相当于C#中using的方法，给Ext.grid起个别名为xg
    var xg = Ext.grid;
    //创建一个CheckBox行对象
    var sm2 = new xg.CheckboxSelectionModel();
   
  
    //设置Grid的列集合
    //列一
    var cm1 = {
       id:'headerID',
       header: "编号",
       width:50,  
       dataIndex: 'headerID'
    };   
    
   var filters = new Ext.grid.GridFilters({
	  filters:[	
	    {type: 'numeric',  dataIndex: 'headerID'},
	    {type: 'numeric',  dataIndex: 'inquisitionID'}			 	   
	]});
    //列二 
    var cm2 =  {
       header: "问卷",
       id:'inquisitionID', 
       width:100,
       dataIndex: 'inquisitionID',
       editor: new Ext.form.TextField({
       allowBlank: false
       })
     };
     //列三
     var cm3 = {
         header: "问题", 
         width:100, 
         dataIndex: 'questionID',
         editor: new Ext.form.TextField({
         allowBlank: false
        })
     };
     //列四
     var cm4 ={ 
          header: "是否必须填写", 
          width:75,
          dataIndex:'isinput',
          editor: new Ext.form.TextField({
          allowBlank: false
         })
     };
     //列五
     var cm5 = {
           header: "显示顺序", 
           width:75, 
           dataIndex:'ReorderPoint',
           editor: new Ext.form.TextField({
               allowBlank: false,
               allowNegative:false
         })
     };
     //列六
     var cm6 ={
           header: "字段名称",
           width:75,
           dataIndex: 'fieldName',
           editor: new Ext.form.TextField({
               allowBlank: false,
               allowNegative:true
         })
     };  
    //列七
     var cm7 ={
           header: "客户编号",
           width:125,          
           dataIndex: 'clientID',    
           editor: new Ext.form.NumberField({
               allowBlank: false,
               allowNegative:true
         })
     };
   
     //grid的列集合
    var cm = new Ext.grid.ColumnModel([
          sm2,
          cm1,
          cm2,
          cm3,
          cm4,
          cm5,
          cm6,
          cm7
     ]);
    // 开启排序支持
    cm.defaultSortable = true;
    
    //Grid内置菜单中的添加菜单项
    var addMeun = {
            text:'添加',
            tooltip:'添加一条新的记录',
            iconCls:'add',
            handler:addHandler
     };
     //Grid内置菜单中的分隔符
     var sepeator ='-';
     //Grid内置菜单中的修改菜单项
     var editMenu ={
            text:'修改',
            tooltip:'修改选中的记录',
            iconCls:'save',
            handler:editHandler
     };    
      //Grid内置菜单中的删除菜单项
     var removeMenu={
            text:'删除',
            tooltip:'删除选中的的记录',
            iconCls:'remove',
            handler:removeHandler
     };
     //Grid内置菜单中的刷新菜单项
     var refreshMenu={
            text:'刷新',
            tooltip:'刷新',
            iconCls:'refresh',
            handler:function refresh()
            {
                   grid.filters.clearFilters();                   
                   store.load({params:{start:0,limit:25}});   
            }
     };
     //Grid内置菜单中的刷新菜单项
     var exportMenu=new Ext.Toolbar.MenuButton({
            text:'导出',
            tooltip:'导出',
            iconCls:'export',
            menu:{items:[
            {text:'导出该页',tooltip:'只将显示的该页数据导出到Excel',iconCls:'export',handler:exportPageHandler},
            {text:'导出全部',tooltip:'将全部数据导出到Excel',iconCls:'export',handler:exportAllHander}
            ]}        
       });    


    ColModel =  function(dataIndex,header)
    {
        this.dataIndex = dataIndex;
        this.header = header;
    }
   
     //分页工具栏    
    var pageBar  =  new Ext.PagingToolbar({
            pageSize: 25,
            store: store,
            displayInfo: true,
            displayMsg: '总记录数 {0} - {1} of {2}',
            emptyMsg: "没有记录"            
     });
     
     var viewCfg = {
          forceFit:true,
          columnsText:'列',
          sortAscText:'升序',
          sortDescText:'降序'       
     };
    //创建可编辑Grid对象
    grid = new Ext.grid.EditorGridPanel({        
        store: store,
        renderTo:'page-grid',
        cm:cm,
        sm:sm2,
        //设置有边框
        frame:true,
        //显示加载图标
        loadMask: true,       
        //设置Name列为大小自适应
        autoExpandColumn: 'inquisitionID',
        height:500,
        width:760,
        //自定义控件
        plugins:[filters],      
        title:'调查问卷表头信息',
        //clicksToEdit为1的时候单击单元格即可进入编辑状态，为0的时候需要双击
        clicksToEdit:1,
        viewConfig:viewCfg,      
        // 工具栏
        tbar:[
            addMeun, 
            sepeator, 
            editMenu,
            sepeator,
            removeMenu,
            sepeator,
            refreshMenu,
            sepeator,
            exportMenu
         ],
        bbar: pageBar
    });       
    
   
   //设置Grid的加载选项中的提示文本
   grid.loadMask.msg ='加载中...';
   
    //载入数据 
   store.load({params:{start:0,limit:SMGK_MAX_RESULT}});   
   
   //选中第一行
   grid.getSelectionModel().selectFirstRow(); 	
}); 	

