<script type="text/javascript">

Ext.onReady(function(){
	

	PartyListGrid = Ext.extend(Ext.grid.GridPanel, {
		id:'PartyListGrid',
		autoWidth:true,
		bodyStyle:'padding:5px 5px 0;height:95%;width:100%;',
	    frame:true,
	    iconCls:'icon-grid',
	    closable:true,
	    autoDestroy:true,
	    autoScroll:true,
	    loadMask : new Ext.LoadMask(Ext.getBody(), {msg:"加载中..."}),
	    //autoExpandColumn:'description',
	    sm: new Ext.grid.RowSelectionModel({
	        singleSelect: true
	    }),
	    viewConfig: {
            forceFit:true,
            enableRowBody:true
	    },
		initComponent: function(){
			this.toolbar = new Ext.Toolbar({
				items:[
					'-',
					{
						text:'编辑选中记录',
						iconCls:'icon-edit',
						scope: this,
						id : '${RequestParameters["roleTypeId"]}',
						handler:this.editParty
					},
					'-',
					{
						text:'删除记录',
						iconCls:'icon-delete',
						scope: this,
						handler:this.deleteCatalog
					},
					'-',
					{
						text:'',
						xtype:'label'
					}]
			});

			this.items = [this.toolbar];
			PartyListGrid.superclass.initComponent.call(this);
		},
		constructor: function(config){

			var store = new Ext.data.JsonStore({
		        root: 'dataset',
		        totalProperty: 'totalCount',
		        idProperty: 'partyId',
		        autoDestroy: true,
		        remoteSort: true,
		        autoLoad:true,
		        url: 'partyLoader.action',
		        baseParams:{actionType : 'LoadPartyByRoleType', roleTypeId : '${RequestParameters["roleTypeId"]}'},
		        fields: [
		            'partyId', 'personalTitle', 'lastName', 'firstName', 'partyTypeId', 'partyTypeDescription', 'comments'
		        ]
		    });
			

	        var colModel =  new Ext.grid.ColumnModel({
				columns:[
					{id:'partyId', header: '雇员ID', width:50, dataIndex:'partyId'},
		            {header: '雇员称谓', width:120, dataIndex:'personalTitle'},
		            {header: '姓氏', width:120, dataIndex:'lastName'},
					{header: '名字',width:120, dataIndex:'firstName'},
		            {header: '成员类别', width:120, dataIndex:'partyTypeId'},
		            {header: '成员类别描述',width:120, dataIndex:'partyTypeDescription'},
		            {header: '备注', width:120, dataIndex:'comments'}
				],
			    defaults: {
			        sortable: true,
			        menuDisabled: true,
			        width: 100
			    }
	        
	        });
	                    
			PartyListGrid.superclass.constructor.call(this, {store:store, colModel:colModel});
			

		},
		listeners:{
  			scope:this,
	    	rowclick:function(sGrid, rowIndex, e){
	    		var record = sGrid.getSelectionModel().getSelected();
	    		
	    	}
	    },
		createNewCatalog : function(p){
			var ds = this.store;		
			var win = new Ext.CommonSubmitWindow({
				title:'创建新的',
				url:'productCostsManager.action?actionType=CreateProductPrice',
				formId:'PartyCreateForm',
				store:ds,
				hideBtn:true
			});
		    
		    Ext.log('[partyList.ftl][configComponent] roleType: ' + p.id);
		    
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/party/js/PartyCreateForm.js', 
				varName:'PartyCreateForm',
				CmpId:'PartyCreateForm',
				baseParams : {roleType : p.id},
				callCfg:true
			});
		},
		deleteCatalog:function(){
			var rec = this.getSelectionModel().getSelected();
			if(rec == undefined){
				return;
			}
			var ds = this.store;
			
			var partyId = rec.get('partyId');
			
			Ext.MessageBox.confirm('删除', '确认删除'+partyId+'?', function(btn){
				if('yes' == btn){
					DataConnectionSubmit({
						url:'partyManager.action?actionType=DeleteParty',
						params:{'party.partyId':partyId},
						store:ds,
						record:rec
					});
				}
			});
		},
		editParty : function(record){
			var ds = this.store;		
			var win = new Ext.CommonSubmitWindow({
				title:'编辑选中的',
				url:'productCostsManager.action?actionType=UpdatePerson',
				formId:'PartyUpdateForm',
				store:ds,
				hideBtn:true
			});
		    
		    Ext.log('[partyList.ftl][configComponent] roleType: ' + record.id);
		    
			AjaxEvalScript({
				container:win, 
				containerType:'window', 
				url:'applications/party/js/PartyUpdateForm.js', 
				varName:'PartyUpdateForm',
				CmpId:'PartyUpdateForm',
				baseParams : {roleType : record.id},
				callCfg:true
			});
		}
	
	});
	
	var grid = new PartyListGrid();
	grid.render('employeeDetailsofPartyList');
	
	
});

</script>

<div id="employeeDetailsofPartyList"></div>