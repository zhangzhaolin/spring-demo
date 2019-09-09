var spittlesList;

$(function () {
    axios.post('/spittles', {

    }).then(function (response) {
        spittlesList = new Vue({
            el : '#spittlesList',
            data : {
                spittles : response.data.data
            },
            filters : {
                formateDate: function (value) {
                    moment.locale("zh_cn");
                    return moment(value).format("LLL");
                }
            }
        });
    }).catch(function (error) {
        console.log(error);
    });

});