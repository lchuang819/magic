var systemLog = Ext.extend(Ext.app.Module, {
	moduleType : '',
	moduleId : 'systemLog',
	text : '系统日志',
	iconCls : 'icon-plugin',
	createWindow : function() {
		var logPanel = new Ext.Panel({
			id:this.moduleId,
			title:this.text,
			closable:true,
			autoScroll:true,
			iconCls : 'icon-plugin',
			bodyStyle : 'padding:5px 10px 0',
			autoLoad:{url:util.constant.appPath+'logs/magic.html',scripts:true},
			tbar: [{
	            text: '停止刷新',
	            handler : function(){
	                // access the Record constructor through the grid's store
	        		Ext.TaskMgr.stop(task); 
	            }
	        },{
	            text: '开始刷新',
	            handler : function(){
	                // access the Record constructor through the grid's store
	        		Ext.TaskMgr.start(task); 
	            }
	        }]
		});
		
		logPanel.on('close', function() {

	    	Ext.TaskMgr.stop(task);
			
	    });
		
		var task = {     
				run : function() {
					logPanel.getUpdater().update({
					     url: util.constant.appPath+'logs/magic.html'
					 });

	    			//store.reload();
	    		},       
	    		interval : 4000, // 2秒刷新一次
	    		scope : this
	    }; 
		
		//ofbiz.add(form);
		desk.add(logPanel);
		desk.activate(logPanel);
	}
});