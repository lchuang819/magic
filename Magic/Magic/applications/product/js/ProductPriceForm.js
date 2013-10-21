ProductPriceForm = Ext.extend(Ext.magic.MagicForm, {
	id:'ProductPriceForm',
	title:'产品价格配置',
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	closable:true,
	autoScroll:true,
	buttonAlign:"left",
	constructor: function(config){
		
		var priceTf = new Ext.form.NumberField({
			id:'price',
			fieldLabel: '价格',
			name:'productPrice.price',
			width:165,
			allowBlank:false
		});
		
		var fromDateDf = new Ext.form.DateField({
			id:'fromDate',
            fieldLabel: '开始日期',
            format:'Y-m-d',
            name: 'productPriceId.fromDate',
            width:165
        });
		
		var thruDateDf = new Ext.form.DateField({
			id:'thruDate',
            fieldLabel: '结束日期',
            format:'Y-m-d',
            name: 'productPrice.thruDate',
            width:165
        });
		
		this.items = [
//		              productPriceTypeCbx,
		              priceTf,
		              fromDateDf,
		              thruDateDf
		              ];
		
//		this.buttons = [
//				            {
//				            text: '保存',
//				            type:'submit',
//				            handler:function(){
//				            	Ext.getCmp('ProductPriceForm').doSubmitAction({url:'productPriceManager.action?actionType=CreateProductPrice'});
//				        	}
//				        },{
//				            text: '重置',
//				            type:'reset',
//				            handler:function(){Ext.getCmp('ProductPriceForm').form.reset();}
//				        }];
		ProductPriceForm.superclass.constructor.call(this);
	},
	configComponent:function(options){
		
		this.id = options.CmpId;
		
		var productIdTf = new Ext.form.TextField({
			id:'productId',
			name:'productPriceId.productId',
			width:160,
			value:'',
			regex:/^[a-zA-Z0-9]+$/,
			regexText:'仅能输入大小写字母与数字',
			allowBlank:false,
			hidden:true,
			value:options.params.productId
		});
		
		this.add(productIdTf);
		
		var hiddenValue = '';
		if(options.operation == 'update'){
			hiddenValue = options.record.get('productPriceTypeId');
		}
		
		var productPriceTypeCbx = new Ext.magic.LocalDataComboBox({
			id:'productPriceTypeDesc',
			fieldLabel: '价格类型',
			name:'productPriceTypeId',
			dataStoreUrl:'applications/product/data/productPriceType.xml',
			hiddenName:'productPriceId.productPriceTypeId',
			hiddenValue:hiddenValue
		});
		
		this.insert(0, productPriceTypeCbx);
		
		if(options.operation == 'update'){
			this.get('fromDate').setVisible(false);
			this.get('thruDate').setVisible(false);
			productPriceTypeCbx.setVisible(false);
//			productPriceTypeCbx.disable();
		}
		
		if(options.record != undefined){
			this.form.loadRecord(options.record);
		}
	}
});