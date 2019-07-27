<template>
<inputTemplate :label="label">
    <input type="text" class="form-control" :id="id" :placeholder="id" autofocus required>
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'input_text',
    props: {
        id: String,
        label: String,
    },
    components: {
        inputTemplate,
    }
}
</script>
