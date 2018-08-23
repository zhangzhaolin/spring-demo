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
                    timeFormater : function (time) {
                        
                    }
                }
            })
        },
        dataType: "json",
        error : function (error) {

        }
    });
});