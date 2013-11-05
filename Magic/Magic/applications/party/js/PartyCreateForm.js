PartyCreateForm = Ext.extend(Ext.magic.MagicForm, {
	id : 'PartyCreateForm',
	title : '创建',
	labelWidth : 100,
	labelAlign : "right",
	layout : "form",
	padding : "10px",
	frame : true,
	closable : true,
	autoScroll : true,
	buttonAlign : "center",

	roleType : '',

	constructor : function(config) {

		var productPriceTypeCbx = new Ext.magic.LocalDataComboBox({
			id : 'partyId',
			fieldLabel : '成本组成类型',
			name : 'party.partyId',
//			dataStoreUrl : 'applications/product/data/CostComponentType.xml',
//			hiddenName : 'costComponent.costComponentTypeId',
			hiddenValue : ''
		});

		var priceTf = new Ext.form.NumberField({
			id : 'cost',
			fieldLabel : '成本',
			name : 'costComponent.cost',
			value : '',
			width : 165
		});

		var productIdTf = new Ext.form.TextField({
			id : 'costUomId',
			name : 'costComponent.costUomId',
			width : 160,
			value : 'CNY',
			allowBlank : false,
			hidden : true
		});

		var fromDateDf = new Ext.form.DateField({
			id : 'fromDate',
			fieldLabel : '开始日期',
			format : 'Y-m-d',
			name : 'costComponent.fromDate',
			width : 165
		});

		var thruDateDf = new Ext.form.DateField({
			id : 'thruDate',
			fieldLabel : '结束日期',
			format : 'Y-m-d',
			name : 'costComponent.thruDate',
			width : 165
		});

		var productIdTf = new Ext.form.TextField({
			id : 'costComponentId',
			name : 'costComponent.costComponentId',
			width : 160,
			value : '',
			regex : /^[a-zA-Z0-9]+$/,
			regexText : '仅能输入大小写字母与数字',
			allowBlank : false,
			hidden : true
		});

		this.items = [ productPriceTypeCbx, priceTf, fromDateDf, thruDateDf, productIdTf ];

		this.buttons = [ {
			text : '保存',
			type : 'submit',
			handler : function() {
				var form = Ext.getCmp('PartyCreateForm');
				Ext.log('[PartyCreateForm][buttons][handler] roleType: ' + form.roleType);
				form.doSubmitAction({
					url : 'facilityManager.action',
					params : {
						roleType : form.roleType
					}
				});
			}
		}, {
			text : '重置',
			type : 'reset',
			handler : function() {
				Ext.getCmp('PartyCreateForm').form.reset();
			}
		} ];
		PartyCreateForm.superclass.constructor.call(this);
	},
	configComponent : function(options) {

		this.id = options.CmpId;

		Ext.log('[PartyCreateForm][configComponent] roleType: ' + options.baseParams.roleType);

		this.roleType = options.baseParams.roleType;

	}
});