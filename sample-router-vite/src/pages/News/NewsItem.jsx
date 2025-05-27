import React from "react";

const NewsItem = React.memo(({ article }) => {
    const { title, description, url, urlToImage } = article;

    return (
        <div style={styles.item}>
            {urlToImage && (
                <div>
                    <img
                        src={urlToImage}
                        alt="thumbnail"
                        style={{ width: "200px", objectFit: "cover" }}
                    />
                </div>
            )}
            <div style={styles.contents}>
                <h2>
                    <a href={url} target="_blank" rel="noopener noreferrer">
                        {title}
                    </a>
                </h2>
                <p>{description}</p>
            </div>
        </div>
    );
});

const styles = {
    item: {
        display: "flex",
        marginBottom: "20px",
        borderBottom: "1px solid #ddd",
        paddingBottom: "16px",
    },
    contents: {
        marginLeft: "16px",
    },
};

export default NewsItem;
