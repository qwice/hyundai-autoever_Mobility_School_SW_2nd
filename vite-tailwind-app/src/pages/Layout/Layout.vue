<template>
    <div class="flex flex-col min-h-screen">
        <Header />
        <main class="flex-grow container mx-auto p-4">
            <router-view />
        </main>
        <Footer />
    </div>
</template>

<script setup>
import Header from "./Header.vue";
import Footer from "./Footer.vue";
</script>
