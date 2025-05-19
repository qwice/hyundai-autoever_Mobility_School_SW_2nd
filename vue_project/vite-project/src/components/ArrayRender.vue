<template>
    <!-- <ul>
        <li v-for="user in users" :key="user.id">
            이름 : {{ user.userName }}, 이메일 : {{ user.email }}
        </li>
    </ul> -->
    <!-- <input v-model="inputText" type="text" @keydown.enter="addTodo" /> -->
    <input
        v-model="inputText"
        type="text"
        @dblclick="() => removeTodo(user.id)"
    />
    <button @click="addTodo">추가</button>
    <ul>
        <li v-for="user in users" :key="user.id">
            {{ user.toDo }}
        </li>
    </ul>
</template>

<script setup>
import { ref, watch } from "vue";

// const user = [
//     { id: 1, userName: "지훈", email: "test1@test.com" },
//     { id: 2, userName: "마리", email: "test2@test.com" },
//     { id: 3, userName: "민혁", email: "test3@test.com" },
// ];

// const users = ref([
//     { id: 1, toDo: "HTML 공부" },
//     { id: 2, toDo: "CSS 공부" },
// ]);

const inputText = ref("");
const nextId = ref(3);

const addTodo = () => {
    if (!inputText.value.trim()) return;
    users.value.push({ id: nextId.value++, userName: inputText.value });
    inputText.value = "";
};

const removeTodo = (id) => {
    users.value = users.value.filter((user) => user.id !== id);
};

const stored = localStorage.getItem("users");
const users = ref(
    stored
        ? JSON.parse(stored)
        : [
              { id: 1, toDo: "HTML 공부" },
              { id: 2, toDo: "CSS 공부" },
          ]
);

watch(
    users,
    (newVal) => {
        localStorage.setItem("users", JSON.stringify(newVal));
    },
    { deep: true }
);
</script>

<style lang="scss" scoped></style>
