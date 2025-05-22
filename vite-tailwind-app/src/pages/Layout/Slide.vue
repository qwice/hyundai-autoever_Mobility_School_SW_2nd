<template>
    <div>
        <!-- 어두운 배경 오버레이 -->
        <transition name="fade">
            <div
                v-if="menuOpen"
                class="fixed inset-0 bg-black bg-opacity-50 z-[90]"
                @click="toggleMenu"
            />
        </transition>

        <!-- 햄버거 버튼 -->
        <button
            @click="toggleMenu"
            class="fixed top-[76px] left-4 focus:outline-none text-2xl font-bold z-[110]"
            aria-label="메뉴 토글"
        >
            <i :class="menuOpen ? 'fas fa-times' : 'fas fa-bars'"></i>
        </button>

        <!-- 슬라이드 메뉴 -->
        <transition name="slide">
            <nav
                v-if="menuOpen"
                class="fixed top-[60px] left-0 w-[220px] h-full bg-gray-800 text-white shadow-lg z-[100]"
            >
                <ul class="p-6 space-y-6 mt-10">
                    <li v-for="item in menuItems" :key="item.name">
                        <a
                            href="#"
                            @click.prevent="navigate(item.path)"
                            class="block hover:bg-gray-700 rounded px-4 py-2 transition"
                        >
                            {{ item.name }}
                        </a>
                    </li>
                </ul>
            </nav>
        </transition>
    </div>
</template>

<script setup>
import { ref } from "vue";
import router from "../../router";

const menuOpen = ref(false);
const toggleMenu = () => {
    menuOpen.value = !menuOpen.value;
};
const menuItems = [
    { name: "홈", path: "/layout" },
    { name: "마이페이지", path: "/layout/mypage" },
    { name: "카테고리", path: "/layout/category" },
    { name: "게시판", path: "/layout/board" },
];
const navigate = (path) => {
    menuOpen.value = false;
    router.push(path);
};
</script>

<style scoped>
.slide-enter-active,
.slide-leave-active {
    transition: transform 0.3s ease;
}
.slide-enter-from,
.slide-leave-to {
    transform: translateX(-100%);
}
.slide-enter-to,
.slide-leave-from {
    transform: translateX(0%);
}

.fade-enter-active,
.fade-leave-active {
    transition: opacity 0.3s ease;
}
.fade-enter-from,
.fade-leave-to {
    opacity: 0;
}
.fade-enter-to,
.fade-leave-from {
    opacity: 1;
}
</style>
