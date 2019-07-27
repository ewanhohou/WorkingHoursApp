<template>
<inputTemplate :label="label">
    <select class="form-control">
        <option v-for="(option, index) in options" v-bind:key="index">{{option}}</option>
    </select>
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'selectComp',
    props: {
        label: String,
        options: Array
    },
    components: {
        inputTemplate,
    }
}
</script>
