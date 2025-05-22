<template>
    <li
        class="bg-gray-100 p-4 rounded-lg shadow mb-4 flex items-center cursor-pointer hover:bg-gray-200"
    >
        <img
            :src="board.img || 'http://via.placeholder.com/160'"
            alt="board image"
            class="w-28 h-28 rounded mr-4"
        />
        <div class="flex flex-col flex-1">
            <div class="flex justify-between">
                <h2 class="text-lg font-bold text-blue-500">
                    {{ board.title }}
                </h2>
                <span class="text-sm italic text-gray-600">{{
                    board.email
                }}</span>
            </div>
            <p class="text-sm text-gray-700 mt-2">{{ board.content }}</p>
            <p class="text-right text-xs text-gray-500">
                {{ timeFromNow(board.regDate) }}
            </p>
        </div>
    </li>
</template>

<script setup>
import { timeFromNow } from "@/utils/commons";
const props = defineProps({ board: Object });
</script>
