<template>
    <div class="max-w-2xl mx-auto p-6 bg-green-200 rounded shadow">
        <!-- 상단 작성자 정보 영역 -->
        <div class="flex items-center justify-between mb-4">
            <!-- 왼쪽: 이미지 + 제목/내용 -->
            <div class="flex items-center gap-4">
                <img
                    :src="board.img || '/src/assets/default_image.png'"
                    alt="작성자 이미지"
                    class="w-24 h-24 rounded"
                />
                <div>
                    <h2 class="text-xl font-bold text-gray-800">
                        {{ board.title }}
                    </h2>
                    <p class="text-gray-700">{{ board.content }}</p>
                </div>
            </div>

            <!-- 오른쪽: 작성 시간 -->
            <p class="text-sm text-gray-600">{{ formatTime(board.regDate) }}</p>
        </div>

        <!-- 댓글 보기/숨기기 + 삭제 버튼 -->
        <div class="flex justify-center gap-2 mb-4">
            <button
                @click="toggleComments"
                class="bg-green-500 text-white px-4 py-1 rounded"
            >
                {{
                    showComments
                        ? "댓글 숨기기"
                        : `댓글 ${comments.length}개 보기`
                }}
            </button>
            <button
                v-if="email === board.email"
                @click="deleteBoard"
                class="bg-green-500 text-white px-4 py-1 rounded"
            >
                삭제
            </button>
        </div>

        <!-- 댓글 입력 -->
        <CommentForm :boardId="route.params.id" @comment-added="loadComments" />

        <!-- 댓글 목록 -->
        <CommentList v-if="showComments" :comments="comments" />
    </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useBoardApi } from "../../api/board";
import CommentForm from "../comment/CommentForm.vue";
import CommentList from "../comment/CommentList.vue";

const { boardDetail, commentList, boardDelete } = useBoardApi();

const board = ref({});
const comments = ref([]);
const route = useRoute();
const router = useRouter();
const showComments = ref(false);
const email = JSON.parse(localStorage.getItem("info")).email;

const loadBoard = async () => {
    const res1 = await boardDetail(route.params.id);
    board.value = res1.data;
    const res2 = await commentList(route.params.id);
    comments.value = res2.data;
};

const loadComments = async () => {
    const res = await commentList(route.params.id);
    comments.value = res.data;
};

const toggleComments = () => {
    showComments.value = !showComments.value;
    if (showComments.value) loadComments();
};

const deleteBoard = async () => {
    if (confirm("정말 삭제하시겠습니까?")) {
        await boardDelete(route.params.id);
        alert("삭제되었습니다.");
        router.push("/layout/board"); // 게시판 목록 경로로 수정
    }
};

const formatTime = (iso) =>
    new Date(iso).toLocaleString("ko-KR", {
        year: "numeric",
        month: "2-digit",
        day: "2-digit",
        hour: "2-digit",
        minute: "2-digit",
    });

onMounted(() => {
    loadBoard();
});
</script>
