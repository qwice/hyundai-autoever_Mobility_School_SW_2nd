import "./App.css";
import About from "./pages/About";
import Home from "./pages/Home";
import Profile from "./pages/Profile";
import Layout from "./pages/Layout";
import News from "./pages/News";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
    return (
        <Router>
            <Routes>
                <Route element={<Layout />}>
                    <Route path="/" element={<Home />} />
                    <Route path="/About" element={<About />} />
                    <Route path="/profiles/:username" element={<Profile />} />
                    <Route path="/news" element={<News />} />
                </Route>
            </Routes>
        </Router>
    );
}

// import React, { useState, useCallback } from "react";

// const Button = React.memo(({ onClick, children }) => {
//     console.log("onClick", onClick);
//     console.log("Button 렌더링:", children);
//     return <button onClick={onClick}>{children}</button>;
// });

// function App() {
//     const [count, setCount] = useState(0);

//     // useCallback 없으면 함수가 매번 새로 만들어짐 → Button 재렌더링
//     const increment = useCallback(() => {
//         setCount((c) => c + 1);
//     }, []);

//     // const increment = () => {
//     //     setCount((c) => c + 1);
//     // };

//     return (
//         <div>
//             <p>Count: {count}</p>
//             <Button onClick={increment}>증가</Button>
//         </div>
//     );
// }
export default App;
