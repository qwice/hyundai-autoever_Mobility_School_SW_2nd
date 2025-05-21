import { createApp } from "vue";
// import './style.css'
import App from "./App.vue";
import "./assets/tailwind.css";

// 라우터 설정
import router from "./router";

// 전역 상태 관리
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

//pinia 플러그인 연결
const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

createApp(App).use(router).use(pinia).mount("#app");
