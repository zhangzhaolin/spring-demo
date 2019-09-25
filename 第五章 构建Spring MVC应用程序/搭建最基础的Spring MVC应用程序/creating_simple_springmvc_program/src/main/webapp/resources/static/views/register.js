$(function () {

    $("form .checkbox").checkbox();

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
        }
    });

    $("#submit").click(function () {
        $(".ui.form").submit();
    });
});