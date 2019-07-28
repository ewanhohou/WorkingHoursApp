<template>
<inputTemplate :label="label">
    <input type="number" class="form-control" :id="id" :placeholder="id" required @change="$emit('input', $event.target.value)">
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'inputNumberValid',
    props: {
        id: String,
        label: String,
    },
    components: {
        inputTemplate,
    }
}
</script>
