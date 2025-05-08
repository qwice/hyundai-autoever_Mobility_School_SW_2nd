// 연산자 : 수학적인 계산을 위해 사용되거나, 참과 거짓을 판별할 때 사용
// 산술연산자 : +, -, *, /, %, **
let a = 10;
let b = 4;
console.log(a+b);
console.log(a-b);
console.log(a*b);
console.log(a/b); // 나눗셈
console.log(parseInt(a/b)); // 몫 > 정수형변환
console.log(Math.floor(a/b)); // 몫 > 소숫점 이하를 버림
console.log(a%b);
console.log(a**b);

// 대입연산자 : =, +=, -=, *=, /=, %=
let c = 10;
console.log(c += 2); // c = c+2 = 12
console.log(c -= 2); // c = c-2 = 10
console.log(c *= 2); // c = c*2 = 20
console.log(c /= 2); // c = c/2 = 10
console.log(c %= 2); // c = c%2 = 0

// 증감연산자 : ++, --
console.log(a); // 10
console.log(a++); // 10
console.log(a); //11
console.log(++a); //12

// 비교연산자 : == (값이 같은지 판단), === (동등 비교 연산자, 값과 타입까지 비교)
console.log(100 == "100"); // true
console.log(100 === "100"); // false

// 삼항연산자 : a = (조건) ? b : c >> 조건이 참이면 a = b , 거짓이면 a = c, 참과 거짓을 구분하는 간단한 조건식, 연산자 취급
const age = 18;
console.log(`당신은 ${age > 19 ? "성인" : "미성년자"}입니다.`);

// 형변환 : 정해진 타입을 다른 타입으로 변경하는 것
// 묵시적 형변환 : 컴파일러가 알아서 바꿔줌.
const rst = 100 + 3.14;
console.log(typeof(rst));
console.log(typeof rst);
console.log(rst);
console.log(10 + 10 + "10"); // 2010

// 명시적 형변환 :
console.log(100+Number("3.14"));

// 논리연산자
// 비트연산자
// 전개연산자

// 윤년 계산하기
// 1. 연도가 4로 나누어 떨어짐
// 2. 100으로 나누어 떨어지면 윤년이 아님
// 3. 400으로 나누어 지면 윤년
// let num = parseInt(prompt("정수 입력: "));
let num = 2024;
if(num % 4 === 0 && (num % 100 !== 0 || num % 400 === 0)) {
    console.log("윤년");
} else {
    console.log("아님");
}

// 주민등록번호를 입력 받음 : 010222-3164414
// 성별, 나이, 생년월일 출력
// 문자열의 인덱싱과 슬라이싱 사용 : slice(시작인덱스, 종료인덱스);
// new Date().getFullYear();
// const t = "010222-3164414"; 
// const t = prompt("주민번호");
let gender, age2, birth;

if(t[7] === '1' || t[7] === '2') {
    gender = "man";
} else gender = "girl";


if(t[7] === '3' || t[7] === '4') {
    birth = "20" + t[0] + t[1];
    let date = new Date().getFullYear();
    age2 = date - birth + 1;
} else {
    birth = "19" + t[0] + t[1];
    let date = new Date().getFullYear();
    age2 = date - birth + 1;
}
console.log(`성별 : ${gender}, 나이 : ${age2}, 생년월일 : ${birth}`);

