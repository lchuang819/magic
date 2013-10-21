var partyMgr = Ext.extend(Ext.app.Module,{
    moduleType:'',
    moduleId:'partyMgr',
    text:'partyMgr',
    iconCls:'icon-grid',
	createWindow:function(){
	// create the Data Store
    var store = new Ext.data.JsonStore({
        root: 'dataset',
        totalProperty: 'totalCount',
        idProperty: 'partyId',
        autoDestroy: true,
        remoteSort: true,
        url: 'partyLoader.action',
        baseParams:{actionType:'LoadParty'},
        fields: [
            'partyId', 'personalTitle', 'firstName', 'lastName', 'partyTypeId', 'partyTypeDescription', 'comments'
            // 会员标识 		用户登录 		名字		类型 
        ]

        // load using script tags for cross domain, if the data in on the same
		// domain as
        // this page, an HttpProxy would be better
        // proxy: new Ext.data.ScriptTagProxy({
            // url: 'dataQuery.action'
        // })
    });
//    store.load();
//    alert(store.getCount());
   // store.setDefaultSort('lastpost', 'desc');


    // pluggable renders
    /**
	 * function renderTopic(value, p, record){ return String.format( '<b><a
	 * href="http://extjs.com/forum/showthread.php?t={2}" target="_blank">{0}</a></b><a
	 * href="http://extjs.com/forum/forumdisplay.php?f={3}" target="_blank">{1}
	 * Forum</a>', value, record.data.forumtitle, record.id,
	 * record.data.forumid); } function renderLast(value, p, r){ return
	 * String.format('{0}<br/>by {1}', value.dateFormat('M j, Y, g:i a'),
	 * r.data['lastposter']); }
	 */
    var searchTbar = new Ext.Toolbar({
    	items:[{
			text:'角色管理',
			iconCls:'icon-user-edit',
			handler:function(){
	        	var rec = allPartyGrid.getSelectionModel().getSelected();
	    		if(rec == undefined){
	    			Ext.MessageBox.alert('提示', '请选择成员');
	    			return;
	    		}
	    		var partyId = rec.get('partyId');
	    		var partyRolePanel = new Ext.Panel({
					id:'partyRolePanel',
					title:partyId + '-角色',
					closable:true,
					autoDestroy:true,
					autoScroll:true,
					iconCls:'icon-user-edit',
					autoLoad:{url:'partyDetailLoader.action?partyId='+partyId, scope:this, scripts:true,
	        			callback:function(el, success, response, options){
	    					if(!success){
	    						Ext.MessageBox.show({
	    							title:'错误',
	    							msg: '成员信息加载失败',
	    							buttons: Ext.Msg.OK,
	    							icon: Ext.MessageBox.ERROR
	    						});
	    					}
	    				}
	    			}
	    		
				});
	    		desk.add(partyRolePanel);
	    		desk.activate(partyRolePanel);
	    	}
    	},{
    		text:'关系管理',
			iconCls:'icon-link-with',
			handler:function(){
	        	var rec = allPartyGrid.getSelectionModel().getSelected();
	    		if(rec == undefined){
	    			Ext.MessageBox.alert('提示', '请选择成员');
	    			return;
	    		}
	    		var partyId = rec.get('partyId');
	    		
	    		var partyRelationshipPanel = new Ext.Panel({
					id:'partyRelationshipPanel',
					title:partyId + '-角色',
					closable:true,
					autoDestroy:true,
					autoScroll:true,
					iconCls:'icon-user-edit',
					autoLoad:{url:util.constant.appPath+'/applications/party/widget/partyRelationships.ftl?partyId='+partyId, scope:this, scripts:true,
	        			callback:function(el, success, response, options){
	    					if(!success){
	    						Ext.MessageBox.show({
	    							title:'错误',
	    							msg: '成员信息加载失败',
	    							buttons: Ext.Msg.OK,
	    							icon: Ext.MessageBox.ERROR
	    						});
	    					}
	    				}
	    			}
	    		
				});
	    		desk.add(partyRelationshipPanel);
	    		desk.activate(partyRelationshipPanel);
    		}
    	},
    	{
		    text: '清空过滤器',
		    iconCls:'icon-delete',
		    handler: function () {
				allPartyGrid.filters.clearFilters();
		    } 
		}
    	]
    });

    var partyGridFilters = new JavaGridFilters({
        filters: [{
            type: 'string',
            dataIndex: 'partyId'
        },
        {
            type: 'string',
            dataIndex: 'partyTypeId'
        }
        ]
    });
    
    var allPartyGrid = new Ext.grid.GridPanel({
    	id:'allPartyGrid',
        width:700,
        height:500,
        title:'所有成员',
        iconCls:'icon-grid',
        store: store,
        trackMouseOver:false,
        disableSelection:false,
        autoDestroy:true,
        loadMask: true,
        closable : true,
        plugins: [partyGridFilters],
        columns:[{
            id: 'topic', // id assigned so we can apply custom css (e.g.
							// .x-grid-col-topic b { color:#333 })
            header: "成员标识",
            dataIndex: 'partyId',
            width: 40,
            sortable: true,
            filter:true
        },{
            header: "称谓",
            dataIndex: 'personalTitle',
            width: 50,
            hidden: false,
            sortable: true
        },{
            header: "名称",
            dataIndex: 'firstName',
            width: 100,
            hidden: false,
            sortable: true
        },{
            header: "英文名称",
            dataIndex: 'lastName',
            width: 60,
            hidden: false,
            sortable: true
        },{
            header: "备注",
            dataIndex: 'comments',
            width: 100,
            align: 'right',
            sortable: true
        },{
            header: "类型",
            dataIndex: 'partyTypeDescription',
            width: 40,
            align: 'right',
            sortable: true
        },{
            header: "类型标识",
            dataIndex: 'partyTypeId',
            width: 40,
            align: 'right',
            sortable: true
        }],

        // customize view config
        
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
        },listeners:{
			scope:this,
			rowdblclick:function(cgrid, index, e) {

        	var cRecord = cgrid.store.getAt(index);
        	
        	var partyTypeId = cRecord.get('partyTypeId');
        	var actionType = 'UpdatePerson';
        	if('PARTY_GROUP' == partyTypeId){
        		actionType = 'UpdatePartyGroup';
        	}
        	
        	var partyForm = new PartyForm({
        		actionType:'UpdateParty', 
        		record:cRecord, 
        		enableData:true, 
        		loadParty:true,
        		buttons:[{
		            text: '保存',
		            type:'submit',
		            handler:function(){
        			partyForm.form.submit({
							url:'partyManager.action?actionType=' + actionType,
			    		    method : 'POST',
			    		    waitMsg : "正在创建……",
			        		success:function(form,action){
	        					Ext.MessageBox.alert('提示', '操作成功');
			        		},
			        		failure:function(form,action){
			        			var errorMsg;
			        				if(action.failureType=='connect'){
			        					errorMsg = '连接服务器失败，请稍后再试';
			        				}else if(action.failureType=='client'){
			        					errorMsg = '输入信息有误';
			        				}else{
			        					errorMsg = action.result.msg;
			        				}
			        				Ext.MessageBox.show({
			        					title: '错误',
			        					msg: errorMsg,
			        					buttons: Ext.MessageBox.OK,
			        					//fn: showResult,
			        					icon:Ext.MessageBox.ERROR
			        				});
			        		}
			        	});
		        	}
					},{
			            text: '重置',
			            type:'reset',
			            handler:function(){partyForm.form.reset();}
			        },{
			            text: '关闭',
			            type:'close',
			            handler:function(){win.close();}
			        }]
        		});
//	        var pf = new Ext.UpdatePartyForm();
				var win = new Ext.Window( {
					title:'编辑',
					layout : 'form',
					plain : true,
					buttonAlign : 'center',
					border : false,
					resizable : false,
					modal : true,
					autoScroll:true,
					autoDestroy:true,
					width : 1200,
					autoScroll:true
					//height : 320
				});
				
				win.add(partyForm);
				win.show();
			}
		},
        bbar:
            new Ext.PagingToolbar({ 
        	pageSize:10, 
        	store: store, 
//        	autoWidth:true,
        	displayInfo: true, 
        	displayMsg: '双击编辑数据  显示成员{0} - {1} of {2}', 
        	emptyMsg: "查询无任何数据",
        	refreshText:'刷新'
        	}),
        tbar:searchTbar
		
    });
    
    
    allPartyGrid.on('close', function() {
    	allPartyGrid.filters.clearFilters();
		
    });
    // render it
    // grid.render('topic-grid');
	desk.add(allPartyGrid);
	desk.activate(allPartyGrid);
    // trigger the data store load
    store.load({params:{start:0, limit:10}});
	}
});