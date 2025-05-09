// 반복문 : 조건이 참인 동안 반복 수행하는 구문
// for : for(초기값 ; 조건식 : 증감식), for ..in(키값 순회), for ..of(iterable 객체 반복, 내부 데이터 변경 못함)
// while, do while : 반복횟수를 알 수 없을 때

// const prompt = require("prompt-sync")();
// let num = Number(prompt("정수 입력 : "));

// let num = 10;
// 입력 받은 정수 범위의 합을 구하기
// let sum = 0; // 반드시 초기화 해줘야 함
// while(num) {
//     sum += num;
//     num--;
// }

// for(let i = 1; i <= num ; i++) {
//     sum += i;
// }

// console.log(sum);

// while문 사용 예 : 반복 횟수를 알 수 없는 경우 사용하면 유리
// let age;

// while(true){ // 무한 반복문, 반드시 탈출 조건이 필요
//     // age = Number(prompt("나이를 입력하세요 : "));
//     age = 10;
//     if (age >= 0 && age <= 200) break;

//     console.log("나이를 잘 못 입력 하셨습니다.");
// }

// console.log(`당신의 나이는 ${age}입니다.`);

// for 문
const cars = ["테슬라 모델 Y", "제네시스 G80", "그랜저", "싼타페", "코나"];

for(let i = 0 ; i < cars.length; i++){
    cars[i] += "0000"; // 원본을 변경할 수 있다.
    console.log(cars[i]);
}

// for ..of : iterable 순회 방식, 향상된 for문
for(let e of cars){
    e += "1111"; // 원본을 바꿀 수 없다. 깊은 복사
    console.log(e);
}
for(let e of cars){
    console.log(e);
}