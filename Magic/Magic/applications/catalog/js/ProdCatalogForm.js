ProdCatalogForm = Ext.extend(Ext.magic.MagicForm, {
   	id:'ProdCatalogForm',
	title:"目录信息",
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	buttonAlign:"left",
	constructor: function(config){
		
		var catalogDetailFs = new Ext.form.FieldSet({
		  	id:'catalogDetailFs',
		  	columnWidth: 0.3,
			xtype: 'fieldset',
	        title: '目录详细信息',
	        autoHeight:true,
	        hideLabel:false,
	        layout:'table',
	        layoutConfig: {columns:1},
	        buttonAlign:'right',
			items:[
				{
	    			layout:'form',
	    			items:[{
	    				  xtype:'textfield',
	    				  id:'catalogName',
	                      fieldLabel: '目录名称',
	                      name: 'prodCatalog.catalogName'
	                  }]
	    		},{
	    			layout:'form',
	    			items:[{
	    				xtype:'textfield',
	    				id:'styleSheet',
	                      fieldLabel: '风格页',
	                      name: 'prodCatalog.styleSheet'
	                  }]
	    		},{
	    			layout:'form',
	    			items:[{
	    					xtype:'textfield',
	    					id:'headerLogo',
	                      	fieldLabel: '头标识',
	                      	name: 'prodCatalog.headerLogo'
	                  }]
	    		},{
	    			layout:'form',
	    			items:[{
	    					xtype:'textfield',
	    					width:200,
	    					id:'contentPathPrefix',
	    					fieldLabel: '内容路径前缀',
	    					name: 'prodCatalog.contentPathPrefix'
	                  }]
	    		},{
	    			layout:'form',
	    			items:[{
	    				xtype:'textfield',
	    				width:200,
	    				id:'templatePathPrefix',
	    				fieldLabel: '模板路径前缀',
	    				name: 'prodCatalog.templatePathPrefix'
	              }]
	    		}]
	    		
		});
		
		ProdCatalogForm.superclass.constructor.call(this, {items:catalogDetailFs});
	},
	configComponent:function(options){

		var prodCatalogIdTf = new Ext.form.TextField({
			id:'prodCatalogId',
			xtype:'textfield',
			fieldLabel: '目录标识',
			name: 'prodCatalog.prodCatalogId',
			allowBlank:false
		});
		
		if(options.operation == 'update'){
			prodCatalogIdTf.setValue(options.record.get('prodCatalogId'));
			prodCatalogIdTf.readOnly=true;
			prodCatalogIdTf.addClass('x-item-disabled');
			
			var tf = {//第一行
				layout:'form',
				items:[prodCatalogIdTf]
	    		};
			this.get('catalogDetailFs').insert(0, tf);
			this.getForm().loadRecord(options.record);
			
		}else{
			
			var tf = {//第一行
				layout:'form',
				items:[prodCatalogIdTf]
	    		};
			this.get('catalogDetailFs').insert(0, tf);
		}
		
		
	}
});