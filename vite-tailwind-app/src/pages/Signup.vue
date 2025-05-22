<template>
    <div class="flex flex-col justify-center items-center h-screen box-border">
        <h1>회원가입</h1>
        <br />
        <form
            @submit.prevent="funcSignup"
            id="funcSignup"
            class="flex flex-col items-center relative"
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
                placeholder="사용하실 비밀번호를 입력해 주세요."
                v-model="pwd"
            />
            <i
                :class="pwdFontAweSome"
                class="fas w-[30px] h-[30px] flex items-center justify-center absolute left-[260px] top-[150px] -translate-y-1/2 cursor-pointer"
                id="togglePwd"
                @click="togglePassword"
            />
            <span
                id="pwPatternConfirm"
                :class="pwdColor"
                class="block w-[260px] text-right text-[12px] text-gray-400"
                >{{ pwdMsg }}</span
            >
            <br />
            <h3 class="self-start">비밀번호 확인</h3>
            <BaseInput
                :type="pwdCheckType"
                placeholder="비밀번호를 한번 더 입력해 주세요."
                v-model="pwdCheck"
            />
            <i
                :class="pwdCheckFontAweSome"
                class="flex items-center justify-center absolute fas w-[30px] h-[30px] left-[260px] top-[255px] -translate-y-1/2 cursor-pointer"
                id="togglePwdCheck"
                @click="togglePasswordCheck"
            />
            <span
                id="pwConfirm"
                :class="pwdCheckColor"
                class="block w-[250px] text-right text-[12px] text-gray-400"
                >{{ pwdCheckMsg }}</span
            >
            <br />
            <h3 class="self-start">이름</h3>
            <BaseInput
                id="name"
                type="text"
                placeholder="이름을 입력해 주세요."
                v-model="name"
            />
            <br />
            <BaseButton class="w-[130px]" type="submit">회원가입</BaseButton>
        </form>
    </div>
</template>

<script setup>
import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import { ref, watch, computed } from "vue";
// import axios from "axios";
import { useAuthApi } from "../api/auth";
import { useRouter } from "vue-router";
import { useModalStore } from "../stores/modal";

const { signup, exists } = useAuthApi();
const modal = useModalStore();

const router = useRouter();

const email = ref("");
const emailMsg = ref("이메일을 입력해 주세요.");
const pwd = ref("");
const pwdMsg = ref("8~16자의 영문 대소문자, 숫자, 특수문자(~!@#) 사용");
const pwdType = ref("password");
const pwdFontAweSome = ref("fa-eye");
const pwdCheck = ref("");
const pwdCheckMsg = ref("비밀번호를 입력하세요.");
const pwdCheckType = ref("password");
const pwdCheckFontAweSome = ref("fa-eye");
const name = ref("");

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

function isPasswordValid(pwdValue) {
    const lengthCheck = pwdValue.length >= 8 && pwdValue.length <= 16;
    const upperCaseCheck = /[A-Z]/.test(pwdValue);
    const lowerCaseCheck = /[a-z]/.test(pwdValue);
    const numberCheck = /[0-9]/.test(pwdValue);
    const specialCharCheck = /[~!@#]/.test(pwdValue);
    return (
        lengthCheck &&
        upperCaseCheck &&
        lowerCaseCheck &&
        numberCheck &&
        specialCharCheck
    );
}

watch(pwd, (newPwd) => {
    if (newPwd === "") {
        pwdMsg.value = "8~16자의 영문 대소문자, 숫자, 특수문자(~!@#) 사용";
    } else if (isPasswordValid(newPwd)) {
        pwdMsg.value = "사용 가능한 비밀번호입니다.";
    } else {
        pwdMsg.value = "비밀번호 형식이 올바르지 않습니다.";
    }
});

const pwdColor = computed(() => {
    if (pwdMsg.value === "사용 가능한 비밀번호입니다.") return "text-green-500";
    if (pwdMsg.value === "비밀번호 형식이 올바르지 않습니다.")
        return "text-red-500";
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

function togglePasswordCheck() {
    if (pwdCheckType.value === "password") {
        pwdCheckType.value = "text";
        pwdCheckFontAweSome.value = "fa-eye-slash";
    } else {
        pwdCheckType.value = "password";
        pwdCheckFontAweSome.value = "fa-eye";
    }
}

watch(pwdCheck, (newPwdCheck) => {
    if (pwd.value === "") {
        pwdCheckMsg.value = "비밀번호를 입력하세요.";
    } else if (pwd.value !== "" && pwd.value === newPwdCheck) {
        pwdCheckMsg.value = "비밀번호가 일치합니다.";
    } else {
        pwdCheckMsg.value = "비밀번호가 일치하지 않습니다.";
    }
});

const pwdCheckColor = computed(() => {
    if (pwdCheckMsg.value === "비밀번호가 일치합니다.") return "text-green-500";
    if (pwdCheckMsg.value === "비밀번호가 일치하지 않습니다.")
        return "text-red-500";
    return "text-gray-400";
});

const funcSignup = async () => {
    const emailPattern = /^[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$/;

    if (!emailPattern.test(email.value)) {
        alert("이메일 형식이 올바르지 않습니다.");
        return;
    }

    if (!isPasswordValid(pwd.value)) {
        alert("비밀번호 형식이 올바르지 않습니다.");
        return;
    }

    if (pwd.value !== pwdCheck.value) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    if (name.value.trim() === "") {
        alert("이름을 입력해 주세요.");
        return;
    }

    // try {
    //     const payload = {
    //         email: email.value,
    //         pwd: pwd.value,
    //         name: name.value,
    //     };
    //     const res = await axios.post(
    //         "http://222.117.237.119:8111/auth/signup",
    //         payload
    //     );

    //     if (res.data) {
    //         alert("회원 가입 성공");
    //         router.push("/");
    //     } else {
    //         alert("회원 가입 실패");
    //     }
    // } catch (err) {
    //     console.error(err);
    //     alert("가입 실패! 서버 오류 발생");
    // }
    const res = await signup(email.value, pwd.value, name.value);
    if (res.data) {
        if (
            modal.openA({
                title: "성공",
                msg: "회원가입 성공",
            })
        ) {
            router.push("/");
        }
    } else {
        modal.openA({
            title: "오류",
            msg: "회원가입 실패",
        });
        // alert("회원가입 실패 ");
    }
};
</script>

<style scoped></style>
