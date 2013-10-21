var catalogProduct=Ext.extend(Ext.app.Module,{
    moduleType:'',
    moduleId:'catalogProduct',
    text:'产品管理',
    iconCls:'icon-plugin',
	createWindow:function(){
		//alert("Fuck shit come on babby.");
		//new Ext.Window({title:'日志管理',layout:'fit',plain:true,buttonAlign:'center',border:false,resizable:false,modal:true,width:750,height:320}).show();
		
		var productPanel = new Ext.tree.TreePanel({
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
					id : 'newProduct',
					text : '新增产品',
					leaf : true,
					iconCls:'icon-add',
					path:''
				}, {
					id : 'queryProduct',
					text : '查询产品',
					leaf : true,
					iconCls:'icon-search',
					path:''
				}]
			}),
			rootVisible : false,
			
			listeners : {
				scope:this,
				click : function(n) {
					if(n.isLeaf()){
						this.openItem(n, n.id, n.text, n.attributes.path);
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
			       productPanel,
			       this.centerPanel
			]
		});
		
		//ofbiz.add(form);
		desk.add(ofbiz);
		desk.activate(ofbiz);
	},
	openItem:function(node, id,name,path){
		
		if(node.id == 'newProduct'){
			
			var productIdTf = new Ext.form.TextField({
				fieldLabel: '产品标识',
				name:'product.productId',
				width:160,
				value:'',
				regex:/^[a-zA-Z0-9]+$/,
				regexText:'仅能输入大小写字母与数字',
				allowBlank:false
			});
			
			var productTypeStore = new Ext.data.JsonStore({
				//autoLoad:true,
				url: 'loadParams.action?actionType=productType',
				root:'dataset',
				fields: [
				         'description', 
				         'productTypeId'
				         ]
				        // ,
				//data:[['root','all'],['root2','info'],['root3','error']]
			});
			
			productTypeStore.load();
			
			var productTypeCbx = new Ext.form.ComboBox({
				name:'product.productTypeId',
				hiddenName:'product.productTypeId',
				//hiddenValue:'root',
				fieldLabel:'产品类型',
		        store:productTypeStore,
		        displayField:'description',
		        valueField:'productTypeId',
		        //mode:'local',
		        //typeAhead: true,
		        editable:true,
		        //forceSelection: true,
		        triggerAction: 'all',
		        emptyText:'选择一个产品类型',
		        selectOnFocus:true
		    });
			
			var productBrandNameTf = new Ext.form.TextField({
				fieldLabel: '品牌名称',
				name:'product.brandName',
				value:'',
				width:400
			});
			
			var productInternalNameTf = new Ext.form.TextField({
				fieldLabel: '内部名称',
				name:'product.internalName',
				width:160,
				value:''
			});
			
			var productPinyinTf = new Ext.form.TextField({
				fieldLabel: '拼音码',
				name:'productKeyWords.pinyinCode',
				width:160,
				value:''
			});
			
			var productProvenanceTf = new Ext.form.TextField({
				fieldLabel: '产地',
				name:'partyPostalAddr.address1',
				value:'',
				width:400
			});
			
			var partyStore = new Ext.data.JsonStore({
				//autoLoad:true,
				url: 'partyLoader.action',
				root:'dataset',
				baseParams:{actionType:'LoadPartyByRoleType', roleTypeId:'SUPPLIER'},
				fields: [
				         'partyName', 
				         'partyId',
				         'roleTypeId'
				         ]
				        // ,
				//data:[['root','all'],['root2','info'],['root3','error']]
			});
			partyStore.load();
			
			var productSupplierCbx = new Ext.form.ComboBox({
				name:'supplierProduct.partyId',
				hiddenName:'supplierProduct.partyId',
				//hiddenValue:'root',
				fieldLabel:'供应商',
		        store:partyStore,
		        displayField:'partyName',
		        valueField:'partyId',
		        //mode:'local',
		        //typeAhead: true,
		        editable:true,
		        //forceSelection: true,
		        triggerAction: 'all',
		        emptyText:'选择一个供应商',
		        selectOnFocus:true
		    });
			
			var productCommentsTf = new Ext.form.TextField({
				fieldLabel: '备注',
				name:'product.comments',
				value:'',
				width:670
			});
			
			var productBasicFs = new Ext.form.FieldSet({
				id:'baseInfoFs',
				xtype: 'fieldset',
		        title: '基本信息',
		        autoHeight:true,
		        //labelWidth:120,
		        width:1100,
		        //baseCls:'x-plain',
		        hideLabel:false,
		        layout:'table',
                layoutConfig: {columns:4},
                labelAlign:'left',
				items:[{//第一行
					layout:'form',
					items:[productIdTf]
				},{
					layout:'form',
					items:[productTypeCbx]
				},{
					layout:'form',
					colspan:2,
					items:[productBrandNameTf]
				},{//第二行
					layout:'form',
					items:[productInternalNameTf]
				},{
					layout:'form',
					items:[productPinyinTf]
				},{
					layout:'form',
					colspan:2,
					items:[productProvenanceTf]
				},{//第三行
					layout:'form',
					items:[productSupplierCbx]
				},{
					layout:'form',
					colspan:3,
					items:[productCommentsTf]
				}]
			});
			
			//规格信息
			var measureXMLUomStore = new Ext.data.XmlStore({
				autoDestroy: true,
			    storeId: 'measureUomStore',
			    url:util.constant.appPath+'applications/product/data/measureUom.xml',
			    // reader configs
			    record: 'MeasureItem', // 每条记录都有Item标签。records will have an "Item" tag
			    idPath: 'MeasureUomId',
			    totalRecords: '@total',
			    fields: [
			             'MeasureUomName',
			             'MeasureUomId'
			             ]
			});
			measureXMLUomStore.load();
			
			var weightUomStore = new Ext.data.XmlStore({
				autoDestroy: true,
			    storeId: 'weightUomStore',
			    url:util.constant.appPath+'applications/product/data/weightUom.xml',
			    // reader configs
			    record: 'WeightItem', // 每条记录都有Item标签。records will have an "Item" tag
			    idPath: 'WeightUomId',
			    totalRecords: '@total',
			    fields: [
			             'WeightUomName',
			             'WeightUomId'
			             ]
			});
			weightUomStore.load();
			
			var quantityUomStore = new Ext.data.XmlStore({
				autoDestroy: true,
			    storeId: 'quantityUomStore',
			    url:util.constant.appPath+'applications/product/data/quantityUom.xml',
			    // reader configs
			    record: 'QuantityItem', // 每条记录都有Item标签。records will have an "Item" tag
			    idPath: 'QuantityUomId',
			    totalRecords: '@total',
			    fields: [
			             'QuantityUomName',
			             'QuantityUomId'
			             ]
			});
			quantityUomStore.load();
			
			var productMeasuresFs = new Ext.form.FieldSet({
				id:'measuresFs',
				xtype: 'fieldset',
		        title: '规格及数量',
		        autoHeight:true,
		        //labelWidth:120,
		        width:1100,
		        //baseCls:'x-plain',
		        hideLabel:false,
		        layout:'table',
                layoutConfig: {columns:4},
                labelAlign:'left',
				items:[{//第一行
					layout:'form',
					items:[{
						xtype:'textfield',
						fieldLabel: '产品高度',
						name:'product.productHeight',
						width:160
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'combo',
						store:measureXMLUomStore,
						mode: 'local',
						fieldLabel: '高度单位',
						name:'product.heightUomId',
						hiddenName:'product.heightUomId',
						width:160,
						displayField:'MeasureUomName',
				        valueField:'MeasureUomId',
				        editable:false,
				        forceSelection: true,
				        triggerAction: 'all'
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'textfield',
						fieldLabel: '产品宽度',
						name:'product.productWidth',
						width:160
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'combo',
						store:measureXMLUomStore,
						mode: 'local',
						fieldLabel: '宽度单位',
						name:'product.widthUomId',
						hiddenName:'product.widthUomId',
						width:160,
						displayField:'MeasureUomName',
				        valueField:'MeasureUomId',
				        editable:false,
				        forceSelection: true,
				        triggerAction: 'all'
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'textfield',
						fieldLabel: '产品长度',
						name:'product.productDepth',
						width:160
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'combo',
						store:measureXMLUomStore,
						mode: 'local',
						fieldLabel: '长度单位',
						name:'product.depthUomId',
						hiddenName:'product.depthUomId',
						width:160,
						displayField:'MeasureUomName',
				        valueField:'MeasureUomId',
				        editable:false,
				        forceSelection: true,
				        triggerAction: 'all'
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'textfield',
						fieldLabel: '重量',
						name:'product.weight',
						width:160
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'combo',
						store:weightUomStore,
						mode: 'local',
						fieldLabel: '重量单位',
						name:'product.weightUomId',
						hiddenName:'product.weightUomId',
						width:160,
						displayField:'WeightUomName',
				        valueField:'WeightUomId',
				        editable:false,
				        forceSelection: true,
				        triggerAction: 'all'
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'textfield',
						fieldLabel: '数量',
						name:'product.quantityIncluded',
						width:160
					}],
					colspan:2
				},{//第一行
					layout:'form',
					items:[{
						xtype:'combo',
						store:quantityUomStore,
						mode: 'local',
						fieldLabel: '数量单位',
						name:'product.quantityUomId',
						hiddenName:'product.quantityUomId',
						width:160,
						displayField:'QuantityUomName',
				        valueField:'QuantityUomId',
				        editable:false,
				        forceSelection: true,
				        triggerAction: 'all'
					}],
					colspan:2
				}]
			});
			
			var form = new Ext.form.FormPanel({
				id:node.id,
				labelWidth: 100, // label settings here cascade unless overridden
		        url:'productManager.action?actionType=CreateProduct',
		        frame:true,
		        title:node.text,
		        bodyStyle:'padding:5px 5px 0',
		        autoDestroy:true,
		        autoScroll:true,
		        closable:true,
				labelAlign:'right',
				iconCls:'icon-plugin',
				items: [productBasicFs,productMeasuresFs],
		        buttons:[
		            {
		            text: '保存',
		            type:'submit',
		            handler:function(){
			        	form.form.submit({
			        		//url : 'login.action',         
			    		    method : 'POST',
			        		success:function(form,action){
			        			alert('成功');
			        		},
			        		failure:function(form,action){
			        				if(action.failureType=='connect'){
			        					alert('连接服务器失败，请稍后再试');
			        				}else if(action.failureType=='client'){
			        					alert('提交信息有误');
			        				}else{
			        					alert('错误'+action.result.msg);
			        				}
			        		}
			        	});
		        	}
		        },{
		            text: '重置',
		            type:'reset',
		            handler:function(){form.form.reset();}
		        }],
		        buttonAlign:'left'
			});
			
			this.centerPanel.add(form);
			this.centerPanel.activate(form);
		}//newProduct end
		else if (node.id == 'queryProduct'){
			
			var store = new Ext.data.JsonStore({
		        root: 'topics',
		        totalProperty: 'totalCount',
		        idProperty: 'threadid',
		        remoteSort: true,
		        baseParams:{actionType:'LoadAll'},
		        url: 'productLoader.action',
		        fields: [
		            'sequenceId','productId','brandName','internalName'
		        ]
		    });
			
			store.load({params:{start:0, limit:10}});
			
			var conditionNameStore = new Ext.data.ArrayStore({
		        fields: ['searchConditionName', 'searchConditionId'],
		        data:[
		              ['产品标识','productId'],
		              ['品牌名称','brandName'],
		              ['内部名称','internalName'],
		              ['拼音码','pinyinCode']
		              ] // from states.js
		    });
			
			var conditionStore = new Ext.data.ArrayStore({
		        fields: ['conditionName', 'conditionType'],
		        data:[
		              ['模糊查找','like'],
		              ['精确查找','=']
		              ] // from states.js
		    });
			
			var searchConditionNameCbx = new Ext.form.ComboBox({
					store:conditionNameStore,
					mode: 'local',
					name:'searchConditionName',
					hiddenName:'searchConditionName',
					width:160,
					displayField:'searchConditionName',
			        valueField:'searchConditionId',
			        value:'productId',
			        editable:false,
			        //forceSelection: true,
			        triggerAction: 'all',
			        emptyText:'查找字段'
				});
			
			var conditionCbx = new Ext.form.ComboBox({
					store:conditionStore,
					mode: 'local',
					name:'conditionName',
					hiddenName:'conditionName',
					width:160,
					displayField:'conditionName',
			        valueField:'conditionType',
			        value:'=',
			        editable:false,
			        //forceSelection: true,
			        triggerAction: 'all',
			        emptyText:'查询条件'
				});
			
			var searchContent = new Ext.form.TextField({
				fieldLabel: '查询内容',
				name:'searchContent',
				emptyText:'查询内容',
				value:''
			});
			
			var cepanel = this.centerPanel;
			var loadCallback = function(el, success, response, options){
				if(success == false){
					Ext.log(response.responseText);
					Ext.MessageBox.show({
						title:'错误',
						msg: '信息加载失败',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			};
			
			var searchTbar = new Ext.Toolbar({
				items:[searchConditionNameCbx,conditionCbx,searchContent,{
					xtype:'button',
					text: '查询',
		            type:'submit',
		            handler:function(){
					//alert(searchConditionNameCbx.getValue() + conditionCbx.getValue() + searchContent.getValue());
						store.reload({params:{start:0, limit:10, actionType:'LoadPart', 'searchCondition.conditionName':searchConditionNameCbx.getValue(), 'searchCondition.condition':conditionCbx.getValue(), 'searchCondition.searchContent':searchContent.getValue()}});
					}
				},'-',{
		        	text:'基本信息',
		        	iconCls:'icon-static',
		        	handler:function(){
		        		var rec = grid.getSelectionModel().getSelected();
		        		if(rec == undefined){
		        			Ext.MessageBox.alert('提示', '请选择产品');
		        			return;
		        		}
		        		
		        		var productId = rec.get('productId');
		        		var productDetailPanel = new Ext.Panel({
							id:'ProductDetailPanel',
							title:'产品-'+productId+'',
							closable:true,
							autoDestroy:true,
							autoScroll:true,
							iconCls:'icon-static',
							autoLoad:{url:'productDetailLoader.action?productId='+productId, scope:this, scripts:true,
			        			callback:function(el, success, response, options){
		        					if(!success){
		        						Ext.MessageBox.show({
		        							title:'错误',
		        							msg: '产品信息加载失败',
		        							buttons: Ext.Msg.OK,
		        							icon: Ext.MessageBox.ERROR
		        						});
		        					}
		        				}
		        			}
						});
						
		        		cepanel.add(productDetailPanel);
		        		cepanel.activate(productDetailPanel);
						
		        	}
		        },'-',{
		        	text:'价格',
		        	iconCls:'icon-money-add',
		        	handler:function(){
	        			var rec = grid.getSelectionModel().getSelected();
		        		if(rec == undefined){
		        			Ext.MessageBox.alert('提示', '请选择产品');
		        			return;
		        		}
		        		var productId = rec.get('productId');
		        		var ProductPricePanel = new Ext.Panel({
							id:'ProductPricePanel',
							title:'产品-'+productId+'-价格',
							closable:true,
							autoDestroy:true,
							autoScroll:true,
							iconCls:'icon-money-add',
							autoLoad:{url:'productPrice.action?productId='+productId, scope:this, scripts:true, callback:loadCallback}
						});
						
		        		cepanel.add(ProductPricePanel);
		        		cepanel.activate(ProductPricePanel);
			        }
		        },'-',{
		        	text:'成本',
		        	iconCls:'icon-money-delete',
		        	handler:function(){
	        		var rec = grid.getSelectionModel().getSelected();
		        		if(rec == undefined){
		        			Ext.MessageBox.alert('提示', '请选择产品');
		        			return;
		        		}
		        		
		        		var productId = rec.get('productId');
		        		var productCostsPanel = new Ext.Panel({
							id:'productCostsPanel',
							title:'产品-'+productId+'-成本',
							closable:true,
							autoDestroy:true,
							autoScroll:true,
							iconCls:'icon-money-delete',
							autoLoad:{url:'productCostsLoader.action?productId='+productId, scope:this, scripts:true}
						});
						
		        		cepanel.add(productCostsPanel);
		        		cepanel.activate(productCostsPanel);
			        }
		        },'-',{
		        	text:'库存',
		        	iconCls:'icon-db',
		        	handler:function(){
	        		var rec = grid.getSelectionModel().getSelected();
		        		if(rec == undefined){
		        			Ext.MessageBox.alert('提示', '请选择产品');
		        			return;
		        		}
			        }
		        }]
			});
			
		    var grid = new Ext.grid.GridPanel({
		    	id:node.id+'Grid',
		        width:700,
		        height:500,
		        title:'产品列表',
		        store: store,
		        iconCls:'icon-grid',
		        trackMouseOver:true,
		        disableSelection:true,
		        loadMask: {msg:'加载'},
		        closable : true,
		        autoScroll:true,
		        sm: new Ext.grid.RowSelectionModel({
		            singleSelect: true
		        }),
		        columns:[{
		            id: 'sequenceId',
		            header: "行号",
		            dataIndex: 'sequenceId',
		            width: 15,
		            sortable: true
		        },{
		            header: "产品标识",
		            dataIndex: 'productId',
		            width: 60,
		            hidden: false,
		            sortable: true
		        },{
		            header: "品牌名称",
		            dataIndex: 'brandName',
		            //width: 70,
		            align: 'right',
		            sortable: true
		        },{
		            header: "内部名称",
		            dataIndex: 'internalName',
		            //width: 70,
		            align: 'right',
		            sortable: true
		        }],
		        viewConfig: {
		            forceFit:true,
		            enableRowBody:true,
		            showPreview:false,
		            getRowClass : function(record, rowIndex, p, store){
		                if(this.showPreview){
		                    p.body = '<p>'+record.data.excerpt+'</p>';
		                    return 'x-grid3-row-expanded';
		                }
		                return 'x-grid3-row-collapsed';
		            }
		        },
		        listeners:{
					scope:this,
					rowdblclick:function(cgrid, index, e) {
		        		var cRecord = cgrid.store.getAt(index);
		        		var productId = cRecord.get('productId');
						var productDetailPanel = new Ext.Panel({
							id:'ProductDetailPanel',
							title:'产品['+cRecord.get('productId')+']',
							closable:true,
							autoDestroy:true,
							autoScroll:true,
							iconCls:'icon-static',
//							autoLoad:{url:util.constant.appPath+'applications/product/widget/productDetail.ftl?productId='+productId, scripts:true}
							autoLoad:{
								url:'productDetailLoader.action?productId='+productId, 
								scope:this, 
								scripts:true,
								callback:loadCallback
							}
						});
						
						this.centerPanel.add(productDetailPanel);
						this.centerPanel.activate(productDetailPanel);
						
					},
					rowcontextmenu:function(cgrid, index, e){
						cgrid.getSelectionModel().selectRow(index);
						e.preventDefault();
						var cenp = this.centerPanel;
						
						new Ext.menu.Menu({
							items : [{
								id:'productBasicInfo',
								text : '基本信息',
								iconCls:'icon-preview',
								panel:cenp,
								record:cgrid.store.getAt(index),
								handler:this.showProductDetail
							},{
								id:'productPrice',
								text : '产品价格',
								iconCls:'icon-preview',
								panel:cenp,
								record:cgrid.store.getAt(index),
								handler:this.showProductPrice
							}]
						}).showAt(e.getXY());
					}
				},tbar:searchTbar,
				bbar: new Ext.PagingToolbar({ 
		        	pageSize:10, 
		        	store: store, 
		        	displayInfo: true, 
		        	displayMsg: '产品列表{0} - {1} of {2}', 
		        	emptyMsg: "无产品",
		        	refreshText:'刷新'
//		        	items:[ '-', {pressed: true, enableToggle:true, text: 'Show Preview', 
//		        		cls:'x-btn-text-icon details', toggleHandler: function(btn, pressed){ 
//		        		var view = grid.getView(); 
//		        		view.showPreview = pressed; 
//		        		view.refresh(); 
//		        		} 
//		        	}] 
		        	})
				
		    });
		    
			this.centerPanel.add(grid);
			this.centerPanel.activate(grid);
		}

	},
	showProductDetail:function(tb){
		AjaxEvalScript({
			container:tb.panel,
			url:'applications/product/js/ProductForm.js', 
			varName:'ProductForm',
			record:tb.record,
			callCfg:true
		});
	},
	showProductPrice:function(tb){
		AjaxEvalScript({
			container:tb.panel,
			url:'applications/product/js/ProductPriceForm.js', 
			varName:'ProductPriceForm',
			record:tb.record,
			callCfg:true
		});
	},
	showProductCosts:function(tb){
		
	},
	showProductInventory:function(tb){
		
	}
});