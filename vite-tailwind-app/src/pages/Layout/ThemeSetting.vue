<template>
    <div>
        <h1>테마 색상 선택</h1>
        <BaseButton
            v-for="color in colors"
            :key="color"
            @click="setColor(color)"
            class="w-[100px] mr-[10px]"
            :style="{ backgroundColor: color }"
            >{{ color }}</BaseButton
        >
    </div>
</template>

<script setup>
import BaseButton from "../../components/base/BaseButton.vue";
import { useThemeStore } from "../../stores/theme";

const themeStore = useThemeStore();
const setColor = themeStore.setColor;
const colors = ["orange", "green", "lightgray", "grey", "royalblue", "white"];
</script>

<style scoped></style>
