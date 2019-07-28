<template>
<inputTemplate :label="label">
    <select class="form-control" @change="$emit('input', $event.target.value)">
        <option v-for="(option, index) in options" v-bind:key="index" :value="option.slug">{{option.name}}</option>
    </select> </inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'selectValid',
    props: {
        label: String,
        options: Array
    },
    components: {
        inputTemplate,
    }
}
</script>
