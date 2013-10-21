WarehouseGrid = Ext.extend(Ext.grid.GridPanel, {
	id:'WarehouseGrid',
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
    viewConfig:{
//		autoFill:true
		forceFit:true
	},
    listeners:{
  		scope:this,
  		rowdblclick:function(cgrid, index, e){

			var cRecord = cgrid.store.getAt(index);
//				Ext.getCmp("facilityForm").getForm().loadRecord(cRecord);
			var win = new Ext.CommonSubmitWindow({
				title:'更新',
				url:'facilityManager.action?actionType=UpdateFacility',
				formId:'WarehouseForm',
				store:cgrid.store
			});
		       
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/facility/js/WarehouseForm.js', 
				varName:'WarehouseForm',
				CmpId:'WarehouseForm',
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
					handler:this.createNewWarehouse
				},{
					text:'删除记录',
					iconCls:'icon-delete',
					scope: this,
					handler:this.deleteWarehouse
				},
				'-',
				{
					text:'角色',
					iconCls:'icon-user-edit',
					scope:this,
					handler:this.editFacilityParties
				}]
		});
	    
		this.items = [this.toolbar];
		WarehouseGrid.superclass.initComponent.call(this);
	},
	constructor: function(config){
		var facilityStore = new Ext.data.JsonStore({
			autoLoad:true,
			url: 'facilityLoader.action?facilityType=WAREHOUSE',
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
			{header: "描述信息", width:230, sortable: true, dataIndex: 'description'},
			{header: "开放日期", sortable: true, dataIndex: 'contentPathPrefix'},
			{header: "关闭日期", sortable: true, dataIndex: 'templatePathPrefix'}
			];
          
//          this.columns = colModel;
//          this.store = facilityStore;
		WarehouseGrid.superclass.constructor.call(this, {store:facilityStore, columns:colModel});
	},
	createNewWarehouse:function(){
		
		var ds = this.store;		
		var win = new Ext.CommonSubmitWindow({
			title:'创建',
			url:'facilityManager.action?actionType=CreateFacility',
			formId:'WarehouseForm',
			store:ds
		});
	       
		AjaxEvalScript({
			container:win, 
			containerType:'window', 
			url:'applications/facility/js/WarehouseForm.js', 
			varName:'WarehouseForm',
			CmpId:'WarehouseForm',
			callCfg:false,
			operation:'create'
		});
		
	},
	deleteWarehouse:function(){
		var rec = this.getSelectionModel().getSelected();
		if(rec == undefined){
			return;
		}
		var ds = this.store;
		
		Ext.MessageBox.confirm('删除', '确认删除该记录?', function(btn){
			if('yes' == btn){
				DataConnectionSubmit({
					url:'facilityManager.action?actionType=DeleteFacility',
					params:{'facility.facilityId':rec.get('facilityId')},
					store:ds,
					record:rec
				});
			}
		});


	},
	editFacilityParties:function(){
		var rec = this.getSelectionModel().getSelected();
		if(rec == undefined){
			Ext.MessageBox.alert('提示', '请选择仓库');
			return;
		}
		
		var facilityId = rec.get('facilityId');
		var facilityPartiesPanel = new Ext.Panel({
			id:'facilityPartiesPanel',
			title:'仓库-'+facilityId+'',
			closable:true,
			autoDestroy:true,
			autoScroll:true,
			iconCls:'icon-user-edit',
			autoLoad:{url:util.constant.appPath+'/applications/facility/widget/facilityParties.ftl?facilityId='+facilityId, scope:this, scripts:true,
    			callback:function(el, success, response, options){
					if(!success){
						Ext.MessageBox.show({
							title:'错误',
							msg: '信息加载失败',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.ERROR
						});
					}
				}
			}
		});
		
		this.centerpanel.add(facilityPartiesPanel);
		this.centerpanel.activate(facilityPartiesPanel);
	},
	configComponent:function(options){
		this.centerpanel = options.container;
	}
});