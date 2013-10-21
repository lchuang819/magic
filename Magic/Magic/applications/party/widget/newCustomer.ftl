<script type="text/javascript">
	var newcustomerPanel = new Ext.form.FormPanel({
        labelWidth: 75,
        title: '编辑组信息',
        bodyStyle:'padding:5px 5px 0px',
        defaults: {width: 230},
        width:500,
        autoDestroy:true,
        defaultType: 'textfield',
		buttonAlign:'left',
        items: [{
                fieldLabel: '组标识',
                name: 'partyGroup.partyId',
                allowBlank:false
            },{
                fieldLabel: '组名称',
                name: 'partyGroup.groupName',
                allowBlank:false
            },{
                fieldLabel: '本地语言',
                name: 'partyGroup.groupNameLocal'
            },{
                fieldLabel: '备注',
                name: 'partyGroup.comments'
        }],
        buttons:[{
	            text: '保存',
	            type:'submit',
	            handler:function(){
		        	newcustomerPanel.form.submit({
		        		url:'partyGroupManager.action?actionType=CreatePartyGroup',
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
		            handler:function(){newcustomerPanel.form.reset();}
		        }]
    });
    
		newcustomerPanel.render('newcustomer');
    
</script>
<div id="newcustomer">
</div>

