ProductCostsForm = Ext.extend(Ext.magic.MagicForm, {
	id:'ProductCostsForm',
	title:'产品成本配置',
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	closable:true,
	autoScroll:true,
	buttonAlign:"left",
	constructor: function(config){
		
		var productPriceTypeCbx = new Ext.magic.LocalDataComboBox({
			id:'costComponentTypeId',
			fieldLabel: '成本组成类型',
			name:'costComponent.costComponentTypeId',
			dataStoreUrl:'applications/product/data/CostComponentType.xml',
			hiddenName:'costComponent.costComponentTypeId',
			hiddenValue:''
		});
	
		var priceTf = new Ext.form.NumberField({
			id:'cost',
			fieldLabel: '成本',
			name:'costComponent.cost',
			value:'',
			width:165
		});
		
		var productIdTf = new Ext.form.TextField({
			id:'costUomId',
			name:'costComponent.costUomId',
			width:160,
			value:'CNY',
			allowBlank:false,
			hidden:true
		});
		
		var fromDateDf = new Ext.form.DateField({
			id:'fromDate',
            fieldLabel: '开始日期',
            format:'Y-m-d',
            name: 'costComponent.fromDate',
            width:165
        });
		
		var thruDateDf = new Ext.form.DateField({
			id:'thruDate',
            fieldLabel: '结束日期',
            format:'Y-m-d',
            name: 'costComponent.thruDate',
            width:165
        });
		
		var productIdTf = new Ext.form.TextField({
			id:'costComponentId',
			name:'costComponent.costComponentId',
			width:160,
			value:'',
			regex:/^[a-zA-Z0-9]+$/,
			regexText:'仅能输入大小写字母与数字',
			allowBlank:false,
			hidden:true
		});
		
		this.items = [
		              productPriceTypeCbx,
		              priceTf,
		              fromDateDf,
		              thruDateDf,
		              productIdTf
		              ];
		
		this.buttons = [
				            {
				            text: '保存',
				            type:'submit',
				            handler:function(){
				            	Ext.getCmp('ProductCostsForm').doSubmitAction({url:'facilityManager.action'});
				        	}
				        },{
				            text: '重置',
				            type:'reset',
				            handler:function(){Ext.getCmp('ProductCostsForm').form.reset();}
				        }];
		ProductCostsForm.superclass.constructor.call(this);
	},
	configComponent:function(options){
		
		this.id = options.CmpId;
	}
});