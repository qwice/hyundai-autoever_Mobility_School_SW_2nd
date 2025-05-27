import { useEffect, useRef, useState } from "react";

const RefCnt = () => {
    const cntRef = useRef(0);
    let cntTest = 0;
    const [flag, setFlag] = useState(false);

    const increamentCnt = () => {
        cntRef.current += 1;
        cntTest += 1;
        setFlag(!flag);
    };

    console.log("Ref Cnt : ", cntRef);
    console.log("let cnt : ", cntTest);

    useEffect(() => {
        const interval = setInterval(increamentCnt, 1000);
        return () => clearInterval(interval);
    });

    return (
        <>
            <h3>count 연습</h3>
            <p>콘솔창에서 값 확인</p>
        </>
    );
};

export default RefCnt;
