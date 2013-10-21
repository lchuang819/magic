StockGrid = Ext.extend(Ext.grid.EditorGridPanel, {
//    renderTo: 'user-grid',
	id:'StockGrid',
    iconCls: 'icon-grid',
    frame: true,
    title: 'Users',
    height: 300,
    width: 500,
    closable:true,
    autoDestroy:true,
    buttonAlign:'left',
//    style: 'margin-top: 10px',
//    sm: new Ext.grid.RowSelectionModel({
//        singleSelect: true
//    }),
    initComponent : function() {

        // typical viewConfig
        this.viewConfig = {
            forceFit: true
        };

        // relay the Store's CRUD events into this grid so these events can be conveniently listened-to in our application-code.
        this.relayEvents(this.store, ['destroy', 'save', 'update']);

        // build toolbars and buttons.
        this.tbar = this.buildTopToolbar();
//        this.bbar = this.buildBottomToolbar();
        this.buttons = this.buildUI();
		StockGrid.superclass.initComponent.call(this);
    },
    constructor: function(config){
//    	 var prodCatalogStore = new Ext.data.JsonStore({
// 			autoLoad:true,
// 			url: 'categoryLoader.action',
// 			root:'dataset',
// 			fields: [
// 			         'productCategoryId', 
// 			         'productCategoryTypeId',
// 			         'productCategoryTypeDesc',
// 			         'categoryName',
// 			         'description',
// 			         'categoryImageUrl',
// 			         'linkOneImageUrl',
// 			         'linkTwoImageUrl',
// 			         'primaryParentCategoryId'
// 			         ]
// 			        // ,
// 			//data:[['root','all'],['root2','info'],['root3','error']]
// 		});
    	 
    	 var proxy = new Ext.data.HttpProxy({
    		    api: {
    		        read : 'categoryLoader.action',
    		        create : 'orderManager.action',
    		        update: 'app.php/users/update',
    		        destroy: 'app.php/users/destroy'
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
				 'productCategoryId', 
				 'productCategoryTypeId',
				 'productCategoryTypeDesc',
				 'categoryName',
				 'description',
				 'categoryImageUrl',
				 'linkOneImageUrl',
				 'linkTwoImageUrl',
				 'primaryParentCategoryId'
			 ]
			);

    		// The new DataWriter component.
    		var writer = new Ext.data.JsonWriter({
    		    encode: true,
    		    writeAllFields: true,
    		    listful:true
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
    	 
    	 var colModel = [
 		                {id:'productCategoryId',header: "分类标识", width:120, sortable: true, locked:false, dataIndex: 'productCategoryId', editor: textField},
 		                {header: "分类类型", sortable: true, width:120,dataIndex: 'productCategoryTypeDesc', editor: textField},
// 		                {header: "分类类型标识", sortable: true, width:120,dataIndex: 'productCategoryTypeId'},
 		                {header: "分类名称", sortable: true, width:160,dataIndex: 'categoryName', editor: textField},
 		                {id:'description', header: "描述", sortable: true, dataIndex: 'description', editor: textField},
 		                {header: "主要上级分类", sortable: true, dataIndex: 'primaryParentCategoryId', editor: textField},
 		                {header: "分类图像URL", sortable: true, dataIndex: 'categoryImageUrl', editor: textField},
 		                {header: "链接图像1URL", sortable: true, dataIndex: 'linkOneImageUrl', editor: textField},
 		                {header: "链接图像2URL", sortable: true, dataIndex: 'linkTwoImageUrl', editor: textField}
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
            iconCls: 'silk-add',
            handler: this.onAdd,
            scope: this
        }, '-', {
            text: 'Delete',
            iconCls: 'silk-delete',
            handler: this.onDelete,
            scope: this
        }, '-'];
    },
//
//    /**
//     * buildBottomToolbar
//     */
//    buildBottomToolbar : function() {
//        return ['<b>@cfg:</b>', '-', {
//            text: 'autoSave',
//            enableToggle: true,
//            pressed: true,
//            tooltip: 'When enabled, Store will execute Ajax requests as soon as a Record becomes dirty.',
//            toggleHandler: function(btn, pressed) {
//                this.store.autoSave = pressed;
//            },
//            scope: this
//        }, '-', {
//            text: 'batch',
//            enableToggle: true,
//            pressed: true,
//            tooltip: 'When enabled, Store will batch all records for each type of CRUD verb into a single Ajax request.',
//            toggleHandler: function(btn, pressed) {
//                this.store.batch = pressed;
//            },
//            scope: this
//        }, '-', {
//            text: 'writeAllFields',
//            enableToggle: true,
//            tooltip: 'When enabled, Writer will write *all* fields to the server -- not just those that changed.',
//            toggleHandler: function(btn, pressed) {
//                store.writer.writeAllFields = pressed;
//            },
//            scope: this
//        }, '-'];
//    },
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
        var u = new this.store.recordType({
            first : '',
            last: '',
            email : ''
        });
        this.stopEditing();
        this.store.insert(0, u);
        this.startEditing(0, 1);
    },

    /**
     * onDelete
     */
    onDelete : function(btn, ev) {
        var index = this.getSelectionModel().getSelectedCell();
        if (!index) {
            return false;
        }
        var rec = this.store.getAt(index[0]);
        this.store.remove(rec);
    },
	configComponent:function(options){
		
		//this.id = options.CmpId;
	}
});