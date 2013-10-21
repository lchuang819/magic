PartyRoleForm = Ext.extend(Ext.magic.MagicForm, {
	id:'PartyRoleForm',
	title:'成员角色',
	labelWidth:100,
	labelAlign:"right",
	layout:"form",
	padding:"10px",
	frame:true,
	closable:true,
	autoScroll:true,
	buttonAlign:"left",
	constructor: function(config){
		
		var roleTypeCbx = new Magic.party.RoleTypeComboBox({
			hiddenName:'partyRoleId.roleTypeId'
		});
	
		this.items = [
		              roleTypeCbx
		              ];
		
//		this.buttons = [
//				            {
//				            text: '保存',
//				            type:'submit',
//				            handler:function(){
//				            	Ext.getCmp('PartyRoleForm').doSubmitAction({url:'facilityManager.action'});
//				        	}
//				        },{
//				            text: '重置',
//				            type:'reset',
//				            handler:function(){Ext.getCmp('PartyRoleForm').form.reset();}
//				        }];
		PartyRoleForm.superclass.constructor.call(this);
	},
	configComponent:function(options){
		
		this.id = options.CmpId;
		var partyIdTf = new Ext.form.TextField({
			id:'partyRoleId',
			name:'partyRoleId.partyId',
			width:160,
			value:options.partyId,
			regexText:'仅能输入大小写字母与数字',
			allowBlank:false,
			hidden:true
		});
		
		this.insert(1, partyIdTf);
	}
});