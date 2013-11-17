PartyUpdateForm = Ext.extend(Ext.form.FormPanel, {
	id : 'PartyUpdateForm',
	title : '编辑',
	labelWidth : 100,
	labelAlign : "right",
	layout : "form",
	padding : "10px",
	frame : true,
	closable : true,
	autoScroll : true,
	buttonAlign : "center",

	roleType : '',

	constructor : function(config) {
		
		PartyUpdateForm.superclass.constructor.call(this);
	},
	configComponent : function(options) {


	}
});