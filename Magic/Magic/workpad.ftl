<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Magic/framework/resources/css/ext-all.css"/>
<link rel="stylesheet" type="text/css" href="/Magic/framework/resources/css/icons.css"/>
<link rel="stylesheet" type="text/css" href="/Magic/framework/resources/css/debug.css"/>
<link rel="stylesheet" type="text/css" href="/Magic/framework/resources/css/ux-all.css"/>
<link rel="stylesheet" type="text/css" href="/Magic/framework/resources/css/customer/ux.css"/>
<!-- -->

<link rel="shortcut icon" href="/Magic/framework/resources/icons/favicon.gif"/>

<script type="text/javascript" src="/Magic/framework/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/Magic/framework/scripts/ext-all.js"></script>
<script type="text/javascript" src="/Magic/framework/scripts/debug.js"></script>
<script type="text/javascript" src="/Magic/framework/scripts/ux-all.js"></script>
<script type="text/javascript" src="/Magic/framework/scripts/ux.js"></script>
<!--
<script type="text/javascript" src="/Magic/framework/adapter/prototype/ext-prototype-adapter-debug.js"></script>
-->
<script type="text/javascript" src="/Magic/framework/base/js/util.js"></script>
<script type="text/javascript" src="/Magic/framework/base/js/common-magic.js"></script>


<script type="text/javascript" src="/Magic/applications/commonjs/common-applications.js"></script>
<script type="text/javascript" src="/Magic/applications/commonjs/common-party.js"></script>
<script type="text/javascript" src="/Magic/applications/commonjs/common-product.js"></script>
<title>Build</title>

<STYLE>
.cc
{
	color:white;
	text-align:center;
	font:normal 12px tahoma, arial, helvetica, sans-serif;
}

/* ==== Styles For The Html Log === */
.DEBUG {
color: #808080;
font-size:80%;
}

.WARN {
color: #0000ff;
font-weight: bold;
font-size:80%;
}

.INFO{
color: #008000;
font-size:80%;
}

.ERROR {
border: 0.2em solid #ff0000;
color: #ff0000;
font-weight: bold;
font-size:90%;
}

</STYLE>

<script type="text/javascript">
		
	var modules = [
		<#list labelList as userMap>
        {id:'${userMap.id?default('')}',text:'${userMap.text}',isroot:<#if '${userMap.isroot}'=='true'>true<#else>false</#if>,iconCls:'${userMap.iconCls}',html:'${userMap.html?default('#')}',jsPath:'${userMap.jsPath?default('')}'}
        <#if userMap_has_next>,</#if>
        </#list>
	];
	
Ext.onReady(function(){
		
    	var welcome = new Ext.Panel({
                title: 'Welcome',
                closable:true,
                autoScroll:true,
                autoLoad:{url:util.constant.appPath+'welcome.ftl', scripts:true}
            });
		
		tabpanel.add(welcome);
		
		var viewport = new Ext.Viewport({
            layout: 'border',
            items: [
            // create instance immediately
            {
                // lazily created panel (xtype:'panel' is default)
                region: 'north',
                split: true,
                height: 100,
                border: false,
                items:[
                	{	region:'north',
                		height: 75,
                		bodyStyle:'background-color:#126499;padding:10 0 10 10',
                		autoLoad:{url:util.constant.appPath+'framework/webtools/widget/north.ftl', scripts:true}
                    },
                	tb
                    ],
                margins: '0 0 0 0'
            },{
                // lazily created panel (xtype:'panel' is default)
                region: 'south',
                split: true,
                height: 100,
                minSize: 100,
                maxSize: 200,
                collapsible: true,
                collapsed:true,
                title: 'South',
                margins: '0 0 0 0',
                items:[
                	
                ]
            },
            tabpanel
           
            ]
        });
	});
	createToolbar(modules);

	//Ext.log('123');
	//Ext.log('123');
</script>

</head>
<body scroll="no" id="docs">

</body>
</html>