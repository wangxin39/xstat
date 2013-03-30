var tree = new Ext.tree.ColumnTree({   
    width:568,   
    height:300,   
    border: false,   
    lines: false,   
    animate: false,   
    rootVisible: false,   
    autoScroll:true,   
    checkModel:'cascade',//级联多选，如果不需要checkbox,该属性去掉   
    onlyLeafCheckable: false,//所有结点可选，如果不需要checkbox,该属性去掉   
    loader: new Ext.ux.DWRTreeLoader({   
        dwrMethod:Param.getParamTree,   
        baseAttrs:{uiProvider:Ext.ux.ColumnTreeCheckNodeUI}//如果不需要checkbox,则需要使用Ext.tree.ColumnTreeNodeUI   
    }),   
    root: new Ext.tree.AsyncTreeNode({ id:'0'}),   
    columns:[   
        { header:'参数名称', width:180, dataIndex:'name' },   
        { header:'ID', width:50, dataIndex:'id' ,renderer:filterId},   
        { header:'参数标识', width:70, dataIndex:'enname'},   
        { header:'参数类型', width:70, dataIndex:'type'},   
        { header:'参数描述', width:180, dataIndex:'desc'}   
    ],   
    tbar:['参数名称：',{xtype:'textfield',id:'name'},'参数标识：',{xtype:'textfield',id:'enname'},{text:'查询'}]   
});   
var win = new Ext.Window({   
    title: 'Example Tasks',   
    width:582,   
    height:388,   
    border :true,   
    resizable : false,   
    items: tree,   
    buttonAlign:'center',   
    buttons:[{text:'确定'},{text:'关闭'}]   
});   
win.show();  
