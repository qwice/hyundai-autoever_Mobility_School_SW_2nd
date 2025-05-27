import { createContext, useState } from "react";

export const UserContext = createContext(null);

const UserStore = (props) => {
    const [userId, setUserId] = useState("");
    const [userPwd, setUserPwd] = useState("");

    return (
        <UserContext.Provider
            value={{
                userId,
                setUserId,
                userPwd,
                setUserPwd,
            }}
        >
            {props.children}
        </UserContext.Provider>
    );
};

export default UserStore;
