// for(let i = 1 ; i <= 9 ; i++){
//     console.log(`2 x ${i} = ${2 * i}`);
// }

// const num = Number(prompt("숫자 입력 : "));

// if(num >= 0 ) {
//     console.log(`${num}은 양수 입니다.`);
// } else {
//     console.log(`${num}은 음수 입니다.`);
// }

// const PI = 3.14;
// console.log(PI * 20);

// prompt 입력 받기 : 자바스크립트는 기본적으로 웹기반의 언어이므로 콘솔 입력이 없음
const name = prompt("이름을 입력하세요.");
const greeting = document.getElementById("greeting") /* id 선택자 추적 */
if(name) {
    greeting.innerText = `${name}님. 환영합니다.`;
} else {
    greeting.innerText = "이름을 입력하지 않으셨습니다.";
}