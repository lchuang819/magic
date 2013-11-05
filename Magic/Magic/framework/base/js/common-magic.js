Ext.namespace("Ext.magic");

Ext.onReady(function(){
	Ext.CommonWindow=Ext.extend(Ext.Window ,{
			id:'CommonWindow',
			xtype:"window",
			layout : 'form',
			plain : true,
			buttonAlign : 'center',
			border : false,
			resizable : false,
			modal : true,
			autoScroll:true,
			autoDestroy:true,
			width : 420,
			initComponent: function(){
				Ext.CommonWindow.superclass.initComponent.call(this);
			},
			constructor: function(config){
				this.title = config.title;
				
				var items = config.itemForm;
				
				var buttons = config.buttons;
				
				if(buttons == 'undefined' || buttons == null){
					
					buttons=[{
						text:'提交',
						handler: function(){
						config.itemForm.doSubmitAction(config);
					}
					},{
						text: '关闭',
						handler: function(){
						Ext.WindowMgr.get('CommonWindow').close();
					}
					}];
				}
				
				Ext.CommonWindow.superclass.constructor.call(this, {buttons:buttons, items:items});
			}
		});
	
	Ext.CommonSubmitWindow=Ext.extend(Ext.Window ,{
		id:'CommonSubmitWindow',
		title:'操作',
		layout : 'form',
		plain : true,
		buttonAlign : 'center',
		border : false,
		resizable : false,
		modal : true,
		autoScroll:true,
		autoDestroy:true,
		width : 420,
		autoScroll:true,
		constructor:function(config){
			this.title = config.title;
			var buttonsCfg = [{
				text:'提交',
				handler: function(){
					Ext.getCmp(config.formId).doSubmitAction(config);
				}
			},{
				text: '关闭',
				handler: function(){
					Ext.WindowMgr.get('CommonSubmitWindow').close();
				}
			}];
			
			if(!config.hideBtn){
				
				this.buttons = buttonsCfg;
			}
			
			Ext.CommonSubmitWindow.superclass.constructor.call(this);
		}
	});
	
	Ext.magic.MagicForm = Ext.extend(Ext.form.FormPanel ,{
		doSubmitAction:function(options){
			this.form.submit({
				url:options.url,
			    method : 'POST',
			    waitMsg : "正在执行……",
			    params : options.params,
				success:function(form, action){
					
					Ext.MessageBox.alert('提示', '操作成功');
					if(options.store != undefined){
						options.store.reload();
					}
				},
				failure:function(form,action){
					
					switch (action.failureType) {
		            case Ext.form.Action.CLIENT_INVALID:
		                Ext.Msg.alert('Failure', '输入信息有误');
		                break;
		            case Ext.form.Action.CONNECT_FAILURE:
		                Ext.Msg.alert('Failure', '服务器连接错误');
		                break;
		            case Ext.form.Action.SERVER_INVALID:
		            	if(action.result.msg != undefined){
		            		Ext.MessageBox.show({title: '失败',msg:'操作失败:'+action.result.msg,buttons: Ext.MessageBox.OK,icon: Ext.MessageBox.ERROR});
		            	}else{
		            		Ext.log(action.result.exceptionStack);
		            		Ext.MessageBox.show({title: '失败',msg:'操作失败:'+action.result.exception.message, buttons: Ext.MessageBox.OK,icon: Ext.MessageBox.ERROR});
		            	}
					}
				}
			});
		}
	});
	
	Ext.magic.LocalDataComboBox = Ext.extend(Ext.form.ComboBox ,{
		mode: 'local',
		fieldLabel: 'ComboBoxLabel',
		name:'LocalDataComboBoxName',
		hiddenName:'LocalDataComboBoxHiddenName',
//		width:160,
		displayField:'attrName',
        valueField:'attrValue',
        editable:false,
        forceSelection: true,
        triggerAction: 'all',
        initComponent: function(){
			Ext.magic.LocalDataComboBox.superclass.initComponent.call(this);
		},
		constructor: function(options){
			
			this.fieldLabel = options.fieldLabel;
			this.name = options.name;
			this.hiddenName = options.hiddenName;
			this.hiddenValue = options.hiddenValue;
			this.value = options.value;
			this.id = options.id;
			
//			this.displayField = options.displayField;
//			this.valueField = options.valueField;
			
			var localDataXMLStore = new Ext.data.XmlStore({
				autoLoad:true,
				autoDestroy: true,
//			    storeId: 'LocalDataComboBoxStore',
			    url:util.constant.appPath+options.dataStoreUrl,
			    // reader configs
			    record: 'Item', // 每条记录都有Item标签。records will have an "Item" tag
			    idPath: 'attrValue',
			    totalRecords: '@totalCount',
			    fields: [
			             {name:'attrName', mapping:'attrName'},
			             {name:'attrValue', mapping:'attrValue'}
			             ]
			});
			
			Ext.magic.LocalDataComboBox.superclass.constructor.call(this, {store:localDataXMLStore});
		}
		
	});
	
	Ext.magic.proviceComboBox = Ext.extend(Ext.form.ComboBox ,{
		mode: 'local',
		fieldLabel: '省/州',
		name:'postalAddress.province',
		hiddenName:'postalAddress.province',
		width:160,
		displayField:'provinceName',
        valueField:'provinceCode',
        editable:false,
        forceSelection: true,
        triggerAction: 'all',
        initComponent: function(){
			Ext.magic.proviceComboBox.superclass.initComponent.call(this);
		},
		constructor: function(config){
			var provinceXMLStore = new Ext.data.XmlStore({
				autoLoad:true,
				autoDestroy: true,
			    storeId: 'provinceXMLStore',
			    url:util.constant.appPath+'applications/party/data/countryInfo.xml',
			    // reader configs
			    record: 'province', // 每条记录都有Item标签。records will have an "Item" tag
			    idPath: 'provinceCode',
			    totalRecords: '@totalCount',
			    fields: [
			             {name:'provinceName', mapping:'provinceName'},
			             {name:'provinceCode', mapping:'provinceCode'}
			             ]
			});
			
			Ext.magic.proviceComboBox.superclass.constructor.call(this, {store:provinceXMLStore});
		}
		
	});
	
	Ext.magic.GeoComboBox = Ext.extend(Ext.form.ComboBox ,{
		mode: 'local',
		width:160,
		displayField:'geoName',
        valueField:'geoName',
        editable:false,
        forceSelection: true,
        triggerAction: 'all',
        autoDestroy:true,
        initComponent: function(){
			Ext.magic.proviceComboBox.superclass.initComponent.call(this);
		},
		constructor: function(options){
			this.fieldLabel = options.fieldLabel;
			this.name = options.name;
			this.hiddenName = options.hiddenName;
			this.hiddenValue = options.hiddenValue;
			
			var baseParams = {actionType:'LoadGeo'};
			if(options.useBaseParams){
				baseParams = options.baseParams;
			}
			
			var geoStore = new Ext.data.JsonStore({
//				autoLoad:true,
				url: 'partyLoader.action',
				root:'dataset',
				baseParams:baseParams,
				fields: [
				         'geoId', 
				         'geoTypeId',
				         'geoName',
				         'geoCode',
				         'geoSecCode'
				         ]
				        // ,
				//data:[['root','all'],['root2','info'],['root3','error']]
			});
			
			Ext.magic.GeoComboBox.superclass.constructor.call(this, {store:geoStore});
		},
		setProvince:function(){
			
		}
		
	});
	
});
