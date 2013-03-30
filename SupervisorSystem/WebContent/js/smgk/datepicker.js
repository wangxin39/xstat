Ext.onReady(function(){
    Ext.QuickTips.init();
    Ext.form.Field.prototype.msgTarget = 'side';    
    var datefield = new Ext.FormPanel({
        labelWidth: 100, // label settings here cascade unless overridden
        frame:true,
        title: 'Datepicker',
        bodyStyle:'padding:5px 5px 0',
        width: 360,
        defaults: {width: 220},
        defaultType: 'datefield',
        items: [{
                fieldLabel: 'Date',
                name: 'date',
                value:'2007-12-03 12:16',
                readOnly:true,
                format:'yyyy-MM-dd HH:mm:ss',
                timePicker : true
            }
        ]
    });
    datefield.render('startDay');
    
	if(Ext.DatePicker){	
		  Ext.apply(Ext.DatePicker.prototype, {	
		     todayText        : "今天",
		     minText          : "日期在最小日期之前",	
		     maxText          : "日期在最大日期之后",	
		     disabledDaysText : "",	
		     disabledDatesText : "",	
		     monthNames     : Date.monthNames,	
		     dayNames         : Date.dayNames,  
		     nextText         : '下月(Control+Right)',	
		     prevText         : '上月(Control+Left)',
		     monthYearText    : '选择一个月(Control+Up/Down来改变年)',
		     todayTip         : "{0} (Spacebar)",
		     okText           : "确定",
		     cancelText       : "取消",
		     format           : "y年m月d日"
		  });
		
		}    
    
}); 