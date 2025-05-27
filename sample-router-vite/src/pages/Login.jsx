import { useContext, useState } from "react";
import { UserContext } from "../store/UserStore";
import { Link, useNavigate } from "react-router-dom";

const Login = () => {
    const [id, setId] = useState("");
    const [pwd, setPwd] = useState("");
    const { userId, userPwd } = useContext(UserContext);
    const navigate = useNavigate();

    const inputId = (e) => {
        console.log("e : ", e.target.value);
        setId(e.target.value);
    };
    const inputPwd = (e) => {
        console.log("pE : ", e.target.value);
        setPwd(e.target.value);
    };
    const check = () => {
        if (id === userId && pwd === userPwd) navigate("/home");
        else alert("아이디 또는 비밀번호가 맞지 않습니다.");
    };
    return (
        <>
            <input
                type="text"
                id="id"
                name="id"
                placeholder="이메일을 입력하세요"
                onChange={inputId}
            />
            <input
                type="password"
                id="pwd"
                name="pwd"
                placeholder="비밀번호를 입력하세요"
                onChange={inputPwd}
            />
            <button onClick={() => check()}>로그인</button>
            <Link to="/signup">회원가입하기</Link>
        </>
    );
};
export default Login;
