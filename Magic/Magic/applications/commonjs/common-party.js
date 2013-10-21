Ext.namespace("Magic", "Magic.party");

Ext.onReady(function(){
	
	Magic.party.PartyComboBox = Ext.extend(Ext.form.ComboBox ,{
		mode: 'local',
		fieldLabel: '成员',
		name:'PartyComboBoxName',
		hiddenName:'PartyComboBoxHiddenName',
//		width:160,
		displayField:'partyName',
        valueField:'partyId',
        editable:false,
        forceSelection: true,
        triggerAction: 'all',
        initComponent: function(){
			Magic.party.PartyComboBox.superclass.initComponent.call(this);
		},
		constructor: function(options){
			
			var baseParams = {actionType:'LoadPartyByRoleType', roleTypeId:''};
			
			if(options != undefined){
				if(undefined != options.fieldLabel){
					this.fieldLabel = options.fieldLabel;
				}
				if(options.name != undefined){
					this.name = options.name;
				}
				if(options.hiddenName != undefined){
					this.hiddenName = options.hiddenName;
				}
				if(options.hiddenValue != undefined){
					this.hiddenValue = options.hiddenValue;
				}
				if(options.value != undefined){
					this.value = options.value;
				}
				if(options.id != undefined){
					this.id = options.id;
				}
				if(options.roleTypeId != undefined){
					baseParams.roleTypeId = options.roleTypeId;
				}
				
				if(options.baseParams != undefined){
					baseParams = options.baseParams;
				}
			}
			
			
//			this.displayField = options.displayField;
//			this.valueField = options.valueField;
			
			var partyStore = new Ext.data.JsonStore({
				autoLoad:true,
				url: 'partyLoader.action',
				root:'dataset',
				baseParams:baseParams,
				fields: [
				         'partyName', 
				         'partyId',
				         'roleTypeId'
				         ]
				        // ,
				//data:[['root','all'],['root2','info'],['root3','error']]
			});
			
			Magic.party.PartyComboBox.superclass.constructor.call(this, {store:partyStore});
		}
		
	});
	
	Magic.party.RoleTypeComboBox = Ext.extend(Ext.form.ComboBox ,{
		mode: 'local',
		fieldLabel: '角色类型',
		name:'RoleTypeComboBoxName',
		hiddenName:'RoleTypeComboBoxHiddenName',
//		width:160,
		displayField:'description',
        valueField:'roleTypeId',
        editable:false,
        forceSelection: true,
        triggerAction: 'all',
        initComponent: function(){
			Magic.party.PartyComboBox.superclass.initComponent.call(this);
		},
		constructor: function(options){
			
			var roleTypeId = "";
			
			if(options != undefined){
				if(undefined != options.fieldLabel){
					this.fieldLabel = options.fieldLabel;
				}
				if(options.name != undefined){
					this.name = options.name;
				}
				if(options.hiddenName != undefined){
					this.hiddenName = options.hiddenName;
				}
				if(options.hiddenValue != undefined){
					this.hiddenValue = options.hiddenValue;
				}
				if(options.value != undefined){
					this.value = options.value;
				}
				if(options.id != undefined){
					this.id = options.id;
				}
				if(options.roleTypeId != undefined){
					roleTypeId = options.roleTypeId;
				}
			}
			
			
//			this.displayField = options.displayField;
//			this.valueField = options.valueField;
			
			var partyStore = new Ext.data.JsonStore({
				autoLoad:true,
				url: 'roleTypeLoader.action',
				root:'dataset',
				baseParams:{},
				fields: [
				         'description', 
				         'roleTypeId'
				         ]
				        // ,
				//data:[['root','all'],['root2','info'],['root3','error']]
			});
			
			Magic.party.RoleTypeComboBox.superclass.constructor.call(this, {store:partyStore});
		}
		
	});
});
