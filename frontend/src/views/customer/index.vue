<template>
<mainTemplate :tableData="dt" url="/customers/modify" title="客戶" @deleteMethod="deleteMethod"></mainTemplate>
</template>

<script>
import mainTemplate from '@/components/template/mainTemplate';
import {
    api
} from '@/resource';
import {
    list
} from '@/mixins';

export default {
    name: 'customer',
    data() {
        const title = ['姓名', '電話​', '地址​'];
        return {
            dt: {
                title: title,
                rows: []
            }
        };
    },
    mounted() {
        api('customers').then(res => {
            this.dt.rows = res.data.map(m => {
                return {
                    id: m.cusId,
                    name: m.name,
                    mobile: m.mobile,
                    address: m.address
                };
            });
        }).catch(this.$handleError);
    },
    components: {
        mainTemplate
    },
    mixins: [list],
    methods: {
        deleteMethod(row, i) {
            this.remove('customers/', row.id, i)
        }
    }
};
</script>
