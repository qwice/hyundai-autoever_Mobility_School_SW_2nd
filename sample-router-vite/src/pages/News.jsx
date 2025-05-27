import NewsList from "./News/NewsList";
import NewsCategory from "./News/NewsCategory";
import { useCallback, useState } from "react";

const News = () => {
    const [category, setCategory] = useState("all");
    const onSelect = useCallback((category) => {
        console.log("category: ", category);
        setCategory(category);
    }, []);
    return (
        <div
            style={{
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
            }}
        >
            <NewsCategory cate={category} onSelect={onSelect}></NewsCategory>
            <NewsList category={category}></NewsList>
        </div>
    );
};
export default News;
