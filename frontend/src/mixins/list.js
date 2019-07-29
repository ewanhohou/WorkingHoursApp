import {
    api
} from "@/resource";
export default {
    data() {
        return {};
    },
    methods: {
        remove(url, id, i) {
            api.delete(`${url}${id}`).then(res => {
                this.dt.rows.splice(i, 1);
            });
        }
    }
}