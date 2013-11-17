Ext.namespace("Ext.magic");

Ext.onReady(function() {

	/**
	 * Party Component
	 */
	var globalPartyId = '';
	// ======== 在新建成员 客户 成员管理中使用的PartyForm ==========/
	PartyForm = Ext.extend(Ext.form.FormPanel, {
		id : 'PartyForm',
		iconCls : 'icon-plugin',
		labelWidth : 75,
		title : '',
		bodyStyle : 'padding:5px 5px 0px',
		// width:500,
		autoDestroy : true,
		frame : true,
		closable : true,
		buttonAlign : 'left',
		labelAlign : 'right',
		autoScroll : true,
		initComponent : function() {
			PartyForm.superclass.initComponent.call(this);
		},
		constructor : function(config) {
			this.id = config.id;
			this.title = config.title;
			this.buttons = config.buttons;

			var partyId = '';

			// 当修改Party数据时初始化字段值
			var partyRecord = new Ext.data.Record();
			if (config.enableData) {
				partyRecord = config.record;
				partyId = partyRecord.get('partyId');
				globalPartyId = partyId;
			}

			var beanName = 'person';
			var beanFirstName = 'person.firstName';
			if ('PARTY_GROUP' == partyRecord.get('partyTypeId')) {
				beanName = 'partyGroup';
				beanFirstName = 'partyGroup.groupName';
			}

			var partyIdLabel2 = new Ext.form.TextField({
				fieldLabel : '标识',
				id : 'partyId',
				width : 100,
				regex : /^[a-zA-Z0-9]+$/,
				regexText : '仅能输入大小写字母与数字'
			});

			var partyIdLabel = new Ext.form.Label({
				fieldLabel : '标识',
				id : 'partyId',
				name : 'partyId',
				width : 150,
				html : '<b>' + partyId + '</b>'
			});

			var personTitleTf = new Ext.form.TextField({
				fieldLabel : '称谓',
				name : 'person.personalTitle',
				width : 160,
				value : partyRecord.get('personalTitle')
			});

			var firstNameTf = new Ext.form.TextField({
				fieldLabel : '名字',
				name : 'person.firstName',
				width : 160,
				value : partyRecord.get('firstName'),
				allowBlank : false
			});

			var lastNameTf = new Ext.form.TextField({
				fieldLabel : '姓氏',
				name : 'person.lastName',
				width : 160,
				value : partyRecord.get('lastName'),
				allowBlank : false
			});

			var firstNameLocalTf = new Ext.form.TextField({
				fieldLabel : '名字拼音',
				name : 'person.firstNameLocal',
				width : 160,
				value : partyRecord.get('firstName'),
				allowBlank : false
			});

			var lastNameLocalTf = new Ext.form.TextField({
				fieldLabel : '姓氏拼音',
				name : 'person.lastNameLocal',
				width : 160,
				value : partyRecord.get('lastNameLocal'),
				allowBlank : false
			});
			
			var partyRole = new Ext.form.Hidden({
				hidden : false,
				name : 'partyRoleId.roleTypeId',
				value : config.partyRole,
			});

			// var roleTypeStore = new Ext.data.JsonStore({
			// //autoLoad:true,
			// url: 'loadParams.action?actionType=roleType',
			// root:'dataset',
			// fields: [
			// 'description',
			// 'roleTypeId'
			// ]
			// // ,
			// //data:[['root','all'],['root2','info'],['root3','error']]
			// });
			//	    	
			// roleTypeStore.load();
			//	    	
			// var partyTypeCbx = new Ext.form.ComboBox({
			// name:'partyType.roleTypeId',
			// hiddenName:'partyType.roleTypeId',
			// fieldLabel:'角色',
			// store:roleTypeStore,
			// displayField:'description',
			// valueField:'roleTypeId',
			// //mode:'local',
			// //typeAhead: true,
			// editable:true,
			// triggerAction: 'all',
			// emptyText:'选择一个角色',
			// selectOnFocus:true
			// });

			var productBasicFs = new Ext.form.FieldSet({
				id : 'personBaseInfoFs',
				xtype : 'fieldset',
				title : '基本信息',
				autoHeight : true,
				// labelWidth:120,
				width : 1100,
				// baseCls:'x-plain',
				hideLabel : false,
				layout : 'table',
				layoutConfig : {
					columns : 4
				},
				labelAlign : 'left',
				items : []
			});

			var genderCbx = new Ext.form.ComboBox({
				width : 40,
				mode : 'local',
				value : '',
				triggerAction : 'all',
				editable : false,
				fieldLabel : '性别',
				name : 'gender',
				hiddenName : 'person.gender',
				displayField : 'name',
				valueField : 'value',
				store : new Ext.data.JsonStore({
					fields : [ 'name', 'value' ],
					data : [ {
						name : '男',
						value : 'M'
					}, {
						name : '女',
						value : 'W'
					} ]
				})
			});

			var gender = {
				layout : 'form',
				items : [ genderCbx ]
			};

			var socialSecurityNumberTf = new Ext.form.TextField({
				fieldLabel : '身份证',
				name : 'person.socialSecurityNumber',
				width : 160,
				value : ''
			});

			var socialSecurityNumber = {
				layout : 'form',
				items : [ socialSecurityNumberTf ]
			};

			if (config.gender) {
				productBasicFs.add(gender);
			}

			if (config.socialSecurityNumber) {
				productBasicFs.add(socialSecurityNumber);
			}

			if (config.partyType == 'PERSON') {

				var detailFieldGroup = {
					layout : 'form',
					items : [ partyIdLabel, personTitleTf, genderCbx, socialSecurityNumberTf ]
				};
				
				productBasicFs.add(detailFieldGroup);

				var nameFieldGroup = {
					layout : 'form',
					items : [ lastNameTf, firstNameTf, lastNameLocalTf, firstNameLocalTf ]
				};
				productBasicFs.add(nameFieldGroup);
			}
			
			if(config.partyRole == 'EMPLOYEE'){
				productBasicFs.add(partyRole);
			}

			//productBasicFs.add(comments);

			var postAddr1Tf = new Ext.form.TextField({
				fieldLabel : '地址1',
				name : 'postalAddress.address1',
				width : 400,
				value : ''
			});

			var postAddr2Tf = new Ext.form.TextField({
				fieldLabel : '地址2',
				name : 'postalAddress.address2',
				width : 400,
				value : ''
			});

			var postalCodeTf = new Ext.form.TextField({
				fieldLabel : '邮编',
				name : 'postalAddress.postalCode',
				width : 160,
				value : ''
			});

			var countryGeoIdTf = new Ext.form.TextField({
				fieldLabel : '国家',
				name : 'postalAddress.countryGeoId',
				width : 160,
				value : '中国'
			});

			var stateProvinceGeoIdTf = new Ext.form.TextField({
				fieldLabel : '省/州',
				name : 'postalAddress.stateProvinceGeoId',
				width : 160,
				value : ''
			});

			var cityTf = new Ext.form.TextField({
				fieldLabel : '城市',
				name : 'postalAddress.city',
				width : 160,
				value : ''
			});

			var postalAddressFs = new Ext.form.FieldSet({
				id : 'postalAddressFs',
				xtype : 'fieldset',
				title : '邮寄/货运地址',
				autoHeight : true,
				// labelWidth:120,
				width : 1100,
				// baseCls:'x-plain',
				hideLabel : false,
				layout : 'table',
				layoutConfig : {
					columns : 4
				},
				labelAlign : 'left',
				items : [ {// 第一行
					layout : 'form',
					colspan : 2,
					items : [ postAddr1Tf ]
				}, {
					layout : 'form',
					colspan : 2,
					items : [ postAddr2Tf ]
				}, {// 第二行
					layout : 'form',
					items : [ postalCodeTf ]
				}, {
					layout : 'form',
					items : [ countryGeoIdTf ]
				}, {
					layout : 'form',
					items : [ stateProvinceGeoIdTf ]
				}, {
					layout : 'form',
					items : [ cityTf ]
				} ]
			});

			// 联系方式

			var telcountryCode = new Ext.form.TextField({
				fieldLabel : '国家代码',
				name : 'telecomNumber.countryCode',
				width : 40,
				value : '+86'
			});

			var telareaCode = new Ext.form.TextField({
				fieldLabel : '地区代码',
				name : 'telecomNumber.areaCode',
				width : 40,
				value : ''
			});

			var telcontactCode = new Ext.form.TextField({
				fieldLabel : '电话号码',
				name : 'telecomNumber.contactNumber',
				width : 160,
				value : ''
			});

			var telaskForName = new Ext.form.TextField({
				fieldLabel : '转',
				name : 'telecomNumber.askForName',
				width : 40,
				value : ''
			});

			// var mobcontactCode = new Ext.form.TextField({
			// fieldLabel: '手机号码',
			// name:'telecomNumber.contactCode',
			// width:160,
			// value:''
			// });

			var emailTf = new Ext.form.TextField({
				fieldLabel : '电子邮件',
				name : 'contactMech.infoString',
				width : 200,
				value : ''
			});

			var contactMechTypeIdTf = new Ext.form.TextField({
				name : 'contactMech.contactMechTypeId',
				width : 200,
				hidden : true,
				value : 'EMAIL_ADDRESS'
			});

			var contactMethodFs = new Ext.form.FieldSet({
				id : 'contactMethodFs',
				xtype : 'fieldset',
				title : '联系方式',
				autoHeight : true,
				// labelWidth:120,
				width : 1100,
				// baseCls:'x-plain',
				hideLabel : false,
				layout : 'table',
				layoutConfig : {
					columns : 4
				},
				labelAlign : 'left',
				items : [ {// 第一行
					layout : 'form',
					items : [ telcountryCode ]
				}, {
					layout : 'form',
					items : [ telareaCode ]
				}, {
					layout : 'form',
					items : [ telcontactCode ]
				}, {
					layout : 'form',
					items : [ telaskForName ]
				}, {// 第二行
					layout : 'form',
					items : [ emailTf ]
				}, {
					layout : 'form',
					items : [ contactMechTypeIdTf ]
				} ]
			});
			
			var postCommentsTf = new Ext.form.TextArea({
				fieldLabel : '备注',
				name : 'person.comments',
				width : 300,
				value : partyRecord.get('comments')
			});

			var commentsFS = new Ext.form.FieldSet({
				id : 'contactMethodFs',
				xtype : 'fieldset',
				title : '备注',
				autoHeight : true,
				width : 1100,
				hideLabel : false,
				layout : 'table',
				layoutConfig : {
					columns : 4
				},
				labelAlign : 'left',
				items : [ {// 第一行
					layout : 'form',
					items : [ postCommentsTf ]
				} ]
			});


			var contactPostTeleGridFs;
			var postalAddressGridFs;

			if (config.loadParty) {

				createPostalAddressGrid();
				createTelecomNumberGrid();
				createContactGrid();

				contactPostTeleGridFs = new Ext.form.FieldSet({
					id : 'contactPostTeleGridFs',
					xtype : 'fieldset',
					title : '联系内容/联系电话',
					autoHeight : true,
					// labelWidth:120,
					width : 1100,
					// baseCls:'x-plain',
					hideLabel : false,
					layout : 'table',
					layoutConfig : {
						columns : 5
					},
					labelAlign : 'left',
					items : [ {// 第一行
						layout : 'form',
						colspan : 2,
						items : [ contactGrid ]
					}, {
						xtype : 'panel',
						width : 20
					}, {
						layout : 'form',
						colspan : 2,
						items : [ telecomNumberGrid ]
					}, {
						layout : 'form',
						colspan : 5,
						items : [ postalAddressGrid ]
					} ]
				});

				postalAddressGridFs = new Ext.form.FieldSet({
					id : 'postalAddressGridFs',
					xtype : 'fieldset',
					title : '邮政/联系地址',
					autoHeight : true,
					// labelWidth:120,
					width : 1100,
					// baseCls:'x-plain',
					hideLabel : false,
					layout : 'table',
					layoutConfig : {
						columns : 5
					},
					labelAlign : 'left',
					items : [ {
						layout : 'form',
						colspan : 5,
						items : [ postalAddressGrid ]
					} ]
				});
				// postalAddressFs = postalAddressGridFs;
			}
			
			var items;
			if (config.loadParty) {
				items = [ productBasicFs, contactPostTeleGridFs, postalAddressGrid ];
			} else {
				items = [ productBasicFs, postalAddressFs, contactMethodFs, commentsFS ];
			}

			PartyForm.superclass.constructor.call(this, {
				items : items
			});
		}
	});
	// end partyForm

	/**
	 * 加载邮政地址列表
	 */
	var postalAddressGrid;

	function createPostalAddressGrid() {
		var store = new Ext.data.JsonStore({
			root : 'dataset',
			totalProperty : 'totalCount',
			idProperty : 'partyId',
			remoteSort : true,
			url : 'partyLoader.action',
			baseParams : {
				actionType : 'LoadPostalAddress',
				partyId : globalPartyId
			},
			fields : [ 'contactMechId', 'toName', 'attnName', 'address1', 'address2', 'city', 'postalCode', 'countryGeoId', 'stateProvinceGeoId', 'countyGeoId'
			// 会员标识 用户登录 名字 类型
			]

		// load using script tags for cross domain, if the data in on the same
		// domain as
		// this page, an HttpProxy would be better
		// proxy: new Ext.data.ScriptTagProxy({
		// url: 'dataQuery.action'
		// })
		});

		store.load({
			params : {
				start : 0,
				limit : 10
			}
		});

		postalAddressGrid = new Ext.grid.GridPanel({
			id : 'postalAddressGrid',
			width : 1100,
			height : 180,
			// title:'邮政地址列表',
			store : store,
			trackMouseOver : false,
			disableSelection : false,
			autoDestroy : true,
			loadMask : true,
			closable : true,
			autoScroll : true,
			// grid columns
			columns : [ {
				id : 'topic', // id assigned so we can apply custom css (e.g.
				// .x-grid-col-topic b { color:#333 })
				header : "标识",
				dataIndex : 'contactMechId',
				width : 40,
				sortable : true
			}, {
				header : "名称",
				dataIndex : 'toName',
				// width: 100,
				hidden : false,
				sortable : true
			}, {
				header : "地址1",
				dataIndex : 'address1',
				// width: 70,
				align : 'right',
				sortable : true
			}, {
				header : "地址2",
				dataIndex : 'address2',
				// width: 70,
				align : 'right',
				sortable : true
			}, {
				header : "收件人",
				dataIndex : 'attnName',
				// width: 70,
				align : 'right',
				sortable : true
			}, {
				header : "省/州",
				dataIndex : 'stateProvinceGeoId',
				width : 35,
				align : 'right',
				sortable : true
			}, {
				header : "城市",
				dataIndex : 'city',
				width : 35,
				align : 'right',
				sortable : true
			}, {
				header : "市区",
				dataIndex : 'countyGeoId',
				width : 35,
				align : 'right',
				sortable : true
			}, {
				header : "国家",
				dataIndex : 'countryGeoId',
				width : 30,
				align : 'right',
				sortable : true
			} ],
			tbar : [ {
				xtype : 'label',
				text : '邮政地址列表',
				disable : true
			}, '->', {
				text : '创建新的',
				iconCls : 'icon-add',
				handler : function() {
					var pff = new Ext.UpdatePostalAddressForm({});
					var win = new Ext.CommonWindow({
						title : '创建',
						itemForm : pff,
						store : store,
						url : 'partyManager.action?actionType=CreatePostalAddress'
					});

					// win.add(pff);
					win.show();
				}
			} ],
			viewConfig : {
				forceFit : true,
				enableRowBody : true,
				showPreview : false,
				getRowClass : function(record, rowIndex, p, store) {
					if (this.showPreview) {
						p.body = '<p>' + record.data.excerpt + '</p>';
						return 'x-grid3-row-expanded';
					}
					return 'x-grid3-row-collapsed';
				}
			},
			listeners : {
				scope : this,
				rowdblclick : function(cgrid, index, e) {
					var cRecord = cgrid.store.getAt(index);
					var pff = new Ext.UpdatePostalAddressForm({
						updateData : true,
						record : cRecord
					});
					var win = new Ext.CommonWindow({
						title : '更新',
						itemForm : pff,
						store : store,
						url : 'partyManager.action?actionType=UpdatePostalAddress'
					});

					// win.add(pff);
					win.show();
				}
			},
			bbar : new Ext.PagingToolbar({
				pageSize : 10,
				store : store,
				displayInfo : true,
				displayMsg : '双击编辑数据 Displaying topics{0} - {1} of {2}',
				emptyMsg : "No topics to display"
			// items:[ '-', {pressed: true, enableToggle:true, text: 'Show
			// Preview',
			// cls:'x-btn-text-icon details', toggleHandler: function(btn,
			// pressed){
			// var view = grid.getView();
			// view.showPreview = pressed;
			// view.refresh();
			// }
			// }]
			})

		});// END GRID
	}

	/**
	 * 加载联系电话列表
	 */
	var telecomNumberGrid;

	function createTelecomNumberGrid() {
		var store = new Ext.data.JsonStore({
			root : 'dataset',
			totalProperty : 'totalCount',
			idProperty : 'partyId',
			remoteSort : true,
			url : 'partyLoader.action',
			baseParams : {
				actionType : 'LoadTelecomNumberByParty',
				partyId : globalPartyId
			},
			fields : [ 'contactMechId', 'countryCode', 'areaCode', 'contactNumber', 'askForName'
			// 会员标识 用户登录 名字 类型
			]

		// load using script tags for cross domain, if the data in on the same
		// domain as
		// this page, an HttpProxy would be better
		// proxy: new Ext.data.ScriptTagProxy({
		// url: 'dataQuery.action'
		// })
		});

		store.load({
			params : {
				start : 0,
				limit : 10
			}
		});

		telecomNumberGrid = new Ext.grid.GridPanel({
			id : 'telecomNumberGrid',
			width : 520,
			height : 170,
			// title:'联系电话列表',
			store : store,
			trackMouseOver : false,
			disableSelection : false,
			autoDestroy : true,
			loadMask : true,
			closable : true,
			autoScroll : true,
			// grid columns
			columns : [ {
				id : 'topic', // id assigned so we can apply custom css (e.g.
				// .x-grid-col-topic b { color:#333 })
				header : "标识",
				dataIndex : 'contactMechId',
				width : 40,
				sortable : true
			}, {
				header : "国家",
				dataIndex : 'countryCode',
				width : 100,
				hidden : false,
				sortable : true
			}, {
				header : "地区",
				dataIndex : 'areaCode',
				width : 70,
				align : 'right',
				sortable : true
			}, {
				header : "电话号码",
				dataIndex : 'contactNumber',
				width : 70,
				align : 'right',
				sortable : true
			}, {
				header : "转接",
				dataIndex : 'askForName',
				width : 70,
				align : 'right',
				sortable : true
			} ],
			tbar : [ {
				xtype : 'label',
				text : '联系电话列表',
				disable : true
			}, '->', {
				text : '创建新的',
				iconCls : 'icon-add',
				handler : function() {
					var telecomForm = new Ext.UpdateTelecomForm({
						updateData : false
					});
					var win = new Ext.CommonWindow({
						title : '创建',
						itemForm : telecomForm,
						store : store,
						url : 'partyManager.action?actionType=CreateTelecomNumber'
					});

					// win.add(pff);
					win.show();
				}
			} ],
			viewConfig : {
				forceFit : true,
				enableRowBody : true,
				showPreview : false,
				getRowClass : function(record, rowIndex, p, store) {
					if (this.showPreview) {
						p.body = '<p>' + record.data.excerpt + '</p>';
						return 'x-grid3-row-expanded';
					}
					return 'x-grid3-row-collapsed';
				}
			},
			listeners : {
				scope : this,
				rowdblclick : function(cgrid, index, e) {

					var cRecord = cgrid.store.getAt(index);
					var telecomForm = new Ext.UpdateTelecomForm({
						updateData : true,
						record : cRecord
					});
					var win = new Ext.CommonWindow({
						title : '创建',
						itemForm : telecomForm,
						store : store,
						url : 'partyManager.action?actionType=UpdateTelecomNumber'
					});

					// win.add(pff);
					win.show();
				}
			},
			bbar : new Ext.PagingToolbar({
				pageSize : 10,
				store : store,
				displayInfo : true,
				displayMsg : '双击编辑数据 Displaying topics{0} - {1} of {2}',
				emptyMsg : "No topics to display"
			// items:[ '-', {pressed: true, enableToggle:true, text: 'Show
			// Preview',
			// cls:'x-btn-text-icon details', toggleHandler: function(btn,
			// pressed){
			// var view = grid.getView();
			// view.showPreview = pressed;
			// view.refresh();
			// }
			// }]
			})

		});// END GRID
	}// END FUNCTION

	/**
	 * 联系内容表格
	 */
	var contactGrid;

	function createContactGrid() {
		var store = new Ext.data.JsonStore({
			root : 'dataset',
			totalProperty : 'totalCount',
			idProperty : 'contactMechId',
			baseParams : {
				actionType : 'LoadContactMechByParty',
				partyId : globalPartyId
			},
			remoteSort : true,
			url : 'partyLoader.action',

			fields : [ 'contactMechId', 'contactMechTypeId', 'infoString', 'contactMechTypeDesc'
			// 会员标识 用户登录 名字 类型
			]

		// load using script tags for cross domain, if the data in on the same
		// domain as
		// this page, an HttpProxy would be better
		// proxy: new Ext.data.ScriptTagProxy({
		// url: 'dataQuery.action'
		// })
		});

		store.load({
			params : {
				start : 0,
				limit : 10
			}
		});

		contactGrid = new Ext.grid.GridPanel({
			id : 'contactGrid',
			width : 520,
			height : 170,
			// title:'联系电话列表',
			store : store,
			trackMouseOver : false,
			disableSelection : false,
			autoDestroy : true,
			loadMask : true,
			closable : true,
			autoScroll : true,
			// grid columns
			columns : [ {
				id : 'topic', // id assigned so we can apply custom css (e.g.
				// .x-grid-col-topic b { color:#333 })
				header : "标识",
				dataIndex : 'contactMechId',
				width : 40,
				sortable : true
			}, {
				header : "信息类型",
				dataIndex : 'contactMechTypeDesc',
				width : 100,
				hidden : false,
				sortable : true
			}, {
				header : "信息类型标识",
				dataIndex : 'contactMechTypeId',
				width : 100,
				hidden : false,
				sortable : true
			}, {
				header : "信息内容",
				dataIndex : 'infoString',
				width : 100,
				hidden : false,
				sortable : true
			} ],
			tbar : [ {
				xtype : 'label',
				text : '联系内容列表',
				disable : true
			}, '->', {
				text : '创建新的',
				iconCls : 'icon-add',
				handler : function() {

					var contactForm = new Ext.UpdateContactForm({
						updateData : false
					});
					var win = new Ext.CommonWindow({
						title : '创建',
						itemForm : contactForm,
						store : store,
						url : 'partyManager.action?actionType=CreateContactMech'
					});

					// win.add(pff);
					win.show();
				}
			} ],
			viewConfig : {
				forceFit : true,
				enableRowBody : true,
				showPreview : false,
				getRowClass : function(record, rowIndex, p, store) {
					if (this.showPreview) {
						p.body = '<p>' + record.data.excerpt + '</p>';
						return 'x-grid3-row-expanded';
					}
					return 'x-grid3-row-collapsed';
				}
			},
			listeners : {
				scope : this,
				rowdblclick : function(cgrid, index, e) {

					var cRecord = cgrid.store.getAt(index);
					var contactForm = new Ext.UpdateContactForm({
						updateData : true,
						record : cRecord
					});
					var win = new Ext.CommonWindow({
						title : '更新',
						itemForm : contactForm,
						store : store,
						url : 'partyManager.action?actionType=UpdateContactMech'
					});

					// win.add(pff);
					win.show();
				}
			},
			bbar : new Ext.PagingToolbar({
				pageSize : 10,
				store : store,
				displayInfo : true,
				displayMsg : '双击编辑数据 Displaying topics{0} - {1} of {2}',
				emptyMsg : "No topics to display"
			})

		});// END GRID
	}

	/**
	 * 更新地址表单
	 */
	Ext.UpdatePostalAddressForm = Ext.extend(Ext.magic.MagicForm, {
		xtype : "form",
		title : "联系地址",
		labelWidth : 100,
		labelAlign : "right",
		layout : "form",
		width : 400,
		// height:314,
		padding : "10px",
		frame : true,
		buttonAlign : "left",
		initComponent : function() {
			Ext.UpdatePostalAddressForm.superclass.initComponent.call(this);
		},
		constructor : function(config) {
			var record = new Ext.data.Record();
			if (config.updateData) {
				record = config.record;
			}

			var provinceCbx = new Ext.magic.GeoComboBox({
				fieldLabel : '省/州',
				name : 'postalAddress.stateProvinceGeoId',
				hiddenName : 'postalAddress.stateProvinceGeoId',
				hiddenValue : record.get('stateProvinceGeoId'),
				useBaseParams : true,
				baseParams : {
					actionType : 'LoadGeo',
					geoSecCode : 'CHN',
					geoTypeId : 'STATE'
				}
			});
			provinceCbx.setValue(record.get('stateProvinceGeoId'));
			provinceCbx.store.load();

			var cityCbx = new Ext.magic.GeoComboBox({
				fieldLabel : '城市',
				name : 'postalAddress.city',
				hiddenName : 'postalAddress.city'
			});

			cityCbx.setValue(record.get('city'));

			var urbanCbx = new Ext.magic.GeoComboBox({
				fieldLabel : '市区',
				name : 'postalAddress.countyGeoId',
				hiddenName : 'postalAddress.countyGeoId'
			});

			urbanCbx.setValue(record.get('countyGeoId'));

			provinceCbx.on('select', function() {
				var province = provinceCbx.getValue();
				cityCbx.setValue('');
				cityCbx.store.load({
					params : {
						geoSecCode : province,
						geoTypeId : 'CITY'
					}
				});
			});
			cityCbx.on('select', function() {
				var city = cityCbx.getValue();
				urbanCbx.setValue('');
				urbanCbx.store.load({
					params : {
						geoSecCode : city,
						geoTypeId : 'COUNTY_CITY'
					}
				});
			});

			var items = [ {
				xtype : "textfield",
				fieldLabel : "名称",
				name : 'postalAddress.toName',
				value : record.get('toName'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				fieldLabel : "收件人",
				name : 'postalAddress.attnName',
				value : record.get('attnName'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				fieldLabel : "地址1",
				name : 'postalAddress.address1',
				value : record.get('address1'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				fieldLabel : "地址2",
				name : 'postalAddress.address2',
				value : record.get('address2'),
				anchor : "100%"
			}, provinceCbx, cityCbx, urbanCbx, {
				xtype : "textfield",
				fieldLabel : "邮政编码",
				name : 'postalAddress.postalCode',
				value : record.get('postalCode'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				fieldLabel : "国家",
				name : 'postalAddress.countryGeoId',
				value : record.get('countryGeoId'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				hidden : true,
				name : 'party.partyId',
				value : globalPartyId,
				anchor : "100%"
			}, {
				xtype : "textfield",
				hidden : false,
				name : 'postalAddress.contactMechId',
				value : record.get('contactMechId'),
				anchor : "100%"
			} ];

			Ext.UpdatePostalAddressForm.superclass.constructor.call(this, {
				items : items
			});
		}
	});

	/**
	 * 更新联系电话表单
	 */
	Ext.UpdateTelecomForm = Ext.extend(Ext.magic.MagicForm, {
		xtype : "form",
		title : "联系电话",
		labelWidth : 100,
		labelAlign : "right",
		layout : "form",
		width : 400,
		// height:314,
		padding : "10px",
		frame : true,
		buttonAlign : "left",
		initComponent : function() {
			Ext.UpdateTelecomForm.superclass.initComponent.call(this);
		},
		constructor : function(config) {
			var record = new Ext.data.Record();
			if (config.updateData) {
				record = config.record;
			}

			var items = [ {
				xtype : "textfield",
				fieldLabel : "国家代码",
				name : 'telecomNumber.countryCode',
				value : record.get('countryCode'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				fieldLabel : "地区代码",
				name : 'telecomNumber.areaCode',
				value : record.get('areaCode'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				fieldLabel : "电话号码",
				name : 'telecomNumber.contactNumber',
				value : record.get('contactNumber'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				fieldLabel : "转",
				name : 'telecomNumber.askForName',
				value : record.get('askForName'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				hidden : true,
				name : 'party.partyId',
				value : globalPartyId,
				anchor : "100%"
			}, {
				xtype : "textfield",
				hidden : true,
				name : 'telecomNumber.contactMechId',
				value : record.get('contactMechId'),
				anchor : "100%"
			} ];

			Ext.UpdateTelecomForm.superclass.constructor.call(this, {
				items : items
			});
		}
	});

	/**
	 * 更新联系信息表单
	 */
	Ext.UpdateContactForm = Ext.extend(Ext.magic.MagicForm, {
		xtype : "form",
		title : "联系信息",
		labelWidth : 100,
		labelAlign : "right",
		layout : "form",
		width : 400,
		// height:314,
		padding : "10px",
		frame : true,
		buttonAlign : "left",
		initComponent : function() {
			Ext.UpdateContactForm.superclass.initComponent.call(this);
		},
		constructor : function(config) {
			var record = new Ext.data.Record();
			if (config.updateData) {
				record = config.record;
			}

			var contactMechTypeStore = new Ext.data.JsonStore({
				autoLoad : true,
				url : 'partyLoader.action',
				root : 'dataset',
				baseParams : {
					actionType : 'LoadContactMechType',
					hasTable : 'N'
				},
				fields : [ 'contactMechTypeId', 'description', 'parentTypeId', 'hasTable' ]
			// ,
			// data:[['电子邮件','EMAIL_ADDRESS'],['信息','INFO'],['错误','ERROR']]
			});
			// contactMechTypeStore.load();

			var contactMechTypeCbx = new Ext.form.ComboBox({
				// xtype:"combo",
				fieldLabel : "信息类型",
				mode : 'local',
				store : contactMechTypeStore,
				displayField : 'description',
				valueField : 'contactMechTypeId',
				triggerAction : 'all',
				emptyText : '选择信息类型',
				// selectOnFocus:true,
				forceSelection : true,
				allowBlank : false,
				editable : false,
				name : 'contactMechTypeId',
				hiddenName : 'contactMech.contactMechTypeId',
				hiddenValue : record.get('contactMechTypeId'),
				anchor : "100%"
			});

			contactMechTypeCbx.setValue(record.get('contactMechTypeDesc'));

			var items = [ {
				xtype : "textfield",
				hidden : true,
				name : 'contactMech.contactMechId',
				value : record.get('contactMechId'),
				anchor : "100%"
			}, contactMechTypeCbx, {
				xtype : "textfield",
				fieldLabel : "信息内容",
				name : 'contactMech.infoString',
				value : record.get('infoString'),
				anchor : "100%"
			}, {
				xtype : "textfield",
				hidden : true,
				name : 'party.partyId',
				value : globalPartyId,
				anchor : "100%"
			} ];

			Ext.UpdateContactForm.superclass.constructor.call(this, {
				items : items
			});
		}
	});

	/**
	 * Catalog Component
	 */

	/**
	 * Product Component
	 */

});