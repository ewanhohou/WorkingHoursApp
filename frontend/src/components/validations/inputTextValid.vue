<template>
<inputTemplate :label="label">
    <input :value="value" type="text" class="form-control" :id="id" :placeholder="id" autofocus required @change="$emit('input', $event.target.value)">
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'inputTextValid',
    props: {
        id: String,
        label: String,
        value: String
    },
    components: {
        inputTemplate,
    },
}
</script>
