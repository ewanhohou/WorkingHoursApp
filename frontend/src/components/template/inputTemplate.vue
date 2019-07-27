<template>
<div class="form-group">
    <label for="datepicker" class="col-sm-2 control-label">{{label}}</label>
    <div class="col-sm-10">
        <slot></slot>
    </div>
</div>
</template>

<script>
export default {
    name: 'inputTemplate',
    props: {
        label: String
    },
}
</script>
