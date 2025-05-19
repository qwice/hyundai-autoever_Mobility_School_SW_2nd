<template>
    <div class="w-3/4 border rounded-[10px] h-[90px] flex flex-row">
        <img
            :src="user.image ? user.image : 'src/assets/default_image.png'"
            class="w-[70px] h-[70px] object-cover rounded-full m-2"
        />
        <div class="flex flex-col justify-center">
            <p class="pl-[10px]">이름 : {{ user.name }}</p>
            <p class="pl-[10px]">이메일 : {{ user.email }}</p>
        </div>
    </div>
</template>

<script setup>
const props = defineProps({
    user: Object,
});
</script>

<style scoped></style>
