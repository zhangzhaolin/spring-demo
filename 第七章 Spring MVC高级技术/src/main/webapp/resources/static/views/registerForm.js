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
            },
            imgLogo : {
                identifier : 'imgLogo',
                rules : [{
                    type : 'empty',
                    prompt : '请上传您的图片'
                }]
            }
        },
        onSuccess: function(e) {
            //阻止表单的提交
            e.preventDefault();
        }
    }).api({
        action : "create user",
        method : "POST",
        processData: false,
        contentType: false,
        beforeSend : function(settings){
            settings.data = new FormData($(".ui.form")[0]);
            return settings;
        },
        onResponse : function(response) {
            var data = response.data;
            if(response.result === "SUCCESS"){
                window.location.href = "/spitter/user/" + data;
            }else{
                var errors = [];
                data.forEach(function (element) {
                    errors.push(element.field + " " + element.defaultMessage);
                });
                $(".ui.form").form("add errors",errors);
            }
        },
        onFailure : function(error){
            var errors = [];errors.push(error);
            $(".ui.form").form("add prompt" , "userName");
            $(".ui.form").form("add errors" , errors);
        }
    });

    $("#submit").click(function () {
        $(".ui.form").submit();
    });

    $(".ui.form").on("change","input[name='imgLogo']",function () {
        var file = new FileReader();
        file.onload = function(element){
            $("#logo").attr("src",element.target.result);
        };
        file.readAsDataURL(this.files[0]);
    });

});