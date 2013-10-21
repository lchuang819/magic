var orderBizPurchase = Ext.extend(Ext.app.Module,{
    moduleType:'',
    moduleId:'orderBizPurchase',
	text:'采购业务',
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
					id : 'StockForm',
					text : '进货单',
					leaf : true,
					iconCls:'',
					path:'applications/order/js/StockForm.js'
				}, {
					id : 'StockReturnForm',
					text : '进货退货单',
					leaf : true,
					iconCls:'',
					path:'applications/order/js/StockReturnForm.js'
				}, {
					id : 'OrderPaymentForm',
					text : '付款单',
					leaf : true,
					iconCls:'',
					path:'applications/order/js/OrderPaymentForm.js'
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