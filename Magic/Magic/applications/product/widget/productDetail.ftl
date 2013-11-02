<script type="text/javascript">

Ext.onReady(function(){
	
	var productIdTf = new Ext.form.TextField({
		fieldLabel: '产品标识',
		id:'productId',
		name:'product.productId',
		width:160,
		value:'${productDetail.productId}',
		regex:/^[a-zA-Z0-9_]+$/,
		regexText:'仅能输入大小写字母与数字',
		allowBlank:false,
		readOnly:true,
		cls:'x-item-disabled'
	});
		
	var productTypeStore = new Ext.data.JsonStore({
		autoLoad:true,
		url: 'loadParams.action?actionType=productType',
		root:'dataset',
		fields: [
		         'description', 
		         'productTypeId'
		         ]
		        // ,
		//data:[['root','all'],['root2','info'],['root3','error']]
	});
	
	//productTypeStore.load();
	
	var productTypeCbx = new Ext.form.ComboBox({
		id:'productTypeId',
		name:'product.productTypeId',
		hiddenName:'product.productTypeId',
		hiddenValue:'${productDetail.productTypeId?default('')}',
		fieldLabel:'产品类型',
        store:productTypeStore,
        displayField:'description',
        valueField:'productTypeId',
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
		value:'${productDetail.brandName?default('')}',
		width:400
	});
	
	var productInternalNameTf = new Ext.form.TextField({
		id:'internalName',
		fieldLabel: '内部名称',
		name:'product.internalName',
		width:160,
		value:'${productDetail.internalName?default('')}'
	});
	
	var productPinyinTf = new Ext.form.TextField({
		id:'pinyinCode',
		fieldLabel: '拼音码',
		name:'productKeyWords.pinyinCode',
		width:160,
		value:'${productDetail.pinyinCode?default('')}'
	});
	
	var productProvenanceTf = new Ext.form.TextField({
		id:'address1',
		fieldLabel: '产地',
		name:'partyPostalAddr.address1',
		value:'${productDetail.address1?default('')}',
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
		name:'supplierProductId.partyId',
		hiddenName:'supplierProductId.partyId',
		hiddenValue:'${productDetail.partyId?default('')}',
		value:'${productDetail.partyName?default('')}',
		fieldLabel:'供应商',
        store:partyStore,
        displayField:'partyName',
        valueField:'partyId',
        editable:true,
        triggerAction: 'all',
        emptyText:'选择一个供应商',
        selectOnFocus:true
    });
	
	var productCommentsTf = new Ext.form.TextField({
		id:'comments',
		fieldLabel: '备注',
		name:'product.comments',
		value:'${productDetail.comments?default('')}',
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
				width:160,
				value:'${productDetail.productHeight?default('')}'
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
		        triggerAction: 'all',
				value:'${productDetail.heightUomId?default('')}',
				hiddenValue:'${productDetail.heightUomId?default('')}'
			}],
			colspan:2
		},{//第一行
			layout:'form',
			items:[{
				xtype:'textfield',
				id:'productWidth',
				fieldLabel: '产品宽度',
				name:'product.productWidth',
				width:160,
				value:'${productDetail.productWidth?default('')}',
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
		        triggerAction: 'all',
				value:'${productDetail.widthUomId?default('')}',
				hiddenValue:'${productDetail.widthUomId?default('')}'
			}],
			colspan:2
		},{//第一行
			layout:'form',
			items:[{
				xtype:'textfield',
				id:'productDepth',
				fieldLabel: '产品长度',
				name:'product.productDepth',
				width:160,
				value:'${productDetail.productDepth?default('')}'
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
		        triggerAction: 'all',
				value:'${productDetail.depthUomId?default('')}',
				hiddenValue:'${productDetail.depthUomId?default('')}'
			}],
			colspan:2
		},{//第一行
			layout:'form',
			items:[{
				xtype:'textfield',
				id:'weight',
				fieldLabel: '重量',
				name:'product.weight',
				width:160,
				value:'${productDetail.weight?default('')}'
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
		        triggerAction: 'all',
				value:'${productDetail.weightUomId?default('')}',
				hiddenValue:'${productDetail.weightUomId?default('')}'
			}],
			colspan:2
		},{//第一行
			layout:'form',
			items:[{
				xtype:'textfield',
				id:'quantityIncluded',
				fieldLabel: '数量',
				name:'product.quantityIncluded',
				width:160,
				value:'${productDetail.quantityIncluded?default('')}'
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
		        triggerAction: 'all',
				value:'${productDetail.quantityUomId?default('')}',
				hiddenValue:'${productDetail.quantityUomId?default('')}'
			}],
			colspan:2
		}]
	});
		
	var simple = new Ext.form.FormPanel({
        labelWidth: 75,
        bodyStyle:'padding:5px 5px 0;height:92%',
        labelAlign:'right',
        defaultType: 'textfield',
		buttonAlign:'left',
		frame:true,
		autoScroll:true,
		autoDestroy:true,
        items: [productBasicFs, productMeasuresFs],
        buttons:[{
	            text: '保存',
	            type:'submit',
	            handler:function(){
		        	simple.form.submit({
		        		url:'productManager.action?actionType=UpdateProduct',
		    		    method : 'POST',
		        		success:function(form, action){
		        			Ext.MessageBox.alert('提示', '操作成功');
		        		},
		        		failure:function(form, action){
		        			var msg = action.result.msg;
	        				if(action.failureType=='connect'){
	        					msg = '连接服务器失败，请稍后再试';
	        				}else if(action.failureType=='client'){
	        					msg = '输入信息错误';
	        				}
	        				
	        				Ext.MessageBox.show({title: '失败',msg:'操作失败:'+msg,buttons: Ext.MessageBox.OK,icon: Ext.MessageBox.ERROR});
		        		}
		        	});
	        	}
				},{
		            text: '重置',
		            type:'reset',
		            handler:function(){simple.form.reset();}
		        }]
    });
	
	//simple.render('productbasicinfo');
//	var viewport = new Ext.Viewport({
//        layout: 'fit',
//        items: [
//        	         simple
//        ]
//	
//	});
	

	
	simple.render('productbasicinfo');
	
});
</script>

<div id="productbasicinfo" style="height:100%"></div>