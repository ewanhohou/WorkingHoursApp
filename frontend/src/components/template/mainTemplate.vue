<template>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            {{title}}
            <small>表單</small>
        </h1>
        <ol class="breadcrumb">
            <!-- <li><a href="#">Home</a></li> -->
            <li><a href="#"><i class="fa fa-dashboard"></i>{{title}}表單</a></li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="box">
                    <div class="box-header with-border">
                        <slot></slot>
                        <div v-if="show">
                            <router-link :to="url"><button type="button" class="btn bg-maroon">新增</button></router-link>
                        </div>
                        <!-- <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                <i class="fa fa-minus"></i>
                            </button>
                        </div> -->
                    </div>
                    <div class="box-body">
                        <tableTemplate :show="show" :tableData="tableData" @deleteMethod="deleteMethod"></tableTemplate>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</template>

<script>
import tableTemplate from '@/components/template/tableTemplate';
export default {
    name: 'mainTemplate',
    props: {
        tableData: Object,
        title: String,
        url: String,
        show: Boolean
    },
    components: {
        tableTemplate,
    },
    methods: {
        deleteMethod(row, i) {
            this.$emit('deleteMethod', row, i)
        },
    }
}
</script>
