<template>
    <div class="px-8 pb-40 relative">
        <h1 class="text-center text-2xl font-bold text-gray-800">
            게시판 목록
        </h1>
        <select
            class="border rounded px-4 py-2 mt-6 mb-4 w-52"
            v-model="selectedCategory"
        >
            <option value="all">전체</option>
            <option
                v-for="category in categories"
                :key="category.categoryId"
                :value="category.categoryId"
            >
                {{ category.categoryName }}
            </option>
        </select>

        <ul>
            <li
                v-for="board in boardList"
                :key="board.boardId"
                @click="goDetail(board.boardId)"
                class="bg-gray-100 p-4 rounded-lg shadow mb-4 flex items-center cursor-pointer hover:bg-gray-200"
            >
                <img
                    :src="board.img || '/src/assets/default_image.png'"
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
                    <p class="text-sm text-gray-700 mt-2">
                        {{ board.content }}
                    </p>
                    <p class="text-right text-xs text-gray-500">
                        <!-- {{ timeFromNow(board.regDate) }} -->
                    </p>
                </div>
            </li>
        </ul>

        <button
            @click="goWrite"
            class="fixed bottom-6 right-8 bg-sky-500 hover:bg-sky-600 text-white rounded-full w-14 h-14 text-3xl shadow-lg"
        >
            +
        </button>
    </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { useRouter } from "vue-router";
import { useBoardApi } from "../../api/board";

// ✅ dayjs 관련 설정
// import dayjs from "dayjs";
// import relativeTime from "dayjs/plugin/relativeTime";
// import "dayjs/locale/ko";
// dayjs.extend(relativeTime);
// dayjs.locale("ko");

// ✅ 내부에서 상대 시간 포맷 함수 구현
// const timeFromNow = (dateStr) => dayjs(dateStr).fromNow();

const { cateList, boardList: fetchBoardList } = useBoardApi();
const categories = ref([]);
const boardList = ref([]);
const selectedCategory = ref("all");
const router = useRouter();

onMounted(async () => {
    const res = await cateList();
    categories.value = res.data;
    await loadBoardList();
});

watch(selectedCategory, async () => {
    await loadBoardList();
});

const loadBoardList = async () => {
    const res = await fetchBoardList();
    boardList.value =
        selectedCategory.value === "all"
            ? res.data
            : res.data.filter(
                  (board) =>
                      board.categoryId === parseInt(selectedCategory.value)
              );
};

const goWrite = () => router.push("/layout/boardwrite");
const goDetail = (id) => router.push(`/layout/boarddetail/${id}`);
</script>
