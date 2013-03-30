/*
---------------------------------------------Product 操作脚本-------------------------------------
*/
var formVal ='data';
//添加操作
//添加记录的表单
var addForm =new Ext.FormPanel({
    labelAlign: 'top',
    frame:true,       
    bodyStyle:'padding:5px 5px 0',       
    items: [{
        xtype:'fieldset',
        checkboxToggle:true,
        title: '请添加下面的表头信息',
        autoHeight:true,
        defaults: {width: 210},
        defaultType: 'textfield',
        collapsed: false,
        items :[{
                fieldLabel: '产品名称',
                name: 'name',
                id:'name',
                allowBlank:false,
                blankText:'该项不允许为空！',
                anchor:'95%'
            },{
                fieldLabel: '产品编号',
                name: 'num',
                anchor:'95%'
            },{
                fieldLabel: '产品颜色',
                name: 'color',
                anchor:'95%'
            }, {
                fieldLabel: '产品单价',
                name: 'price',                  
                anchor:'95%'
            }
        ]
    }]      
});

   
//添加新记录的处理函数
function addHandler()
{
    if(!win){
       win =createAddWin(grid);
    } // if(!win) END
    //没有窗体对象，创建窗体对象并显示
    win.show(this);
}    
//创建添加记录的对话框
function createAddWin(grid)
{
       var win = new Ext.Window({
        el:'add-panel',
        layout:'fit',
        title:'添加一个新产品记录',
        width:400,
        height:350,
        closeAction:'hide',
        plain: true,                               
        items:addForm,
        buttons: [{
            text:'提交',
            id:'btnSave',
            handler:function(){                    
               showProcessMsg();
               submit(addForm.getForm(),'PageGridService.svc/AddProduct','PUT',null,addSuccessHandler,addFailureHandler);               }                  
        },
        {
            text: '关闭',
            handler: function(){
                 win.hide();
            }
        }]
    });// new Ext.Window END
    return win;
}

function addSuccessHandler(res)
{
       Ext.MessageBox.hide();
       Ext.MessageBox.alert('提示', '数据保存成功！');
       win.hide();
       store.load({params:{start:0,limit:25}});   
}

function addFailureHandler(res)
{
     showError();
}



//删除操作
function removeHandler()
{
   //如果此时grid为编辑状态，取消编辑状态
   grid.stopEditing();
   //获取选中的行标识对象集合，和读取器中的id属性密切相关
   var selectedItems = grid.selModel.selections.keys;
   if(selectedItems.length==0)
   {
      Ext.MessageBox.alert('提示','请至少选择一条记录！');
   }
   else{
     Ext.MessageBox.confirm('提示','确定要删除选中的记录么？',doRemove);
   }
   grid.startEditing(0, 0);
}

//真正删除记录的处理函数，相当于C#中的委托实例
function doRemove(dialogResult)
{
   if(dialogResult=="yes")
   {
       var selectedItems = grid.selModel.selections.keys;      
       submit(form, 'PageGridService.svc/Delete?formVal='+formVal,"POST",{data:selectedItems},removeSucessHandler,removeFailHandler);            
    }
 }  
 
 function removeSucessHandler(response){ 
   Ext.MessageBox.alert("提示","所选记录成功删除！");
   store.load({params:{start:0,limit:25}});            
 }     
 function removeFailHandler(response)
 {
    showError();
 }





//更新操作
function editHandler()
{
       Ext.MessageBox.confirm('提示','确定要保存已经的修改么?',doUpdated)
}      
//保存修改的记录
function doUpdated(res)
{
     if(res =='yes')
     {   
           showProcessMsg();
           grid.stopEditing();          
           var modifiedItems = grid.getStore().modified;  
           var  jsonData  =  convertRecordsToJson(modifiedItems);  
           if(jsonData=='')
           {
               Ext.MessageBox.alert('提示','没有修改任何数据,无须保存！');
               return;
           }      
           submit(form,'PageGridService.svc/Update?&formVal=data','POST', {data:jsonData},saveSuccessHandler,saveFailureHandler);       
     }
}   

function saveSuccessHandler()
{
    Ext.MessageBox.hide();
    Ext.MessageBox.alert('提示', '数据保存成功！');
    grid.getStore().modified= new Array();
    store.load({params:{start:0,limit:25}});            
}
function saveFailureHandler()
{
     showError();
}

/*
-----------------------------------------------Product END ------------------------------------------
*/