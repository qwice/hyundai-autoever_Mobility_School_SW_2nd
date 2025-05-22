<template>
    <div>
        <div
            v-for="user in users"
            :key="user.name"
            class="p-[10px] w-full flex flex-col items-center"
        >
            <MemberItem :user="user" />
        </div>
    </div>
</template>

<script setup>
import axios from "axios";
import { onMounted, ref } from "vue";
import MemberItem from "./MemberItem.vue";

const users = ref([]);

onMounted(async () => {
    try {
        const res = await axios.get("http://222.117.237.119:8111/users/list");

        if (res) {
            users.value = res.data;
        } else {
            alert("실패");
        }
    } catch (err) {
        console.err(error);
        alert("error");
    }
});
</script>

<style scoped></style>
