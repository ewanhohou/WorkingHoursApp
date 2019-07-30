<template>
<inputTemplate :label="label">
    <input :value="value" type="number" class="form-control" :id="id" :placeholder="id" required @change="$emit('input', parseInt($event.target.value))">
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'inputNumberValid',
    props: {
        id: String,
        label: String,
        value: Number
    },
    components: {
        inputTemplate,
    },
}
</script>
