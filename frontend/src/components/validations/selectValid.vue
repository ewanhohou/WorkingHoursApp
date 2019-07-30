<template>
<inputTemplate :label="label">
    <select class="form-control" :value="value" @change="$emit('input', parseInt($event.target.value))">
        <option v-for="(option, index) in options" v-bind:key="index" :value="option.slug" :selected="option.slug == value">{{option.name}}</option>
    </select>
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate';

export default {
    name: 'selectValid',
    props: {
        label: String,
        options: Array,
        value: Number
    },
    components: {
        inputTemplate
    },
};
</script>
