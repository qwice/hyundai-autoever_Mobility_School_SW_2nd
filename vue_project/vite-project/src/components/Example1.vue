<template>
    <input v-model="name" type="text" placeholder="이름 입력" />
    <input v-model.number="age" type="number" placeholder="나이 입력" />
    <p>성인 여부 : {{ isAudlt ? "성인입니다." : "성인이 아닙니다." }}</p>
</template>

<script setup>
import { computed, onMounted, ref, watch } from "vue";

const name = ref("");
const age = ref(0);
const isAudlt = ref(false);

onMounted(() => {
    alert("마운트 되었습니다.");
});

watch(age, (newVal, oldVal) => {
    console.log(`검색어 변경 : ${oldVal} > ${newVal}`);
    if (newVal >= 20) {
        isAudlt.value = true;
    } else {
        isAudlt.value = false;
    }
});
</script>

<style scoped></style>
