//该函数用于将编辑过的Grid中的数据行对应的Store中的数据项转换成JSON
function convertRecordsToJson(items)
{
       if(items.length==0)
       {
           return '';
       }
       var  jsonData = "[";
        for(i=0;i<items.length;i++) {
                record = items[i];
                if(record.dirty) {
                        jsonData += Ext.util.JSON.encode(record.data) + ",";
                }
        }                                          
      jsonData = jsonData.substring(0,jsonData.length-1) + "]";      
      return jsonData;
}

function arrayToJson(items)
{
     if(items.length==0)
       {
           return '';
       }
       var  jsonData = "[";
        for(i=0;i<items.length;i++) {
              record = items[i];
              jsonData += Ext.util.JSON.encode(record) + ",";            
        }                                          
      jsonData = jsonData.substring(0,jsonData.length-1) + "]";      
      return jsonData;
}
   
   //显示一个进度对话框
   function showProcessMsg()
   {
        Ext.MessageBox.show({
                    msg: '正在保存数据, 请稍侯',
                    progressText: '正在保存中',
                    width:300,
                    wait:true,
                    waitConfig: {interval:200},
                    icon:'ext-mb-save'                 
          });
   }
   
   function showError()
   {
        Ext.MessageBox.hide();
        Ext.MessageBox.show({
           title:'错误',
           msg: '操作失败！',
           buttons: Ext.Msg.OK,
           icon: Ext.MessageBox.ERROR
        });
   }
 
 function submit(form,url,method,params,success,failure)
 {
     form.submit({
        url:url,
        method:method,
        params:params,
        success:success,
        failure:failure
     });
 }