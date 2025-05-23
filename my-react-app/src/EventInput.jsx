import { useState } from "react";

const EventInput = () => {
    const [msg, setMsg] = useState("안녕하세요");
    const changeMsg = (e) => {
        setMsg(e.target.value);
    };

    return (
        <>
            <input placeholder="인사말 입력" onChange={changeMsg} value={msg} />
            {/* <input
                placeholder="인사말 입력"
                onChange={(e) => changeMsg(e)}
                value={msg}
            /> */}
            <h2>입력 받은 메세지 : {msg}</h2>
        </>
    );
};

export default EventInput;
