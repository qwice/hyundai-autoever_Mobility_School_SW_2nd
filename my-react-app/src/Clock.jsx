import { useEffect, useState } from "react";

const Clock = () => {
    const [time, setTime] = useState(new Date());
    // ⬇️ useEffect 안에서 setInterval 설정
    useEffect(() => {
        const interval = setInterval(() => {
            setTime(new Date()); // 1초마다 시간 업데이트
            console.log("interveal start");
        }, 1000);

        // 🧹 clean-up 함수 (타이머 제거)
        return () => {
            clearInterval(interval);
            console.log("interval end");
        };
    }, []); // ✅ [] = 처음에 딱 한 번만 실행
    return (
        <>
            <h2>현재 시간 : {time.toLocaleTimeString()}</h2>
        </>
    );
};

export default Clock;
