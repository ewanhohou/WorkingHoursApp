<template>
<mainTemplate :show="false" :tableData="dt" title="薪資">
    <month @setMonth="setMonth"></month>
</mainTemplate>
</template>

<script>
import mainTemplate from '@/components/template/mainTemplate';
import month from '@/components/validations/month';
import {
    api
} from '@/resource';

export default {
    name: 'wage',
    data() {
        const title = ['姓名', '日期', '工時(Hour)', '薪資'];
        return {
            dt: {
                title: title,
                rows: []
            }
        };
    },
    components: {
        mainTemplate,
        month
    },
    methods: {
        setMonth(month) {
            api(`wages/${month}`).then(res => {
                if (res.data.length == 0) this.$swal('查無資料');
                this.dt.rows = res.data.map(m => {
                    return {
                        name: m.name,
                        date: `${m.month}/${m.year}`,
                        hour: m.totalHour,
                        wage: `$${m.totalWage.toLocaleString()}`,
                    };
                });
            }).catch(this.$handleError);
        }
    }
};
</script>
