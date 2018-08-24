$(function () {

    $.fn.api.settings.api = {
        "create user" : "/spitter/register"
    };

    $(".ui.form").form({
        fields : {
            firstName : {
                identifier : 'firstName',
                rules: [
                    {
                        type   : 'empty',
                        prompt : '请输入您的姓氏'
                    }
                ]
            },
            lastName : {
                identifier: 'lastName',
                rules: [{
                    type: 'empty',
                    prompt: '请输入您的名称'
                }]
            },
            userName : {
                identifier : 'userName',
                rules :[{
                    type : 'empty',
                    prompt : '请输入您的用户名'
                }]
            },
            passWord : {
                identifier : 'passWord',
                rules : [{
                    type : 'empty',
                    prompt : '请输入您的密码'
                }]
            }
        },
        onSuccess: function(e) {
            //阻止表单的提交
            e.preventDefault();
        }
    }).api({
        action : "create user",
        serializeForm : true,
        method : "POST",
        onResponse : function(response) {
            if(response.result === "SUCCESS")
            window.location.href = response.data;
            // valid response and response.success = true
        },
    });

    $("#submit").click(function () {
        $(".ui.form").submit();
    });
});