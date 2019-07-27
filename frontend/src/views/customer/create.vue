<template>
<addTemplate title="客戶">
    <div class="form-horizontal">
        <inputText label="姓名" id="Name"></inputText>
        <inputTel label="電話" id="Mobile"></inputTel>
        <inputText label="地址" id="Address"></inputText>
        <button type="submit" id="submit" class="btn btn-default pull-right">送出</button>
    </div>
</addTemplate>
</template>

<script>
import addTemplate from "@/components/template/addTemplate";
import inputText from "@/components/validations/input_text";
import inputTel from "@/components/validations/input_tel";
export default {
    name: '',
    components: {
        addTemplate,
        inputText,
        inputTel
    },
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
        <inputText label="姓名" id="Name"></inputText>
