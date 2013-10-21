<style type="text/css">
    .complete .x-tree-node-anchor span {
        text-decoration: line-through;
        color: #777;
    }
</style>
<script type="text/javascript">

	//Ext.onReady(function(){
		var selectGroupId;
		var tree = new Ext.tree.TreePanel({
			title : '组列表',
			//width : 400,
			height : 500,
			useArrows:true,
        	autoScroll:true,
        	animate:true,
        	enableDD:true,
        	containerScroll: true,
			root : {
				text : 'groupsRoot',
				nodeType: 'async',
				expanded:true
			},
			loader : new Ext.tree.TreeLoader(),
			listeners : {
				//scope:this,
				click : function(n) {
					if(n.isLeaf()){
						//alert("节点ID："+n.id);
						selectGroupId = n.id;
						tree2.loader.baseParams.groupId=n.id;
						tree2.root.reload();
						tree2.expandAll();
						//tree2.loader.load({params:{groupId:'FULLADMIN'}});
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
		
		tree.on('beforeload', function(node) {

			tree.loader.dataUrl = 'groupTreeLoader.action'; // 定义子节点的Loader

        });
		
		tree.render('tree');
		
		var tree2 = new Ext.tree.TreePanel({
			title : '菜单列表',
			height : 500,
			width : 250,
			useArrows:true,
        	autoScroll:true,
        	animate:true,
        	enableDD:true,
        	containerScroll: true,
			root : {
				text : 'menusRoot',
				nodeType: 'async',
				expanded:true,
				checked:true
			},
			loader : new Ext.tree.TreeLoader({
				dataUrl:'menuTreeLoader.action',
				baseParams:{checkTree:true, groupId:''}
			}),
			listeners: {
	            'checkchange': function(node, checked){
	            	/**
	            	if(node.leaf && checked){
	            		var parentNode = node.parentNode;
	            		var pIsChecked = parentNode.getUI().isChecked();
	            		if(!pIsChecked){
	            			parentNode.getUI().toggleCheck(true);
	            		}
	            	}else 
	            	**/
	            	
	            	if(!node.leaf && checked){
						node.eachChild(function(nodechild){
							nodechild.getUI().toggleCheck(true);
						});
                	}else if(!node.leaf && !checked){
                    	node.eachChild(function(nodechild){
							nodechild.getUI().toggleCheck(false);
						});
                	}
	            }
       		}

		});
		
		tree2.render('tree2');
	
		tree2.on('checkchange', function(node) {

			//alert("id:"+node.id+" check:"+node.getUI().isChecked());
			Ext.Ajax.request({
   				url: 'permissionMenuTreeManager.action',
   				failure: function(f, action){Ext.MessageBox.alert("修改用户菜单失败",action.result.msg);},
   				params:{menuId: node.id, checked:node.getUI().isChecked(), groupId:selectGroupId}
			});
			
        });
	
	
	/**
	MyPanelUi = Ext.extend(Ext.Panel, {
	    title: 'My Panel',
	    width: 430,
	    height: 402,
	    layout: 'table',
	    initComponent: function() {
	        this.items = [
	            tree,
	            tree2
	        ];
	        MyPanelUi.superclass.initComponent.call(this);
	    }
	});
	var pan = new MyPanelUi({});
	pan.render('tree3');
	*/
</script>
<table>
	<tr>
		<td>
			<div id="tree"></div>
		</td>
		<td>
			<div id="tree2"></div>
		</td>
	</tr>
<table>

<div id="tree3"></div>


