var spittlesList;

$(function () {
    $.ajax({
        type: 'POST',
        url: "/spittles",
        success: function (result) {
            spittlesList = new Vue({
                el : '#spittlesList',
                data : {
                    spittles : result.data
                },
                filter : {
                    formateDate : function (value) {
                        return "2019/12/10"
                        // return format(new Date(),"YYYY-MM-dd HH:mm:ss");
                    }
                }
            })
        },
        dataType: "json",
        error : function (error) {

        }
    });
});