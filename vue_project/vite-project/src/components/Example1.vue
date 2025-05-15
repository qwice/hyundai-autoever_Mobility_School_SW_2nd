<template>
    <input v-model="name" type="text" placeholder="이름 입력" />
    <input v-model.number="age" type="number" placeholder="나이 입력" />
    <p>성인 여부 : {{ isAdult ? "성인입니다." : "성인이 아닙니다." }}</p>
</template>

<script setup>
import { computed, onMounted, ref, watch } from "vue";

const name = ref("");
const age = ref(0);
// const isAdult = ref(false);
// const isAdult = computed(() => {
//     console.log(age.value > 19);
//     return age.value > 19;
// });
const isAdult = computed(() => age.value > 19);

onMounted(() => {
    alert("마운트 되었습니다.");
});

watch(age, (newVal, oldVal) => {
    console.log(`검색어 변경 : ${oldVal} > ${newVal}`);
    // if (newVal >= 20) {
    //     isAdult.value = true;
    // } else {
    //     isAdult.value = false;
    // }
});
</script>

<style scoped></style>
