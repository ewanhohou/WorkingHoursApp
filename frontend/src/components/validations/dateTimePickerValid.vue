<template>
<inputTemplate :label="label">
    <Datetime v-model="dt" type="datetime" format="dd-MM-yyyy HH:mm" :minute-step="5" use12-hour input-class="form-control" class="theme-blue"></Datetime>
</inputTemplate>
</template>

<script>
import {
    Datetime
} from 'vue-datetime';
import inputTemplate from '@/components/template/inputTemplate'
import "vue-datetime/dist/vue-datetime.css";
export default {
    name: 'dateTimePickerValidValid',
    props: {
        label: String,
        value: String
    },
    data() {
        return {
            dt: '',
        };
    },
    components: {
        inputTemplate,
        Datetime
    },
    watch: {
        dt($event) {
            this.$emit('dateTimeChangEvent', $event);
        },
        value(val) {
            this.dt = val;
        }
    }
}
</script>

<style lang="scss">
.theme-blue .vdatetime-popup__header,
.theme-blue .vdatetime-calendar__month__day--selected>span>span,
.theme-blue .vdatetime-calendar__month__day--selected:hover>span>span {
    background: #3c8dbc;
}

.theme-blue .vdatetime-year-picker__item--selected,
.theme-blue .vdatetime-time-picker__item--selected,
.theme-blue .vdatetime-popup__actions__button {
    color: #3c8dbc;
}
</style>
