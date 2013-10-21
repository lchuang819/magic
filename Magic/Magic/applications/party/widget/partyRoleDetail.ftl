<script type="text/javascript">
Ext.onReady(function(){

	var partyId = '${partyDetail.partyId?default('')}';

	var searchTbar = new Ext.Toolbar({
    	items:[{
			text:'创建新角色',
			iconCls:'icon-add',
			handler:function(){
        		
				var win = new Ext.CommonSubmitWindow({
					title:'创建新的',
					url:'partyRoleManager.action?actionType=CreatePartyRole&partyId=' + partyId,
					formId:'PartyRoleForm',
					store:store
				});
			       
				AjaxEvalScript({
					container:win, 
					containerType:'window', 
					url:'applications/party/js/PartyRoleForm.js', 
					varName:'PartyRoleForm',
					CmpId:'PartyRoleForm',
					partyId:partyId,
					callCfg:true
				});
        		
	    	}
    	},{
			text:'删除选中角色',
			iconCls:'icon-delete',
			handler:function(){
	        	var rec = partyRoleGrid.getSelectionModel().getSelected();
        		if(rec == undefined){
        			Ext.MessageBox.alert('提示', '请选择角色');
        			return;
        		}
        		var roleTypeId = rec.get('roleTypeId');
        		var partyId = rec.get('partyId');
        		
        		DataConnectionSubmit({url:'partyRoleManager.action?actionType=DeletePartyRole', params:{partyId:partyId, roleTypeId:roleTypeId}, record:rec, store:store});
	    	}
    	}]
    });
    
    var store = new Ext.data.JsonStore({
        root: 'dataset',
        autoLoad:true,
        totalProperty: 'totalCount',
        url: 'partyRoleLoader.action',
        baseParams:{partyId:'${partyDetail.partyId?default('')}'},
        fields: [
            'partyId', 'roleTypeId', 'description'
        ]
    });
    
	var partyRoleGrid = new Ext.grid.GridPanel({
    	id:'partyRoleGrid',
        height:400,
        //title:'${partyDetail.partyId?default('')}-角色列表',
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
            id: 'partyId',
            header: "成员编号",
            dataIndex: 'partyId',
            width: 15,
            sortable: true
        },{
            header: "角色类型",
            dataIndex: 'roleTypeId',
            width: 60,
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
	
	partyRoleGrid.render('partyrolegrid');
});
</script>
<div id="partyrolegrid"></div>