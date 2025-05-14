<template>
    <div style="padding: 2rem">
        <h2>watch() 예제</h2>
        <input type="text" v-model="search" placeholder="검색어 입력" />
        <p>입력값 : {{ search }}</p>
        <p>최근 검색어 : {{ resent }}</p>
    </div>
</template>

<script setup>
import { onMounted, ref, watch } from "vue";
const search = ref("");
const resent = ref("");
onMounted(() => {
    console.log("컴포넌트가 마운트 됨");
});

// watch는 상태 변화를 감지 후 특정 로직을 수행
watch(search, (newVal, oldVal) => {
    console.log(`검색어 변경 : ${oldVal} > ${newVal}`);
    resent.value = newVal;
    // 서버와의 비동기 통신이 주로 이루어짐. async/await 방식
    // await를 통해서 결과가 수신되면 결과를 ref나 reactive로 만들어진 변수나 객체를 업데이트 함.
});
</script>

<style scoped>
input {
    padding: 8px;
    width: 200px;
    margin-bottom: 1rem;
}
p {
    font-size: 20px;
    margin: 4px 0;
}
</style>
