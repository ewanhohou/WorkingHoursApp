<template>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            {{title}}
            <small>{{method}}</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> {{title}}表單</a></li>
            <li><a href="#">{{title}}{{method}}</a></li>
        </ol>
    </section>
    <section class="invoice">
        <div class="row">
            <div class="col-md-12">
                <slot></slot>
                <button type="button" class="btn btn-default pull-right margin" @click.stop.prevent="cancel">取消</button>
            </div>
        </div>
    </section>
</div>
</template>

<script>
export default {
    name: 'modifyTemplate',
    props: {
        title: String,
        method: String
    },
    methods: {
        cancel() {
            this.$router.go(-1);
        }
    }
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
