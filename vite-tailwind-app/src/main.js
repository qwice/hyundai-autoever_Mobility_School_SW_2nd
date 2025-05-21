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

// kakao env
const kakaoScript = document.createElement("script");
kakaoScript.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${
    import.meta.env.VITE_KAKAO_JS_KEY
}&autoload=false`;
kakaoScript.onload = () => {
    // 스크립트가 완전히 로드된 후에 앱 마운트
    createApp(App).use(router).use(pinia).mount("#app");
};
document.head.appendChild(kakaoScript);
