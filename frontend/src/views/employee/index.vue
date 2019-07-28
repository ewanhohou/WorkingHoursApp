<template>
<mainTemplate :tableData="dt" url="/employee_add" title="雇員"></mainTemplate>
</template>

<script>
import mainTemplate from "@/components/template/mainTemplate";
import {
    api
} from "@/resource";
let vm;

export default {
    name: 'employee',
    data() {
        const title = [
            "姓名",
            "電話​",
            "地址​",
            "時薪"
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
        api('employees').then(res => {
            vm.dt.rows  = res.data.map(m=>Object.assign(m));
        });
    },
    components: {
        mainTemplate,
    },
}
</script>
