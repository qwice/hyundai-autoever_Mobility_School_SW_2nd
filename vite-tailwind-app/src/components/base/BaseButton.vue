<template>
    <button @click="onClick" class="border py-2 px-2 rounded-full">
        <slot>기본 버튼</slot>
    </button>
</template>

<script setup>
const emit = defineEmits(["click"]);
const onClick = (event) => {
    console.log(event);
    emit("click", event);
};
</script>

<style scoped></style>
