Ext.onReady(function(){
	
	new Ext.form.DateField({
		renderTo:'startDay',
		format:'Y-m-d',
		name:'startDay',
		value:new Date(),
		width:200
   });	
	new Ext.form.DateField({
		renderTo:'endDay',
		format:'Y-m-d',
		name:'endDay',
		value:new Date(),
		width:200
   });
	new Ext.form.TimeField({
		renderTo:'startTime',
		name:'startTime',
		format:'H:i',
		value:new Date(),
		width:200
   });
	new Ext.form.TimeField({
		renderTo:'endTime',
		name:'endTime',
		format:'H:i',
		value:new Date(),
		width:200
   });         


});
