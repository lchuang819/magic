<script type="text/javascript">
Ext.onReady(function(){
 var simple = new Ext.FormPanel({
        labelWidth: 75, // label settings here cascade unless overridden
        url:'save-form.php',
        frame:true,
        title: 'Simple Form',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',

        items: [{
                fieldLabel: 'First Name',
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
                name: 'email',
                vtype:'email'
            }, new Ext.form.TimeField({
                fieldLabel: 'Time',
                name: 'time',
                minValue: '8:00am',
                maxValue: '6:00pm'
            })
        ],

        buttons: [{
            text: 'Save'
        },{
            text: 'Cancel'
        }]
    });

    simple.render(document.body);
});
</script>
<body>
<b>这里是个人设置</b>
</body>