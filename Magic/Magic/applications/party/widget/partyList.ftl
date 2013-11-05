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
				items:[{
						text:'创建新的',
						iconCls:'icon-add',
						scope: this,
						id : '${RequestParameters["roleTypeId"]}',
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
		            'partyId', 'personalTitle', 'firstName', 'lastName', 'partyTypeId', 'partyTypeDescription', 'comments'
		            // 会员标识 		用户登录 		名字		类型 
		        ]
		    });
			

			var colModel = [
	            {id:'partyId',header: '雇员ID', width:120, sortable: true, locked:false, dataIndex: 'partyId'},
	            {header: '雇员称谓', width:120, sortable: true, dataIndex: 'personalTitle'},
				{header: '名字',width:120,  sortable: true, dataIndex: 'firstName'},
	            {header: '姓氏', width:120, sortable: true, dataIndex: 'lastName'},
	            {header: '成员类别', width:120, sortable: true, dataIndex: 'partyTypeId'},
	            {header: '成员类别描述',width:120,  sortable: true, dataIndex: 'partyTypeDescription'},
	            {header: '备注', width:120, sortable: true, dataIndex: 'comments'}
				
	        ];
	                    
			PartyListGrid.superclass.constructor.call(this, {store:store, columns:colModel});
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
	
	var grid = new PartyListGrid();
	grid.render('employeeDetailsofPartyList');
});

</script>

<div id="employeeDetailsofPartyList"></div>