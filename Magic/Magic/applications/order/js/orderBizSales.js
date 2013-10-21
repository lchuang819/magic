var orderBizSales = Ext.extend(Ext.app.Module,{
    moduleType:'',
    moduleId:'orderBizSales',
	text:'销售业务',
    iconCls:'icon-plugin',
	createWindow:function(){
		
		
		var menuTree = new Ext.tree.TreePanel({
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
					id : 'SalesForm',
					text : '销售单',
					leaf : true,
					iconCls:'',
					path:'applications/order/js/SalesForm.js'
				}, {
					id : 'SalesReturnForm',
					text : '销售退货单',
					leaf : true,
					iconCls:'',
					path:'applications/order/js/SalesReturnForm.js'
				}, {
					id : 'OrderInvoiceForm',
					text : '收款单',
					leaf : true,
					iconCls:'',
					path:'applications/order/js/OrderInvoiceForm.js'
				}]
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
		
		this.centerPanel = new Ext.TabPanel({
			
			region : 'center',
			title:'中心区'
		});
		
		var ofbiz = new Ext.Panel({
			id:this.moduleId,
			title:this.text,
			closable:true,
			iconCls:this.iconCls,
			layout : 'border',
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
		
		AjaxEvalScript({
			container:this.centerPanel,
			url:path,
			varName:node.id,
			CmpId:node.id,
			callCfg:true
		});
		
	}
});