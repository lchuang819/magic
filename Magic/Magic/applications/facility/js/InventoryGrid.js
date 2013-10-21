InventoryGrid = Ext.extend(Ext.grid.GridPanel, {
	id:'InventoryGrid',
	width:600,
    height: 350,
    frame:true,
    title:'仓库列表',
    iconCls:'icon-grid',
    closable:true,
    autoDestroy:true,
//    store: prodCatalogStore,
//    columns: colModel,
    sm: new Ext.grid.RowSelectionModel({
        singleSelect: true
    }),
    listeners:{
  		scope:this,
  		rowdblclick:function(cgrid, index, e){

			var cRecord = cgrid.store.getAt(index);
//				Ext.getCmp("facilityForm").getForm().loadRecord(cRecord);
			var win = new Ext.CommonSubmitWindow({
				title:'更新',
				url:'facilityManager.action?actionType=UpdateFacility',
				formId:'InventoryForm',
				store:cgrid.store
			});
		       
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/facility/js/InventoryForm.js', 
				varName:'InventoryForm',
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
		InventoryGrid.superclass.initComponent.call(this);
	},
	constructor: function(config){
		var facilityStore = new Ext.data.JsonStore({
			autoLoad:true,
			url: 'facilityLoader.action?actionType=',
			root:'dataset',
			fields: [
			         'facilityId', 
			         'facilityName',
			         'ownerPartyId',
			         'description',
			         'openedDate',
			         'closedDate'
			         ]
		});
		
		var colModel = [
			{id:'facilityId',header: "仓库标识", sortable: true, locked:false, dataIndex: 'facilityId'},
			{header: "仓库名称", sortable: true, dataIndex: 'facilityName'},
			{header: "仓库拥有者", sortable: true, dataIndex: 'ownerPartyId'},
			{header: "描述信息", sortable: true, dataIndex: 'description'},
			{header: "开放日期", sortable: true, dataIndex: 'contentPathPrefix'},
			{header: "关闭日期", sortable: true, dataIndex: 'templatePathPrefix'}
			];
          
//          this.columns = colModel;
//          this.store = facilityStore;
		InventoryGrid.superclass.constructor.call(this, {store:facilityStore, columns:colModel});
	},
	createNewCatalog:function(){
		
		var ds = this.store;		
		var win = new Ext.CommonSubmitWindow({
			title:'创建',
			url:'facilityManager.action?actionType=CreateFacility',
			formId:'InventoryForm'
		});
	       
		AjaxEvalScript({
			container:win, 
			containerType:'window', 
			url:'applications/facility/js/InventoryForm.js', 
			varName:'InventoryForm',
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
					url:'facilityManager.action?actionType=DeleteInventory',
					params:{'facility.facilityId':rec.get('facilityId')},
					store:ds,
					record:rec
				});
			}
		});


	},
	configComponent:function(){
		
	}
});