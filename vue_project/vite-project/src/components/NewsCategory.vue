<template>
    <button @click="state">전체</button>
    <button @click="state">정치</button>
    <button @click="state">경제</button>
    <button @click="state">사회</button>
    <button @click="state">문화</button>
    <button @click="state">과학</button>
</template>

<script setup>
const emit = defineEmits(["state"]);
const state = (e) => {
    emit("state", e.target.textContent);
};
</script>

<style scoped>
button {
    padding: 30px;
}
</style>
