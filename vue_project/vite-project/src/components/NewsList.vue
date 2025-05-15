<template>
    <div v-for="item in items" :key="item.title">
        <NewsItem :item="item" />
    </div>
</template>

<script setup>
import NewsItem from "./NewsItem.vue";
const props = defineProps({
    items: Object,
});
</script>

<style scoped></style>
