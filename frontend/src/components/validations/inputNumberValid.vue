<template>
<inputTemplate :label="label">
    <input v-model="number" type="number" class="form-control" :id="id" :placeholder="id">
    <i v-show="errorShow" class="fa fa-warning text-red"> {{label}}請輸入數字</i>

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
            this.$emit('input', parseInt(num));
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
            return this.number.toString().match("^[0-9]*$");
        }
    },
}
</script>
