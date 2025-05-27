import { Outlet } from "react-router-dom";

const Layout = () => {
    return (
        <div style={styles.container}>
            <header style={styles.header}>Header</header>
            <main style={styles.main}>
                <Outlet />
            </main>
            <footer style={styles.footer}>여기는 풋터입니다.</footer>
        </div>
    );
};

const styles = {
    container: {
        display: "flex",
        flexDirection: "column",
        minHeight: "100vh", // 화면 전체 높이
        margin: "0",
        padding: "0",
    },
    header: {
        background: "lightgray",
        padding: "16px",
        fontSize: "24px",
    },
    main: {
        flex: 1, // 남은 공간을 main이 모두 차지
        overflowY: "auto", // 내용이 많으면 스크롤
        padding: "16px",
        background: "gray",
    },
    footer: {
        background: "lightgray",
        padding: "16px",
        fontSize: "24px",
    },
};

export default Layout;
