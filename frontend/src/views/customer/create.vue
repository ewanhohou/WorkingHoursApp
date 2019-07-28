<template>
<addTemplate title="客戶">
    <div class="form-horizontal">
        <inputText label="姓名" id="Name" v-model="form.name"></inputText>
        <inputTel label="電話" id="Mobile" v-model="form.mobile"></inputTel>
        <inputText label="地址" id="Address" v-model="form.address"></inputText>
        <button type="submit" id="submit" class="btn btn-default pull-right" v-on:click.stop.prevent="create()">送出</button>
    </div>
</addTemplate>
</template>

<script>
import {
    api
} from "@/resource";
import addTemplate from "@/components/template/addTemplate";
import inputText from "@/components/validations/inputTextValid";
import inputTel from "@/components/validations/inputTelValid";
export default {
    name: 'create',
    data() {
        return {
            form: {
                name: '',
                mobile: '',
                address: ''
            }
        }
    },
    components: {
        addTemplate,
        inputText,
        inputTel
    },
    methods: {
        create() {
            api.post('customers', this.form,{headers: {'Content-Type': 'application/json'}}).then(res=>{
                if(res.status == 201) this.$router.push({path: '/customer'})
            });
        }
    },
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
        <inputText label="姓名" id="Name"></inputText>
