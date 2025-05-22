<template>
    <header
        class="bg-blue-600 text-white p-4 flex justify-between items-center fixed w-full z-50"
    >
        <h1 class="text-xl font-bold cursor-pointer" @click="goHome">My App</h1>
        <nav>
            <ul class="flex space-x-4">
                <li class="text-black font-bold">{{ name }}님</li>
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
                <li>
                    <router-link
                        to="/layout/themesetting"
                        class="hover:underline"
                        >theme</router-link
                    >
                </li>
                <li>
                    <router-link to="/layout/tourist" class="hover:underline"
                        >관광지</router-link
                    >
                </li>
                <li>
                    <router-link to="/layout/mypage" class="hover:underline"
                        >마이페이지</router-link
                    >
                </li>
                <li>
                    <router-link
                        to="/"
                        class="text-red-600 font-bold hover:underline"
                        @click="logout"
                        >로그아웃</router-link
                    >
                </li>
            </ul>
        </nav>
    </header>
</template>

<script setup>
import { useRouter } from "vue-router";
const name = JSON.parse(localStorage.getItem("info")).name;

const router = useRouter();

function goHome() {
    router.push("/Layout");
}

const logout = () => {
    localStorage.removeItem("name");
};
</script>
