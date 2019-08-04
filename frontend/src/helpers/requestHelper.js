import Vue from 'vue'

export default {
    handleError(err) {
        Vue.swal('發生錯誤，請通知網管人員');
        console.log(err.response);
        if (process.env.NODE_ENV !== 'production') {
            console.info('%c [axios catch error]:', 'color: orange', err);
        }
    }
}
