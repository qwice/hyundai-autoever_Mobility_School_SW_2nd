import React from "react";

const TypeInferenceComponent: React.FC = () => {
    const name = "장원영";
    const age = 20;
    const isAdult = true;

    return (
        <div>
            <h3>타입 추론 예시</h3>
            <p>Name: {name}</p>
            <p>Age: {age}</p>
            <p>Is Adult: {isAdult ? "Yes" : "No"}</p>
        </div>
    );
};

export default TypeInferenceComponent;
