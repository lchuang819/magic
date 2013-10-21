// 用web方式查看系统的日志信息
//var 变量要与数据库中定义的MenuId相同
var settingSystem=Ext.extend(Ext.app.Module,{
    moduleType:'',moduleId:'settingSystem',text:'系统设置',iconCls:'icon-plugin',ft:'刘闯',
	createWindow:function(){
		//alert("Fuck shit come on babby.");
		//new Ext.Window({title:'日志管理',layout:'fit',plain:true,buttonAlign:'center',border:false,resizable:false,modal:true,width:750,height:320}).show();
		var ofbiz = new Ext.Panel({id:this.moduleId,title:this.text,closable:true});
		
		this.centerPanel = new Ext.TabPanel({
			
			region : 'center',
			title:'中心区'
		});

		
		
//		form.on('close', function(){
//			//this.centerPanel.remove(form, true);
//		});
		
	
		var tree = new Ext.tree.TreePanel({
			region : 'west',
			collapsible : true,
			title : this.text,
			width : 200,
			height : this.height,
			autoScroll : true,
			closable : true,
			split : true,
			loader : new Ext.tree.TreeLoader(),
			root : new Ext.tree.AsyncTreeNode({
				expanded : true,
				children : [ {
					id : 'baseParamsSetting',
					text : '基本参数设置',
					leaf : true,
					path:''
				}, {
					id : 'logParamsSetting',
					text : '日志参数设置',
					leaf : true,
					path:''
				}]
			}),
			rootVisible : false,
			
			listeners : {
				scope:this,
				click : function(n) {
					if(n.isLeaf()){
						this.openItem(n.id,n.text,n.attributes.path);
					}else{
						 if(n.expanded){
							 n.collapse();
						 }else{
							 n.expand();
						 }
					}
				}
			}
			});
		
		var permissionSettingPanel = new Ext.Panel({
			id : this.moduleId,
			layout : 'border',
			closable : true,
			title:this.text,
			iconCls:this.iconCls,
			items : [ 
				    tree,
				    this.centerPanel
			]
		});

		desk.add(permissionSettingPanel);
		desk.activate(permissionSettingPanel);
		
		//ofbiz.add(form);
		//desk.add(ofbiz);
		//desk.activate(ofbiz);
	},
	openItem:function(id, text, path){
		
//		Ext.Ajax.request({
//				url: 'systemSettingManager.action',
//				failure: function(f, action){Ext.MessageBox.alert("加载参数信息失败",action.result.msg);},
//				params:{actionType:id+'Load'}
//		});
		
		
		
		if(id == 'baseParamsSetting'){
			
			var form = new Ext.form.FormPanel({
				id:id,
				labelWidth: 120, // label settings here cascade unless overridden
		        url:'systemSettingManager.action?actionType='+id,
		        frame:true,
		        title: text,
		        bodyStyle:'padding:5px 5px 0',
		        autoDestroy:true,
		        closable:true,
				items: [],
		        buttons:[
		            {
		            text: '保存',
		            type:'submit',
		            handler:function(){
			        	form.form.submit({
			        		//url : 'login.action',         
			    		    method : 'POST',
			        		success:function(form,action){
			        			alert('成功');
			        		},
			        		failure:function(form,action){
			        				if(action.failureType=='connect'){
			        					alert('连接服务器失败，请稍后再试');
			        				}else if(action.failureType=='client'){
			        					alert('提交信息错误');
			        				}
			        		}
			        	});
		        	}
		        },{
		            text: '重置',
		            type:'reset',
		            handler:function(){form.form.reset();}
		        }],
		        buttonAlign:'left'
				});
			
			var sessionTimeoutField = new Ext.form.NumberField({
	            fieldLabel: '会话超时时间(分钟)',
	            name: 'systemParam.sessionTimeout',
	            minValue: '10',
	            maxValue: '60',
	            allowBlank:false,
	            minLength:2,
	            maxLength:2,
	            blankText:'参数不能为空',
	            value:30
	        });
			
			var store = new Ext.data.ArrayStore({
		        fields: ['abbr', 'state', 'nick'],
		        data : [
		                ['AL', 'Alabama', 'The Heart of Dixie'],
		                ['AK', 'Alaska', 'The Land of the Midnight Sun'],
		                ['AZ', 'Arizona', 'The Grand Canyon State'],
		                ['AR', 'Arkansas', 'The Natural State'],
		                ['CA', 'California', 'The Golden State']
		                
		            ]// from states.js
		    });
			
			var logpathField = new Ext.form.ComboBox({
				fieldLabel: '会话超时时间(分钟)',
				store:store,
				displayField:'state',
				editable :false,
		        typeAhead: true,
		        mode: 'local',
		        forceSelection: true,
		        triggerAction: 'all',
		        emptyText:'Select a state...',
		        selectOnFocus:true
			});
			
			form.add(sessionTimeoutField);
			form.add(logpathField);
			this.centerPanel.add(form);
			this.centerPanel.activate(form);
		
				
		}else if(id == 'logParamsSetting'){
			
			var reader = new Ext.data.JsonReader({
				totalProperty: 'totalCount',
			    //url: 'systemSettingManager.action?actionType='+id+'Load',
			    root: 'logParamsSettingData',
			    //baseParams:{actionType:id+'Load'},
			    fields: [
			            {name:'logParamsSetting.configFile', mapping:'configFile'}, 
			            {name:'logParamsSetting.configFileContent', mapping:'configFileContent'}
			            ]
			});
			
			var logLevelStore = new Ext.data.JsonStore({
				//autoLoad:true,
				url: 'systemSettingManager.action?actionType='+id+'Load',
				root:'logParamsSettingData',
				fields: [
				         'loggerName', 
				         'level'
				         ]
				        // ,
				//data:[['root','all'],['root2','info'],['root3','error']]
			});
			
			var levelDataStore = new Ext.data.ArrayStore({
		        fields: ['levelName', 'level'],
		        //data:[['全部','ALL'],['信息','INFO'],['错误','ERROR']]
		        data:[['全部','ALL'],['信息','INFO'],['错误','ERROR']]
		    });
			
			var logLevelcombo = new Ext.form.ComboBox({
				name:'rootLevel',
				hiddenName:'rootLevel',
				//hiddenValue:'root',
				fieldLabel:'root',
		        store: levelDataStore,
		        displayField:'levelName',
		        valueField:'level',
		        mode:'local',
		        //typeAhead: true,
		        editable:false,
		        forceSelection: true,
		        triggerAction: 'all',
		        emptyText:'root日志级别',
		        selectOnFocus:true
		    });
			
			logLevelStore.load({callback:function(r, options, success){
				var record = logLevelStore.getAt(0);
				logLevelcombo.setValue(record.get('level'));
			}});
			
			//alert(loglevelChk.getSize());
			var loglevelFs = new Ext.form.FieldSet({
				xtype: 'fieldset',
		        title: '这个表单允许你修改应用程序的调试级别.',
		        autoHeight: true,
		        width:725,
		        layout: 'form',
				items:[logLevelcombo]
			});
			
			var form = new Ext.form.FormPanel({
				id:id,
				labelWidth: 120, // label settings here cascade unless overridden
		        url:'systemSettingManager.action?actionType='+id,
		        frame:true,
		        title: text,
		        bodyStyle:'padding:5px 5px 0',
		        autoDestroy:true,
		        autoScroll:true,
		        closable:true,
				reader:reader,
				labelAlign:'right',
				items: [loglevelFs],
		        buttons:[
		            {
		            text: '保存',
		            type:'submit',
		            handler:function(){
			        	form.form.submit({
			        		//url : 'login.action',         
			    		    method : 'POST',
			        		success:function(form,action){
			        			alert('成功');
			        		},
			        		failure:function(form,action){
			        				if(action.failureType=='connect'){
			        					alert('连接服务器失败，请稍后再试');
			        				}else if(action.failureType=='client'){
			        					alert('提交信息错误');
			        				}else{
			        					alert('错误'+action.result.msg);
			        				}
			        		}
			        	});
		        	}
		        },{
		            text: '重置',
		            type:'reset',
		            handler:function(){form.form.reset();}
		        }],
		        buttonAlign:'left'
				});
			
			
			
			var logpathField = new Ext.form.TextField({
				fieldLabel: '日志存放路径',
				name:'logParamsSetting.logpath',
				width:600,
				value:'',
				allowBlank:false
			});
			
			var log4jFileField = new Ext.form.TextField({
				fieldLabel: '日志配置文件',
				name:'logParamsSetting.configFile',
				readOnly:true,
				width:600,
				value:'',
				allowBlank:false
			});
			
			var log4jFileContentArea = new Ext.form.TextArea({
				fieldLabel: '日志配置文件内容',
				name:'logParamsSetting.configFileContent',
				width:600,
				height:200,
				value:'',
				allowBlank:false
			});
			
			form.getForm().load({url: 'systemSettingManager.action?actionType='+id+'Load'});
			
			form.add(log4jFileField);
			form.add(log4jFileContentArea);
			this.centerPanel.add(form);
			this.centerPanel.activate(form);
			
		}
		

	}
});