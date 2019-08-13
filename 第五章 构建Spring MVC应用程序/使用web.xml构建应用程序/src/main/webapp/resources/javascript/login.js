$(function(){
    $('.ui.form').form(settings);
});

var app = new Vue({
    el: "#app",
    data: {
        username: "",
        password: ""
    },
    methods: {
        submit: function () {
            // 校验表单
            if(!$("#app").form('validate form')) return false;

            fetch("/loginCheck.html", {
                method: 'POST',
                body: JSON.stringify({
                    userName: this.username,
                    password: this.password
                }), // data can be `string` or {object}!
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            }).then(res => res.json())
                .catch(error => console.error('Error:', error))
                .then(response => {
                    // 用户名或密码错误提示...
                    if (!response.status){
                        $("#app").form('add errors',[response.msg]);
                    }else{
                        window.location.href = "/main.html";
                    }
                });
        }
    }
});

var settings = {
    fields: {
        username : {
            identifier : 'username',
            rules : [{
                type : 'empty',
                prompt : '请输入您的用户名.'
            }]
        },
        password : {
            identifier: "password",
            rules : [{
                type : 'empty',
                prompt: '请输入您的密码.'
            }]
        }
    },
    keyboardShortcuts : false
};
