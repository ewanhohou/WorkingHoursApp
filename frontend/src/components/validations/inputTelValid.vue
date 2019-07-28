<template>
<inputTemplate :label="label">
    <input type="tel" class="form-control" :id="id" :placeholder="id" required @change="$emit('input', $event.target.value)">
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'inputTelValid',
    props: {
        id: String,
        label: String,
    },
    components: {
        inputTemplate,
    }
}
</script>
