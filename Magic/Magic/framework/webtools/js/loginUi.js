Ext.onReady(function() {

	var form = new Ext.form.FormPanel( {
		labelWidth : 85, // label settings here cascade unless overridden
		frame : true,
		title:'登陆',
		bodyStyle : 'padding:5px 5px 0',
		width : 350,
		defaults : {
			width : 240
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '用户名',
			name : 'user.userLoginId',
			id : 'username',
			allowBlank:false,
			emptyText:'请输入用户名',   
            blankText:'用户名不能为空',
            value:'admin'
		}, {
			fieldLabel : '密码',
			name : 'user.currentPassword',
			id : 'password',
			inputType : 'password',
			allowBlank:false,
	        blankText:'密码不能为空',
	        value:'admin'
		},{
            xtype:          'combo',
            mode:           'local',
            value:          'jxcManager',
            triggerAction:  'all',
            forceSelection: true,
            editable:       false,
            fieldLabel:     '产品',
            name:           'productType',
            hiddenName:     'productTypeId',
            displayField:   'name',
            valueField:     'value',
            allowBlank:false,
	        blankText:'请选择产品',
            store:          new Ext.data.JsonStore({
                fields : ['name', 'value'],
                data   : [
                    {name : '进销存管理',   value: 'jxcManager'},
                    {name : 'xBugZilla',   value: 'xBugZilla'},
                    {name : '企业ERP',  value: 'corpERP'}
                ]
            })
		}],
		buttons:[{text:"确定", type: 'submit',handler : submitClick},{text:"取消",handler:function(){window.close();}},{text:"重置",handler:function(){form.form.reset();}}], 
		buttonAlign:'center' 
		
	});
	form.render('login');

	//w.show();

	function submitClick(item) {
		if(form.form.isValid()){
		form.form.doAction('submit', {
			waitMsg : "正在登陆......",
			url : 'login.action',         
		    method : 'POST',
			success:function(f, action) {
			 	window.location=util.constant.appPath+'workpad.ftl';
			},
			failure:function(f, action) {
				Ext.MessageBox.alert("登陆失败",action.result.msg);
			}

		});
		}
	};
});