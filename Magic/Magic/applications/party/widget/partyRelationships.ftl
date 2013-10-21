<script type="text/javascript">
Ext.onReady(function(){

	var partyId = '${RequestParameters["partyId"]}';

	var searchTbar = new Ext.Toolbar({
    	items:[{
			text:'创建新角色',
			iconCls:'icon-add',
			handler:function(){
        		
				var win = new Ext.CommonSubmitWindow({
					title:'创建新的',
					url:'partyRelationshipManager.action?actionType=CreatePartyRelationship&partyId=' + partyId,
					formId:'PartyRelationshipForm',
					store:store
				});
			       
				AjaxEvalScript({
					container:win, 
					containerType:'window', 
					url:'applications/party/js/PartyRelationshipForm.js', 
					varName:'PartyRelationshipForm',
					CmpId:'PartyRelationshipForm',
					partyId:partyId,
					callCfg:true
				});
        		
	    	}
    	},{
			text:'删除选中角色',
			iconCls:'icon-delete',
			handler:function(){
	        	var rec = partyRelationshipsGrid.getSelectionModel().getSelected();
        		if(rec == undefined){
        			Ext.MessageBox.alert('提示', '请选择角色');
        			return;
        		}
        		
        		var partyIdFrom = rec.get('partyIdFrom');
        		var partyIdTo = rec.get('partyIdTo');
        		var roleTypeIdTo = rec.get('roleTypeIdTo');
        		var roleTypeIdFrom = rec.get('roleTypeIdFrom');
        		var fromDate = rec.get('fromDate');
        		
        		DataConnectionSubmit({
	        		url:'partyRelationshipManager.action?actionType=DeletePartyRelationship', 
	        		params:{partyIdFrom:partyIdFrom, partyIdTo:partyIdTo, roleTypeIdTo:roleTypeIdTo, roleTypeIdFrom:roleTypeIdFrom, fromDate:fromDate}, 
	        		record:rec, 
	        		store:store
        		});
        		
	    	}
    	}]
    });
    
    var store = new Ext.data.JsonStore({
        root: 'dataset',
        autoLoad:{
        	callback:function(recs, options, success){
        		if(!success){
        			Ext.MessageBox.show('失败', '加载成员关系失败');
        		}
        	}
        },
        totalProperty: 'totalCount',
        url: 'partyRelationshipLoader.action',
        baseParams:{partyId:partyId},
        fields: [
            'partyIdFrom', 'partyIdTo', 'roleTypeIdFrom', 'roleTypeIdTo', 'roleTypeIdFromDesc', 'roleTypeIdToDesc', 'fromDate'
        ]
    });
    
	var partyRelationshipsGrid = new Ext.grid.GridPanel({
    	id:'partyRelationshipsGrid',
        height:400,
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
            id: 'partyIdFrom',
            header: "上级成员",
            dataIndex: 'partyIdFrom',
            sortable: true
        },{
            header: "上级角色类型",
            dataIndex: 'roleTypeIdFromDesc',
            hidden: false,
            sortable: true
        },{
            header: "关系类型",
            dataIndex: 'partyRelationshipTypeDesc',
            width: 30,
            align: 'right',
            sortable: true
        },{
            id: 'partyIdTo',
            header: "下级成员",
            dataIndex: 'partyIdTo',
            sortable: true
        },{
            header: "下级角色类型",
            dataIndex: 'roleTypeIdToDesc',
            hidden: false,
            sortable: true
        },{
            header: "创建日期",
            dataIndex: 'fromDate',
            hidden: false,
            sortable: true,
            renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')
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
	
	partyRelationshipsGrid.render('partyrelationships');
});
</script>
<div id="partyrelationships"></div>