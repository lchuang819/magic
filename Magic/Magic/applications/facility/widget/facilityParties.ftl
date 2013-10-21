<script type="text/javascript">
Ext.onReady(function(){

	var facilityId = '${RequestParameters["facilityId"]}';

	var searchTbar = new Ext.Toolbar({
    	items:[{
			text:'创建新角色',
			iconCls:'icon-add',
			handler:function(){
        		
				var win = new Ext.CommonSubmitWindow({
					title:'创建新的',
					url:'partyRoleManager.action?actionType=CreatePartyRole&facilityId=' + facilityId,
					formId:'PartyRoleForm',
					store:store
				});
			       
				AjaxEvalScript({
					container:win, 
					containerType:'window', 
					url:'applications/party/js/PartyRoleForm.js', 
					varName:'PartyRoleForm',
					CmpId:'PartyRoleForm',
					facilityId:facilityId,
					callCfg:true
				});
        		
	    	}
    	},{
			text:'删除选中角色',
			iconCls:'icon-delete',
			handler:function(){
	        	var rec = facilityPartiesGrid.getSelectionModel().getSelected();
        		if(rec == undefined){
        			Ext.MessageBox.alert('提示', '请选择角色');
        			return;
        		}
        		var roleTypeId = rec.get('roleTypeId');
        		var facilityId = rec.get('facilityId');
        		
        		DataConnectionSubmit({url:'partyRoleManager.action?actionType=DeletePartyRole', params:{facilityId:facilityId, roleTypeId:roleTypeId}, record:rec, store:store});
	    	}
    	}]
    });
    
    var store = new Ext.data.JsonStore({
        root: 'dataset',
        autoLoad:true,
        totalProperty: 'totalCount',
        url: 'facilityPartiesLoader.action',
        baseParams:{facilityId:facilityId},
        fields: [
            'facilityId', 'partyId', 'roleTypeId', 'description'
        ]
    });
    
	var facilityPartiesGrid = new Ext.grid.GridPanel({
    	id:'facilityPartiesGrid',
        height:400,
        //title:facilityId + '-角色列表',
        store: store,
        iconCls:'icon-grid',
        trackMouseOver:false,
        disableSelection:false,
        loadMask: false,
        closable : true,
        autoScroll:true,
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        columns:[{
            id: 'facilityId',
            header: "仓库编号",
            dataIndex: 'facilityId',
            sortable: true
        },{
            id: 'partyId',
            header: "成员编号",
            dataIndex: 'partyId',
            sortable: true
        },{
            header: "角色类型",
            dataIndex: 'roleTypeId',
            hidden: false,
            sortable: true
        },{
            header: "角色类型描述",
            dataIndex: 'description',
            //width: 70,
            align: 'right',
            sortable: true
        }],
        viewConfig: {
            forceFit:true,
            enableRowBody:true,
            showPreview:false,
            getRowClass : function(record, rowIndex, p, store){
                if(this.showPreview){
                    p.body = '<p>'+record.data.excerpt+'</p>';
                    return 'x-grid3-row-expanded';
                }
                return 'x-grid3-row-collapsed';
            }
        },
		tbar:searchTbar
				
	});
	
	facilityPartiesGrid.render('facilitypartiesgrid');
});
</script>
<div id="facilitypartiesgrid"></div>