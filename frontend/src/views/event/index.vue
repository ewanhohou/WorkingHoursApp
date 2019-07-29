<template>
<mainTemplate :tableData="dt"  url="/event_add" title="工時" @deleteMethid="deleteMethid"></mainTemplate>
</template>

<script>
import mainTemplate from "@/components/template/mainTemplate";
import {
    api
} from "@/resource";
import {
    list
} from "@/mixins";

export default {
    name: 'event',
    data() {
        const title = [
            "客戶",
            "雇員",
            "開始日期",
            "結束日期",
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
            this.dt.rows  = res.data.map(m => {
                return {
                    id: m.eventSeq,
                    cusName: m.cus.name,
                    empName: m.emp.name,
                    addstartTimeress: m.startTime,
                    endTime: m.endTime
                };
            });
        });
    },
    components: {
        mainTemplate,
    },
     mixins: [list],
    methods: {
        deleteMethid(row, i) {
            this.remove('events/', row.id, i)
        }
    }
}
</script>
