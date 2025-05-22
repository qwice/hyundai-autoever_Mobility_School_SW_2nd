<template>
    <div class="flex flex-col min-h-screen">
        <Slide />
        <Header />
        <main class="flex-grow container mx-auto p-4 pt-[60px]">
            <router-view />
        </main>
        <Footer />
    </div>
</template>

<script setup>
import Header from "./Header.vue";
import Footer from "./Footer.vue";
import { useThemeStore } from "../../stores/theme";
import Slide from "./Slide.vue";

const themeColor = useThemeStore().color;
</script>
