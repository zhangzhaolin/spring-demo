$(function () {
    
    $("body").on("click","#returnList",function () {
        window.location.href = "/spittles";
    });

    axios.post(window.location.pathname,{}).then(function (response) {
        new Vue({
            el : "#spittle",
            data : {
                "spittle" : response.data.data
            },
            filters : {
                formateDate: function (value) {
                    moment.locale("zh_cn");
                    return moment(value).format("lll");
                }
            }
        })

    }).catch(function (error) {

    });

});
