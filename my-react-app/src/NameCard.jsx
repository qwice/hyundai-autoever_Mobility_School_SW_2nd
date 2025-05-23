import { useState } from "react";

const NameCard = () => {
    const [nameCard, setNameCard] = useState({
        name: "",
        position: "",
        company: "",
        addr: "",
        email: "",
        phone: "",
    });

    const [submit, setSubmit] = useState(false);
    const onChange = (key, value) => {
        setNameCard({
            ...nameCard,
            [key]: value,
        });
    };

    return (
        <>
            <input
                type="text"
                name="name"
                value={nameCard.name}
                onChange={(e) => onChange(e.target.name, e.target.value)}
                placeholder="name"
            />
            <input
                type="text"
                name="position"
                value={nameCard.position}
                onChange={(e) => onChange(e.target.name, e.target.value)}
                placeholder="position"
            />
            <input
                type="text"
                name="company"
                value={nameCard.company}
                onChange={(e) => onChange(e.target.name, e.target.value)}
                placeholder="company"
            />
            <input
                type="text"
                name="addr"
                value={nameCard.addr}
                onChange={(e) => onChange(e.target.name, e.target.value)}
                placeholder="addr"
            />
            <input
                type="text"
                name="email"
                value={nameCard.email}
                onChange={(e) => onChange(e.target.name, e.target.value)}
                placeholder="email"
            />
            <input
                type="text"
                name="phone"
                value={nameCard.phone}
                onChange={(e) => onChange(e.target.name, e.target.value)}
                placeholder="phone"
            />
            <button onClick={() => setSubmit(true)}>제출</button>
            {submit && (
                <>
                    <p>이름 : {nameCard.name}</p>
                    <p>직책 : {nameCard.position}</p>
                    <p>회사 : {nameCard.company}</p>
                    <p>주소 : {nameCard.addr}</p>
                    <p>이메일 : {nameCard.email}</p>
                    <p>번호 : {nameCard.phone}</p>
                </>
            )}
        </>
    );
};

export default NameCard;
