Ext.app.Module=function(a){Ext.apply(this,a);Ext.app.Module.superclass.constructor.call(this);this.init();};Ext.extend(Ext.app.Module,Ext.util.Observable,{launcher:null,loaded:true,menuPath:null,moduleType:null,moduleId:null,init:Ext.emptyFn,createWindow:Ext.emptyFn,handleRequest:Ext.emptyFn});

Ext.BLANK_IMAGE_URL='/Magic/framework/resources/images/default/s.gif';

var tb = new Ext.Toolbar({
	style:'font-family: 微软雅黑;'
});
var util = {constant:{appPath:'/Magic/',debugEnable:true,errorEnable:true},MessageBox:{}};
var tabpanel = desk =  new Ext.TabPanel({
            region: 'center', // a center region is ALWAYS required for border layout
            deferredRender: false,
            activeTab: 0,     // first tab initially active
            style:'font-family: 微软雅黑;'
            //plugins: new Ext.ux.TabCloseMenu()
        });

createToolbar = function(modules){
	if(modules == null){
		return;
	}
	var usermenu;
	for(var i=0;i<modules.length;i++){
		var isroot = modules[i].isroot;
		var text = modules[i].text;
		var iconCls = modules[i].iconCls;
		//alert(iconCls);
		var html = modules[i].html;
		var jsPath = modules[i].jsPath;
		if(jsPath == null || jsPath == ''){
			jsPath = html;
		}
		var id = modules[i].id;
		
		if(isroot){
			usermenu = new Ext.menu.Menu({
				text:text,
				iconCls:iconCls
			});
			tb.add({
				text:text,
				iconCls:iconCls,
				menu:usermenu
			});
		}else{
			var menuItem = new Ext.menu.Item({
				id:id,
				text:text,
				iconCls:iconCls,
				fieldLabel:jsPath,
				style:'font-family: 微软雅黑;',
				listeners:{scope:this,click:function(item, e){
					var evaltext = item.fieldLabel;
					//alert(evaltext.indexOf('.js'));
	            	if(evaltext.indexOf('.js') == -1){
	            		this.openTab(item);
	            	}else{
	            		this.loadjs({path:item.fieldLabel,className:item.id});
	            	}
	            }}
			});
			usermenu.add(
				menuItem
			);
		}
	}
	
	tb.add('->');
	tb.add({
		text:'退出',
		iconCls:'icon-quit',
		handler:function(){
		
			var conn = new Ext.data.Connection();
			conn.request({
				url:'logout.action',
				method:'POST',
				success:function(o, opts){
					window.location = 'index.jsp';
				},
				failure:function(o){
					Ext.MessageBox.show({
						title:'错误',
						msg: 'eval script failure.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			});
		}
	});
};
/*
loadjs=function(item){
	if(item == null){
		return;
	}
	Ext.Ajax.request({
    		url:util.constant.appPath + item.fieldLabel,
    		method:'GET',scope: this,
    		success: function(o){
				//alert("成功加载:"+path);
				var resp = eval(o.responseText);
				resp.title = item.text;
				//alert(resp.id);
				checkOpen(resp.id);
				resp.iconCls = item.iconCls;
				tabpanel.add(resp).show();
				
				new util.MessageBox({title:'Load success',text:'Load ['+item.fieldLabel+'] success!'});
    		},
    		failure:function(){Ext.Msg.alert("Load["+item.fieldLabel+"] error!");}
    	});
};
*/
loadjs=function(config){
	Ext.getBody().mask("Loading...");
	if(config == null){
		return;
	}
	Ext.log(config.path);
	Ext.Ajax.request({
    		url:util.constant.appPath + config.path,
    		method:'GET',scope: this,
    		success: function(o){
    			//new util.MessageBox({title:'Load success',text:'Load ['+config.path+'] success!'});
    			//alert(config.className);	
    			//alert(o.responseText);
    			try {
    				Ext.log('util.loadjs.className: '+config.className);
    				eval(o.responseText);
    				eval('var obj = new '+config.className+'();');
    				if(obj.createWindow && obj.createWindow != 'function (){}'){
    					Ext.log('util.loadjs createWindow:' + obj.createWindow);
    					obj.createWindow.call(obj);
    				}else{
    					Ext.log('util.loadjs init...');
    					//obj.init.call(obj);
    				}
				} catch (e) {
					Ext.loge('util.loadjs.exception:'+e.message);
				}
    			Ext.getBody().unmask();
    		},
    		failure:function(o){
    			//alert("Error:"+o.responseText);
    			Ext.log(o.responseText);
    			Ext.getBody().unmask();
    		}
    	});
	//Ext.getBody().unmask();
};
openTab=function(item){
	if(item == null)return;
	//var id = item.id;
	tabpanel.add({
		id:item.id,
        title:item.text,
        closable:true,
        iconCls:item.iconCls,
        autoScroll: true,
        autoLoad:{url:util.constant.appPath+item.fieldLabel, scripts:true}
	}).show();
};

checkOpen=function(id){
	//alert(id);
	var win = tabpanel.getItem(id);
	//alert(win);
	if(win){
		tabpanel.activate(win);
	}
};
//var utilMessageBox;
util.MessageBox = function(config){
	var gross = new Ext.ProgressBar({
		hidden:false
	}).wait({
		duration:3000,interval: 100,text:'Loading...',
		fn: function(){
	     // Ext.fly('status').update('完成了Done!');
		//utilMessageBox.close();
	}
	   });
	var utilMessageBox = new Ext.Window({
		id:'utilMessageBox',
		title:config.title,
		x:200,
		y:0,
		height:70,
		width:400,
		layout : 'fit',
		plain : true,
		buttonAlign : 'center',
		//border : false,
		resizable : false,
		modal : false,
		//plain:true,
		items:[{html:config.text},gross]
	}).show();
	//alert(config.msg);
};

function AjaxEvalScript(options){
	
	Ext.log('[util.js][AjaxEvalScript]options.url:'+options.url);
	Ext.log('[util.js][AjaxEvalScript]options.baseParams:'+options.baseParams);
	
	if(options.CmpId != undefined && Ext.ComponentMgr.get(options.CmpId)){
		if('window' == options.containerType){
			options.container.show();
		}else{
			options.container.activate(options.CmpId);
			return;
		}
			
	}
	
	Ext.Ajax.request({
		url:util.constant.appPath + options.url,
		method:'GET',
		scope:this,
//		async:false,
		success: function(o){
			var rt = eval(o.responseText);
			if(rt === undefined){
				Ext.MessageBox.show({
					title:'错误',
					msg: 'eval script result is undefined.',
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.ERROR
				});
			}
			
			eval('var obj = new '+options.varName + '();');
			
			//alert('call'+options.callCfg);
			if(options.callCfg){
				obj.configComponent.call(obj,options);
			}
//			
//			if(options.record != null && options.record != undefined){
//				Ext.getCmp(options.formId).getForm().loadRecord(options.record);
//			}
			
			if(options.container == undefined){
				Ext.MessageBox.alert('提示', 'options.container is undefined');
			}
			
			if('window' == options.containerType){
				options.container.add(obj);
				options.container.show();
			}else if('panel' == options.containerType){
				options.container.add(obj);
			}else{
				options.container.add(obj);
				options.container.activate(obj);
			}
		
		},
		failure:function(o){
			Ext.MessageBox.show({
				title:'错误',
				msg: 'eval script failure.',
				buttons: Ext.Msg.OK,
				icon: Ext.MessageBox.ERROR
			});
		}
	});
	
//	return evalObj;
};

function SyncEvalScriptCmp(options){
	
	if(options.CmpId != undefined && Ext.ComponentMgr.get(options.CmpId)){
		if('window' == options.containerType){
			options.container.show();
		}else{
			options.container.activate(options.CmpId);
			return;
		}
			
	}
	
	var conn = new Ext.data.Connection();
	conn.request({
		url:util.constant.appPath + options.url,
		method:'GET',
		scope:this,
		params:options.params,
		success:function(o, opts){
			var rt = eval(o.responseText);
			if(rt === undefined){
				Ext.MessageBox.show({
					title:'错误',
					msg: 'eval script result is undefined.',
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.ERROR
				});
			}
			eval('var obj = new '+options.varName + '();');
			
			if(options.record != null && options.record != undefined){
				Ext.getCmp(options.formId).getForm().loadRecord(options.record);
			}
			
			if('window' == options.containerType){
				options.container.add(obj);
				options.container.show();
			}else{
				
				options.container.add(obj);
				options.container.activate(obj);
			}
		},
		failure:function(o){
			Ext.MessageBox.show({
				title:'错误',
				msg: 'eval script failure.',
				buttons: Ext.Msg.OK,
				icon: Ext.MessageBox.ERROR
			});
		}
	});
	
}

function DataConnectionSubmit(options){
	var conn = new Ext.data.Connection();
	conn.request({
		url:util.constant.appPath + options.url,
		method:'POST',
		scope:this,
		params:options.params,
		success:function(response, opts){
			var res = Ext.util.JSON.decode(response.responseText);
			if(res.success == true){
				if(options.record != undefined && options.store != undefined){
						options.store.remove(options.record);
						Ext.MessageBox.show({
							title:'成功',
							msg: '数据删除成功',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});
				}else{
					Ext.MessageBox.show({
						title:'错误',
						msg: 'record is '+options.record +' \n' + 'store is ' + options.store,
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
				
			}else{
				Ext.MessageBox.show({
					title:'错误',
					msg: '数据删除失败',
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.ERROR
				});
			}
		},
		failure:function(){
			Ext.MessageBox.show({
				title:'错误',
				msg: '操作请求失败',
				buttons: Ext.Msg.OK,
				icon: Ext.MessageBox.ERROR
			});
		}
	});
};


//JavaGridFilters = Ext.extend(Ext.ux.grid.GridFilters, {
//	menuFilterText:'过滤器',
//	buildQuery:function(filters){
//		var p = {};  
//		var s = [];//临时保存所选的所有filter  
//		for(var i=0, len=filters.length; i<len; i++){  
//		    var f = filters[i]; // f = {dataIndex, data, ....};  
//		    //alert(JSON.stringify(f));  
//		    if(f.data['comparison']!=null) {  
//		        if(!p[f.field]) {  
//		            p[ f.field ] = '';  
//		        }  
//		        p[f.field] += f.data['comparison'] + '@' + f.data['value'] +',';  
//		    }else {  
//		        p[f.field] = f.data['value'];  
//		    }  
//		    s.push(f.field);  
//		}  
//		p["gridFilterList"] = s.join(",");  
//		return p;
//
//	},
//	cleanParams : function (p) {  
//		var s = p["gridFilterList"] || "" ;  
//		var k = s.split(",");  
//		for(var i=0, len=k.length; i<len; i++){  
//			var f = k[i];  
//			delete p[f];  
//		}  
//	}
//
//});
