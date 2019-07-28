<template>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            {{title}}
            <small>新增</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">{{title}}新增</a></li>
        </ol>
    </section>
    <section class="invoice">
        <div class="row">
            <div class="col-md-12">
                <slot></slot>
            </div>
        </div>
    </section>
</div>
</template>

<script>
export default {
    name: 'addTemplate',
    props: {
        title: String,
    }
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
