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
	
	Magic.party.PartySummary = Ext.extend(Ext.Window, {
		id: 'PartySummaryWindow',
		layout:'fit',
        width:800,
        height:700,
        closeAction:'hide',
        plain: true,
        maskDisabled: false,
		constructor: function(config) {
			
			var basicDataUrl = './applications/party/widget/CorporateBasicData.jsp';
			
			if(config.partyType == 'PERSON'){
				basicDataUrl = './applications/party/widget/CorporateBasicData.jsp';
			}
			
			var basicDataPanel = new Ext.Panel({
				id: 'basicDataPanel',
				title: '基本信息',
				frame : true,
				closable : true,
				autoDestroy : true,
				autoScroll : true,
				iconCls : 'icon-grid',
				autoLoad : {
					url : './applications/party/widget/CorporateBasicData.jsp',
					params : {
						roleTypeId : 'EMPLOYEE',
					},
					scope : this,
					scripts : true,
					callback : function(el, success, response, options) {
						Ext.log('[PartyList :openItem :callback ] success=' + success);
						if (!success) {
							Ext.MessageBox.show({
								title : '错误',
								msg : '产品信息加载失败',
								buttons : Ext.Msg.OK,
								icon : Ext.MessageBox.ERROR
							});
						}
					}
				}
			});
			
			var partyRolePanel = new Ext.Panel({
				id: 'partyRolePanel',
				title: '角色信息',
				frame : true,
				closable : true,
				autoDestroy : true,
				autoScroll : true,
				iconCls : 'icon-grid',
				autoLoad : {
					url : './applications/party/widget/PartyRole.jsp',
					params : {
						roleTypeId : 'EMPLOYEE',
					},
					scope : this,
					scripts : true,
					callback : function(el, success, response, options) {
						Ext.log('[PartyList :openItem :callback ] success=' + success);
						if (!success) {
							Ext.MessageBox.show({
								title : '错误',
								msg : '产品信息加载失败',
								buttons : Ext.Msg.OK,
								icon : Ext.MessageBox.ERROR
							});
						}
					}
				}
			});
			
			var tab1 = new Ext.TabPanel({
		        autoTabs:true,
		        activeTab:0,
		        deferredRender:false,
		        border:false,
		        items: [
		                basicDataPanel,
		                partyRolePanel
		                ]
		    });
			
			var sbuttons = [{
	            text:'Submit',
	            disabled:true
	        },{
	            text: 'Close',
	            handler: this.closeDetails,
	            scope: this
	        }];
			
			config = Ext.apply({
	            items: tab1,
	            buttons: sbuttons
	        }, config);

			Magic.party.PartySummary.superclass.constructor.call(this, config);

	    },
	    openDetails: function(tle) {
	    	Ext.getBody().mask();
	    	this.show(this);
	    },
	    closeDetails: function(){
	    	Ext.getBody().unmask();
	    	this.hide();
	    },
	    listeners:{
	    	'hide' : function(){
	    		this.destroy();
	    		Ext.getBody().unmask();
	    	},
	    	'close': function(){
	    		this.destroy();
	    	}
	    }
	});
	
});
