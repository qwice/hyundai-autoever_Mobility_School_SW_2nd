import axiosInstance from "./axiosInstance";

export const useAuthApi = () => {
    const signup = async (email, pwd, name) => {
        return await axiosInstance.post("/auth/signup", { email, pwd, name });
    };
    const login = async (email, pwd) => {
        return await axiosInstance.post("/auth/login", { email, pwd });
    };
    const exists = async (email) => {
        return await axiosInstance.get(`/auth/exists/${email}`);
    };

    return { login, signup, exists };
};
