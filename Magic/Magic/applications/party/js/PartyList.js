var PartyList = Ext.extend(Ext.app.Module,{
	init:function(){
		util.constant.debugEnable = true;
		util.constant.errorEnable = true;
		Ext.log('Open Console!');
	}
});