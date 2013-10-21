LoadProductCategory = Ext.extend(Ext.grid.GridPanel, {
	id:'LoadProductCategory',
	width:600,
    height: 350,
    frame:true,
    title:'分类列表',
    iconCls:'icon-grid',
    closable:true,
    autoDestroy:true,
    autoExpandColumn:'description',
    sm: new Ext.grid.RowSelectionModel({
        singleSelect: true
    }),
    viewConfig:{
//		autoFill:true
		forceFit:true
	},
    listeners:{
		scope:this,
		rowdblclick:function(cgrid, index, e){

			var cRecord = cgrid.store.getAt(index);
	//			Ext.getCmp("prodCatalogForm").getForm().loadRecord(cRecord);
			var win = new Ext.CommonSubmitWindow({
				title:'更新',
				url:'categoryManager.action?actionType=UpdateProductCategory',
				formId:'ProductCategoryForm',
				store:cgrid.store
			});
		       
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/catalog/js/ProductCategoryForm.js', 
				varName:'ProductCategoryForm',
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
		LoadProductCategory.superclass.initComponent.call(this);
	},
	constructor: function(config){
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
			        // ,
			//data:[['root','all'],['root2','info'],['root3','error']]
		});
		
		var colModel = [
            {id:'productCategoryId',header: "分类标识", width:120, sortable: true, locked:false, dataIndex: 'productCategoryId'},
            {header: "分类类型", sortable: true, width:120,dataIndex: 'productCategoryTypeDesc'},
//            {header: "分类类型标识", sortable: true, width:120,dataIndex: 'productCategoryTypeId'},
            {header: "分类名称", sortable: true, width:160,dataIndex: 'categoryName'},
            {id:'description', header: "描述", sortable: true, dataIndex: 'description'},
            {header: "主要上级分类", sortable: true, dataIndex: 'primaryParentCategoryId'},
            {header: "分类图像URL", sortable: true, dataIndex: 'categoryImageUrl'},
            {header: "链接图像1URL", sortable: true, dataIndex: 'linkOneImageUrl'},
            {header: "链接图像2URL", sortable: true, dataIndex: 'linkTwoImageUrl'}
        ];
                    
		LoadProductCategory.superclass.constructor.call(this, {store:prodCatalogStore, columns:colModel});
	},
	createNewCatalog:function(){
		var ds = this.store;		
		var win = new Ext.CommonSubmitWindow({
			title:'更新',
			url:'categoryManager.action?actionType=CreateProductCategory',
			formId:'ProductCategoryForm',
			store:ds
		});
	       
		AjaxEvalScript({
			container:win, 
			containerType:'window', 
			url:'applications/catalog/js/ProductCategoryForm.js', 
			varName:'ProductCategoryForm',
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
					url:'categoryManager.action?actionType=DeleteProductCategory',
					params:{'productCategory.productCategoryId':rec.get('productCategoryId')},
					store:ds,
					record:rec
				});
			}
		});
	}

});