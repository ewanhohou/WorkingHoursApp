<template>
<inputTemplate :label="label">
    <Datetime type="datetime" v-model="dt" format="dd-MM-yyyy HH:mm" :minute-step="5" use12-hour input-class="form-control"></Datetime>
</inputTemplate>
</template>

<script>
import {
    Datetime
} from 'vue-datetime';
import inputTemplate from '@/components/template/inputTemplate'
import "vue-datetime/dist/vue-datetime.css";
export default {
    name: 'dateTimePicker',
    props: {
        label: String
    },
    data() {
        return {
            dt: '',
        };
    },
    components: {
        inputTemplate,
        Datetime
    }
}
</script>
