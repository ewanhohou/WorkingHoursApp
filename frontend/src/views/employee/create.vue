<template>
<addTemplate title="雇員">
    <div class="form-horizontal">
        <inputText label="姓名" id="Name" v-model="form.name"></inputText>
        <inputTel label="電話" id="Mobile" v-model="form.mobile"></inputTel>
        <inputText label="地址" id="Address" v-model="form.address"></inputText>
        <inputNumber label="薪資" id="price" v-model="form.hourWage"></inputNumber>
        <button type="submit" id="submit" class="btn btn-default pull-right" @click="create()">送出</button>
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
import inputNumber from "@/components/validations/inputNumberValid";
export default {
    name: 'create',
    data() {
        return {
            form: {
                name: '',
                mobile: '',
                address: '',
                hourWage: 0
            }
        }
    },
    components: {
        addTemplate,
        inputText,
        inputTel,
        inputNumber
    },
    methods: {
        create() {
            api.post('employees', this.form, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                if (res.status == 201) this.$router.push({
                    path: '/employee'
                })
            })
        }
    },
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
