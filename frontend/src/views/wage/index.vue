<template>
<mainTemplate url="/wage_add" title="工時"></mainTemplate>
</template>

<script>
import mainTemplate from "@/components/template/mainTemplate";
export default {
    name: 'wage',
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
