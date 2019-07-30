import {
    api
} from '@/resource';
export default {
    methods: {
        getOne(url, id) {
            api(`${url}/${id}`).then(res => {
                Object.assign(this.form, res.data);
            }).catch(this.$handleError);
        },
        post(url) {
            api.post(url, this.form, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                if (res.status == 201) this.$router.push({
                    path: `/${url}`
                })
            }).catch(this.$handleError);
        },
        put(url, id) {
            api.put(`${url}/${id}`, this.form, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                if (res.status == 200) this.$router.push({
                    path: `/${url}`
                })
            }).catch(this.$handleError);
        },
    }
}