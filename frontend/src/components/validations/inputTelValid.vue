<template>
<inputTemplate :label="label">
    <input-mask v-model="tel" mask="9999999999" :id="id" :placeholder="id" class="form-control"></input-mask>
    <i v-show="errorShow" class="fa fa-warning text-red"> {{label}}格式錯誤 (例：0422791640)</i>
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'
import InputMask from 'vue-input-mask';

export default {
    name: 'inputTelValid',
    data() {
        return {
            tel: '',
            errorShow: false
        }
    },
    watch: {
        tel(val) {
            if (this.regex()) this.errorShow = false;
            this.$emit('input', val);
        },
        value(val) {
            this.tel = val;
        }
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
            return this.tel.match(/[0-9]{10}/);
        }
    },
    props: {
        id: String,
        label: String,
        value: String
    },
    components: {
        inputTemplate,
        InputMask
    },
}
</script>
