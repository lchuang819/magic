ProductCategoryForm = Ext.extend(Ext.magic.MagicForm, {
   	id:'ProductCategoryForm',
	title:"分类信息",
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	buttonAlign:"left",
	constructor: function(config){
		
		var categoryDetailFs = new Ext.form.FieldSet({
		  	id:'categoryDetailFs',
		  	columnWidth: 0.3,
			xtype: 'fieldset',
	        title: '分类详细信息',
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
	    				  id:'categoryName',
	                      fieldLabel: '分类名称',
	                      name: 'productCategory.categoryName'
	                  }]
	    		},{
	    			layout:'form',
	    			items:[{
	    				xtype:'textfield',
	    				id:'description',
	                      fieldLabel: '描述',
	                      width:200,
	                      name: 'productCategory.description'
	                  }]
	    		},{
	    			layout:'form',
	    			items:[{
	    					xtype:'textfield',
	    					width:200,
	    					id:'categoryImageUrl',
	    					fieldLabel: '分类图像URL',
	    					name: 'productCategory.categoryImageUrl'
	                  }]
	    		},{
	    			layout:'form',
	    			items:[{
	    				xtype:'textfield',
	    				width:200,
	    				id:'linkOneImageUrl',
	    				fieldLabel: '链接图像1URL',
	    				name: 'productCategory.linkOneImageUrl'
	              }]
	    		},{
	    			layout:'form',
	    			items:[{
	    				xtype:'textfield',
	    				width:200,
	    				id:'linkTwoImageUrl',
	    				fieldLabel: '链接图像2URL',
	    				name: 'productCategory.linkTwoImageUrl'
	              }]
	    		}]
	    		
		});
		
		ProductCategoryForm.superclass.constructor.call(this, {items:categoryDetailFs});
	},
	configComponent:function(options){

		//分类标识
		var productCategoryIdTf = new Ext.form.TextField({
			id:'productCategoryId',
			xtype:'textfield',
			fieldLabel: '分类标识',
			name: 'productCategory.productCategoryId',
			allowBlank:false
		});
		
		//分类类型ComboBox
		var hiddenValue = '';
		var value = '';
		var priValue = '';
		if(options.record != undefined){
			hiddenValue = options.record.get('productCategoryTypeId');
			value = options.record.get('productCategoryTypeDesc');
			priValue = options.record.get('primaryParentCategoryId');
		}
		
		var productCategoryTypeCbx = new Ext.magic.LocalDataComboBox({
			fieldLabel: '分类类型',
			name:'productCategoryTypeId',
			dataStoreUrl:'applications/catalog/data/categoryType.xml',
			hiddenName:'productCategory.productCategoryTypeId',
			hiddenValue:hiddenValue
		});
		
		productCategoryTypeCbx.setValue(value);
		
		var productCategoryTypeCbxItem = {//第一行
				layout:'form',
				items:[productCategoryTypeCbx]
	    		};
		
		//主要上级分类
		var prodCatalogStore = new Ext.data.JsonStore({
			autoLoad:true,
			url: 'categoryLoader.action',
			root:'dataset',
			fields: [
			         'productCategoryId', 
			         'productCategoryTypeId',
			         'productCategoryTypeDesc',
			         'categoryName',
			         'description',
			         'categoryImageUrl',
			         'linkOneImageUrl',
			         'linkTwoImageUrl',
			         'primaryParentCategoryId'
			         ]
		});
		
		var primaryParendCategoryCbx = new Ext.form.ComboBox({
			//xtype:"combo",
			fieldLabel:"主要上级分类",
			mode:'local',
			store:prodCatalogStore,
			displayField:'productCategoryId',
	        valueField:'productCategoryId',
	        triggerAction: 'all',
	        emptyText:'选择分类',
	        //selectOnFocus:true,
	        forceSelection: true,
			name:'primaryParentCategoryId',
			hiddenName:'productCategory.primaryParentCategoryId',
			anchor:"100%"
		});
	
		primaryParendCategoryCbx.setValue(priValue);
		
		var priCbxItem = {
			layout:'form',
			items:[primaryParendCategoryCbx]
		};
		
		if(options.operation == 'update'){
			//后插入到FORM中的条目无法通过loadRecord加载数据
			productCategoryIdTf.setValue(options.record.get('productCategoryId'));
			productCategoryIdTf.readOnly=true;
			productCategoryIdTf.addClass('x-item-disabled');
			var tf = {//第一行
				layout:'form',
				items:[productCategoryIdTf]
	    		};
			this.get('categoryDetailFs').insert(0, tf);
			this.getForm().loadRecord(options.record);
			
		}else{
			
			var tf = {//第一行
				layout:'form',
				items:[productCategoryIdTf]
	    		};
			this.get('categoryDetailFs').insert(0, tf);
		}
		
		this.get('categoryDetailFs').insert(1, productCategoryTypeCbxItem);
		this.get('categoryDetailFs').insert(4, priCbxItem);
		
	}
});