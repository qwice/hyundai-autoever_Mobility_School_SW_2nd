import React from "react";

interface User {
    name: string;
    age: number;
    isAdult: boolean;
}

interface UserProps {
    user: User;
}

const UserComponent: React.FC<UserProps> = ({ user }) => {
    return (
        <div>
            <h3>인터페이스 예시</h3>
            <p>Name: {user.name}</p>
            <p>Age: {user.age}</p>
            <p>Is Adult: {user.isAdult ? "Yes" : "No"}</p>
        </div>
    );
};

export default UserComponent;
