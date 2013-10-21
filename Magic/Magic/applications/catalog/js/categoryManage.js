var catalogCategory = Ext.extend(Ext.app.Module,{
    moduleType:'',
    moduleId:'catalogCategory',
    text:'分类管理',
    iconCls:'icon-plugin',
	createWindow:function(){
	
		this.centerPanel = new Ext.TabPanel({
			
			region : 'center',
			title:'中心区'
		});
		
		var menuTree = new Ext.tree.TreePanel({
			region : 'west',
			collapsible : true,
			title : this.text,
			width : 200,
			autoScroll : true,
			autoDestroy:true,
			closable : true,
			split : true,
			loader : new Ext.tree.TreeLoader(),
			root : new Ext.tree.AsyncTreeNode({
				expanded : true,
				children : [{
					id:'LoadProductCategory',
	//				varName:'LoadProdCatalog',
					text:'分类列表',
					leaf:true,
					iconCls:'icon-grid',
					path:'applications/catalog/js/CategoryGrid.js'
				},
				{
					id:'AddProductCategory',
	//				varName:'LoadProdCatalog',
					text:'为分类添加产品',
					leaf:true,
					iconCls:'icon-add',
					path:'applications/catalog/js/AddProductCategory.js'
				}
				]
			}),
			rootVisible : false,
			
			listeners : {
				scope:this,
				click : function(n) {
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
		
		var ofbiz = new Ext.Panel({
			layout:'border',
			id:this.moduleId,
			title:this.text,
			closable:true,
			iconCls:this.iconCls,
			items:[
			       menuTree,
			       this.centerPanel
			]
		});
		
		//ofbiz.add(form);
		desk.add(ofbiz);
		desk.activate(ofbiz);
	},
	openItem:function(node, path){
		AjaxEvalScript({container:this.centerPanel, url:path, varName:node.id, CmpId:node.id});
	}
});