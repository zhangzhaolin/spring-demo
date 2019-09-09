$(function () {
    $('#example').DataTable({
        processing : true,
        serverSide : true,
        ajax : {
            contentType : "application/json",
            url : "/spitter",
            type : "post",
            data : function(value){
                return JSON.stringify(value);
            }
        },
        columns : [
            {data : "username"},
            {data : "email"},
            {data : "password"}
        ]
    });
});