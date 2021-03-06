var partyList = Ext.extend(Ext.app.Module, {
	moduleType : '',
	moduleId : 'partyList',
	text : '成员列表',
	iconCls : 'icon-plugin',
	init : function() {
		this.createPanel();
	},
	createPanel : function() {

		var menuTree = new Ext.tree.TreePanel({
			region : 'west',
			collapsible : true,
			title : this.text,
			width : 200,
			height : this.height,
			autoScroll : true,
			autoDestroy:true,
			closable : true,
			split : true,
			loader : new Ext.tree.TreeLoader(),
			root : new Ext.tree.AsyncTreeNode({
				expanded : true,
				children : [ {
					id : 'employeeDetails',
					text : '雇员信息',
					leaf : true,
					iconCls:'icon-grid'
				}, {
					id : 'customerDetails',
					text : '人员信息',
					leaf : true,
					iconCls:'icon-grid'
				}, {
					id : 'CorporateList',
					text : '企业信息',
					leaf : true,
					iconCls:'icon-grid'
				}]
			}),
			rootVisible : false,
			
			listeners : {
				scope:this,
				click : function(n) {
					Ext.log('[PartyList :createPanel :listeners : click] is leaf=' + n.isLeaf());
					if(n.isLeaf()){
						this.openItem(n, n.attributes.path);
					}else{
						 if(n.expanded){
							 n.collapse();
						 }else{
							 n.expand();
						 }
					}
				}
			}
		});
		
		this.centerPanel = new Ext.TabPanel({
			region : 'center',
			title:'中心区'
		});
		
		// Create main pannel
		var ofbiz = new Ext.Panel({
			id : 'partyListMainPanel',
			title : this.text,
			closable : true,
			iconCls : this.iconCls,
			layout : 'border',
			items : [ menuTree, this.centerPanel ]
		});
		
		desk.add(ofbiz);
		desk.activate(ofbiz);

	},
	openItem : function (node, path) {
		var id = node.id;
		Ext.log('[PartyList :openItem] id=' + id);
		if(id == 'employeeDetails'){
			
			Ext.log('[PartyList:openItem] init employeeDetails');
			
			Ext.getBody().mask('加载中...');
			
			var employeeDetailsPanel = new Ext.Panel({
				id : 'employeeDetails',
				title : '雇员列表',
				frame : true,
				closable : true,
				autoDestroy : true,
				autoScroll : true,
				iconCls : 'icon-grid',
				autoLoad : {
					url : util.constant.appPath + '/applications/party/widget/employeeList.ftl', 
					params : {roleTypeId : 'EMPLOYEE'},
					scope : this, 
					scripts : true,
        			callback:function(el, success, response, options){
        				Ext.log('[PartyList :openItem :callback ] success=' + success);
    					if(!success){
    						Ext.MessageBox.show({
    							title:'错误',
    							msg: '产品信息加载失败',
    							buttons: Ext.Msg.OK,
    							icon: Ext.MessageBox.ERROR
    						}); 
    					}
    				}
    			}
			});
			
			this.centerPanel.add(employeeDetailsPanel);
			this.centerPanel.activate(employeeDetailsPanel);
			
			Ext.getBody().unmask();
			
		}else if(id == 'customerDetails'){
			Ext.log('[PartyList:openItem] init customerDetails');
			
			Ext.getBody().mask('加载中...');
			
			var customerDetailsPanel = new Ext.Panel({
				id : 'customerDetails',
				title : '客戶列表',
				frame : true,
				closable : true,
				autoDestroy : true,
				autoScroll : true,
				iconCls : 'icon-grid',
				autoLoad : {
					url : util.constant.appPath + '/applications/party/widget/customerList.ftl', 
					params : {roleTypeId : 'CUSTOMER'},
					scope : this, 
					scripts : true,
        			callback:function(el, success, response, options){
        				Ext.log('[PartyList :openItem :callback ] success=' + success);
    					if(!success){
    						Ext.MessageBox.show({
    							title:'错误',
    							msg: '产品信息加载失败',
    							buttons: Ext.Msg.OK,
    							icon: Ext.MessageBox.ERROR
    						}); 
    					}
    				}
    			}
			});
			
			this.centerPanel.add(customerDetailsPanel);
			this.centerPanel.activate(customerDetailsPanel);
			
			Ext.getBody().unmask();
		}else if(id == 'supplierDetails'){
			Ext.log('[PartyList:openItem] init supplierDetails');
			
			Ext.getBody().mask('加载中...');
			
			var supplierDetailsPanel = new Ext.Panel({
				id : 'supplierDetails',
				title : '客戶列表',
				frame : true,
				closable : true,
				autoDestroy : true,
				autoScroll : true,
				iconCls : 'icon-grid',
				autoLoad : {
					url : util.constant.appPath + '/applications/party/widget/supplierList.ftl', 
					params : {roleTypeId : 'SUPPLIER'},
					scope : this, 
					scripts : true,
        			callback:function(el, success, response, options){
        				Ext.log('[PartyList :openItem :callback ] success=' + success);
    					if(!success){
    						Ext.MessageBox.show({
    							title:'错误',
    							msg: '产品信息加载失败',
    							buttons: Ext.Msg.OK,
    							icon: Ext.MessageBox.ERROR
    						}); 
    					}
    				}
    			}
			});
			
			this.centerPanel.add(supplierDetailsPanel);
			this.centerPanel.activate(supplierDetailsPanel);
			
			Ext.getBody().unmask();
			
		} else if(id == 'CorporateList'){
			Ext.log('[PartyList:openItem] init CorporateList');
			
			Ext.getBody().mask('加载中...');
			
			var CorporateListPanel = new Ext.Panel({
				id : 'CorporateListPanel',
				title : '客戶列表',
				frame : true,
				closable : true,
				autoDestroy : true,
				autoScroll : true,
				iconCls : 'icon-grid',
				autoLoad : {
					url : util.constant.appPath + '/applications/party/widget/CorporateList.jsp', 
					params : {partyTypeId: 'CORPORATION'},
					scope : this, 
					scripts : true,
        			callback:function(el, success, response, options){
        				Ext.log('[PartyList :openItem :callback ] success=' + success);
    					if(!success){
    						Ext.MessageBox.show({
    							title:'错误',
    							msg: '产品信息加载失败',
    							buttons: Ext.Msg.OK,
    							icon: Ext.MessageBox.ERROR
    						}); 
    					}
    				}
    			}
			});
			
			this.centerPanel.add(CorporateListPanel);
			this.centerPanel.activate(CorporateListPanel);
			
			Ext.getBody().unmask();
		}
	}
});