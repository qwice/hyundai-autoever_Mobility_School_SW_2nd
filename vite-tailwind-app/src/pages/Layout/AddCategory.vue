<template>
    <CateTemplate>
        <CateInsert @insert="onInsert" />
        <CateList :cates="categories" @remove="onRemove" />
    </CateTemplate>
</template>

<script setup>
import { ref, onMounted } from "vue";
import CateInsert from "../../components/category/CateInsert.vue";
import CateList from "../../components/category/CateList.vue";
import CateTemplate from "../../components/category/CateTemplate.vue";
import { useBoardApi } from "../../api/board";
const { cateList, cateInsert, cateDelete } = useBoardApi();
import { useModalStore } from "../../stores/modal";
const email = JSON.parse(localStorage.getItem("info")).email;
const categories = ref([]);
const selectedCategoryId = ref(null);
const modal = useModalStore();

const loadCategory = async () => {
    const res = await cateList();
    console.log("catelist:", res);
    categories.value = res.data;
};

onMounted(loadCategory);

const onInsert = async (text) => {
    try {
        const res = await cateInsert(email, text);
        console.log(res);
        if (res.data) await loadCategory();
    } catch (error) {
        modal.openA({
            title: "오류",
            message: "카테고리 추가에 실패했습니다.",
        });
    }
};

const onRemove = (id) => {
    selectedCategoryId.value = id;
    if (
        modal.openB({
            title: "오류",
            message: "카테고리를 정말 삭제하시겠습니까?",
        })
    ) {
        confirmModal();
    }
};

const confirmModal = async () => {
    try {
        const res = await cateDelete(selectedCategoryId.value);
        if (res.data) await loadCategory();
    } catch (error) {
        modal.openA({
            title: "오류",
            message: "카테고리 삭제에 실패했습니다.",
        });
    }
};
</script>
