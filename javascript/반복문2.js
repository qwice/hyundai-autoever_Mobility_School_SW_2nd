const productList = [
    {
        name: "레쓰비",
        price: 700
    },
    {
        name: "티오피",
        price: 1000
    },
    {
        name: "비타500",
        price: 800
    },
    {
        name: "포카리스웨트",
        price: 1000
    },
    {
        name: "파워에이드",
        price: 1200
    }
];
let inputCoin = 800;
let len = productList.length;
// let outputList = []; // 빈 배열 생성

// 전통적인 for문 순회
for(let i = 0; i < len; i++) {
    if(productList[i].price <= inputCoin) {
        // outputList.push(productList[i]);  // 배열의 끝에 새로운 요소 추가
        console.log(productList[i].name);
    }
}

// for ..of
for(const product of productList) {
    if(product.price <= inputCoin) {
        // outputList.push(product);  // 배열의 끝에 새로운 요소 추가
        console.log(product.name);
    }
}
// console.log(outputList);

//filter를 사용하는 방법
productList.filter(e => e.price <= inputCoin).forEach(e => console.log(e.name));


// Math.random() : 0 ~ 1 미만의 임의의 실수값이 반환
// Math.random() * 45 + 1 > 로또
// 두개의 주사위를 굴려 같은 값이 나오면 무인도 탈출

while(true) {
    const a = parseInt(Math.random() * 6) + 1;
    const b = parseInt(Math.random() * 6) + 1;
    console.log(a + " " + b);
    if(a === b) break;
    console.log("탈출 실패");
}
console.log("탈출 성공");

// for ..in : 객체의 키값 기준 순회
const person = {name: "안유진", age: 23, isAdult: true};
for(const key in person){
    console.log(person[key]);
}