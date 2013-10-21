var catalogManage = Ext.extend(Ext.app.Module,{
    moduleType:'',
    moduleId:'catalogManage',
    text:'目录管理',
    iconCls:'icon-plugin',
	createWindow:function(){
		
		
//		var prodCatalogStore = new Ext.data.JsonStore({
//			autoLoad:true,
//			url: 'catalogLoader.action?actionType=',
//			root:'dataset',
//			fields: [
//			         'prodCatalogId', 
//			         'catalogName',
//			         'useQuickAdd',
//			         'styleSheet',
//			         'headerLogo',
//			         'contentPathPrefix',
//			         'templatePathPrefix'
//			         ]
//			        // ,
//			//data:[['root','all'],['root2','info'],['root3','error']]
//		});
//
//	          // example of custom renderer function
//	          function italic(value){
//	              return '<i>' + value + '</i>';
//	          }
//
//	          // example of custom renderer function
//	          function change(val){
//	              if(val > 0){
//	                  return '<span style="color:green;">' + val + '</span>';
//	              }else if(val < 0){
//	                  return '<span style="color:red;">' + val + '</span>';
//	              }
//	              return val;
//	          }
//	          // example of custom renderer function
//	          function pctChange(val){
//	              if(val > 0){
//	                  return '<span style="color:green;">' + val + '%</span>';
//	              }else if(val < 0){
//	                  return '<span style="color:red;">' + val + '%</span>';
//	              }
//	              return val;
//	          }
//	          
//
//	          // the DefaultColumnModel expects this blob to define columns. It can be extended to provide
//	          // custom or reusable ColumnModels
//	          var colModel = [
//	              {id:'prodCatalogId',header: "目录标识", sortable: true, locked:false, dataIndex: 'prodCatalogId'},
//	              {header: "目录名称", sortable: true, dataIndex: 'catalogName'},
//	              {header: "风格页", sortable: true, renderer: change, dataIndex: 'styleSheet'},
//	              {header: "头标识", sortable: true, renderer: pctChange, dataIndex: 'headerLogo'},
//	              {header: "内容路径前缀", sortable: true, dataIndex: 'contentPathPrefix'},
//	              {header: "模板路径前缀", sortable: true, dataIndex: 'templatePathPrefix'}
//	          ];
//
//	          //bd.createChild({tag: 'h2', html: 'Using a Grid with a Form'});
//
//	          var grid = new Ext.grid.GridPanel({
//	        	  	width:600,
//	        	    height: 350,
//	        	    frame:true,
//	        	    title:'目录列表',
//	        	    iconCls:'icon-grid',
//	        	    store: prodCatalogStore,
//	        	    columns: colModel,
//	        	    sm: new Ext.grid.RowSelectionModel({
//                        singleSelect: true
//                    }),
//                    listeners:{
//	        	  		scope:this,
//	        	  		rowclick:function(cgrid, index, e) {
//
//	          			var cRecord = cgrid.store.getAt(index);
//	          				Ext.getCmp("company-form").getForm().loadRecord(cRecord);
//	          			}
//	          		}
//	        	});
	          
	          var prodCatalogIdTf = new Ext.form.TextField({
	        	  	id:'prodCatalogIdTf',
					xtype:'textfield',
					fieldLabel: '目录标识',
					name: 'prodCatalogId'
	          });
	          
	          var catalogDetailFs = new Ext.form.FieldSet({
	        	  	id:'catalogDetailFs',
	        	  	columnWidth: 0.3,
		    		xtype: 'fieldset',
		            title: '目录详细信息',
		            autoHeight:true,
		            //defaultType: 'textfield',
		            //labelWidth:120,
//		            width:1100,
		            //baseCls:'x-plain',
		            hideLabel:false,
		            layout:'table',
		            layoutConfig: {columns:1},
		            labelAlign: 'right',
		            buttonAlign:'right',
		    		items:[
		    		       {//第一行
		    			layout:'form',
		    			items:[prodCatalogIdTf]
			    		},
						{
			    			layout:'form',
			    			items:[{
			    				xtype:'textfield',
			                      fieldLabel: '目录名称',
			                      name: 'catalogName'
			                  }]
			    		},{
			    			layout:'form',
			    			items:[{
			    				xtype:'textfield',
			                      fieldLabel: '风格页',
			                      name: 'styleSheet'
			                  }]
			    		},{
			    			layout:'form',
			    			items:[{
			    				xtype:'textfield',
			                      fieldLabel: '头标识',
			                      name: 'headerLogo'
			                  }]
			    		},{
			    			layout:'form',
			    			items:[{
			    				xtype:'textfield',
			                      fieldLabel: '内容路径前缀',
			                      name: 'contentPathPrefix'
			                  }]
			    		},{
			    			layout:'form',
			    			items:[{
			    				xtype:'textfield',
			    				fieldLabel: '模板路径前缀',
			    				name: 'templatePathPrefix'
		                  }]
			    		}]
	          });
	          

	      /*
	       *    Here is where we create the Form
	       */
//	          var gridForm = new Ext.form.FormPanel({
//	              id: 'company-form',
//	              frame: true,
//	              labelAlign: 'right',
//	              title: '目录管理',
//	              //bodyStyle:'padding:10px',
//	              width: 750,
//	              closable:true,
//	              layout: 'column',    // Specifies that the items will now be arranged in columns
//	              items: [catalogDetailFs,{
//	                  columnWidth: 0.10,
//	                  layout: 'fit',
//	                  items: [{}]
//	              },
//	              {
//	                  columnWidth: 0.50,
//	                  layout: 'fit',
//	                  items: [grid]
//	              }
//	              ],
//	              tbar:[
//	                    '-',
//	                    {
//		            	  xtype:'button',
//		            	  text:'保存目录',
//		            	  iconCls:'icon-save'
//	                    },
//	                    '-',
//	                    {
//		            	  xtype:'button',
//		            	  text:'新增目录',
//		            	  iconCls:'icon-add',
//		            	  handler:function(){
//	                    	Ext.getCmp("company-form").getForm().reset();
//	                      }
//	                    }]
//	          });
		
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
				children : [ {
					id : 'LoadProdCatalog',
//					varName:'LoadProdCatalog',
					text : '目录列表',
					leaf : true,
					iconCls:'icon-grid',
					path:'applications/catalog/js/CatalogGrid.js'
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