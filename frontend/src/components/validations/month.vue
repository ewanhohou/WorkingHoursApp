<template>
<div class="col-xs-12 col-lg-4 col-md-6">
    <div class="form-group">
        <div class="input-group date">
            <date-picker v-model="month" :config="options"></date-picker>
            <span class="icon"><i class="fa fa-calendar"></i></span>
            <span class="input-group-btn">
                <button class="btn btn-primary btn-flat" :class="{disabled: month == ''}" type="submit" @click.stop.prevent="submit">查詢</button>
            </span>
        </div>
    </div>
</div>
</template>

<script>
import datePicker from 'vue-bootstrap-datetimepicker';
import 'pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css';
export default {
    name: 'month',
    data() {
        return {
            month: '',
            options: {
                format: 'YYYY/MM',
                useCurrent: false,
                viewMode: 'months',
                locale: 'zh-TW'
            }
        }
    },
    methods: {
        submit() {
            this.$emit('setMonth', this.month);
        }
    },
    components: {
        datePicker
    }
}
</script>

<style lang="scss" scoped>
.form-group {
    position: relative;

    margin-bottom: 0px;

    input {
        padding-left: 30px;
    }

    .icon {
        position: absolute;
        top: 7px;
        left: 10px;
        color: #ccc;
        z-index: 999;
    }
}
</style>
