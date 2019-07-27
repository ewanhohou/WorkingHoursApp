<template>
<mainTemplate url="/customer_add" title="客戶"></mainTemplate>
</template>

<script>
import mainTemplate from "@/components/template/mainTemplate";
import {
    api
} from "@/resource";
export default {
    name: 'customer',
    data() {
        return {
            dt: Object,
        };
    },
    mounted() {
        api('employees').then(res => {
            console.log(res);
        })
    },
    components: {
        mainTemplate,
    },
}
</script>
