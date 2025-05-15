<template>
    <div class="container">
        <h2>회원정보</h2>
        <UserItem v-for="user in users" :key="user.name" :user="user" />
    </div>
</template>

<script setup>
import { onMounted, reactive } from "vue";
import UserItem from "./UserItem.vue";

const users = reactive([]);

const fetchedData = [
    { name: "1", age: 1, address: "1", isAdult: true },
    { name: "2", age: 2, address: "2", isAdult: true },
    { name: "3", age: 3, address: "3", isAdult: true },
    { name: "4", age: 4, address: "4", isAdult: true },
    { name: "5", age: 5, address: "5", isAdult: true },
    { name: "6", age: 6, address: "6", isAdult: true },
    { name: "7", age: 7, address: "7", isAdult: true },
    { name: "8", age: 8, address: "8", isAdult: true },
    { name: "9", age: 9, address: "9", isAdult: true },
];

// 화면이 처음 나타나는 시점
onMounted(() => {
    // 서버로 데이터를 요청하고 데이터가 전달되면 아래의 동작 수행, async/await
    users.push(...fetchedData);
});
</script>

<style scoped>
.container {
    width: 500px;
    margin: 40px auto;
    text-align: center;
    background-color: antiquewhite;
}
</style>
