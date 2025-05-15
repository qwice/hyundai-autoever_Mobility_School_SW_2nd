<template>
    <div>
        <p>제목 : {{ item.title }}</p>
        <p>내용 : {{ item.content }}</p>
        <p>일자 : {{ item.date }}</p>
        <p>분류 : {{ item.category }}</p>
    </div>
</template>

<script setup>
const props = defineProps({
    item: Object,
});
</script>

<style scoped>
div {
    width: 500px;
    margin: 10px;
    padding: 10px;
    border: 1px solid black;
    border-radius: 10px;
}
</style>
