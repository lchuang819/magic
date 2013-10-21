// 用web方式查看系统的日志信息
//var 变量要与数据库中定义的MenuId相同
var settingPerson=Ext.extend(Ext.app.Module,{
    moduleType:'',moduleId:'settingPerson',text:'个人设置',iconCls:'icon-plugin',ft:'刘闯',
	createWindow:function(){
		//alert("Fuck shit come on babby.");
		//new Ext.Window({title:'日志管理',layout:'fit',plain:true,buttonAlign:'center',border:false,resizable:false,modal:true,width:750,height:320}).show();
		var ofbiz = new Ext.Panel({id:this.moduleId,title:this.text,iconCls:this.iconCls,closable:true});
		var form = new Ext.form.FormPanel({
			labelWidth: 75, // label settings here cascade unless overridden
	        url:'',
	        frame:true,
	        title: '个人信息管理',
	        bodyStyle:'padding:5px 5px 0',
	        //defaults: {width: 230},
	        defaultType: 'textfield',
	        x :700,
	        y :20,
	        //width:350,
			items: [{
                fieldLabel: this.ft,
                id: 'first',
                name: 'first',
                allowBlank:false
            },{
                fieldLabel: 'Last Name',
                name: 'last'
            },{
                fieldLabel: 'Company',
                name: 'company'
            }, {
                fieldLabel: 'Email',
                name: 'email'
            }, new Ext.form.TimeField({
                fieldLabel: 'Time',
                name: 'time',
                minValue: '8:00am',
                maxValue: '6:00pm'
            })
        ],
        buttons: [{
            text: 'Save',
            type:'submit',
            handler:function(){
        	form.form.submit({
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
            text: 'Cancel'
        }]
		});
		//ofbiz.add(form);
		desk.add(ofbiz);
		desk.activate(ofbiz);
}
});