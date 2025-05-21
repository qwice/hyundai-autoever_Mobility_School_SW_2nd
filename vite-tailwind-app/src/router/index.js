import { createRouter, createWebHistory } from "vue-router";
import Login from "../pages/Login.vue";
import Signup from "../pages/Signup.vue";
import Layout from "../pages/Layout/Layout.vue";
import List from "../pages/Layout/List.vue";
import Empty from "../pages/Layout/Empty.vue";
import ThemeSetting from "../pages/Layout/ThemeSetting.vue";
import Tourist from "../pages/Layout/Tourist.vue";

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
        ],
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
