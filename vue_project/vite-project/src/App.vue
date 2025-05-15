<script setup>
import DataBinding from "./components/DataBinding.vue";
import ConditonRender from "./components/ConditonRender.vue";
import IterableArray from "./components/IterableArray.vue";
import ClassBinding from "./components/ClassBinding.vue";
import Reactive from "./components/Reactive.vue";
import Computed from "./components/Computed.vue";
import Watch from "./components/Watch.vue";
import Example1 from "./components/Example1.vue";
import Card from "./components/Card.vue";
import UserCard from "./components/UserCard.vue";
import ChildComponent from "./components/ChildComponent.vue";
import News from "./components/News.vue";
import { reactive, ref } from "vue";
// const inputName = ref("");
// const job = ref("");
// const age = ref();

// card, usercard, useritem
// const member = reactive([
//     {
//         name: "1",
//         job: "1",
//         age: 1,
//     },
//     {
//         name: "2",
//         job: "2",
//         age: 2,
//     },
//     {
//         name: "3",
//         job: "3",
//         age: 3,
//     },
//     {
//         name: "4",
//         job: "4",
//         age: 4,
//     },
//     {
//         name: "5",
//         job: "5",
//         age: 5,
//     },
//     {
//         name: "6",
//         job: "6",
//         age: 6,
//     },
//     {
//         name: "7",
//         job: "7",
//         age: 7,
//     },
//     {
//         name: "8",
//         job: "8",
//         age: 8,
//     },
//     {
//         name: "9",
//         job: "9",
//         age: 9,
//     },
//     {
//         name: "10",
//         job: "10",
//         age: 10,
//     },
// ]);

// childcomponent
// const message = ref("");
// const handleMessage = (payload) => {
//     message.value = payload;
// };
</script>

<template>
    <h3>App.vue 영역 입니다.</h3>
    <!-- <input v-model="inputName" type="text" placeholder="이름" /> -->
    <!-- <input v-model="member.name" type="text" placeholder="이름" /> -->
    <!-- <br /> -->
    <!-- <input v-model="job" type="text" placeholder="직업" /> -->
    <!-- <input v-model="member.job" type="text" placeholder="직업" /> -->
    <!-- <br /> -->
    <!-- <input v-model.number="age" type="number" placeholder="나이" /> -->
    <!-- <input v-model.number="member.age" type="number" placeholder="나이" /> -->
    <!-- <br /> -->
    <!-- <DataBinding />
    <ConditonRender />
    <IterableArray /> -->
    <!-- <ClassBinding /> -->
    <!-- <Reactive /> -->
    <!-- <Computed /> -->
    <!-- <Watch /> -->
    <!-- <Example1 /> -->
    <!-- <Card :name="inputName" :job="job" :age="age" /> -->
    <!-- <Card :name="member.name" :job="member.job" :age="member.age" /> -->
    <!-- <Card :users="member" /> -->
    <!-- <UserCard /> -->

    <!-- <div>{{ message }}</div>
    <ChildComponent @send-message="handleMessage" /> -->
    <News />
</template>

<style scoped>
h1 {
    font-size: 30px;
    color: royalblue;
}
input {
    padding: 8px;
    font-size: 18px;
    margin-top: 10px;
}
</style>
