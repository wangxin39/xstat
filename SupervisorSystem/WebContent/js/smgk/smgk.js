/**
* 神秘客检测管理系统JS对象库 
* 
*/

// 继承Ext.grid.GridPanel

HeaderInfoGrid = function() {
    function italic(value){
        return '<i>' + value + '</i>';
    }

    function change(val){
        if(val > 0){
            return '<span style="color:green;">' + val + '</span>';
        }else if(val < 0){
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    }

    function pctChange(val){
        if(val > 0){
            return '<span style="color:green;">' + val + '%</span>';
        }else if(val < 0){
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    }
    
    HeaderInfoGrid.superclass.constructor.call(this);	
}

Ext.extend(HeaderInfoGrid, Ext.grid.GridPanel);

