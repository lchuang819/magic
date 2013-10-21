LoadProdCatalog = Ext.extend(Ext.grid.GridPanel, {
	id:'LoadProdCatalog',
	width:600,
    height: 350,
    frame:true,
    title:'目录列表',
    iconCls:'icon-grid',
    closable:true,
    autoDestroy:true,
//    store: prodCatalogStore,
//    columns: colModel,
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
//				Ext.getCmp("prodCatalogForm").getForm().loadRecord(cRecord);
			var win = new Ext.CommonSubmitWindow({
				title:'更新',
				url:'catalogManager.action?actionType=UpdateProdCatalog',
				formId:'ProdCatalogForm',
				store:cgrid.store
			});
		       
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/catalog/js/ProdCatalogForm.js', 
				varName:'ProdCatalogForm',
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
		LoadProdCatalog.superclass.initComponent.call(this);
	},
	constructor: function(config){
		var prodCatalogStore = new Ext.data.JsonStore({
			autoLoad:true,
			url: 'catalogLoader.action?actionType=',
			root:'dataset',
			fields: [
			         'prodCatalogId', 
			         'catalogName',
			         'useQuickAdd',
			         'styleSheet',
			         'headerLogo',
			         'contentPathPrefix',
			         'templatePathPrefix'
			         ]
			        // ,
			//data:[['root','all'],['root2','info'],['root3','error']]
		});

//          // example of custom renderer function
//          function italic(value){
//              return '<i>' + value + '</i>';
//          }
//
//          // example of custom renderer function
//          function change(val){
//              if(val > 0){
//                  return '<span style="color:green;">' + val + '</span>';
//              }else if(val < 0){
//                  return '<span style="color:red;">' + val + '</span>';
//              }
//              return val;
//          }
//          // example of custom renderer function
//          function pctChange(val){
//              if(val > 0){
//                  return '<span style="color:green;">' + val + '%</span>';
//              }else if(val < 0){
//                  return '<span style="color:red;">' + val + '%</span>';
//              }
//              return val;
//          }
          

          // the DefaultColumnModel expects this blob to define columns. It can be extended to provide
          // custom or reusable ColumnModels
          var colModel = [
              {id:'prodCatalogId',header: "目录标识", sortable: true, locked:false, dataIndex: 'prodCatalogId'},
              {header: "目录名称", sortable: true, dataIndex: 'catalogName'},
              {header: "风格页", sortable: true, dataIndex: 'styleSheet'},
              {header: "头标识", sortable: true, dataIndex: 'headerLogo'},
              {header: "内容路径前缀", sortable: true, dataIndex: 'contentPathPrefix'},
              {header: "模板路径前缀", sortable: true, dataIndex: 'templatePathPrefix'}
          ];
          
//          this.columns = colModel;
//          this.store = prodCatalogStore;
          LoadProdCatalog.superclass.constructor.call(this, {store:prodCatalogStore, columns:colModel});
	},
	createNewCatalog:function(){
		
		var ds = this.store;		
		var win = new Ext.CommonSubmitWindow({
			title:'更新',
			url:'catalogManager.action?actionType=CreateProdCatalog',
			formId:'ProdCatalogForm',
			store:ds
		});
	       
		AjaxEvalScript({
			container:win, 
			containerType:'window', 
			url:'applications/catalog/js/ProdCatalogForm.js', 
			varName:'ProdCatalogForm',
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
					url:'catalogManager.action?actionType=DeleteProdCatalog',
					params:{'prodCatalog.prodCatalogId':rec.get('prodCatalogId')},
					store:ds,
					record:rec
				});
			}
		});


	}
});