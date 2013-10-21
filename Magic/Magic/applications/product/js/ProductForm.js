ProductForm = Ext.extend(Ext.magic.MagicForm, {
	title:'产品详细信息',
   	id:'ProductForm',
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	closable:true,
	autoScroll:true,
	buttonAlign:"left",
	constructor: function(config){
		var productIdTf = new Ext.form.TextField({
			fieldLabel: '产品标识',
			id:'productId',
			name:'product.productId',
			width:160,
			value:'',
			regex:/^[a-zA-Z0-9]+$/,
			regexText:'仅能输入大小写字母与数字',
			allowBlank:false
		});
		
		var productTypeStore = new Ext.data.JsonStore({
			//autoLoad:true,
			url: 'loadParams.action?actionType=productType',
			root:'dataset',
			fields: [
			         'description', 
			         'productTypeId'
			         ]
			        // ,
			//data:[['root','all'],['root2','info'],['root3','error']]
		});
		
		productTypeStore.load();
		
		var productTypeCbx = new Ext.form.ComboBox({
			id:'productTypeId',
			name:'product.productTypeId',
			hiddenName:'product.productTypeId',
			//hiddenValue:'root',
			fieldLabel:'产品类型',
	        store:productTypeStore,
	        displayField:'description',
	        valueField:'productTypeId',
	        //mode:'local',
	        //typeAhead: true,
	        editable:true,
	        //forceSelection: true,
	        triggerAction: 'all',
	        emptyText:'选择一个产品类型',
	        selectOnFocus:true
	    });
		
		var productBrandNameTf = new Ext.form.TextField({
			id:'brandName',
			fieldLabel: '品牌名称',
			name:'product.brandName',
			value:'',
			width:400
		});
		
		var productInternalNameTf = new Ext.form.TextField({
			id:'internalName',
			fieldLabel: '内部名称',
			name:'product.internalName',
			width:160,
			value:''
		});
		
		var productPinyinTf = new Ext.form.TextField({
			id:'pinyinCode',
			fieldLabel: '拼音码',
			name:'productKeyWords.pinyinCode',
			width:160,
			value:''
		});
		
		var productProvenanceTf = new Ext.form.TextField({
			id:'address1',
			fieldLabel: '产地',
			name:'partyPostalAddr.address1',
			value:'',
			width:400
		});
		
		var partyStore = new Ext.data.JsonStore({
			//autoLoad:true,
			url: 'partyLoader.action',
			root:'dataset',
			baseParams:{actionType:'LoadPartyByRoleType', roleTypeId:'SUPPLIER'},
			fields: [
			         'partyName', 
			         'partyId',
			         'roleTypeId'
			         ]
			        // ,
			//data:[['root','all'],['root2','info'],['root3','error']]
		});
		partyStore.load();
		
		var productSupplierCbx = new Ext.form.ComboBox({
			id:'partyId',
			name:'supplierProduct.partyId',
			hiddenName:'supplierProduct.partyId',
			//hiddenValue:'root',
			fieldLabel:'供应商',
	        store:partyStore,
	        displayField:'partyName',
	        valueField:'partyId',
	        //mode:'local',
	        //typeAhead: true,
	        editable:true,
	        //forceSelection: true,
	        triggerAction: 'all',
	        emptyText:'选择一个供应商',
	        selectOnFocus:true
	    });
		
		var productCommentsTf = new Ext.form.TextField({
			id:'comments',
			fieldLabel: '备注',
			name:'product.comments',
			value:'',
			width:670
		});
		
		var productBasicFs = new Ext.form.FieldSet({
			id:'baseInfoFs',
			xtype: 'fieldset',
	        title: '基本信息',
	        autoHeight:true,
	        //labelWidth:120,
	        width:1100,
	        //baseCls:'x-plain',
	        hideLabel:false,
	        layout:'table',
	        layoutConfig: {columns:4},
	        labelAlign:'left',
			items:[{//第一行
				layout:'form',
				items:[productIdTf]
			},{
				layout:'form',
				items:[productTypeCbx]
			},{
				layout:'form',
				colspan:2,
				items:[productBrandNameTf]
			},{//第二行
				layout:'form',
				items:[productInternalNameTf]
			},{
				layout:'form',
				items:[productPinyinTf]
			},{
				layout:'form',
				colspan:2,
				items:[productProvenanceTf]
			},{//第三行
				layout:'form',
				items:[productSupplierCbx]
			},{
				layout:'form',
				colspan:3,
				items:[productCommentsTf]
			}]
		});
		
		//规格信息
		var measureXMLUomStore = new Ext.data.XmlStore({
			autoDestroy: true,
		    storeId: 'measureUomStore',
		    url:util.constant.appPath+'applications/product/data/measureUom.xml',
		    // reader configs
		    record: 'MeasureItem', // 每条记录都有Item标签。records will have an "Item" tag
		    idPath: 'MeasureUomId',
		    totalRecords: '@total',
		    fields: [
		             'MeasureUomName',
		             'MeasureUomId'
		             ]
		});
		measureXMLUomStore.load();
		
		var weightUomStore = new Ext.data.XmlStore({
			autoDestroy: true,
		    storeId: 'weightUomStore',
		    url:util.constant.appPath+'applications/product/data/weightUom.xml',
		    // reader configs
		    record: 'WeightItem', // 每条记录都有Item标签。records will have an "Item" tag
		    idPath: 'WeightUomId',
		    totalRecords: '@total',
		    fields: [
		             'WeightUomName',
		             'WeightUomId'
		             ]
		});
		weightUomStore.load();
		
		var quantityUomStore = new Ext.data.XmlStore({
			autoDestroy: true,
		    storeId: 'quantityUomStore',
		    url:util.constant.appPath+'applications/product/data/quantityUom.xml',
		    // reader configs
		    record: 'QuantityItem', // 每条记录都有Item标签。records will have an "Item" tag
		    idPath: 'QuantityUomId',
		    totalRecords: '@total',
		    fields: [
		             'QuantityUomName',
		             'QuantityUomId'
		             ]
		});
		quantityUomStore.load();
		
		var productMeasuresFs = new Ext.form.FieldSet({
			id:'measuresFs',
			xtype: 'fieldset',
	        title: '规格及数量',
	        autoHeight:true,
	        //labelWidth:120,
	        width:1100,
	        //baseCls:'x-plain',
	        hideLabel:false,
	        layout:'table',
	        layoutConfig: {columns:4},
	        labelAlign:'left',
			items:[{//第一行
				layout:'form',
				items:[{
					xtype:'textfield',
					id:'productHeight',
					fieldLabel: '产品高度',
					name:'product.productHeight',
					width:160
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'combo',
					store:measureXMLUomStore,
					mode: 'local',
					id:'heightUomId',
					fieldLabel: '高度单位',
					name:'product.heightUomId',
					hiddenName:'product.heightUomId',
					width:160,
					displayField:'MeasureUomName',
			        valueField:'MeasureUomId',
			        editable:false,
			        forceSelection: true,
			        triggerAction: 'all'
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'textfield',
					id:'productWidth',
					fieldLabel: '产品宽度',
					name:'product.productWidth',
					width:160
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'combo',
					store:measureXMLUomStore,
					mode: 'local',
					id:'widthUomId',
					fieldLabel: '宽度单位',
					name:'product.widthUomId',
					hiddenName:'product.widthUomId',
					width:160,
					displayField:'MeasureUomName',
			        valueField:'MeasureUomId',
			        editable:false,
			        forceSelection: true,
			        triggerAction: 'all'
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'textfield',
					id:'productDepth',
					fieldLabel: '产品长度',
					name:'product.productDepth',
					width:160
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'combo',
					store:measureXMLUomStore,
					mode: 'local',
					id:'depthUomId',
					fieldLabel: '长度单位',
					name:'product.depthUomId',
					hiddenName:'product.depthUomId',
					width:160,
					displayField:'MeasureUomName',
			        valueField:'MeasureUomId',
			        editable:false,
			        forceSelection: true,
			        triggerAction: 'all'
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'textfield',
					id:'weight',
					fieldLabel: '重量',
					name:'product.weight',
					width:160
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'combo',
					store:weightUomStore,
					mode: 'local',
					id:'weightUomId',
					fieldLabel: '重量单位',
					name:'product.weightUomId',
					hiddenName:'product.weightUomId',
					width:160,
					displayField:'WeightUomName',
			        valueField:'WeightUomId',
			        editable:false,
			        forceSelection: true,
			        triggerAction: 'all'
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'textfield',
					id:'quantityIncluded',
					fieldLabel: '数量',
					name:'product.quantityIncluded',
					width:160
				}],
				colspan:2
			},{//第一行
				layout:'form',
				items:[{
					xtype:'combo',
					store:quantityUomStore,
					mode: 'local',
					id:'quantityUomId',
					fieldLabel: '数量单位',
					name:'product.quantityUomId',
					hiddenName:'product.quantityUomId',
					width:160,
					displayField:'QuantityUomName',
			        valueField:'QuantityUomId',
			        editable:false,
			        forceSelection: true,
			        triggerAction: 'all'
				}],
				colspan:2
			}]
		});
		
		var formItems = [productBasicFs,productMeasuresFs];
		
		var formButtons = [
		            {
		            text: '保存',
		            type:'submit',
		            handler:function(){
		            	Ext.getCmp('ProductForm').doSubmitAction({url:'productManager.action'});
		        	}
		        },{
		            text: '重置',
		            type:'reset',
		            handler:function(){form.form.reset();}
		        }];
		        	
		ProductForm.superclass.constructor.call(this, {items:formItems, buttons:formButtons});
	},
	configComponent:function(options){
//		alert(options.record.get('productId'));
		this.getForm().loadRecord(options.record);
	}
});