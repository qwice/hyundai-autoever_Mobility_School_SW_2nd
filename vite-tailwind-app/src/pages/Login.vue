<template>
    <div class="flex flex-col justify-center items-center h-screen">
        <img
            src="https://www.starbucks.co.kr/common/img/common/logo.png"
            class="w-[75px] h-[75px] mb-[20px]"
        />
        <form
            @submit.prevent="login"
            id="signup"
            class="flex flex-col items-center"
        >
            <h3 class="self-start">아이디</h3>
            <BaseInput
                type="email"
                placeholder="이메일을 입력해 주세요"
                v-model="email"
            />
            <span
                id="idConfirm"
                :class="emailColor"
                class="block w-[250px] text-right text-[12px] text-gray-400"
                >{{ emailMsg }}</span
            >
            <br />
            <h3 class="self-start">비밀번호</h3>
            <BaseInput
                :type="pwdType"
                placeholder="비밀번호를 입력하세요"
                v-model="pwd"
            />
            <i
                :class="pwdFontAweSome"
                class="fas w-[30px] h-[30px] relative left-[150px] bottom-[13px] -translate-y-1/2 cursor-pointer"
                id="togglePwd"
                @click="togglePassword"
            ></i>
            <nav>
                <router-link to="/signup">Sign up</router-link>
            </nav>
            <BaseButton class="w-[130px]" type="submit">로그인</BaseButton>
        </form>
    </div>
</template>

<script setup>
import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import { ref, watch, computed } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { useModalStore } from "../stores/modal";

const modal = useModalStore();

const router = useRouter();

const email = ref("");
const emailMsg = ref("이메일을 입력해 주세요.");
const pwd = ref("");
const pwdType = ref("password");
const pwdFontAweSome = ref("fa-eye");
const pwdCheckType = ref("password");

watch(email, (newEmail) => {
    const pattern = /^[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$/;

    if (newEmail === "") {
        emailMsg.value = "이메일을 입력해 주세요.";
    } else if (!pattern.test(newEmail)) {
        emailMsg.value = "이메일 형식이 아닙니다.";
    } else {
        emailMsg.value = "올바른 이메일 형식입니다.";
    }
});

const emailColor = computed(() => {
    if (emailMsg.value === "올바른 이메일 형식입니다.") return "text-green-500";
    if (emailMsg.value === "이메일 형식이 아닙니다.") return "text-red-500";
    return "text-gray-400";
});

function togglePassword() {
    if (pwdType.value === "password") {
        pwdType.value = "text";
        pwdFontAweSome.value = "fa-eye-slash";
    } else {
        pwdType.value = "password";
        pwdFontAweSome.value = "fa-eye";
    }
}

const login = async () => {
    const emailPattern = /^[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$/;

    if (!emailPattern.test(email.value)) {
        alert("이메일 형식이 올바르지 않습니다.");
        return;
    }

    try {
        const payload = {
            email: email.value,
            pwd: pwd.value,
        };
        const res = await axios.post(
            "http://222.117.237.119:8111/auth/login",
            payload
        );

        if (res.data) {
            const detail = await axios.get(
                `http://222.117.237.119:8111/users/detail/${payload.email}`
            );
            console.log("detail : ", detail);
            localStorage.setItem("name", detail.data.name);
            console.log("name : ", localStorage.getItem("name"));
            //alert("로그인 성공");
            if (
                await modal.openA({
                    title: "성공",
                    msg: "로그인에 성공하셨습니다.",
                })
            ) {
                router.push("/Layout");
            }
        } else {
            modal.openB({
                title: "실패",
                msg: "로그인에 실패하셨습니다.",
            });
            //alert("로그인 실패");
        }
    } catch (err) {
        console.error(err);
        modal.openA({
            title: "오류",
            msg: "서버에 오류가 발생했습니다.",
        });
        //alert("로그인 실패! 서버 오류 발생");
    }
};
</script>

<style scoped></style>
