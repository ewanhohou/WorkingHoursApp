<template>
<div>
    <inputTemplate label="起始日期">
        <Datetime v-model="sdt" type="datetime" format="dd-MM-yyyy HH:mm" :minute-step="5" use12-hour input-class="form-control" class="theme-blue"></Datetime>
        <i v-show="sdtErrorShow" class="fa fa-warning text-red"> 起始日期必填</i>
    </inputTemplate>
    <inputTemplate label="結束日期">
        <Datetime v-model="edt" type="datetime" format="dd-MM-yyyy HH:mm" :minute-step="5" :min-datetime="sdt" use12-hour input-class="form-control" class="theme-blue"></Datetime>
        <i v-show="edtErrorShow" class="fa fa-warning text-red"> 結束日期必填</i>
    </inputTemplate>
</div>
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
        startTimeOld: String,
        endTimeOld: String,
    },
    data() {
        return {
            sdt: '',
            edt: '',
            sdtErrorShow: false,
            edtErrorShow: false
        };
    },
    components: {
        inputTemplate,
        Datetime
    },
    watch: {
        sdt($event) {
            if ($event !== '') this.sdtErrorShow = false;
            this.$emit('setStartTime', $event);
        },
        edt($event) {
            if ($event == '') this.edtErrorShow = false;
            this.$emit('setEndTime', $event);
        },
        startTimeOld(val) {
            this.sdt = val;
        },
        endTimeOld(val) {
            this.edt = val;
        }
    },
    methods: {
        require() {
            if (this.sdt == '' || this.edt == '') {
                if (this.sdt == '') this.sdtErrorShow = true;
                if (this.edt == '') this.edtErrorShow = true;
                return false;
            }
            this.sdtErrorShow = false;
            this.edtErrorShow = false;
            return true;
        },
    },
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
