// 자바스크립트는 원시 타입을 제외한 모든 값이 객체
// 객체리터럴은 중괄호 {}로 생성, 속성과 값의 쌍으로 구성

const person = {
    title: "지구오락실",
    name: "안유진",
    age: 23,
    job: "IVE",
}

console.log(person);

const member = {
    id: "id",
    pwd: "pwd",
    addr: {
        home: "서울시 동대문구",
        company: "서울시 금천구 가산동"
    },
    name: "name",
    func1: () => {
        console.log("함수 호출 입니다.");
    }
}

member.func1();

const members = [ // 만약 서버에서 데이터가 넘어온다면 이런 형식(ArrayList)으로 넘어올 것이다.
    {
        id: "id",
        pwd: "pwd",
        addr: "서울시 강남구 역삼동",
        name: "name",
    },
    {
        id: "id",
        pwd: "pwd",
        addr: "서울시 강남구 역삼동",
        name: "name",
    },
    {
        id: "id",
        pwd: "pwd",
        addr: "서울시 강남구 역삼동",
        name: "name",
    }
]

members.map(member => {
    console.log("아이디 : " + member.id + " 주소 : " + member.addr + " 이름 : " + member.name);
})