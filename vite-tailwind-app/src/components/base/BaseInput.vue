<template>
    <input
        class="w-[250px] h-[40px] border border-solid rounded-sm pl-3"
        :type="type"
        :placeholder="placeholder"
        :value="modelValue"
        @input="$emit('update:modelValue', $event.target.value)"
    />
</template>

<script setup>
defineProps({
    type: {
        type: String,
        default: "",
    },
    placeholder: {
        type: String,
        default: "",
    },
    modelValue: {
        type: [String, Number],
        default: "",
    },
});

defineEmits(["update:modelValue"]);
</script>
