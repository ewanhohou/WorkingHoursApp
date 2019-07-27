<template>
<mainTemplate url="/employee_add" title="雇員"></mainTemplate>
</template>

<script>
import mainTemplate from "@/components/template/mainTemplate";
export default {
    name: 'employee',
    data() {
        return {
            dt: Object,
        };
    },
    mounted() {

    },
    components: {
        mainTemplate,
    },
}
</script>
