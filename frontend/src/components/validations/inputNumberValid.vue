<template>
<inputTemplate :label="label">
    <input v-model="number" type="number" step="0.01" class="form-control" :id="id" :placeholder="id">
    <i v-show="errorShow" class="fa fa-warning text-red"> {{label}}請輸入數字，小數點後兩位(例：24.11)</i>
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'inputNumberValid',
    data() {
        return {
            number: 0,
            errorShow: false
        }
    },
    props: {
        id: String,
        label: String,
        value: Number
    },
    watch: {
        number(num) {
            if (this.regex()) this.errorShow = false;
            this.$emit('input', parseFloat(num));
        },
        value(val) {
            this.number = val;
        }
    },
    components: {
        inputTemplate,
    },
    methods: {
        require() {
            if (this.regex()) {
                this.errorShow = false;
                return true;
            }
            this.errorShow = true;
            return false;
        },
        regex() {
            return this.number.toString().match("^[0-9]+(?:\.[0-9]{1,2})?$");
        }
    },
}
</script>
