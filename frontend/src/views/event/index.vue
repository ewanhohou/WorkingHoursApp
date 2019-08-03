<template>
<mainTemplate :show="true" :tableData="dt" url="/events/modify" title="工時" @deleteMethod="deleteMethod"></mainTemplate>
</template>

<script>
import mainTemplate from '@/components/template/mainTemplate';
import {
    api
} from '@/resource';
import {
    list
} from '@/mixins';
import moment from 'moment'

export default {
    name: 'event',
    data() {
        const title = [
            '客戶',
            '雇員',
            '開始日期',
            '結束日期',
        ];
        return {
            dt: {
                title: title,
                rows: [],
            },
        };
    },
    mounted() {
        api('events').then(res => {
            this.dt.rows = res.data.map(m => {
                return {
                    id: m.eventSeq,
                    cusName: m.cus.name,
                    empName: m.emp.name,
                    startTime: moment(String(m.startTime)).format('DD-MM-YYYY HH:mm'),
                    endTime: moment(String(m.endTime)).format('DD-MM-YYYY HH:mm')
                };
            });
        }).catch(this.$handleError);
    },
    components: {
        mainTemplate,
    },
    mixins: [list],
    methods: {
        deleteMethod(row, i) {
            this.remove('events/', row.id, i)
        }
    }
}
</script>
