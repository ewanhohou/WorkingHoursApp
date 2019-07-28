<template>
<mainTemplate :tableData="dt"  url="/event_add" title="工時"></mainTemplate>
</template>

<script>
import mainTemplate from "@/components/template/mainTemplate";
import {
    api
} from "@/resource";
let vm;

export default {
    name: 'event',
    data() {
        const title = [
            "empId",
            "cusId",
            "startTime",
            "endTime",
        ];
        return {
            dt: {
                title: title,
                rows: [],
            },
        };
    },
    mounted() {
        vm = this;
        api('events').then(res => {
            vm.dt.rows  = res.data.map(m=>Object.assign(m));
        });
    },
    components: {
        mainTemplate,
    },
}
</script>
