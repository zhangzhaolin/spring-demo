$(function () {
    $.ajax({
        type: 'POST',
        url: "/spittles",
        success: function (data) {
            console.log(data);
        },
        dataType: "json",
        error : function (error) {
            console.log(error);
        }
    });
});