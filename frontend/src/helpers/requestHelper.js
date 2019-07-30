export default {
    handleError(err) {
        alert('錯誤喔＠＠')
        console.log(err.response);
        if (process.env.NODE_ENV !== 'production') {
            console.info('%c [axios catch error]:', 'color: orange', err);
        }
    }
}
