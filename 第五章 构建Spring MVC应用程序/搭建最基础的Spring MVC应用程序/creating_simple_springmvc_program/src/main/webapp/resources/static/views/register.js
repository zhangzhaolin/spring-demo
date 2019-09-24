$(function () {

    $("form .checkbox").checkbox();

    $.fn.api.settings.api = {
        "create user": contextPath + "spitter/register"
    };

    $(".ui.form").form({
        fields: {
            firstName: {
                identifier: 'firstName',
                rules: [
                    {
                        type: 'empty',
                        prompt: '请输入您的姓氏'
                    }
                ]
            },
            lastName: {
                identifier: 'lastName',
                rules: [{
                    type: 'empty',
                    prompt: '请输入您的名称'
                }]
            },
            userName: {
                identifier: 'userName',
                rules: [{
                    type: 'empty',
                    prompt: '请输入您的用户名'
                }]
            },
            passWord: {
                identifier: 'passWord',
                rules: [{
                    type: 'empty',
                    prompt: '请输入您的密码'
                }]
            }
        },
        onSuccess: function (e) {
            //阻止表单的提交
            e.preventDefault();
        }
    }).api({
        action: "create user",
        serializeForm: true,
        method: "POST",
        onResponse: function (response) {
            if (response.result === "SUCCESS") {
                window.location.href = contextPath + "spitter/user/" + response.data;
            } else {
                var errors = [];
                response.data.forEach(function (item) {
                    $(".ui.form").form('add prompt', item.field,item.defaultMessage);
                    errors.push(item.defaultMessage);
                });
                $(".ui.form").form('add errors', errors);
            }
        }
    });

    $("#submit").click(function () {
        $(".ui.form").submit();
    });
});