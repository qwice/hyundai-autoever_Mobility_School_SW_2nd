import React from "react";

const categories = [
    {
        name: "all",
        text: "전체보기",
    },
    {
        name: "business",
        text: "비즈니스",
    },
    {
        name: "entertainment",
        text: "엔터테인먼트",
    },
    {
        name: "health",
        text: "건강",
    },
    {
        name: "sport",
        text: "스포츠",
    },
    {
        name: "technology",
        text: "기술",
    },
];

const NewsCategory = React.memo(({ onSelect, cate }) => {
    return (
        <div
            style={{
                width: "900px",
                // height: "5vh",
                display: "flex",
                marginBottom: "20px",
                border: "1px solid black",
                borderRadius: "10px",
            }}
        >
            {categories.map((category) => {
                const isSelected = cate === category.name;
                return (
                    <div
                        key={category.name}
                        onClick={() => onSelect(category.name)}
                        style={{
                            cursor: "pointer",
                            width: "150px",
                            height: "5vh",
                            padding: "10px",
                            alignContent: "center",
                            fontWeight: isSelected ? "bold" : "normal",
                            backgroundColor: isSelected
                                ? "#007BFF"
                                : "transparent",
                            color: isSelected ? "white" : "black",
                            borderRadius: "8px",
                        }}
                    >
                        {category.name}
                    </div>
                );
            })}
        </div>
    );
});

export default NewsCategory;
