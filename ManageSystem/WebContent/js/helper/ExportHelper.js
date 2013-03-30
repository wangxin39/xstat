function exportPageHandler()
{
       var jsonDatas =GetDisplayColumns();
       var filterDatas = arrayToJson(grid.filters.getFilterData());       
       var pageIndex = grid.bottomToolbar.getPageData().activePage;
       var remoteSort =grid.store.remoteSort;
       var dir =grid.store.sortInfo.direction;
       var sort =grid.store.sortInfo.field;
       var pageCount = 25;
       //window.open('PageGridService.svc/PageExportExcel?cols='+jsonDatas+"&filters="+filterDatas+"&pageIndex="+pageIndex+"&pageCount="+pageCount+"&remoteSort="+remoteSort+"&sort="+sort+"&dir="+dir);       
}
 function exportAllHander()
 {
        var jsonDatas =GetDisplayColumns();
        var filterDatas = arrayToJson(grid.filters.getFilterData());
        //window.open('PageGridService.svc/ExportExcel?cols='+jsonDatas+"&filters="+filterDatas);
 }
 
function GetDisplayColumns()
{
        var i = 0;
        var canExportColumnModels = new Array();
        for(i=0;i<grid.colModel.config.length;i++)
        {
              var cm = grid.colModel.config[i];
              if(cm.dataIndex!=''&&!cm.hidden)
              {
                     var c = new  ColModel(cm.dataIndex,cm.header);      
                     canExportColumnModels.push(c);       
              }                 
         }
         var jsonDatas = arrayToJson(canExportColumnModels);
         return jsonDatas;
}