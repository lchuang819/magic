var systemLog = Ext.extend(Ext.app.Module, {
	moduleType : '',
	moduleId : 'systemLog',
	id:'systemLog',
	text : '系统日志',
	iconCls : 'icon-plugin',
	createWindow : function() {
		var logPanel = new Ext.Panel({
			id:'logPanel',
			title:this.text,
			closable:true,
			autoScroll:true,
			iconCls : 'icon-plugin',
			bodyStyle : 'padding:5px 10px 0',
			autoLoad:{url:util.constant.appPath+'logs/magic.html',scripts:true},
			tbar: [{
	            text: '刷新',
	            iconCls:'icon-refresh-yellow',
	            handler : function(){
	                // access the Record constructor through the grid's store
	        		//Ext.TaskMgr.stop(task);
	            	
	            	var updater = logPanel.getUpdater();
					updater.update({
						url: util.constant.appPath+'logs/magic.html'
					});
	            }
	        },{
	            text: '到最后',
	            iconCls:'icon-select-next',
	            handler : function(){
	                // access the Record constructor through the grid's store
	        		//Ext.TaskMgr.start(task);
//	            	var updater = logPanel.getUpdater();
//					updater.update({
//						url: util.constant.appPath+'logs/magic.html'
//					});
					
					var d = logPanel.body.dom;
		    		d.scrollTop = d.scrollHeight;
		    		Ext.log('logPanel afterrender...' + d.scrollHeight);
	            }
	        }]
		});
		
		logPanel.on('close', function() {
	    	Ext.TaskMgr.stop(task);
	    });
		
		logPanel.on('afterlayout', function() {
			var d = logPanel.body.dom;
    		d.scrollTop = d.scrollHeight;
    		//Ext.log('logPanel afterrender...');
	    });
		
		
		
		//var d = logPanel.body.dom;
		//d.scrollTop = d.scrollHeight;

		var task = {     
				run : function() {
					var updater = logPanel.getUpdater();
					updater.update({
						url: util.constant.appPath+'logs/magic.html'
					});
					
//					Ext.Ajax.request({
//			    		url:util.constant.appPath+'logs/magic.html',
//			    		method:'GET',scope: this,
//			    		success: function(o){
//			    			Ext.log(o.responseText);
//			    			Ext.log('------');
//			    		},
//			    		failure:function(o){
//			    			
//			    		}
//			    	});
	    		},       
	    		interval : 4000,
	    		scope : this
	    };

		
		//ofbiz.add(form);
		desk.add(logPanel);
		desk.activate(logPanel);
	},
	scrollBottom  : function(){
		var panel = Ext.getCmp('logPanel');
		var d = panel.body.dom;
		Ext.log(d.scrollHeight);
		d.scrollTop = d.scrollHeight;
	}
	
});