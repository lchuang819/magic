StockForm = Ext.extend(Ext.magic.MagicForm, {
	id:'StockForm',
	title:'进货单',
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	closable:true,
	autoScroll:true,
	buttonAlign:"left",
	iconCls:'icon-grid',
	constructor: function(config){
	
		var orderNameTf = new Ext.form.TextField({
			fieldLabel:'进货单名称',
			width:160,
			name:'orderName',
			allowBlank:false
		});
		
		var store = new Ext.data.JsonStore({
	        root: 'dataset',
	        totalProperty: 'totalCount',
	        idProperty: 'partyId',
	        autoDestroy: true,
	        remoteSort: true,
	        autoLoad:true,
	        url: 'partyLoader.action',
	        baseParams:{actionType : 'LoadPartyByRoleType', roleTypeId : 'SUPPLIER'},
	        fields: [
	            'partyId', 'personalTitle', 'lastName', 'firstName', 'partyTypeId', 'partyTypeDescription', 'comments'
	        ]
	    });
		
		var supplierCbx = new Ext.form.ComboBox({
			fieldLabel:'供应商',
			store:store,
			valueField:'partyId',
			displayField:'lastName',
			mode:'local'
		});
	
		var passBy = new Magic.party.PartyComboBox({
			fieldLabel:'经手人',
			roleTypeId:'EMPLOYEE'
		});
		
		var receiveProductStore = new Magic.party.PartyComboBox({
			fieldLabel:'收货仓库',
			roleTypeId:'EMPLOYEE'
		});
		
		var commentsTf = new Ext.form.TextField({
			fieldLabel:'备注',
			name:'comments',
			width:400,
			allowBlank:true,
			hidden:false
		});
		
		var stockBasicInfoFs = new Ext.form.FieldSet({
			id:'stockBasicInfoFs',
			xtype: 'fieldset',
//	        title: '基本信息',
	        autoHeight:true,
	        //labelWidth:120,
//	        width:1100,
	        //baseCls:'x-plain',
	        hideLabel:false,
	        layout:'table',
	        layoutConfig: {columns:4},
	        labelAlign:'left',
			items:[{//第一行
				layout:'form',
				items:[orderNameTf]
			},{
				layout:'form',
				items:[supplierCbx]
			},{
				layout:'form',
				items:[passBy]
			},{
				layout:'form',
				items:[receiveProductStore]
			},{//第二行
				layout:'form',
				colspan:4,
				items:[commentsTf]
			}]
		});
		
		var StockGrid = Ext.extend(Ext.grid.EditorGridPanel, {
//		    renderTo: 'user-grid',
			id:'StockGrid',
		    iconCls: 'icon-grid',
		    frame: true,
		    title: '产品明细',
		    height: 280,
//		    width: 500,
		    closable:true,
		    autoDestroy:true,
		    buttonAlign:'left',
//		    style: 'margin-top: 10px',
		    clicksToEdit:1,
		    autoExpandColumn:'itemDescription',
		    sm: new Ext.grid.RowSelectionModel({
		        singleSelect: true
		    }),
		    listeners:{
				scope:this,
				afteredit:function(o){
					var q = o.record.get('quantity');
					var u = o.record.get('unitPrice');
					o.record.set('totalPrice', q * u);
				}
			},
		    initComponent : function() {

		        // typical viewConfig
		        this.viewConfig = {
		            forceFit: true
		        };

		        // relay the Store's CRUD events into this grid so these events can be conveniently listened-to in our application-code.
		        this.relayEvents(this.store, ['destroy', 'save', 'update']);

		        // build toolbars and buttons.
		        this.tbar = this.buildTopToolbar();
//		        this.bbar = this.buildBottomToolbar();
//		        this.buttons = this.buildUI();
				StockGrid.superclass.initComponent.call(this);
		    },
		    constructor: function(config){
//		    	 var prodCatalogStore = new Ext.data.JsonStore({
//		 			autoLoad:true,
//		 			url: 'categoryLoader.action',
//		 			root:'dataset',
//		 			fields: [
//		 			         'productCategoryId', 
//		 			         'productCategoryTypeId',
//		 			         'productCategoryTypeDesc',
//		 			         'categoryName',
//		 			         'description',
//		 			         'categoryImageUrl',
//		 			         'linkOneImageUrl',
//		 			         'linkTwoImageUrl',
//		 			         'primaryParentCategoryId'
//		 			         ]
//		 			        // ,
//		 			//data:[['root','all'],['root2','info'],['root3','error']]
//		 		});
		    	 
		    	 var proxy = new Ext.data.HttpProxy({
		    		    api: {
		    		        read : '#',
		    		        create : 'orderManager.action?actionType=CreateOrder',
		    		        update: 'orderManager.action?actionType=UpdateOrder',
		    		        destroy: 'orderManager.action?actionType=DeleteOrder'
		    		    }
		    		});

		    		// Typical JsonReader.  Notice additional meta-data params for defining the core attributes of your json-response
		    		var reader = new Ext.data.JsonReader({
		    		    totalProperty: 'total',
		    		    successProperty: 'success',
		    		    idProperty: 'id',
		    		    root: 'dataset',
		    		    messageProperty: 'message'  // <-- New "messageProperty" meta-data
		    		},[
						 'productId', 
						 'brandName',
						 'quantity',
						 'unitPrice',
						 'totalPrice',
						 'itemDescription'
					 ]
					);

		    		// The new DataWriter component.
		    		var writer = new Ext.data.JsonWriter({
		    		    encode: true,
		    		    writeAllFields: false
		    		});

		    		// Typical Store collecting the Proxy, Reader and Writer together.
		    		var prodCatalogStore = new Ext.data.Store({
		    		    id: 'user',
		    		    proxy: proxy,
		    		    reader: reader,
		    		    writer: writer,  // <-- plug a DataWriter into the store just as you would a Reader
		    		    autoSave: false // <-- false would delay executing create, update, destroy requests until specifically told to do so with some [save] buton.
		    		});

		    		// load the store immeditately
		    		prodCatalogStore.load();
		         
		    	 var textField =  new Ext.form.TextField();
		    	 var numberField = new Ext.form.NumberField();
		    	 
		    	 var colModel = [
		 		                {id:'productId',header: "产品编号", width:60, sortable: true, locked:false, dataIndex: 'productId', editor: textField},
		 		                {header: "产品名称", sortable: true, width:100,dataIndex: 'brandName', editor: textField},
		 		                {header: "数量", sortable: true, width:30, dataIndex: 'quantity', editor: numberField},
		 		                {header: "单价", sortable: true, width:30, dataIndex: 'unitPrice', editor: numberField},
		 		                {header: "合计", sortable: true, width:30, dataIndex: 'totalPrice', editor: numberField},
		 		                {header: "清单备注", sortable: true, dataIndex: 'itemDescription', editor: textField}
		 		            ];

		         // super
		         StockGrid.superclass.constructor.call(this, {store:prodCatalogStore, columns:colModel});
		    },

		    /**
		     * buildTopToolbar
		     */
		    buildTopToolbar : function() {
		        return [{
		            text: 'Add',
		            iconCls: 'icon-add',
		            handler: this.onAdd,
		            scope: this
		        }, '-', {
		            text: 'Delete',
		            iconCls: 'icon-delete',
		            handler: this.onDelete,
		            scope: this
		        }, '-'];
		    },
		//
//		    /**
//		     * buildBottomToolbar
//		     */
//		    buildBottomToolbar : function() {
//		        return ['<b>@cfg:</b>', '-', {
//		            text: 'autoSave',
//		            enableToggle: true,
//		            pressed: true,
//		            tooltip: 'When enabled, Store will execute Ajax requests as soon as a Record becomes dirty.',
//		            toggleHandler: function(btn, pressed) {
//		                this.store.autoSave = pressed;
//		            },
//		            scope: this
//		        }, '-', {
//		            text: 'batch',
//		            enableToggle: true,
//		            pressed: true,
//		            tooltip: 'When enabled, Store will batch all records for each type of CRUD verb into a single Ajax request.',
//		            toggleHandler: function(btn, pressed) {
//		                this.store.batch = pressed;
//		            },
//		            scope: this
//		        }, '-', {
//		            text: 'writeAllFields',
//		            enableToggle: true,
//		            tooltip: 'When enabled, Writer will write *all* fields to the server -- not just those that changed.',
//		            toggleHandler: function(btn, pressed) {
//		                store.writer.writeAllFields = pressed;
//		            },
//		            scope: this
//		        }, '-'];
//		    },
		//
		    /**
		     * buildUI
		     */
		    buildUI : function() {
		        return [{
		            text: 'Save',
		            iconCls: 'icon-save',
		            handler: this.onSave,
		            scope: this
		        }];
		    },

		    /**
		     * onSave
		     */
		    onSave : function(btn, ev) {
		        this.store.save();
		    },
		//
		    /**
		     * onAdd
		     */
		    onAdd : function(btn, ev) {
		        
		        var win = new Ext.Window({
		        	id:'ProductGridWindow',
		        	width:600, height: 320,
		    		title:'操作',
		    		layout : 'fit',
		    		plain : true,
		    		border : false,
		    		resizable : false,
		    		modal : true,
		    		autoDestroy:true
		        });
		        
		        var stockGrid = this;
		        var stockStore = this.store;
		        
		        var p = new Magic.product.ProductGrid({id:'StockFormProductGrid'});
		        p.on('rowdblclick', function(cgrid, index, e){
		        	var cRecord = cgrid.store.getAt(index);
	        		var productIds = cRecord.get('productId');
	        		var brandNames = cRecord.get('brandName');
	        		
	        		var u = new this.store.recordType({
			            productId : productIds,
			            brandName: brandNames,
			            quantity : 1,
			            unitPrice : 1,
			            totalPrice : 1,
			            itemDescription : ''
			        });
	        		
	        		stockGrid.stopEditing();
	        		stockStore.insert(0, u);
//			        stockGrid.startEditing(0, 0);
			        
	        		win.close();
		        });
		        
		        
		        win.add(p);
		        win.show();
		        
		        
		    },

		    /**
		     * onDelete
		     */
		    onDelete : function(btn, ev) {
		        var index = this.getSelectionModel().getSelected();
		        if (!index) {
		            return false;
		        }
//		        var rec = this.store.getAt(index[0]);
		        this.store.remove(index);
		    },
			configComponent:function(options){
				
				//this.id = options.CmpId;
			},
			doAction:function(params){
				this.store.setBaseParam('supplierId', params.supplierId);
				this.store.setBaseParam('passBy', params.passBy);
				this.store.setBaseParam('receiveProductStore', params.receiveProductStore);
				this.store.setBaseParam('comments', params.comments);
				this.store.setBaseParam('orderTypeId', "PURCHASE_ORDER");
				this.store.setBaseParam('orderName', params.orderName);
				
				var saveCount = grid.store.save();
				if(saveCount == -1){
					Ext.MessageBox.show({title: '失败',msg:'操作失败', buttons: Ext.MessageBox.OK,icon: Ext.MessageBox.ERROR});
					return false;
				}else{
					this.store.commitChanges();
					return true;
				}
			}
		});
		
		var grid = new StockGrid();
		
		this.items = [
		              stockBasicInfoFs,
		              grid
		              ];
		
		this.buttons = [{
							id:'stocksave',
							text: '保存',
				            type:'submit',
				            handler:function(){
//								alert(Ext.getCmp('StockForm').form.isValid());
								if(!Ext.getCmp('StockForm').form.isValid()){
									Ext.MessageBox.show({title: '失败',msg:'输入信息有误', buttons: Ext.MessageBox.OK,icon: Ext.MessageBox.ERROR});
									return;
								}
								
								var res = grid.doAction({
									supplierId:supplierCbx.getValue(),
									passBy:passBy.getValue(),
									receiveProductStore:receiveProductStore.getValue(),
									comments:commentsTf.getValue(),
									orderName:orderNameTf.getValue()
								});
								
								if(res){
									Ext.MessageBox.show({
								           title:'操作成功',
								           msg: '数据保存成功，继续创建新订单?',
								           buttons: Ext.MessageBox.YESNO,
								           fn: this.showResult,
								           animEl: 'stocksave',
								           icon: Ext.MessageBox.QUESTION
									});
								}
								
				        	},
				        	showResult:function(btn){
				        		if(btn == 'yes'){
				        			Ext.getCmp('StockForm').form.reset();
				        			grid.store.removeAll();
				        		}else{
				        			Ext.getCmp('StockForm').destroy();
				        		}
				        	}
				        },{
				            text: '重置',
				            type:'reset',
				            handler:function(){Ext.getCmp('StockForm').form.reset();}
				        }];
		StockForm.superclass.constructor.call(this);
	},
	configComponent:function(options){
		
		//this.id = options.CmpId;
	}
});