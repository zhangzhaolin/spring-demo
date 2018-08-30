$(function () {

    axios.post(window.location.pathname).then(function (response) {
        new Vue({
            el : "#spitter",
            data : {
                spitter : response.data.data
            }

        })
    }).catch(function (error) {
        if(error.response){
            console.log(error.response.data);
            new Vue({
                el : "#spitter",
                data : {
                    spitter : {
                        firstName : error.response.data
                    }
                }
            })
        }else{
            console.log(error.message)
        }
    })

});