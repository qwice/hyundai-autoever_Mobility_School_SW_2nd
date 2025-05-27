import "./App.css";
import Members from "./Members";
import Say from "./Say";
import EventInput from "./EventInput";
import TableMap from "./TableMap";
import NameCard from "./NameCard";
import Info from "./Info";
import Clock from "./Clock";
import Counter from "./Counter";
import Average from "./Average";
import RefCnt from "./RefCnt";

function App() {
    // const name = "name";
    // 구조 분해 또는 비구조화 할당
    // const {name, age, addr="서울", isAdult} = props;
    return (
        <>
            <h3>App.js 입니다.</h3>
            <Members name="안유진" age={23} addr="대전" isAdult={true} />
            <Say />
            {/* <h3>안녕하세요. {name}님</h3> */}
            {/* <br /> */}
            {/* {name == "리액트" ? <h3>환영합니다. 리액트 님.</h3> : <h3>고객 아님</h3>} */}
            {/* {name == "리액트" && <h3>환영합니다. 리액트 님.</h3>} */}
            <EventInput />
            <TableMap />
            <NameCard />
            <Info />
            <Clock />
            <Counter />
            <Average />
            <RefCnt />
        </>
    );
}

export default App;
