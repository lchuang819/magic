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
					id : 'SUPPLIER_CORPORATION',
					text : '创建供应商(企业)',
					leaf : true,
					iconCls : 'icon-user_biz',
					partyType : 'CORPORATION'
				}, {
					id : 'SUPPLIER_PERSON',
					text : '创建供应商(个人)',
					leaf : true,
					iconCls : 'icon-user-gray',
					partyType : 'PERSON'
				}, {
					id : 'CUSTOMER_CORPORATION',
					text : '创建客户(企业)',
					leaf : true,
					iconCls : 'icon-user_biz',
					partyType : 'CORPORATION'
				}, {
					id : 'CUSTOMER_PERSON',
					text : '创建客户(个人)',
					leaf : true,
					iconCls : 'icon-user-gray',
					partyType : 'PERSON'
				}, {
					id : 'EMPLOYEE',
					text : '创建雇员',
					leaf : true,
					iconCls : 'icon-user-add',
					partyType : 'PERSON'
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
		var newcustomerPanel = new PartyForm({
			actionType : node.id,
			partyType : node.attributes.partyType,
			id : node.id,
			title : node.text,
			loadParty : false,
			buttons : [ {
				text : '保存',
				type : 'submit',
				handler : function() {
					newcustomerPanel.form.submit({
						url : 'partyManager.action',
						method : 'POST',
						waitMsg : "正在创建……",
						params : {
							actionType : 'NewPerson',
							partyType : 'PERSON'
						},
						success : function(form, action) {
							Ext.log('==============successfully===============');
							var s = Ext.util.JSON.encode(action.result.ResponseBody);
							var partyId = action.result.ResponseBody.party.partyId;
							var c = newcustomerPanel.find('id', 'partyId');
							if(c.length > 0 && c[0]){
								c[0].setText(partyId);
							}
							
							Ext.MessageBox.alert('提示', '创建['+partyId+'],操作成功!');
						},
						failure : function(form, action) {
							var errorMsg;
							if (action.failureType == 'connect') {
								errorMsg = '连接服务器失败，请稍后再试!';
							} else if (action.failureType == 'client') {
								errorMsg = '输入信息有误!';
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