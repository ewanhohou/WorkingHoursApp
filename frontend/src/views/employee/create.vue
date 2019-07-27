<template>
<addTemplate title="雇員">
    <div class="form-horizontal">
        <inputText label="姓名" id="Name"></inputText>
        <inputTel label="電話" id="Mobile"></inputTel>
        <inputText label="地址" id="Address"></inputText>
        <div class="form-group">
            <label for="number" class="col-sm-2 control-label">薪資</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="number" placeholder="price" required>
            </div>
        </div>
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
