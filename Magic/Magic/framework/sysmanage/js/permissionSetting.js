var settingPermission = Ext.extend(Ext.app.Module, {
	moduleType : '',
	moduleId : 'permissionSetting',
	text : '权限设置',
	iconCls : 'icon-plugin',
	createWindow:function(){
		this.centerPanel = new Ext.TabPanel({
			
			region : 'center',
			title:'中心区'
		});
	
		var tree = new Ext.tree.TreePanel({
			region : 'west',
			collapsible : true,
			title : this.text,
			width : 200,
			height : this.height,
			autoScroll : true,
			closable : true,
			split : true,
			loader : new Ext.tree.TreeLoader(),
			root : new Ext.tree.AsyncTreeNode({
				expanded : true,
				children : [ {
					id : 'groupPermission',
					text : '组权限',
					leaf : true,
					path:'framework/sysmanage/widget/distributeGroupMenus.ftl'
				}, {
					id : 'userPermission',
					text : '用户权限',
					leaf : true,
					path:'framework/sysmanage/widget/distributeUserMenus.ftl'
				}]
			}),
			rootVisible : false,
			
			listeners : {
				scope:this,
				click : function(n) {
					if(n.isLeaf()){
						this.openItem(n.id,n.text,n.attributes.path);
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
		
		var permissionSettingPanel = new Ext.Panel({
			id : this.moduleId,
			layout : 'border',
			closable : true,
			title:this.text,
			iconCls:this.iconCls,
			items : [ 
				    tree,
				    this.centerPanel
			]
		});

		desk.add(permissionSettingPanel);
		desk.activate(permissionSettingPanel);
	},
	openItem:function(id,name,path){
		var tab = new Ext.Panel({
			id:id,
			title:name,
			autoScroll:true,
			closable:true,
			autoLoad:{url:util.constant.appPath+path,scripts:true}
//			tbar: [{
//	            text: '保存',
//	            iconCls:'icon-save',
//	            handler : function(){
//	                // access the Record constructor through the grid's store
//	                
//	            }
//	        }]
		});
		this.centerPanel.add(tab);
		this.centerPanel.activate(id);
	}
});