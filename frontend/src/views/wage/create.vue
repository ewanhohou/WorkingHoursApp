<template>
<addTemplate title="工時">
    <div class="form-horizontal">
        <selectComp label="客戶"></selectComp>
        <selectComp label="雇員"></selectComp>
        <dateTimePicker label="起始日期"></dateTimePicker>
        <dateTimePicker label="結束日期"></dateTimePicker>
        <button type="submit" id="submit" class="btn btn-default pull-right">送出</button>
    </div>
</addTemplate>
</template>

<script>
import addTemplate from "@/components/template/addTemplate";
import selectComp from "@/components/validations/select";
import dateTimePicker from "@/components/validations/dateTimePicker";

export default {
    name: '',
    data() {
        return {
            startDate: String,
            endDate: String,
        };
    },
    components: {
        addTemplate,
        selectComp,
        dateTimePicker
    },
    mounted() {
    }
}
</script>

<style lang="scss" scoped>

.form-group {
    margin-bottom: 15px;
}
</style>
