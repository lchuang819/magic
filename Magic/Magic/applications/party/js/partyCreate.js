var partyCreate = Ext.extend(Ext.app.Module, {
	moduleType : '',
	moduleId : 'partyCreate',
	text : '创建新的',
	iconCls : 'icon-plugin',
	createWindow : function() {

		// 新建会员组
		// 新建人员
		// 创建客户
		// 创建期望
		// 创建职员

		var menuTree = new Ext.tree.TreePanel({
			region : 'west',
			collapsible : true,
			title : this.text,
			width : 200,
			height : this.height,
			autoScroll : true,
			autoDestroy : true,
			closable : true,
			split : true,
			loader : new Ext.tree.TreeLoader(),
			root : new Ext.tree.AsyncTreeNode({
				expanded : true,
				children : [ {
					id : 'CORPORATION',
					text : '创建企业',
					leaf : true,
					iconCls : 'icon-user_biz',
					partyType : 'CORPORATION',
					partyRole : 'SUPPLIER'
				}, {
					id : 'PERSON',
					text : '创建人员',
					leaf : true,
					iconCls : 'icon-user-gray',
					partyType : 'PERSON',
					partyRole : 'CUSTOMER'
				} ]
			}),
			rootVisible : false,

			listeners : {
				scope : this,
				click : function(n) {
					if (n.isLeaf()) {
						this.openItem(n, n.attributes.path);
					} else {
						if (n.expanded) {
							n.collapse();
						} else {
							n.expand();
						}
					}
				}
			}
		});

		this.centerPanel = new Ext.TabPanel({

			region : 'center',
			title : '中心区'
		});

		var ofbiz = new Ext.Panel({
			id : this.moduleId,
			title : this.text,
			closable : true,
			iconCls : this.iconCls,
			layout : 'border',
			items : [ menuTree, this.centerPanel ]
		});

		// ofbiz.add(form);
		desk.add(ofbiz);
		desk.activate(ofbiz);
	},
	openItem : function(node, path) {
		Ext.log('Create Party and Type is:' + node.attributes.partyType);
		Ext.log('Create Party and Type is:' + node.attributes.partyRole);

		var urls = "";

		var title = "";

		if (node.id == 'CORPORATION') {
			title = '创建企业';
			urls = 'applications/party/widget/CorporationAdd.jsp';
		} else {
			title = '创建个人';
			urls = 'applications/party/widget/IndividualAdd.jsp';
		}
		
		var employeeDetailsPanel = new Ext.Panel({
			id : node.id,
			title : title,
			frame : true,
			closable : true,
			autoDestroy : true,
			autoScroll : true,
			iconCls : 'icon-grid',
			autoLoad : {
				url : util.constant.appPath + urls,
				params : {
					roleTypeId : 'EMPLOYEE',
					panelID : node.id
				},
				scope : this,
				scripts : true,
				callback : function(el, success, response, options) {
					Ext.log('[PartyList :openItem :callback ] success=' + success);
					if (!success) {
						Ext.MessageBox.show({
							title : '错误',
							msg : '产品信息加载失败',
							buttons : Ext.Msg.OK,
							icon : Ext.MessageBox.ERROR
						});
					}
				}
			}
		});

		this.centerPanel.add(employeeDetailsPanel);
		this.centerPanel.activate(employeeDetailsPanel);

	}
});