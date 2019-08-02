<template>
<inputTemplate :label="label">
    <input v-model="text" type="text" class="form-control is-invalid" :id="id" :placeholder="id" autofocus @change="change">
    <i v-show="errorShow" class="fa fa-warning text-red"> {{label}}必填</i>
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'inputTextValid',
    data() {
        return {
            text: '',
            errorShow: false
        }
    },
    watch: {
        value(val) {
            this.text = val;
        }
    },
    props: {
        id: String,
        label: String,
        value: String
    },
    methods: {
        require() {
            if (this.text == '') {
                this.errorShow = true;
                return false;
            }
            this.errorShow = false;
            return true;
        },
        change($event) {
            this.require();
            this.$emit('input', $event.target.value);
        }
    },
    components: {
        inputTemplate,
    },
}
</script>
