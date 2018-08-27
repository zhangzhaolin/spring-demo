$(function () {

    axios.post(window.location.pathname).then(function (response) {
        new Vue({
            el : "#spitter",
            data : {
                spitter : response.data.data
            }

        })
    }).catch(function (error) {
        console.log(error)
    })

});