<template>
    <!-- <div class="card">
        <h2>이름 : {{ name }}</h2>
        <p>직업 : {{ job }}</p>
        <p>나이 : {{ age }}</p>
    </div> -->
    <div class="card" v-for="user in users" :key="user.name">
        <h2>이름 : {{ user.name }}</h2>
        <p>직업 : {{ user.job }}</p>
        <p>나이 : {{ user.age }}</p>
    </div>
</template>

<script setup>
// const props = defineProps({
//     name: String,
//     job: String,
//     age: Number,
// });
// defineProps({
//     name: String,
//     job: String,
//     age: Number,
// });
defineProps({
    users: Object,
});
</script>

<style scoped>
.card {
    border: 1px solid #ccc;
    padding: 1rem;
    border-radius: 8px;
}
</style>
