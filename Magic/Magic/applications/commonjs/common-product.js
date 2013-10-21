Ext.namespace("Magic", "Magic.product");

Ext.onReady(function(){
	
	Magic.product.ProductGrid = Ext.extend(Ext.grid.GridPanel ,{
        width:420,
        height:350,
        title:'产品列表',
        iconCls:'icon-grid',
        trackMouseOver:false,
        disableSelection:false,
        loadMask: true,
        closable : true,
        autoScroll:true,
//        plugins: [new JavaGridFilters({
//            filters: [{
//                type: 'string',
//                dataIndex: 'productId'
//            }
//            ,{
//                type: 'string',
//                dataIndex: 'brandName'
//            },{
//                type: 'string',
//                dataIndex: 'internalName'
//            }
//            ]
//        })],
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        columns:[{
            header: "产品标识",
            dataIndex: 'productId',
            width: 60,
//            fixed:true,
            hidden: false,
            sortable: true
        },{
            header: "品牌名称",
            dataIndex: 'brandName',
            //width: 70,
//            fixed:true,
            align: 'right',
            sortable: true
        },{
            header: "内部名称",
            dataIndex: 'internalName',
            //width: 70,
//            fixed:true,
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
		constructor:function(options){
        	
        	if(options != undefined && options.id != undefined){
        		this.id = options.id;
        	}
        	
			var store = new Ext.data.JsonStore({
		        root: 'topics',
		        totalProperty: 'totalCount',
		        idProperty: 'threadid',
		        remoteSort: true,
		        baseParams:{actionType:'LoadAll'},
		        url: 'productLoader.action',
		        fields: [
		            'sequenceId','productId','brandName','internalName','defaultPrice'
		        ]
		    });
			
			var bbar = new Ext.PagingToolbar({ 
	        	pageSize:10, 
	        	store: store, 
	        	displayInfo: true, 
	        	displayMsg: '产品列表{0} - {1} of {2}', 
	        	emptyMsg: "无产品",
	        	refreshText:'刷新'
//	        	items:[ '-', {pressed: true, enableToggle:true, text: 'Show Preview', 
//	        		cls:'x-btn-text-icon details', toggleHandler: function(btn, pressed){ 
//	        		var view = grid.getView(); 
//	        		view.showPreview = pressed; 
//	        		view.refresh(); 
//	        		} 
//	        	}] 
	        	});
			
			store.load({params:{start:0, limit:10}});
			
			this.store = store;
			
			Magic.product.ProductGrid.superclass.constructor.call(this, {bbar:bbar});
		}
	});
});
