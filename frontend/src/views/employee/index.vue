<template>
<mainTemplate :tableData="dt" url="/employees/modify" title="雇員" @deleteMethid="deleteMethid"></mainTemplate>
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
        api('employees').then(res => {
            this.dt.rows = res.data.map(m => {
                return {
                    id: m.empId,
                    name: m.name,
                    mobile: m.mobile,
                    address: m.address,
                    hourWage: m.hourWage
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
            this.remove('employees/', row.id, i)
        }
    }
}
</script>
