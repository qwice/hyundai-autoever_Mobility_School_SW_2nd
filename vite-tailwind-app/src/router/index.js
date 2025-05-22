import { createRouter, createWebHistory } from "vue-router";
import Login from "../pages/Login.vue";
import Signup from "../pages/Signup.vue";
import Layout from "../pages/Layout/Layout.vue";
import List from "../pages/Layout/List.vue";
import Empty from "../pages/Layout/Empty.vue";
import ThemeSetting from "../pages/Layout/ThemeSetting.vue";
import Tourist from "../pages/Layout/Tourist.vue";
import Mypage from "../pages/Layout/Mypage.vue";
import AddCategory from "../pages/Layout/AddCategory.vue";
import Board from "../pages/Layout/Board.vue";
import BoardWrite from "../pages/Layout/BoardWrite.vue";
import BoardDetailPage from "../components/board/BoardDetailPage.vue";

const routes = [
    {
        path: "/",
        name: "Login",
        component: Login,
    },
    {
        path: "/signup",
        name: "Signup",
        component: Signup,
    },
    {
        path: "/layout",
        name: "Layout",
        component: Layout,
        children: [
            {
                path: "",
                name: "List",
                component: List,
            },
            {
                path: "empty",
                name: "Empty",
                component: Empty,
            },
            {
                path: "themesetting",
                name: "ThemeSetting",
                component: ThemeSetting,
            },
            {
                path: "tourist",
                name: "tourist",
                component: Tourist,
            },
            {
                path: "mypage",
                name: "mypage",
                component: Mypage,
            },
            {
                path: "category",
                name: "category",
                component: AddCategory,
            },
            {
                path: "board",
                name: "board",
                component: Board,
            },
            {
                path: "boardWrite",
                name: "boardWrite",
                component: BoardWrite,
            },
            {
                path: "boarddetail/:id",
                name: "BoardDetail",
                component: BoardDetailPage,
            },
            {
                path: "boardwrite",
                name: "BoardWrite",
                component: BoardWrite,
            },
        ],
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
