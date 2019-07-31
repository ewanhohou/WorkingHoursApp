<template>
<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">{{title}}</h4>
            </div>
            <div class="modal-body">
                <slot></slot>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" @click.stop.prevent="submit">送出</button>
            </div>
        </div>
    </div>
</div>
</template>

<script>
export default {
    name: 'modalTemplate',
    props: {
        title: String
    },
    methods: {
        show() {
            $(this.$el).modal("show");
        },
        hide() {
            $(this.$el).modal("hide");
        },
        submit(e) {
            this.$emit("submit");
        },
    }
};
</script>

<style>
</style>
