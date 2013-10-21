<script type="text/javascript">

Ext.onReady(function(){
	LoadProductPriceGrid = Ext.extend(Ext.grid.GridPanel, {
		id:'LoadProductPriceGrid',
		//width:600,
	    height: 350,
	    frame:true,
	    //title:'价格配置列表',
	    iconCls:'icon-grid',
	    closable:true,
	    autoDestroy:true,
	    loadMask:'Loading...',
	    //autoExpandColumn:'description',
	    sm: new Ext.grid.RowSelectionModel({
	        singleSelect: true
	    }),
	    listeners:{
			scope:this,
			rowdblclick:function(cgrid, index, e){
				var cRecord = cgrid.store.getAt(index);
	//			Ext.getCmp("ProductPriceForm").getForm().loadRecord(cRecord);
				var win = new Ext.CommonSubmitWindow({
					title:'更新',
					url:'productPriceManager.action?actionType=UpdateProductPrice',
					formId:'ProductPriceForm',
					store:cgrid.store
				});
			       
				AjaxEvalScript({
					container:win, 
					containerType:'window', 
					url:'applications/product/js/ProductPriceForm.js', 
					varName:'ProductPriceForm',
					params:{productId:'${productDetail.productId?default('')}'},
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
			LoadProductPriceGrid.superclass.initComponent.call(this);
		},
		constructor: function(config){
			var prodCatalogStore = new Ext.data.JsonStore({
				autoLoad:true,
				url: 'productPriceLoader.action?productId=${productDetail.productId?default('')}',
				root:'dataset',
				fields: [
				         'productId',
				         'productPriceTypeId',
				         'productPriceTypeDesc',
				         'productPricePurposeId',
				         'productPricePurposeDesc',
				         'currencyUomId',
				         'productStoreGroupId',
				         'fromDate',
				         'thruDate',
				         'price'
				         ]
			});
			
		var colModel = [
	            {id:'productId',header: '产品标识', width:120, sortable: true, locked:false, dataIndex: 'productId'},
	            {header: '价格', width:120, sortable: true, dataIndex: 'price'},
	            {header: '价格类型', width:120, sortable: true, dataIndex: 'productPriceTypeDesc'},
				{header: '目的', width:120, sortable: true, dataIndex: 'productPricePurposeDesc'},
	            {header: '货币', width:120, sortable: true, dataIndex: 'currencyUomId'},
	            //{header: '店铺组',width:120,  sortable: true, dataIndex: 'productStoreGroupId'},
	            {header: '起始日期和时间', width:160, sortable: true, renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s'), dataIndex: 'fromDate'},
	            {header: '结束日期和时间',width:160,  sortable: true, renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s'), dataIndex: 'thruDate'}
	        ];
	                    
			LoadProductPriceGrid.superclass.constructor.call(this, {store:prodCatalogStore, columns:colModel});
		},
		createNewCatalog:function(){
			var ds = this.store;		
			var win = new Ext.CommonSubmitWindow({
				title:'创建新的',
				url:'productPriceManager.action?actionType=CreateProductPrice',
				formId:'ProductPriceForm',
				store:ds,
				hideBtn:false
			});
		       
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/product/js/ProductPriceForm.js', 
				varName:'ProductPriceForm',
				CmpId:'ProductPriceForm',
				params:{productId:'${productDetail.productId?default('')}'},
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
						url:'productPriceManager.action?actionType=DeleteProductPrice',
						params:{productId:'${productDetail.productId?default('')}', productPriceTypeId:rec.get('productPriceTypeId'), fromDate:rec.get('fromDate')},
						store:ds,
						record:rec
					});
				}
			});
		}
	
	});
	
	var productPriceGrid = new LoadProductPriceGrid();
	productPriceGrid.render('productpriceinfo');
});

</script>

<div id="productpriceinfo"></div>