<template>
<addTemplate title="客戶">
    <div class="form-horizontal">
        <inputText label="姓名" id="Name" v-model="form.name"></inputText>
        <inputTel label="電話" id="Mobile" v-model="form.mobile"></inputTel>
        <inputText label="地址" id="Address" v-model="form.address"></inputText>
        <button type="submit" id="submit" class="btn btn-default pull-right" @click.stop.prevent="submit()">送出</button>
    </div>
</addTemplate>
</template>

<script>
import addTemplate from "@/components/template/addTemplate";
import inputText from "@/components/validations/inputTextValid";
import inputTel from "@/components/validations/inputTelValid";
import {
    modify
} from "@/mixins";

export default {
    name: "modify",
    data() {
        return {
            form: {
                name: "",
                mobile: "",
                address: ""
            }
        };
    },
    components: {
        addTemplate,
        inputText,
        inputTel
    },
    mixins: [modify],
    mounted() {
        if (this.$route.params.id) this.get();
    },
    methods: {
        submit() {
            if (!this.$route.params.id) this.create();
            else this.modify();
        },
        create() {
            this.post("customers");
        },
        modify() {
            this.put("customers", this.$route.params.id);
        },
        get() {
            this.getOne("customers", this.$route.params.id);
        }
    }
};
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
        <inputText label="姓名" id="Name"></inputText>
