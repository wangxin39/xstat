
JLComboBox = Ext.extend(Ext.form.ComboBox,{
		valueField:'id',
		displayField:'label',
		emptyText:'请选择',
		mode:'local',
		triggerAction:'all',
		initComponent:function() {
			this.children=[];
			
			JLComboBox.superclass.thisComponent.apply(this,arguments);
			
			this.store = new Ext.data.Store({
				baseParams:this.params || {},
				proxy:new Ext.data.HttpProxy({
					url:this.dataUrl
					}),
				reader:new Ext.data.JsonReader({
					root:dms',
					id:'id',
					totalProperty:'total'
					},[
						{name:'id',mapping:'id'},
						{name:'label',mapping:'label'}
					])
			});	
		},
		setDefaultValue:function(v) {
			this.setValue(v);
			
			this.fireEvent('select',this);	
		},
		addParam:function(parameters) {
			Ext.apply(this.store.baseParams,parameters);	
		},
		listeners:{
			select:function(combo,record,index) {
				Ext.each(this.children,function(child){
					child.addParam({parent:combo.value});	
					
					child.reload();
				});	
			}
		},
		addChild:function(child) {
			this.children.push(child);
			return this;	
		},
		reload:function() {
			if(this.store) {
				this.store.load();	
			}
			if(this.defaultValue) {
				this.setDefaultValue(this.defaultValue);
				this.defaultValue = null;
			}
			return this;
		}
});
