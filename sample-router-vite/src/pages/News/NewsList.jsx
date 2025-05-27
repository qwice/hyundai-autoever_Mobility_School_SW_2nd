import { useEffect, useState } from "react";
import ClipLoader from "react-spinners/ClipLoader";
import NewsItem from "./NewsItem";
import axios from "axios";

const NewsList = ({ category }) => {
    const [articles, setArticles] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const query =
                    category === "all" ? "all" : `category=${category}`;
                const response = await axios.get(
                    `https://newsapi.org/v2/top-headlines?country=us&${query}&apiKey=${
                        import.meta.env.VITE_NEWS_API_KEY
                    }`
                );
                setArticles(response.data.articles);
            } catch (e) {
                console.error(e);
            }
            setLoading(false);
        };
        fetchData();
    }, [category]);

    if (loading) {
        return (
            <div
                style={{
                    display: "flex",
                    justifyContent: "center",
                    marginTop: 50,
                }}
            >
                <ClipLoader color="#3498db" loading={true} size={50} />
            </div>
        );
    }

    return (
        <div style={{ minHeight: "100px", marginTop: "10px" }}>
            {articles.length === 0 ? (
                <div>기사가 없습니다.</div>
            ) : (
                articles.map((article) => (
                    <NewsItem key={article.url} article={article} />
                ))
            )}
        </div>
    );
};

export default NewsList;
