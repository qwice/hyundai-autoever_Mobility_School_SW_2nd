<template>
    <div class="h-screen flex justify-center items-center">
        <div
            class="flex justify-center items-center border rounded border-black w-[500px] h-[500px]"
        >
            <div class="flex flex-col justify-center items-center relative">
                <img
                    :src="
                        info.image
                            ? info.image
                            : '/src/assets/default_image.png'
                    "
                    class="w-[90px] h-[90px] object-cover rounded-full m-2"
                /><br />
                <h3 class="self-start ml-[10px]">이름</h3>
                <BaseInput
                    type="text"
                    placeholder="이름을 입력해 주세요."
                    v-model="info.name"
                    disabled
                />
                <br />
                <h3 class="self-start ml-[10px]">비밀번호 변경</h3>
                <BaseInput
                    :type="pwdType"
                    placeholder="사용하실 비밀번호를 입력해 주세요."
                    v-model="pwd"
                />
                <i
                    :class="pwdFontAweSome"
                    class="fas w-[30px] h-[30px] flex items-center justify-center absolute left-[260px] top-[262px] -translate-y-1/2 cursor-pointer"
                    id="togglePwd"
                    @click="togglePassword"
                />
                <span
                    id="pwPatternConfirm"
                    :class="pwdColor"
                    class="block w-[260px] text-right text-[12px] text-gray-400"
                    >{{ pwdMsg }}</span
                ><br />
                <h3 class="self-start ml-[10px]">비밀번호 변경 확인</h3>
                <BaseInput
                    :type="pwdCheckType"
                    placeholder="비밀번호를 한번 더 입력해 주세요."
                    v-model="pwdCheck"
                />
                <i
                    :class="pwdCheckFontAweSome"
                    class="flex items-center justify-center absolute fas w-[30px] h-[30px] left-[260px] top-[369px] -translate-y-1/2 cursor-pointer"
                    id="togglePwdCheck"
                    @click="togglePasswordCheck"
                />
                <span
                    id="pwConfirm"
                    :class="pwdCheckColor"
                    class="block w-[250px] text-right text-[12px] text-gray-400"
                    >{{ pwdCheckMsg }}</span
                >
                <BaseButton @click="infoUpdate" class="w-[100px] mt-[10px]"
                    >수정</BaseButton
                >
            </div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, reactive, ref, watch, computed } from "vue";
import axiosInstance from "../../api/axiosInstance";
import { useModalStore } from "../../stores/modal";
import BaseInput from "../../components/base/BaseInput.vue";
import BaseButton from "../../components/base/BaseButton.vue";

const modal = useModalStore();

const pwd = ref("");
const pwdMsg = ref("8~16자의 영문 대소문자, 숫자, 특수문자(~!@#) 사용");
const pwdType = ref("password");
const pwdFontAweSome = ref("fa-eye");
const pwdCheck = ref("");
const pwdCheckMsg = ref("비밀번호를 입력하세요.");
const pwdCheckType = ref("password");
const pwdCheckFontAweSome = ref("fa-eye");

const email = JSON.parse(localStorage.getItem("info")).email;
const info = reactive({
    name: "",
    email: "",
    image: "",
    pwd: "",
});

onMounted(async () => {
    const res = await axiosInstance.get(`/users/detail/${email}`);
    console.log("res :", res);
    if (res.data) {
        info.name = res.data.name;
        info.email = res.data.email;
        info.image = res.data.image;
        info.pwd = res.data.pwd;
        console.log("info: ", info);
    } else {
        modal.openA({
            title: "오류",
            msg: "오류가 발생했습니다.",
        });
    }
});

function toggleVisibility(typeRef, iconRef) {
    if (typeRef.value === "password") {
        typeRef.value = "text";
        iconRef.value = "fa-eye-slash";
    } else {
        typeRef.value = "password";
        iconRef.value = "fa-eye";
    }
}

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
    toggleVisibility(pwdType, pwdFontAweSome);
}

function togglePasswordCheck() {
    toggleVisibility(pwdCheckType, pwdCheckFontAweSome);
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

const infoUpdate = async () => {
    if (!isPasswordValid(pwd.value)) {
        alert("비밀번호 형식이 올바르지 않습니다.");
        return;
    }

    if (!pwd.value && pwd.value !== info.pwd) {
        info.pwd = pwd.value;
    }

    try {
        const res = await axiosInstance.put("/users/modify", info);
        console.log(res);
        if (res.data) {
            if (
                modal.openA({
                    title: "성공",
                    msg: "수정이 완료되었습니다.",
                })
            ) {
                pwd.value = "";
                pwdCheck.value = "";
            }
        } else {
            if (
                modal.openA({
                    title: "실패",
                    msg: "수정에 실패하였습니다.",
                })
            ) {
                pwd.value = "";
                pwdCheck.value = "";
            }
        }
    } catch (err) {
        console.error(err);
    }
};
</script>

<style scoped></style>
