import { useContext } from "react";
import { UserContext } from "../store/UserStore";
import { useNavigate } from "react-router-dom";

const Signup = () => {
    const { userId, setUserId, userPwd, setUserPwd } = useContext(UserContext);
    const navigate = useNavigate();
    const inputId = (e) => {
        console.log("signup e : ", e.target.value);
        setUserId(e.target.value);
    };
    const inputPwd = (e) => {
        console.log("signup pE : ", e.target.value);
        setUserPwd(e.target.value);
    };
    const signup = () => {
        localStorage.setItem("id", userId);
        localStorage.setItem("pwd", userPwd);
        navigate("/");
    };
    return (
        <>
            <input
                type="text"
                id="id"
                name="id"
                placeholder="이메일을 입력하세요."
                onChange={inputId}
            />
            <input
                type="password"
                id="pwd"
                name="pwd"
                placeholder="비밀번호를 입력하세요."
                onChange={inputPwd}
            />
            <button onClick={() => signup()}>회원가입하기</button>
        </>
    );
};

export default Signup;
