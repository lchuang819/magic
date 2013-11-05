var partyCreate = Ext.extend(Ext.app.Module, {
	moduleType : '',
	moduleId : 'partyCreate',
	text : '创建新成员或组织',
	iconCls : 'icon-plugin',
	createWindow : function() {

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
					id : 'SUPPLIER',
					text : '创建供应商',
					leaf : true,
					iconCls : 'icon-user_biz'
				}, {
					id : 'CUSTOMER',
					text : '创建客户',
					leaf : true,
					iconCls : 'icon-user-gray'
				}, {
					id : 'EMPLOYEE',
					text : '创建雇员',
					leaf : true,
					iconCls : 'icon-user-add'
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

		var ssn = true;
		var gener = true;
		
		if (node.id == 'SUPPLIER') {
			ssn = false;
			gener = false;
		}

		var newcustomerPanel = new PartyForm({
			actionType : node.id,
			gender : gener,
			socialSecurityNumber : ssn,
			id : node.id,
			title : node.text,
			loadParty : false,
			buttons : [ {
				text : '保存',
				type : 'submit',
				handler : function() {
					newcustomerPanel.form.submit({
						url : 'partyManager.action?actionType=NewCustomer',
						method : 'POST',
						waitMsg : "正在创建……",
						success : function(form, action) {
							alert('成功');
						},
						failure : function(form, action) {
							var errorMsg;
							if (action.failureType == 'connect') {
								errorMsg = '连接服务器失败，请稍后再试';
							} else if (action.failureType == 'client') {
								errorMsg = '输入信息有误';
							} else {
								errorMsg = action.result.msg;
							}
							Ext.MessageBox.show({
								title : '错误',
								msg : errorMsg,
								buttons : Ext.MessageBox.OK,
								// fn: showResult,
								icon : Ext.MessageBox.ERROR
							});
						}
					});
				}
			}, {
				text : '重置',
				type : 'reset',
				handler : function() {
					newcustomerPanel.form.reset();
				}
			} ]
		});

		this.centerPanel.add(newcustomerPanel);
		this.centerPanel.activate(newcustomerPanel);

	}
});