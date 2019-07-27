<template>
<inputTemplate :label="label">
    <input type="url" class="form-control" :id="id" :placeholder="id" autofocus required>
</inputTemplate>
</template>

<script>
import inputTemplate from '@/components/template/inputTemplate'

export default {
    name: 'input_tel',
    props: {
        id: String,
        label: String,
    },
    components: {
        inputTemplate,
    }
}
</script>
