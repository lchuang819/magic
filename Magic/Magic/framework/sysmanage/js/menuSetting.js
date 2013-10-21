var settingMenu = Ext.extend(Ext.app.Module, {
	moduleType : '',
	moduleId : 'menuSet',
	text : '菜单管理',
	iconCls : 'icon-plugin',
	createWindow : function() {
	
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
			rootVisible : true,
			listeners : {
				scope:this,
				click : function(n) {
					if(n.isLeaf()){
						//this.openItem(n.id,n.text,n.attributes.path);
					}
				},
				contextmenu : function(node, e) {
					e.preventDefault();
					node.select();
					new Ext.menu.Menu( {
							items : [{
								id:'add',
								text : '增加菜单',
								iconCls:'icon-add',
								//cNodeId:node.id,
								//cNodeText:node.text,
								cIsroot:!node.attributes.leaf,
								cParentId:node.parentNode.id,
								cParentName:node.parentNode.text,
								cNode:node,
								cParentNode:node.parentNode,
								handler :modifyWindow
							},{
								id:'mod',
								text : '修改菜单',
								iconCls:'icon-plugin',
								cNode:node,
								cNodeId:node.id,
								cNodeText:node.text,
								cIsroot:!node.attributes.leaf,
								cIconCls:node.attributes.iconCls,
								cParentId:node.parentNode.id,
								cParentName:node.parentNode.text,
								cParentNode:node.parentNode,
								cPath:node.attributes.path,
								handler:modifyWindow
							},{
								id:'del',
								text : '删除菜单',
								iconCls:'icon-delete',
								cNodeId:node.id,
								cNodeText:node.text,
								cIsroot:!node.attributes.leaf,
								cIconCls:node.attributes.iconCls,
								cParentId:node.parentNode.id,
								cParentName:node.parentNode.text,
								disabled:(node.childNodes.length == 0)?false:true,
								handler:modifyWindow
							}]
						}).showAt(e.getPoint());
						
				}
			}
			});
		
		
		
		var rootnode = new Ext.tree.AsyncTreeNode({
            id : 'source',
            text : '系统菜单',
            draggable : false,// 根节点不容许拖动
            expanded : true
        });
		
		tree.setRootNode(rootnode);

		tree.on('beforeload', function(node) {

			tree.loader.dataUrl = 'menuTreeLoader.action'; // 定义子节点的Loader

        });
		
		var menuSettingPanel = new Ext.Panel({
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

		desk.add(menuSettingPanel);
		desk.activate(menuSettingPanel);
		
		tree.expandAll();
		
		function reloadTree(){
			tree.root.reload();
			tree.expandAll();
		}
		
		//modifyWindow function start
		function modifyWindow(r){
			
			var idReadOnly = false;
			var readOnlyCls = 'x-item-disabled';
			if(r.id == 'mod'){
				idReadOnly = true;
			}else{
				idReadOnly = false;
				readOnlyCls = '';
			}
			
			var addForm = new Ext.form.FormPanel({
				labelWidth : 85, // label settings here cascade unless overridden
				frame : true,
				labelAlign:'right',
				bodyStyle : 'padding:5px 5px 0',
				defaultType : 'textfield',
				items : [{
					fieldLabel : 'ID',
					name : 'menus.contentId',
					width:150,
					id : 'id',
					readOnly:idReadOnly,
					allowBlank:false,
					cls:readOnlyCls,
					value:r.cNodeId
				},{
					fieldLabel : '名称',
					name : 'menus.contentName',
					width:150,
					id : 'menuName',
					allowBlank:false,
					value:r.cNodeText
				},{
					width:          150,
	                xtype:          'combo',
	                mode:           'local',
	                value:          ''+r.cIsroot,
	                triggerAction:  'all',
	                forceSelection: true,
	                editable:       false,
	                fieldLabel:     '是否为根',
	                name:           'contentTypeId',
	                hiddenName:     'menus.contentTypeId',
	                displayField:   'name',
	                valueField:     'value',
	                store:          new Ext.data.JsonStore({
	                    fields : ['name', 'value'],
	                    data   : [
	                        {name : '是',   value: 'MENU_ROOT'},
	                        {name : '否',  value: 'MENU_CONTAINER'}
	                    ]
	                })
				},{
					fieldLabel : 'CSS',
					name : 'menus.mimeTypeId',
					id : 'iconCls',
					width:150,
					value:r.cIconCls
				},{
					fieldLabel : '内容',
					name : 'menus.description',
					value:r.cPath,
					width:150,
					id : 'contentPath'
				},{
					width:          150,
	                xtype:          'combo',
	                mode:           'local',
	                value:          'Y',
	                triggerAction:  'all',
	                forceSelection: true,
	                editable:       false,
	                fieldLabel:     '是否启用',
	                name:           'enable',
	                hiddenName:     'menus.statusId',
	                displayField:   'name',
	                valueField:     'value',
	                store:          new Ext.data.JsonStore({
	                    fields : ['name', 'value'],
	                    data   : [
	                        {name : '启用',   value: 'Y'},
	                        {name : '禁用',  value: 'N'}
	                    ]
	                })
				},{
					fieldLabel : '序号',
					name : 'menus.privilegeEnumId',
					width:150,
					id : 'sequenceId'
				}
//				,{
//					fieldLabel : '父节点',
//					name : 'menus.parentId',
//					width:150,
//					id : 'parentId',
//					hidden:true,
//					hideLabel:true,
//					hideMode:'display',
//					value:r.cParentId
//				}
//				,{
//					fieldLabel : '父节点名称',
//					name : 'parentName',
//					width:150,
//					id : 'parentName',
//					value:r.cParentName
//				}
				],
				buttons:[{
					text:"确定",
					type: 'submit',
					handler:function(){
					addForm.form.doAction('submit', {
						waitMsg : "正在提交......",
						url : 'menuTreeManage.action?opn='+r.id,
					    method : 'POST',
						success:function(f, action) {
							Ext.MessageBox.alert("成功",'菜单增加成功!');
							win.close();
							reloadTree();
						},
						failure:function(f, action) {
							if(action.failureType == 'client'){
								Ext.MessageBox.alert("操作失败", "信息输入有误");
							}else{
								Ext.MessageBox.alert("操作失败",action.result.msg);
							}
						}
					});
					}
				},
				{text:"取消",handler:function(){win.close();}}], 
				buttonAlign:'center'
			});
			
			var parentNameField;
			if(r.id == 'add' || r.id == 'mod'){
				parentNameField = {
						width:          150,
		                xtype:          'combo',
		                mode:           'local',
		                value:          r.cParentNode.id,
		                triggerAction:  'all',
		                forceSelection: true,
		                editable:       false,
		                fieldLabel:     '父节点名称',
		                name:           'parentName',
		                hiddenName:     'menus.ownerContentId',
		                displayField:   'name',
		                valueField:     'value',
		                store:          new Ext.data.JsonStore({
		                    fields : ['name', 'value'],
		                    data   : [
		                        {name : r.cParentNode.text,   value: r.cParentNode.id},
		                        {name : r.cNode.text,  value: r.cNode.id}
		                    ]
		                })
					};
				
				addForm.add(parentNameField);
			}
			
			
			var win = new Ext.Window( {
				title:r.text,
				layout : 'form',
				plain : true,
				buttonAlign : 'center',
				border : false,
				resizable : false,
				modal : true,
				width : 300
				//height : 320
			});

			win.add(addForm);
			win.show();
		}
		//modifyWindow function end
	},
	openItem:function(id,name,path){
		var tab = new Ext.Panel({id:id,title:name,autoScroll:true,closable:true,
			autoLoad:{url:util.constant.appPath+path}
		});
		
		this.centerPanel.add(tab);
		this.centerPanel.activate(id);
	}
});
