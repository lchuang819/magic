<script type="text/javascript">

Ext.onReady(function(){
	LoadProductCostsGrid = Ext.extend(Ext.grid.GridPanel, {
		id:'LoadProductCostsGrid',
		autoWidth:true,
		bodyStyle:'padding:5px 5px 0;height:95%;width:100%;',
	    frame:true,
	    //title:'价格配置列表',
	    iconCls:'icon-grid',
	    closable:true,
	    autoDestroy:true,
	    autoScroll:true,
	    //autoExpandColumn:'description',
	    sm: new Ext.grid.RowSelectionModel({
	        singleSelect: true
	    }),
	    viewConfig: {
            forceFit:true,
            enableRowBody:true
	    },
	    listeners:{
			scope:this,
			rowdblclick:function(cgrid, index, e){
				var cRecord = cgrid.store.getAt(index);
	//			Ext.getCmp("ProductCostsForm").getForm().loadRecord(cRecord);
				var win = new Ext.CommonSubmitWindow({
					title:'更新',
					url:'productCostsManager.action?actionType=UpdateProductCategory',
					formId:'ProductCostsForm',
					store:cgrid.store
				});
			       
				AjaxEvalScript({
					container:win, 
					containerType:'window', 
					url:'applications/product/js/ProductPriceForm.js', 
					varName:'ProductCostsForm',
					record:cRecord,
					callCfg:true,
					operation:'update'
				});
			}
		},
		initComponent: function(){
			this.toolbar = new Ext.Toolbar({
				items:[{
						text:'创建新的',
						iconCls:'icon-add',
						scope: this,
						handler:this.createNewCatalog
					},{
						text:'删除记录',
						iconCls:'icon-delete',
						scope: this,
						handler:this.deleteCatalog
					},
					'-',
					{
						text:'双击编辑数据',
						xtype:'label'
					}]
			});
		    
			this.items = [this.toolbar];
			LoadProductCostsGrid.superclass.initComponent.call(this);
		},
		constructor: function(config){
			var prodCatalogStore = new Ext.data.JsonStore({
				autoLoad:true,
				url: 'productCostsLoader.action',
				root:'dataset',
				fields: [
				         'productId', 
				         'productPriceTypeDesc',
				         'productPricePurposeDesc',
				         'currencyUomId',
				         'productStoreGroupId',
				         'fromDate',
				         'thurDate',
				         'price'
				         ]
			});
			
		var colModel = [
	            {id:'costComponentId',header: '成本组成标识', width:'auto', sortable: true, locked:false, dataIndex: 'costComponentId'},
	            {header: '成本组成类型', width:120, sortable: true, dataIndex: 'costComponentTypeId'},
				{header: '成本',width:120,  sortable: true, dataIndex: 'cost'},
	            {header: '货币', width:120, sortable: true, dataIndex: 'costUomId'},
	            {header: '起始日期和时间', width:120, sortable: true, dataIndex: 'fromDate'},
	            {header: '结束日期和时间',width:120,  sortable: true, dataIndex: 'thruDate'},
	            {header: '产品特征标识', width:120, sortable: true, dataIndex: 'productFeatureId'},
				{header: '会员标识', width:120, sortable: true, dataIndex: 'partyId'},
	            {header: '地理标识',width:120,  sortable: true, dataIndex: 'geoId'},
	            {header: '成本组成计算标识',width:120,  sortable: true, dataIndex: 'costComponentCalcId'}
	        ];
	                    
			LoadProductCostsGrid.superclass.constructor.call(this, {store:prodCatalogStore, columns:colModel});
		},
		createNewCatalog:function(){
			var ds = this.store;		
			var win = new Ext.CommonSubmitWindow({
				title:'创建新的',
				url:'productCostsManager.action?actionType=CreateProductPrice',
				formId:'ProductCostsForm',
				store:ds,
				hideBtn:true
			});
		       
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/product/js/ProductCostsForm.js', 
				varName:'ProductCostsForm',
				CmpId:'ProductCostsForm',
				callCfg:true
			});
		},
		deleteCatalog:function(){
			var rec = this.getSelectionModel().getSelected();
			if(rec == undefined){
				return;
			}
			var ds = this.store;
			
			Ext.MessageBox.confirm('删除', '确认删除该记录?', function(btn){
				if('yes' == btn){
					DataConnectionSubmit({
						url:'productCostsManager.action?actionType=DeleteProductCategory',
						params:{'productCategory.productCategoryId':rec.get('productCategoryId')},
						store:ds,
						record:rec
					});
				}
			});
		}
	
	});
	
	var productPriceGrid = new LoadProductCostsGrid();
	productPriceGrid.render('productcostsinfo');
});

</script>

<div id="productcostsinfo"></div>