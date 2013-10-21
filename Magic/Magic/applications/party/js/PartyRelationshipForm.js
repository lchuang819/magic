PartyRelationshipForm = Ext.extend(Ext.magic.MagicForm, {
	id:'PartyRelationshipForm',
	title:'成员关系',
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	closable:true,
	autoScroll:true,
	buttonAlign:"left",
	constructor: function(config){
		
		var roleTypeFromCbx = new Magic.party.RoleTypeComboBox({
			hiddenName:'partyRelationshipId.roleTypeIdFrom'
		});
	
		var partyIdToCbx = new Ext.form.ComboBox({
			fieldLabel:'下级成员',
			name:'partyIdTo',
			hiddenName:'partyRelationshipId.partyIdTo',
			displayField:'firstName',
	        valueField:'partyId',
	        editable:false,
	        forceSelection: true,
	        triggerAction: 'all',
	        store:new Ext.data.JsonStore({
				autoLoad:true,
				url: 'partyByLoader.action',
				root:'dataset',
				baseParams:{},
				fields: [
				         'firstName',
				         'partyId'
				         ]
			})
		});
		
		var roleTypeToCbx = new Magic.party.RoleTypeComboBox({
			hiddenName:'partyRelationshipId.roleTypeIdTo'
		});
		
		var fromDateDf = new Ext.form.DateField({
			id:'fromDate',
			fieldLabel: '创建日期',
			name: 'partyRelationshipId.fromDate',
			width:190,
			format:'Y-m-d'
		});
		
		var commentsTf = new Ext.form.TextField({
			id:'comments',
			fieldLabel: '描述信息',
			name:'partyRelationship.comments',
			width:200
		});
		
		this.items = [
		              roleTypeToCbx,
		              partyIdToCbx,
		              roleTypeFromCbx,
		              fromDateDf,
		              commentsTf
		              ];
		
//		this.buttons = [
//				            {
//				            text: '保存',
//				            type:'submit',
//				            handler:function(){
//				            	Ext.getCmp('PartyRelationshipForm').doSubmitAction({url:'facilityManager.action'});
//				        	}
//				        },{
//				            text: '重置',
//				            type:'reset',
//				            handler:function(){Ext.getCmp('PartyRelationshipForm').form.reset();}
//				        }];
		PartyRelationshipForm.superclass.constructor.call(this);
	},
	configComponent:function(options){
		
		this.id = options.CmpId;
		var partyIdFromTf = new Ext.form.TextField({
			id:'partyIdFrom',
			fieldLabel:'上级成员',
			name:'partyRelationshipId.partyIdFrom',
			width:160,
			value:options.partyId,
			allowBlank:false
		});
		
		this.insert(0, partyIdFromTf);
	}
});