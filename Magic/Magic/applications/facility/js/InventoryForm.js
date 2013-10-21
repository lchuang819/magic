InventoryForm = Ext.extend(Ext.magic.MagicForm, {
	id:'InventoryForm',
	title:'仓库信息',
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	closable:true,
	autoScroll:true,
	buttonAlign:"left",
	constructor: function(config){
		var facilityIdTf = new Ext.form.TextField({
			fieldLabel: '仓库标识',
			id:'facilityId',
			name:'facility.facilityId',
			width:160,
			value:'',
			regex:/^[a-zA-Z0-9]+$/,
			regexText:'仅能输入大小写字母与数字',
			allowBlank:false
		});
		
		var ownerPartyIdTf = new Ext.form.TextField({
			id:'ownerPartyId',
			fieldLabel: '仓库拥有者',
			name:'facility.ownerPartyId',
			value:'',
			width:160
		});
		
		var facilityNameTf = new Ext.form.TextField({
			id:'facilityName',
			fieldLabel: '仓库名称',
			name:'facility.facilityName',
			value:'',
			width:160
		});
		
		var descriptionTf = new Ext.form.TextField({
			id:'description',
			fieldLabel: '描述信息',
			name:'facility.description',
			value:'',
			width:200
		});
		
		var openedDateDf = new Ext.form.DateField({
			id:'openedDate',
            fieldLabel: '开放日期',
            name: 'facility.openedDate',
            width:190
        });
		
		var closedDateDf = new Ext.form.DateField({
			id:'closedDate',
            fieldLabel: '关闭日期',
            name: 'facility.openedDate',
            width:190
        });
		
		this.items = [
		              facilityIdTf,
		              ownerPartyIdTf,
		              facilityNameTf,
		              descriptionTf,
		              openedDateDf,
		              closedDateDf
		              ];
		
//		this.buttons = [
//				            {
//				            text: '保存',
//				            type:'submit',
//				            handler:function(){
//				            	Ext.getCmp('InventoryForm').doSubmitAction({url:'facilityManager.action'});
//				        	}
//				        },{
//				            text: '重置',
//				            type:'reset',
//				            handler:function(){Ext.getCmp('InventoryForm').form.reset();}
//				        }];
		InventoryForm.superclass.constructor.call(this);
	},
	configComponent:function(options){
		
		this.id = options.CmpId;
	}
});