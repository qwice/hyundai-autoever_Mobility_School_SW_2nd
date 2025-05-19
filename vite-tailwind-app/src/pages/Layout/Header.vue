<template>
    <header
        class="bg-blue-600 text-white p-4 flex justify-between items-center"
    >
        <h1 class="text-xl font-bold cursor-pointer" @click="goHome">My App</h1>
        <nav>
            <ul class="flex space-x-4">
                <li>
                    <router-link to="/layout" class="hover:underline"
                        >list</router-link
                    >
                </li>
                <li>
                    <router-link to="/layout/empty" class="hover:underline"
                        >empty</router-link
                    >
                </li>
                <!-- <li>
                    <router-link to="/layout" class="hover:underline"
                        >메인</router-link
                    >
                </li> -->
            </ul>
        </nav>
    </header>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

function goHome() {
    router.push({ name: "Layout" });
}
</script>
